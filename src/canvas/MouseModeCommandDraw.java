package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public abstract class MouseModeCommandDraw implements UndoableCommandInterface{
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    History history;
    public MouseModeCommandDraw(ApplicationState appState, PaintCanvasBase paintCanvas, History history) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.history = history;
    }

    @Override
    public void onMousePressed() {}
    @Override
    public void onMouseReleased() {
        this.draw();
        history.push(this);
    }
    @Override
    public void onMouseClicked() {}
    @Override
    public void unExecute() {

    }

    public abstract void draw();

}
