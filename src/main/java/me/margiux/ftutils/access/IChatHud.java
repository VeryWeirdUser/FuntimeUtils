package me.margiux.ftutils.access;

import net.minecraft.text.Text;

public interface IChatHud {
    void addHiddenMessage(String message);
    void addHiddenMessage(Text message);
}
