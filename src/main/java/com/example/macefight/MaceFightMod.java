package com.example.macefight;

import com.mojang.brigadier.Command;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public final class MaceFightMod implements ModInitializer {
    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(literal("mace").executes(context -> {
                ServerPlayerEntity player = context.getSource().getPlayer();
                equip(player, EquipmentSlot.HEAD, Items.NETHERITE_HELMET);
                equip(player, EquipmentSlot.CHEST, Items.NETHERITE_CHESTPLATE);
                equip(player, EquipmentSlot.LEGS, Items.NETHERITE_LEGGINGS);
                equip(player, EquipmentSlot.FEET, Items.NETHERITE_BOOTS);
                give(player, Items.MACE, 1);
                give(player, Items.SHIELD, 1);
                give(player, Items.WIND_CHARGE, 16);
                give(player, Items.ENDER_PEARL, 8);
                give(player, Items.GOLDEN_APPLE, 8);
                give(player, Items.WATER_BUCKET, 1);
                give(player, Items.TOTEM_OF_UNDYING, 1);
                player.sendMessage(Text.translatable("text.macefight.kit_given"), false);
                return Command.SINGLE_SUCCESS;
            }))
        );
    }

    private static void equip(ServerPlayerEntity player, EquipmentSlot slot, Item item) {
        ItemStack previous = player.getEquippedStack(slot);
        if (!previous.isEmpty()) {
            giveStack(player, previous.copy());
        }
        player.equipStack(slot, new ItemStack(item));
    }

    private static void give(ServerPlayerEntity player, Item item, int count) {
        giveStack(player, new ItemStack(item, count));
    }

    private static void giveStack(ServerPlayerEntity player, ItemStack stack) {
        if (!player.getInventory().insertStack(stack)) {
            player.dropItem(stack, false);
        }
    }
}
