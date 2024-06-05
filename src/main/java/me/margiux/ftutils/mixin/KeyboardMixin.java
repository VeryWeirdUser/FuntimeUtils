package me.margiux.ftutils.mixin;

import me.margiux.ftutils.Main;
import me.margiux.ftutils.event.EventManager;
import me.margiux.ftutils.event.KeyEvent;
import me.margiux.ftutils.event.ModuleKeyEvent;
import net.minecraft.client.Keyboard;
import net.minecraft.client.gui.screen.ChatScreen;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public abstract class KeyboardMixin {
    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    private void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        if (!(Main.MC.currentScreen instanceof ChatScreen)) {
            EventManager.fireEvent(new KeyEvent(key, modifiers, action));
            if (action == 1 && modifiers == GLFW.GLFW_MOD_ALT) {
                ModuleKeyEvent moduleKeyEvent = new ModuleKeyEvent(key, modifiers, action);
                EventManager.fireEvent(moduleKeyEvent);
                if (moduleKeyEvent.isCanceled()) {
                    ci.cancel();
                }
            }
        }
    }
}
