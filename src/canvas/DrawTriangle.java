package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawTriangle extends MouseModeCommandDraw {
    public DrawTriangle(ApplicationState appState, PaintCanvasBase paintCanvas) {
        super(appState, paintCanvas);
    }

    @Override
    public void draw() {
        System.out.println("Draw Triangle");
    }
}
