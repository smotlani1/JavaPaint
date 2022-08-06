package canvas.Rectangle;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class RectangleOutlineFill extends RectangleAbstract{
    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;

    int startX;
    int startY;
    int width;
    int height;
    Color color;
    Color secondaryColor;
    boolean selected = false;

    public RectangleOutlineFill(Color color, Color secondary, int startX, int startY, int width, int height, PaintCanvasBase paintCanvas) {
        super(startX, startY, width, height, paintCanvas);
        this.paintCanvas = paintCanvas;
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.color = color;
        this.secondaryColor = secondary;
    }

    @Override
    public void draw() {
        graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(color);
        graphics2d.fillRect(startX, startY, width, height);
        graphics2d.setColor(secondaryColor);
        graphics2d.drawRect(startX, startY, width, height);
        if (selected == true) {
            graphics2d.setColor(Color.BLACK);
            float dash1[] = {10.0f};
            Stroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER , 10.0f, dash1, 0.0f);
            graphics2d.setStroke(dashed);
            graphics2d.drawRect(startX - 3, startY - 3, width + 6, height + 6);
        }
    }
}
