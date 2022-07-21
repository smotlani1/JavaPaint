package canvas;

import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.util.Iterator;

public class MouseModeCommandMove implements UndoableCommandInterface {

    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    int xDiff;
    int yDiff;

    public MouseModeCommandMove(ApplicationState appState, PaintCanvasBase paintCanvas) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.xDiff = appState.getPoint2().getX() - appState.getPoint1().getX();
        this.yDiff = appState.getPoint2().getY() - appState.getPoint1().getY();
    }


    @Override
    public void execute() {
        if (appState.getPoint1() != null) {
            transpose(xDiff, yDiff);
            History.push(this);
            paintCanvas.paint(paintCanvas.getGraphics2D());
        }
    }

    private void transpose(int x, int y) {
        Iterator<MouseModeCommandDraw> iterator = MouseModeCommandSelect.selectedShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.setPoint1(new Point((shape.getPoint1().getX() + x), (shape.getPoint1().getY()) + y));
            shape.setPoint2(new Point((shape.getPoint2().getX() + x), (shape.getPoint2().getY()) + y));
        }
    }
    @Override
    public void undo() {
        Iterator<MouseModeCommandDraw> iterator = MouseModeCommandSelect.selectedShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.setPoint1(new Point((shape.getPoint1().getX() - xDiff), (shape.getPoint1().getY()) -yDiff));
            shape.setPoint2(new Point((shape.getPoint2().getX() -xDiff), (shape.getPoint2().getY()) -yDiff));
        }
        paintCanvas.paint(paintCanvas.getGraphics2D());
    }

    @Override
    public void redo() {
        this.transpose(xDiff, yDiff);
        paintCanvas.paint(paintCanvas.getGraphics2D());
    }
}
