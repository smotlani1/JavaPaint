package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public abstract class MouseModeDraw extends MouseModeAbstract{
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    public MouseModeDraw(ApplicationState appState, PaintCanvasBase paintCanvas) {
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
