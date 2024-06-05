package me.margiux.ftutils.event;

import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;

public class UpdateEvent extends Event {
    @Nullable
    protected final Screen screen;

    @Nullable
    public Screen getScreen() {
        return screen;
    }

    public UpdateEvent(@Nullable Screen screen) {
        this.screen = screen;
    }

    public UpdateEvent() {
        this(null);
    }
}
