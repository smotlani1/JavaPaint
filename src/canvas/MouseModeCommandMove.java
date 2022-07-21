package canvas;

import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.util.Iterator;

public class MouseModeCommandMove implements MouseModeCommandInterface {

    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    public MouseModeCommandMove(ApplicationState appState, PaintCanvasBase paintCanvas) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }


    @Override
    public void execute() {
        if (appState.getPoint1() != null) {
            int xDiff = appState.getPoint2().getX() - appState.getPoint1().getX();
            int yDiff = appState.getPoint2().getY() - appState.getPoint1().getY();
            Iterator<MouseModeCommandDraw> iterator = MouseModeCommandSelect.selectedShapes.iterator();
            while (iterator.hasNext()) {
                MouseModeCommandDraw shape = iterator.next();
                shape.setPoint1(new Point((shape.getPoint1().getX() + xDiff), (shape.getPoint1().getY()) + yDiff));
                shape.setPoint2(new Point((shape.getPoint2().getX() + xDiff), (shape.getPoint2().getY()) + yDiff));
            }
            paintCanvas.paint(paintCanvas.getGraphics2D());
        }
    }

//    private Point transpose(Shape shape, int xDiff, int yDiff) {
//
//    }
}
