package me.margiux.ftutils.gui;

import net.minecraft.util.math.ColorHelper;

public class Color {
    public final int color;

    public Color(int color) {
        this.color = color;
    }

    public static Color getColorFromGradient(Gradient gradient, float step) {
        return getColorFromGradient(gradient.color, gradient.endColor, step);
    }

    public static Color getColorFromGradient(int color, int endColor, float step) {
        return new Color(getHexColorFromGradient(color, endColor, step));
    }

    public static int getHexColorFromGradient(int color, int endColor, float step) {
        return ColorHelper.Argb.lerp(step, color, endColor);
    }
}