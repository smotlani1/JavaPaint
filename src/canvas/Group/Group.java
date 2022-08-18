package canvas.Group;

import canvas.*;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group implements UndoableCommandInterface {
    PaintCanvasBase paintCanvas;
    private List<MouseModeCommandDraw> groupShapes = new ArrayList<>();
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
        System.out.println(groupShapes);
        MouseModeCommandSelect.selectedShapes.clear();
        groupShape.setSelected(true);
        MouseModeCommandSelect.selectedShapes.add(groupShape);
        ShapeList.shapeList.add(groupShape);
        paintCanvas.paint(paintCanvas.getGraphics2D());
    }

    @Override
    public void undo() {
        Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            ShapeList.shapeList.add(shape);
        }
        ShapeList.shapeList.remove(groupShape);
        groupShape.setSelected(false);
        System.out.println(ShapeList.shapeList);
        paintCanvas.paint(paintCanvas.getGraphics2D());
    }

    @Override
    public void redo() {
        this.execute();
    }
}
