package canvas.Ellipse;

import view.interfaces.PaintCanvasBase;

public class EllipseAbstract {
    int startX;
    int startY;
    int width;
    int height;
    PaintCanvasBase paintCanvas;

    public EllipseAbstract(int startX, int startY, int width, int height, PaintCanvasBase paintCanvas) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;

        this.paintCanvas = paintCanvas;
    }

    public void draw() {}
}
