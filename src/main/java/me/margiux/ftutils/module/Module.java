package me.margiux.ftutils.module;

import me.margiux.ftutils.Main;
import me.margiux.ftutils.Mode;
import me.margiux.ftutils.event.EventHandler;
import me.margiux.ftutils.event.Listener;
import me.margiux.ftutils.event.ModuleKeyEvent;
import me.margiux.ftutils.setting.EnumSetting;
import me.margiux.ftutils.setting.Setting;
import me.margiux.ftutils.utils.HudUtil;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayList;
import java.util.List;

public class Module implements Listener {
    public final String name;
    public final String description;
    public final Category category;
    public final List<Setting<?>> moduleSettings = new ArrayList<>();
    protected final EnumSetting<Mode> mode = new EnumSetting<>("Mode", "", Mode.DISABLED);
    public final boolean builtin;
    public boolean disabledByMain = false;
    public final int activationKey;

    public static final MinecraftClient MC = Main.MC;
    public EnumSetting<Mode> getModeSetting() {
        return mode;
    }
    public boolean isClientInGame() {
        return Main.isClientInGame();
    }

    // Please don't use this constructor outside ftutils package
    public Module(String name, String description, Category category, int activationKey, Mode defaultMode, boolean builtin) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.activationKey = activationKey;
        this.mode.setData(defaultMode);
        this.builtin = builtin;
    }

    public Module(String name, String description, Category category, int activationKey, Mode defaultMode) {
        this(name, description, category, activationKey, defaultMode, false);
    }

    public Module(String name, String description, Category category, int activationKey) {
        this(name, description, category, activationKey, Mode.DISABLED);
    }

    public void changeMode(Mode mode) {
        Mode oldMode = this.mode.getData();
        if (mode == oldMode) return;
        this.mode.setData(mode);
        if (this.mode.getData() == Mode.ENABLED) onEnable();
        else if (oldMode == Mode.ENABLED) onDisable();
    }

    public void toggle() {
        if (this.mode.getData() != Mode.FORCE_DISABLED) changeMode(mode.getData().getNext());
    }

    protected void onEnable() {
        HudUtil.setSubTitle("§7" + name + ": §aEnabled");
    }

    protected void onDisable() {
        HudUtil.setSubTitle("§7" + name + ": §cDisabled");
    }

    public boolean isEnabled() {
        return mode.getData() == Mode.ENABLED;
    }
    public Mode getMode() {
        return mode.getData();
    }

    @EventHandler
    public void onModuleKey(ModuleKeyEvent event) {
        if (event.getKey() == activationKey) {
            toggle();
            event.setCanceled();
        }
    }

    public void addSetting(Setting<?> setting) {
        this.moduleSettings.add(setting);
    }

    public String getColorizedName() {
        String c = "§7";
        if (getMode() == Mode.ENABLED) c = "§a";
        else if (getMode() == Mode.DISABLED) c = "§c";
        return c + this.name;
    }

    public void enable() {
        changeMode(Mode.ENABLED);
    }

    public void disable() {
        changeMode(Mode.DISABLED);
    }

    public void sendMessage(String message) {
        Main.instance.sendMessage(this, message);
    }

    public void sendMessage(Object message) {
        Main.instance.sendMessage(this, message);
    }
}
