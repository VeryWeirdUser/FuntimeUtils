package me.margiux.ftutils.event;

import net.minecraft.client.gui.screen.Screen;

public class OpenScreenEvent extends Event {
    protected final Screen screen;

    public Screen getScreen() {
        return screen;
    }
    public OpenScreenEvent(Screen screen) {
        this.screen = screen;
    }
}
