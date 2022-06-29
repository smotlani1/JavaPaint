package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawTriangle extends MouseModeDraw {
    public DrawTriangle(ApplicationState appState, PaintCanvasBase paintCanvas) {
        super(appState, paintCanvas);
    }

    @Override
    public void draw() {
        System.out.println("Draw Triangle");
    }
}
