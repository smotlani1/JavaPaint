package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public abstract class MouseModeCommandDraw extends MouseModeCommandAbstract {
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    public MouseModeCommandDraw(ApplicationState appState, PaintCanvasBase paintCanvas) {
        super(appState, paintCanvas);
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void onMousePressed() {

    }

    @Override
    public void onMouseReleased() {
        this.draw();
    }

    @Override
    public void onMouseClicked() {

    }


    public abstract void draw();
}
