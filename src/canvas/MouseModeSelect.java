package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class MouseModeSelect extends MouseModeAbstract{

    public MouseModeSelect(ApplicationState appState, PaintCanvasBase paintCanvas) {
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
        System.out.println("Object Selected");

    }
}
