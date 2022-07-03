package canvas;

import model.MouseMode;
import model.ShapeType;
import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;


//Implementation of Static Factory Method?
public class ToolType {

    public static MouseModeCommandInterface getTool(ApplicationState appState, PaintCanvasBase paintCanvas, History history) {
        if (appState.getActiveMouseMode() == MouseMode.DRAW) {
            ShapeFactory factory = new ShapeFactory();
            return factory.getShapeToDraw(appState, paintCanvas, history);
        }

        else if (appState.getActiveMouseMode() == MouseMode.MOVE) {
            return new MouseModeCommandMove(appState, paintCanvas);
        }

        else return new MouseModeCommandSelect(appState, paintCanvas);

    }
}
