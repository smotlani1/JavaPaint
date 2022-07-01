package model;
import canvas.MouseModeCommandAbstract;
import canvas.ToolType;
import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clickHandler extends MouseAdapter{
    ApplicationState state;
    PaintCanvasBase paintCanvas;
    MouseModeCommandAbstract tool;


    public clickHandler(ApplicationState state, PaintCanvasBase paintCanvas) {
        this.state = state;
        this.paintCanvas = paintCanvas;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tool = ToolType.getTool(state, paintCanvas);
        tool.onMouseClicked();
    }

    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        state.setPoint1(new Point(x, y));
        tool = ToolType.getTool(state, paintCanvas);
        tool.onMousePressed();

    }

    @Override
    public void mouseReleased(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        state.setPoint2(new Point(x, y));
        tool = ToolType.getTool(state, paintCanvas);
        tool.onMouseReleased();

    }

}
