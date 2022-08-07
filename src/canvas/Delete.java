package canvas;

import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Delete implements UndoableCommandInterface{
    private List<MouseModeCommandDraw> shapesToDelete = new ArrayList<>();


    @Override
    public void execute() {
        Iterator<MouseModeCommandDraw> iterator = MouseModeCommandSelect.selectedShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shapesToDelete.add(shape);
            shape.undo();
        }
        History.push(this);
//        paintCanvas.paint(paintCanvas.getGraphics2D());
    }

    @Override
    public void undo() {
        Iterator<MouseModeCommandDraw> iterator = this.shapesToDelete.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.redo();
        }
        this.shapesToDelete.clear();
    }

    @Override
    public void redo() {
        this.execute();
    }
}
