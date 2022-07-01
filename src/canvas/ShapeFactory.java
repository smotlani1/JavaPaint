package canvas;

import model.ShapeType;
import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class ShapeFactory extends ShapeFactoryAbstract{

    @Override
    MouseModeCommandDraw getShapeToDraw(ApplicationState appState, PaintCanvasBase paintCanvas) {
        if (appState.getActiveShapeType() == ShapeType.RECTANGLE) {
            return new DrawRectangle(appState, paintCanvas);
        } else if (appState.getActiveShapeType() == ShapeType.ELLIPSE) {
            return new DrawEllipse(appState, paintCanvas);
        } else if (appState.getActiveShapeType() == ShapeType.TRIANGLE) {
            return new DrawTriangle(appState, paintCanvas);
        }

        return null;
    }
}
