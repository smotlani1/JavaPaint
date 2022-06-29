package canvas;

import model.MouseMode;
import model.ShapeType;
import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class ToolType {

    public static MouseModeAbstract getTool(ApplicationState appState, PaintCanvasBase paintCanvas) {
        if (appState.getActiveMouseMode() == MouseMode.DRAW) {
            if (appState.getActiveShapeType() == ShapeType.RECTANGLE) {
                return new DrawRectangle(appState, paintCanvas);
            } else if (appState.getActiveShapeType() == ShapeType.ELLIPSE) {
                return new DrawEllipse(appState, paintCanvas);
            } else if (appState.getActiveShapeType() == ShapeType.TRIANGLE) {
                return new DrawTriangle(appState, paintCanvas);
            }
        } else if (appState.getActiveMouseMode() == MouseMode.MOVE) {
            return new MouseModeMove(appState, paintCanvas);

        } else return new MouseModeSelect(appState, paintCanvas);

        return null;
    }
}
