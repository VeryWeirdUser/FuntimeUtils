package me.margiux.ftutils.gui.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import me.margiux.ftutils.setting.ExtendedEnum;
import me.margiux.ftutils.setting.EnumSetting;
import me.margiux.ftutils.utils.RenderUtils;
import net.minecraft.client.util.math.MatrixStack;
import org.jetbrains.annotations.Nullable;

public class Enum<T extends java.lang.Enum<T> & ExtendedEnum<T>> extends Button {
    public int selected;
    public EnumSetting<T> setting;
    public final PressAction<T> onPress;
    public boolean displayInSingleLine = false;

    public Enum(int x, int y, int width, int height, String name, String description, EnumSetting<T> setting, @Nullable PressAction<T> handler) {
        super(x, y, width, height, name, description, null);
        this.onPress = handler;
        this.setting = setting;
        this.displayNameSupplier = () -> name + ": " + setting.getData().toString();
        refreshDisplayName();
    }

    public Enum(int width, int height, String name, String description, EnumSetting<T> setting, @Nullable PressAction<T> handler) {
        this(0, 0, width, height, name, description, setting, handler);
    }

    @SuppressWarnings("unused")
    public Enum(String name, String description, EnumSetting<T> setting, @Nullable PressAction<T> handler) {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT, name, description, setting, handler);
    }

    @Override
    public void onClick(double mouseX, double mouseY, int button) {
        if (onPress != null) onPress.onPress(this, button);
        else {
            T[] ec = setting.getData().getDeclaringClass().getEnumConstants();
            while (ec[(selected + 1) % ec.length].isDisplayOnly()) selected++;
            this.setting.setData(ec[selected = (selected + 1) % ec.length]);
            refreshDisplayName();
        }
    }

    @FunctionalInterface
    public interface PressAction<T extends java.lang.Enum<T> & ExtendedEnum<T>> {
        void onPress(Enum<T> enumWidget, int button);
    }

    @Override
    public void renderBackground(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        if (displayInSingleLine) {
            super.renderBackground(matrices, mouseX, mouseY, delta);
            return;
        }
        RenderUtils.setupRender(this.alpha);
        RenderSystem.enableDepthTest();
        RenderUtils.fill(matrices, this.x, this.y + 10, this.x + this.width, this.y + this.height, 0xFF092D49);
        RenderUtils.fill(matrices, this.x + 2, this.y + 12, this.x + this.width - 2, this.y + this.height - 2, 0xFF0887E7);
        RenderUtils.resetRender();
    }

    @Override
    public void renderText(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        if (displayInSingleLine) {
            super.renderText(matrices, mouseX, mouseY, delta);
            return;
        }
        RenderUtils.drawText(matrices, name + ":", this.x + 3, this. y + 2, 0xFFFFFFFF);
        RenderUtils.drawText(matrices, setting.getData().toString(), this.x + 3, this. y + 16, 0xFFFFFFFF);
    }

    public int calculateHeight() {
        if (displayInSingleLine) return DEFAULT_HEIGHT;
        else return 30;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        refreshDisplayName();
        setHeight(calculateHeight());
        super.render(matrices, mouseX, mouseY, delta);
    }
}
