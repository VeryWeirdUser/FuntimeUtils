package me.margiux.ftutils.gui.widget;

import me.margiux.ftutils.setting.BooleanSetting;
import me.margiux.ftutils.utils.RenderUtils;
import net.minecraft.client.util.math.MatrixStack;

public class ToggleButton extends Button {
    public final BooleanSetting setting;

    public ToggleButton(int x, int y, int width, int height, String name, String description, BooleanSetting setting) {
        super(x, y, width, height, name, description, null);
        this.setting = setting;
    }

    public ToggleButton(int width, int height, String name, String description, BooleanSetting setting) {
        this(0, 0, width, height, name, description, setting);
    }

    public ToggleButton(String name, String description, BooleanSetting setting) {
        this(DEFAULT_WIDTH, 15, name, description, setting);
    }

    @Override
    public void onClick(double mouseX, double mouseY, int button) {
        setting.setData(!setting.getData());
    }

    @Override
    public void renderText(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        RenderUtils.fill(matrices, this.x + 3, this.y + 3, this.x + 13, this.y + 12, 0xFF092D49);
        RenderUtils.drawText(matrices, "✔", x + 5, y + 4, setting.getData() ? 0xffeeff : 0x66666666);

        RenderUtils.drawTextWithShadow(matrices, displayName, x + 14, y + 4, 0xffffff);
    }
}
