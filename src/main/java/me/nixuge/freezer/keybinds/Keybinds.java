package me.nixuge.freezer.keybinds;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
    public static KeyBinding altf4 = new KeyBinding("Crash", Keyboard.KEY_J, "Freezer");
    public static KeyBinding freezeGameHold = new KeyBinding("Freeze (hold)", Keyboard.KEY_H, "Freezer");
    public static KeyBinding freezeGameToggle = new KeyBinding("Freeze (toggle)", Keyboard.KEY_G, "Freezer");

    public static void register() {
        ClientRegistry.registerKeyBinding(altf4);
        ClientRegistry.registerKeyBinding(freezeGameHold);
        ClientRegistry.registerKeyBinding(freezeGameToggle);
    }
}
