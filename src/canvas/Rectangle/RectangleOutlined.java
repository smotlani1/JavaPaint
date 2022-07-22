package canvas.Rectangle;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class RectangleOutlined extends RectangleAbstract{

    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;

    int startX;
    int startY;
    int width;
    int height;
    Color color;

    public RectangleOutlined(Color color, int startX, int startY, int width, int height, PaintCanvasBase paintCanvas) {
        super(startX, startY, width, height, paintCanvas);
        this.paintCanvas = paintCanvas;
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw() {
        graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(color);
        graphics2d.drawRect(startX, startY, width, height);
    }
}
