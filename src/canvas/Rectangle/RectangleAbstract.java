package canvas.Rectangle;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class RectangleAbstract {
    int startX;
    int startY;
    int width;
    int height;
    PaintCanvasBase paintCanvas;
    protected boolean selected = false;

    public RectangleAbstract(int startX, int startY, int width, int height, PaintCanvasBase paintCanvas) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;

        this.paintCanvas = paintCanvas;
    }

    public void draw() {}
}
