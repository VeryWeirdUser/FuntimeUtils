package me.margiux.ftutils.gui;

import me.margiux.ftutils.gui.widget.Widget;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class FTScreen extends Screen {
    public final Widget rootWidget;
    public FTScreen(Text title) {
        super(title);
        rootWidget = new Widget(0, 0, 0, 0);
    }
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
    }


    @Override
    public void close() {
        super.close();
    }

    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        rootWidget.mouseMoved(mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        Widget hovered = rootWidget.findHoveredWidget();
        if (hovered == null) return false;
        return hovered.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        Widget hovered = rootWidget.findHoveredWidget();
        if (hovered == null) return false;
        return hovered.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        Widget hovered = rootWidget.findHoveredWidget();
        if (hovered == null) return false;
        return hovered.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        Widget hovered = rootWidget.findHoveredWidget();
        if (hovered == null) return false;
        return hovered.mouseScrolled(mouseX, mouseY, amount);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256 && this.shouldCloseOnEsc()) {
            this.close();
            return true;
        }
        Widget hovered = rootWidget.findHoveredWidget();
        if (hovered == null) return false;
        return hovered.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        Widget hovered = rootWidget.findHoveredWidget();
        if (hovered == null) return false;
        return hovered.keyReleased(keyCode, scanCode, modifiers);
    }

    @Override
    public boolean charTyped(char chr, int modifiers) {
        Widget hovered = rootWidget.findHoveredWidget();
        if (hovered == null) return false;
        return hovered.charTyped(chr, modifiers);
    }
}
