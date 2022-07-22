package canvas.Rectangle;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class RectangleFilled extends RectangleAbstract {

    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;

    int startX;
    int startY;
    int width;
    int height;
    Color color;

    public RectangleFilled(Color color, int startX, int startY, int width, int height, PaintCanvasBase paintCanvas) {
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
        graphics2d.fillRect(startX, startY, width, height);
    }
}
