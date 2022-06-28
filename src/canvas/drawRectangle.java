package canvas;

import model.persistance.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class drawRectangle extends drawTool{

    private PaintCanvasBase paintCanvas;

    public drawRectangle(PaintCanvasBase paintCanvas, ApplicationState appState) {
        super(appState);
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void draw() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect(appState.getPoint1().getX(), appState.getPoint1().getY(), (appState.getPoint2().getX()-appState.getPoint1().getX()), (appState.getPoint2().getY()-appState.getPoint1().getY()));
    }
}
