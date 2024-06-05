package me.margiux.ftutils.setting;

import me.margiux.ftutils.gui.widget.ToggleButton;
import me.margiux.ftutils.gui.widget.Widget;

public class BooleanSetting extends Setting<Boolean> {
    public BooleanSetting(String name, String description, Boolean data) {
        super(name, description, data);
    }

    public BooleanSetting(String name, String description) {
        super(name, description);
    }

    public Widget makeWidget(int width, int height) {
        return new ToggleButton(width, height, name, description, this);
    }

    public Widget makeWidget() {
        return new ToggleButton(name, description, this);
    }
}
