package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import model.persistance.Point;

public class DrawRectangle extends MouseModeCommandDraw {
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;

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

    public DrawRectangle(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        super(appState, paintCanvas, history, shapeList);
        this.appState = appState;
        this.paintCanvas = paintCanvas;


    }

    @Override
    public void draw() {
        System.out.println("Rectangle drawn");
        graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(appState.getActivePrimaryColor().getColor());
        graphics2d.fillRect(point1.getX(), point1.getY(), (point2.getX()-point1.getX()), (point2.getY()-point1.getY()));
    }

//    @Override
//    public void unExecute() {
//        graphics2d.setColor(Color.white);
//        graphics2d.fillRect(point1.getX(), point1.getY(), (point2.getX()-point1.getX()), (point2.getY()-point1.getY()));
//    }
}
