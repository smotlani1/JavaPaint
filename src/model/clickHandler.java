package model;
import canvas.drawRectangle;
import model.persistance.ApplicationState;
import model.persistance.Point;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clickHandler extends MouseAdapter{
    ApplicationState state;
    PaintCanvasBase paintCanvas;

    public clickHandler(ApplicationState state, PaintCanvasBase paintCanvas) {
        this.state = state;
        this.paintCanvas = paintCanvas;
    }
    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        state.setPoint1(new Point(x, y));

    }

    @Override
    public void mouseReleased(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        state.setPoint2(new Point(x, y));
        var rectangle = new drawRectangle(paintCanvas, state);
        rectangle.draw();

    }
}
