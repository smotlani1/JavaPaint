package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawRectangle extends MouseModeCommandDraw {
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    History history;
    public DrawRectangle(ApplicationState appState, PaintCanvasBase paintCanvas, History history) {
        super(appState, paintCanvas, history);
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.history = history;
    }

    @Override
    public void draw() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(appState.getActivePrimaryColor().getColor());
        graphics2d.fillRect(appState.getPoint1().getX(), appState.getPoint1().getY(), (appState.getPoint2().getX()-appState.getPoint1().getX()), (appState.getPoint2().getY()-appState.getPoint1().getY()));
    }

    @Override
    public void unExecute() {
        System.out.println("Rectangle draw unexecuted");
    }
}
