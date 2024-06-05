package me.margiux.ftutils.utils;

import me.margiux.ftutils.Main;
import net.minecraft.client.util.InputUtil;

public class Input {
    public static boolean isKeyPressed(int key) {
        return InputUtil.isKeyPressed(Main.MC.getWindow().getHandle(), key);
    }
}
