package canvas.Ellipse;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class EllipseOutlinedFilled extends EllipseAbstract {
    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;

    int startX;
    int startY;
    int width;
    int height;
    Color color;
    Color secondaryColor;

    public EllipseOutlinedFilled(Color color, Color secondary, int startX, int startY, int width, int height, PaintCanvasBase paintCanvas) {
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
        graphics2d.fillOval(startX, startY, width, height);
        graphics2d.setColor(secondaryColor);
        graphics2d.drawOval(startX, startY, width, height);
    }
}
