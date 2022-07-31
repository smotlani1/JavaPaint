package canvas;

import model.persistance.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Paste implements UndoableCommandInterface{
    private int offset;
    MouseModeCommandInterface tool;
    private List<MouseModeCommandDraw> clipBoard = new ArrayList<>();
    private List<MouseModeCommandDraw> pastedShapes = new ArrayList<>();

    public Paste() {
        this.offset = 50;
        this.clipBoard.addAll(Copy.clipBoard);
    }

    @Override
    public void execute() {
        Iterator<MouseModeCommandDraw> iterator = this.clipBoard.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            var shapeCopy = shape.copy();
            shapeCopy.setPoint1(new Point((shape.getPoint1().getX() + offset), (shape.getPoint1().getY()) + offset));
            shapeCopy.setPoint2(new Point((shape.getPoint2().getX() + offset), (shape.getPoint2().getY()) + offset));
            pastedShapes.add(shapeCopy);
            shapeCopy.draw();
            ShapeList.shapeList.push(shapeCopy);
//            shape.draw();
//            ShapeList.shapeList.push(shape);
        }
        History.push(this);
        System.out.println("Pasted");

    }

    @Override
    public void undo() {
        Iterator<MouseModeCommandDraw> iterator = this.pastedShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.undo();
        }
        pastedShapes.clear();

    }

    @Override
    public void redo() {
        this.execute();
    }
}
