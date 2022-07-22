package canvas.Triangle;

import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class TriangleOutlined extends TriangleAbstract{
    Point point1;
    Point point2;
    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;
    Color color;
    public TriangleOutlined(Color color, Point point1, Point point2, PaintCanvasBase paintCanvas) {
        super(point1, point2, paintCanvas);
        this.point1 = point1;
        this.point2 = point2;
        this.paintCanvas = paintCanvas;
        this.color = color;
    }

    @Override
    public void draw() {
        graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(color);
        graphics2d.drawPolygon(new int[]{point1.getX(), point2.getX(), point1.getX()}, new int[]{point1.getY(), point2.getY(), point2.getY()}, 3);
    }
}
