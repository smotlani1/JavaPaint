package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public abstract class ShapeFactoryAbstract {
    abstract MouseModeCommandDraw getShapeToDraw(ApplicationState appState, PaintCanvasBase paintCanvas, History history);
}
