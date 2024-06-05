package me.margiux.ftutils.setting;


import me.margiux.ftutils.gui.widget.Enum;
import me.margiux.ftutils.gui.widget.Widget;

public class EnumSetting<T extends java.lang.Enum<T> & ExtendedEnum<T>> extends Setting<T> {
    public EnumSetting(String name, String description, T data) {
        super(name, description, data);
    }

    public EnumSetting(String name, String description) {
        super(name, description);
    }

    public Widget makeWidget(int width, int height) {
        return new Enum<>(width, height, name, description, this, null);
    }

    public Widget makeWidget() {
        return makeWidget(Widget.DEFAULT_WIDTH, Widget.DEFAULT_HEIGHT);
    }
}
