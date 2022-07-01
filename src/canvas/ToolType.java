package canvas;

import model.MouseMode;
import model.ShapeType;
import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;


//Implementation of Static Factory Method?
public class ToolType {

    public static MouseModeCommandAbstract getTool(ApplicationState appState, PaintCanvasBase paintCanvas) {
        if (appState.getActiveMouseMode() == MouseMode.DRAW) {
            ShapeFactory factory = new ShapeFactory();
            return factory.getShapeToDraw(appState, paintCanvas);
        }

        else if (appState.getActiveMouseMode() == MouseMode.MOVE) {
            return new MouseModeCommandMove(appState, paintCanvas);
        }

        else return new MouseModeCommandSelect(appState, paintCanvas);

    }
}
