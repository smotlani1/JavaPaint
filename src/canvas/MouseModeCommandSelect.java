package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseModeCommandSelect implements MouseModeCommandInterface {

    ApplicationState appState;
    PaintCanvasBase paintCanvas;

    public MouseModeCommandSelect(ApplicationState appState, PaintCanvasBase paintCanvas) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void onMousePressed() {

    }

    @Override
    public void onMouseReleased() {

    }

    @Override
    public void onMouseClicked() {
        System.out.println("Object Selected");

    }


}
