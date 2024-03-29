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
//    public abstract void setColor(Color color);
    public abstract Point getPoint1();
    public abstract Point getPoint2();

    public MouseModeCommandDraw(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.history = history;
        this.shapeList = shapeList;
    }
    public MouseModeCommandDraw(PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void execute() {
        this.setPoint1(appState.getPoint1());
        this.setPoint2(appState.getPoint2());
//        this.setColor(appState.getActivePrimaryColor().getColor());
        this.draw();
        history.push(this);
        shapeList.addShapeToShapeList(this);
    }
    @Override
    public void undo() {
        ShapeList.shapeList.remove(this);
        paintCanvas.paint(paintCanvas.getGraphics2D());
    }

    @Override
    public void redo() {
        ShapeList.shapeList.add(this);
        this.draw();
//        paintCanvas.paint(paintCanvas.getGraphics2D());
    }

    public void delete() {
        this.undo();
    }
    public abstract void draw();
    public abstract MouseModeCommandDraw copy();

    public abstract void setSelected(boolean selected);
}






