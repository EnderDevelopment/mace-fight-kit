# Mace Fight Minecraft Mod

Mace Fight is a Fabric Minecraft mod for Minecraft 1.21.1 that adds a `/mace` command and equips the executing player with a complete mace fight kit, including netherite armor, a mace, combat supplies, defensive items, and survival utilities.

## Install

Requirements:

- Minecraft 1.21.1
- Java 21
- Fabric Loader 0.16.10 or newer
- Fabric API for Minecraft 1.21.1

1. Install Fabric Loader for Minecraft 1.21.1.
2. Install the matching Fabric API and place it in your Minecraft `mods` folder.
3. Build the project with:

   ```bash
   ./gradlew build
   ```

4. Place the generated `build/libs/mace-fight-1.0.0.jar` file in your Minecraft `mods` folder.
5. Start Minecraft using the Fabric 1.21.1 profile.

## Use

1. Join a single-player world or a server running the mod.
2. Run:

   ```text
   /mace
   ```

3. The command equips the player with:

   - Netherite helmet
   - Netherite chestplate
   - Netherite leggings
   - Netherite boots
   - Mace
   - Shield
   - 16 wind charges
   - 8 ender pearls
   - 8 golden apples
   - Water bucket
   - Totem of undying

Any armor already equipped is moved into the player inventory. If there is not enough inventory space, the displaced armor is dropped on the ground. Additional kit items that cannot fit in the inventory are also dropped.

The command affects only the player who runs it and can be used in single-player or on a server where the mod is installed.

---

More Minecraft mod projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/7ed1a8d8-834e-4acc-b7c0-4e99ebc8ecb5?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=7ed1a8d8-834e-4acc-b7c0-4e99ebc8ecb5
