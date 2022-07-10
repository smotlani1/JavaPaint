package canvas;

import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.Iterator;

public abstract class MouseModeCommandDraw implements UndoableCommandInterface{
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    History history;
    ShapeList shapeList;

    public abstract void setPoint1(Point point);
    public abstract void setPoint2(Point point);
    public abstract Point getPoint1();
    public abstract Point getPoint2();

    public MouseModeCommandDraw(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.history = history;
        this.shapeList = shapeList;
    }

//    @Override
//    public void onMousePressed() {}
    @Override
    public void execute() {
        this.setPoint1(appState.getPoint1());
        this.setPoint2(appState.getPoint2());
        this.draw();
        history.push(this);
        shapeList.addShapeToShapeList(this);
    }
//    @Override
//    public void onMouseClicked() {}
    @Override
    public void unExecute() {
        shapeList.removeShape();
        paintCanvas.paint(paintCanvas.getGraphics2D());



//        Iterator<MouseModeCommandDraw> it = shapeList.getShapeList().iterator();
//        while (it.hasNext()) {
//            it.next();
//
//        }

    }

    public abstract void draw();

}
