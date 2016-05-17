package mcjty.theoneprobe.apiimpl.elements;

import mcjty.theoneprobe.rendering.RenderHelper;
import net.minecraft.client.Minecraft;

public class ElementProgress implements Element {

    private final int current;
    private final int max;
    private final String suffix;

    public ElementProgress(int current, int max, String suffix) {
        this.current = current;
        this.max = max;
        this.suffix = suffix;
    }

    @Override
    public void render(Cursor cursor) {
        int w = 100;
        int x = cursor.getX();
        int y = cursor.getY();
        RenderHelper.drawThickBeveledBox(x, y, x + w, y + 12, 1, 0xffffffff, 0xffffffff, 0xff000000);
        if (current > 0) {
            int dx = current * (w-2) / max;
            RenderHelper.drawThickBeveledBox(x + 1, y + 1, x + dx - 1, y + 12 - 1, 1, 0xffff0000, 0xffff0000, 0xffff0000);
        }

        RenderHelper.renderText(Minecraft.getMinecraft(), cursor.getX()+3, cursor.getY()+2, current + suffix);

        cursor.addX(w);
        cursor.updateMaxY(12);
    }
}
