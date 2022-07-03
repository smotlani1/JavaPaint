package model;
import canvas.History;
import canvas.MouseModeCommandAbstract;
import canvas.MouseModeCommandInterface;
import canvas.ToolType;
import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clickHandler extends MouseAdapter{
    ApplicationState state;
    PaintCanvasBase paintCanvas;
    History history;
    MouseModeCommandInterface tool;


    public clickHandler(ApplicationState state, PaintCanvasBase paintCanvas, History history) {
        this.state = state;
        this.paintCanvas = paintCanvas;
        this.history = history;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tool = ToolType.getTool(state, paintCanvas, history);
        tool.onMouseClicked();
    }

    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        state.setPoint1(new Point(x, y));
        tool = ToolType.getTool(state, paintCanvas, history);
        tool.onMousePressed();

    }

    @Override
    public void mouseReleased(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        state.setPoint2(new Point(x, y));
        tool = ToolType.getTool(state, paintCanvas, history);
        tool.onMouseReleased();

    }

}
