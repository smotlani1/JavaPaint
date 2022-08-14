package canvas.Group;

import canvas.History;
import canvas.UndoableCommandInterface;
import view.interfaces.PaintCanvasBase;

public class Group implements UndoableCommandInterface {
    PaintCanvasBase paintCanvas;
    GroupShape groupShape;

    public Group(PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
        this.groupShape = new GroupShape(paintCanvas);
        History.push(this);
    }

    @Override
    public void execute() {
        groupShape.execute();
    }

    @Override
    public void undo() {
        System.out.println(History.undoStack);
        groupShape.undo();
    }

    @Override
    public void redo() {
        this.execute();
    }
}
