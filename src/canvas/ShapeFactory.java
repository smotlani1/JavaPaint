package canvas;

import model.ShapeType;
import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class ShapeFactory extends ShapeFactoryAbstract{

    @Override
    MouseModeCommandDraw getShapeToDraw(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        if (appState.getActiveShapeType() == ShapeType.RECTANGLE) {
            return new CreateRectangle(appState, paintCanvas, history, shapeList);
        }
        else if (appState.getActiveShapeType() == ShapeType.ELLIPSE) {
            return new CreateEllipse(appState, paintCanvas, history, shapeList);
        }
        else if (appState.getActiveShapeType() == ShapeType.TRIANGLE) {
            return new CreateTriangle(appState, paintCanvas, history, shapeList);
        }

        return null;
    }
}
