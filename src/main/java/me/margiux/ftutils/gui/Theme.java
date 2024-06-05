package me.margiux.ftutils.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;

import java.util.function.Supplier;

public class Theme {
    public Supplier<TextRenderer> textRenderer = () -> MinecraftClient.getInstance().textRenderer;
    public static Theme theme;

    public TextRenderer textRenderer() {
        return textRenderer.get();
    }

    public Color buttonWidget() {
        return new Gradient(0xFF87f2b2, 0xFF8BA8E0);
    }

    public Color buttonStroke() {
        return new Gradient(0xFF87f2b2 - 0x00333333, 0xFF8BA8E0 - 0x00333333);
    }

    public Color toggleButtonEnabled() {
        return new Color(0xffeeff);
    }

    public Color toggleButtonDisabled() {
        return new Color(0x66666666);
    }

    public Color text() {
        return new Color(0xffffff);
    }

    public static TextRenderer TextRenderer() {
        return theme.textRenderer();
    }

    public static Color ButtonWidget() {
        return theme.buttonWidget();
    }

    public static Color ButtonStroke() {
        return theme.buttonStroke();
    }

    public static Color ToggleButtonEnabled() {
        return theme.toggleButtonEnabled();
    }

    public static Color ToggleButtonDisabled() {
        return theme.toggleButtonDisabled();
    }

    public static Color Text() {
        return theme.text();
    }
}
