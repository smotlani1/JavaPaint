package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawEllipse extends MouseModeDraw {
    public DrawEllipse(ApplicationState appState, PaintCanvasBase paintCanvas) {
        super(appState, paintCanvas);
    }

    @Override
    public void draw() {
        System.out.println("Draw Ellipse");
    }
}
