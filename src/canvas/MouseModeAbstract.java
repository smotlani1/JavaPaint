package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public abstract class MouseModeAbstract {
    PaintCanvasBase paintCanvas;
    ApplicationState appState;

    public MouseModeAbstract(ApplicationState appState, PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }

    public abstract void onMousePressed();
    public abstract void onMouseReleased();
    public abstract void onMouseClicked();


}
