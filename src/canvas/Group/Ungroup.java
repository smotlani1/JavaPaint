package canvas.Group;

import canvas.*;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ungroup implements UndoableCommandInterface {
    private List<MouseModeCommandDraw> Selected = new ArrayList<>();
    private List<MouseModeCommandDraw> UnGroupedShapes = new ArrayList<>();
    PaintCanvasBase paintCanvas;

    public Ungroup(PaintCanvasBase paintCanvas) {
        Selected.addAll(MouseModeCommandSelect.selectedShapes);
        this.paintCanvas = paintCanvas;
        History.push(this);
    }
    public void execute() {
        Iterator<MouseModeCommandDraw> iterator = Selected.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.undo();
        }
        UnGroupedShapes.addAll(MouseModeCommandSelect.selectedShapes);
    }

    @Override
    public void undo() {
        History.undoStack.pop();
        var group = new Group(paintCanvas);
        group.groupShapes.clear();
        group.groupShapes.addAll(UnGroupedShapes);
        group.execute();
        Selected.clear();
        Selected.add(group.groupShape);
    }

    @Override
    public void redo() {
        this.execute();
    }
}
