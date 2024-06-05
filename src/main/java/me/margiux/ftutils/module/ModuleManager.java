package me.margiux.ftutils.module;

import me.margiux.ftutils.event.EventManager;
import me.margiux.ftutils.module.visual.ClientTime;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final List<Module> modules = new ArrayList<>();
    public static final ClientTime clientTime = new ClientTime("ClientTime", "Allows to world time on the client side", Category.VISUAL, GLFW.GLFW_KEY_M);


    public static void init() {
        addModule(clientTime);
    }

    public static void addModule(Module module) {
        modules.add(module);
        EventManager.addListener(module);
        EventManager.addModuleListener(module);
    }
}
