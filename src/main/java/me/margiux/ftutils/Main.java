package me.margiux.ftutils;

import me.margiux.ftutils.access.IChatHud;
import me.margiux.ftutils.gui.Theme;
import me.margiux.ftutils.module.Module;
import me.margiux.ftutils.module.ModuleManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;

public class Main implements ModInitializer {
    public static Main instance;
    public static MinecraftClient MC = MinecraftClient.getInstance();

    public static boolean isClientInGame() {
        return MC.player != null && MC.world != null;
    }

    @Override
    public void onInitialize() {
        instance = this;
        Theme.theme = new Theme();
        ModuleManager.init();
    }

    public void sendMessage(Module module, Object object) {
        sendMessage(module, object.toString());
    }

    public void sendMessage(Module module, String message) {
        ((IChatHud)MC.inGameHud.getChatHud()).addHiddenMessage("§l[" + module.name + "] : §r" +  message);
    }

    public void sendMessage(Object object) {
        sendMessage(object.toString());
    }

    public void sendMessage(String message) {
        addHiddenMessage("§l[§bFuntime Utils§f] : §r" +  message);
    }

    private void addHiddenMessage(String message) {
        ((IChatHud)MC.inGameHud.getChatHud()).addHiddenMessage(message);
    }
}