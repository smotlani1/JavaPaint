package canvas.Triangle;

import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

public class TriangleAbstract {
    Point point1;
    Point point2;
    PaintCanvasBase paintCanvas;


    public TriangleAbstract(Point point1, Point point2, PaintCanvasBase paintCanvas) {
        this.point1 = point1;
        this.point2 = point2;
        this.paintCanvas = paintCanvas;
    }

    public void draw(){}
}
