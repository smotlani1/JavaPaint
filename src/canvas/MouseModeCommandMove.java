package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseModeCommandMove extends MouseModeCommandAbstract {
    public MouseModeCommandMove(ApplicationState appState, PaintCanvasBase paintCanvas) {
        super(appState, paintCanvas);
    }

    @Override
    public void onMousePressed() {

    }

    @Override
    public void onMouseReleased() {

    }

    @Override
    public void onMouseClicked() {
        System.out.println("moving object");
    }
}
