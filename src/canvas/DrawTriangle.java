package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class DrawTriangle extends MouseModeCommandDraw {
    public DrawTriangle(ApplicationState appState, PaintCanvasBase paintCanvas, History history) {
        super(appState, paintCanvas, history);
    }

    @Override
    public void draw() {
        System.out.println("Draw Triangle");
    }

    @Override
    public void unExecute(){
        System.out.println("Undoing Triangle");
    }
}
