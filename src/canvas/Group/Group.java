package canvas.Group;

import canvas.*;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements UndoableCommandInterface {
    PaintCanvasBase paintCanvas;
    List<MouseModeCommandDraw> groupShapes = new ArrayList<>();
    GroupShape groupShape;

    public Group(PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
        this.groupShapes.addAll(MouseModeCommandSelect.selectedShapes);
        this.groupShape = new GroupShape(paintCanvas, groupShapes);
        History.push(this);
    }

    @Override
    public void execute() {
        Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.setSelected(false);
            ShapeList.shapeList.remove(shape);
        }
        MouseModeCommandSelect.selectedShapes.clear();
        groupShape.setSelected(true);
        MouseModeCommandSelect.selectedShapes.add(groupShape);
        ShapeList.shapeList.add(groupShape);
        paintCanvas.paint(paintCanvas.getGraphics2D());
    }

    @Override
    public void undo() {
        groupShape.undo();
        System.out.println(History.undoStack);
        System.out.println(ShapeList.shapeList);
    }

    @Override
    public void redo() {
        this.execute();
        System.out.println(History.undoStack);
    }
}
