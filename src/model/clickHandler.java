package model;
import canvas.*;
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
    ShapeList shapeList;


    public clickHandler(ApplicationState state, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        this.state = state;
        this.paintCanvas = paintCanvas;
        this.history = history;
        this.shapeList = shapeList;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tool = ToolType.getTool(state, paintCanvas, history, shapeList);
        tool.execute();
    }

    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        state.setPoint1(new Point(x, y));
//        tool = ToolType.getTool(state, paintCanvas, history);
//        tool.onMousePressed();

    }

    @Override
    public void mouseReleased(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        state.setPoint2(new Point(x, y));
        tool = ToolType.getTool(state, paintCanvas, history, shapeList);
        tool.execute();

    }

}
