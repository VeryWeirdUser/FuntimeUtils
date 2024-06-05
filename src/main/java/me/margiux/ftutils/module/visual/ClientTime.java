package me.margiux.ftutils.module.visual;

import me.margiux.ftutils.module.Category;
import me.margiux.ftutils.module.Module;
import me.margiux.ftutils.setting.EnumSetting;
import me.margiux.ftutils.setting.ExtendedEnum;

public class ClientTime extends Module {
    public enum Time implements ExtendedEnum<Time> {
        NIGHT(18000, "Night"),
        SUNRISE(23250, "Sunrise"),
        DAY(6000, "Day"),
        SUNSET(12500, "Sunset");

        public final int time;
        public final String name;

        Time(int time, String name) {
            this.time = time;
            this.name = name;
        }
        @Override
        public boolean isDisplayOnly() {
            return false;
        }

        @Override
        public Time[] getValues() {
            return values();
        }

        @Override
        public String toString() {
            return name;
        }
    }
    public final EnumSetting<Time> timeSetting = new EnumSetting<>("Time", "Time of the world", Time.SUNRISE);
    public ClientTime(String name, String description, Category category, int activationKey) {
        super(name, description, category, activationKey);
        addSetting(timeSetting);
    }
}
