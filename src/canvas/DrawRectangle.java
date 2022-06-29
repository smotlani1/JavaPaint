package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class DrawRectangle extends MouseModeDraw {
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    public DrawRectangle(ApplicationState appState, PaintCanvasBase paintCanvas) {
        super(appState, paintCanvas);
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void draw() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(appState.getActivePrimaryColor().getColor());
        graphics2d.fillRect(appState.getPoint1().getX(), appState.getPoint1().getY(), (appState.getPoint2().getX()-appState.getPoint1().getX()), (appState.getPoint2().getY()-appState.getPoint1().getY()));
    }
}
