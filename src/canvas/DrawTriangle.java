package canvas;

import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawTriangle extends MouseModeCommandDraw {
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;

    Color color;
    Point point1;
    Point point2;
    @Override
    public void setPoint1(Point point) {
        this.point1 = point;
    }
    @Override
    public void setPoint2(Point point) {
        this.point2 = point;
    }
    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public DrawTriangle(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        super(appState, paintCanvas, history, shapeList);
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void draw() {
        graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(color);
        graphics2d.fillPolygon(new int[]{point1.getX(), point2.getX(), point1.getX()}, new int[]{point1.getY(), point2.getY(), point2.getY()}, 3);
    }

}
