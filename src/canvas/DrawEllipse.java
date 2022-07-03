package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawEllipse extends MouseModeCommandDraw {
    public DrawEllipse(ApplicationState appState, PaintCanvasBase paintCanvas, History history) {
        super(appState, paintCanvas, history);
    }

    @Override
    public void draw() {
        System.out.println("Draw Ellipse");
    }

    @Override
    public void unExecute() {
        System.out.println("Undoing draw ellipse");
    }
}
