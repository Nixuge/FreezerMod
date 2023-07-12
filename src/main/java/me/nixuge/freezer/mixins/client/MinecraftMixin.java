package me.nixuge.freezer.mixins.client;

import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.nixuge.freezer.keybinds.KeyToggleData;
import me.nixuge.freezer.keybinds.Keybinds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow
    public GameSettings gameSettings;
    @Shadow
    private long debugCrashKeyPressTime;

    @Shadow
    public void dispatchKeypresses(){};
    @Shadow
    private void refreshResources() {};
    @Shadow
    public static long getSystemTime() {return 0;}

    public void processKeyboardInput() {
        while (Keyboard.next())
        {
            int k = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
            KeyBinding.setKeyBindState(k, Keyboard.getEventKeyState());

            if (Keyboard.getEventKeyState())
            {
                KeyBinding.onTick(k);
            }

            this.dispatchKeypresses();
        }

        // Forge events don't get called from here, so adding another check
        if (Keybinds.freezeGameToggle.isKeyDown() && KeyToggleData.canChange())
            KeyToggleData.toggleFrozen();
    }

    @Inject(method = "runTick", at = @At("HEAD"), cancellable = true)
    public void runTick(CallbackInfo ci) {
        boolean hold = Keybinds.freezeGameHold.isKeyDown();
        boolean freezeToggled = KeyToggleData.isGameFrozen();

        // Wanted behavior:
        // If hold alone, freeze
        // If freeze toggled alone, freeze
        // If hold + freeze toggled, unfreeze
        if ((hold && !freezeToggled) || (!hold && freezeToggled)) {
            this.processKeyboardInput();
            ci.cancel();
        }
        if (Keybinds.freezeGameToggle.isKeyDown() && KeyToggleData.canChange()) {
            KeyToggleData.toggleFrozen();
            ci.cancel();
        }
        if (Keybinds.altf4.isKeyDown()) {
            System.out.println(4 / 0); // lol
        }
    }
}
