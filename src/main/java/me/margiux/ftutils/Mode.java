package me.margiux.ftutils;

import me.margiux.ftutils.setting.ExtendedEnum;

public enum Mode implements ExtendedEnum<Mode> {
    ENABLED("§aEnabled"),
    DISABLED("§cDisabled"),
    FORCE_DISABLED("§7Disabled", true);

    final boolean displayOnly;
    final String name;

    Mode(String name, boolean displayOnly) {
        this.name = name;
        this.displayOnly = displayOnly;
    }

    Mode(String name) {
        this(name, false);
    }

    @Override
    public boolean isDisplayOnly() {
        return displayOnly;
    }

    @Override
    public Mode[] getValues() {
        return values();
    }

    @Override
    public String toString() {
        return this.name;
    }
}