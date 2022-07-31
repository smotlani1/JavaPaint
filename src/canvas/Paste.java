package canvas;

import model.persistance.Point;

import java.util.Iterator;

public class Paste implements UndoableCommandInterface{
    private int offset;

    public Paste() {
        this.offset = 50;
    }

    @Override
    public void execute() {
        Iterator<MouseModeCommandDraw> iterator = Copy.clipBoard.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.setPoint1(new Point((shape.getPoint1().getX() + offset), (shape.getPoint1().getY()) + offset));
            shape.setPoint2(new Point((shape.getPoint2().getX() + offset), (shape.getPoint2().getY()) + offset));
            shape.draw();
        }
        System.out.println("Pasted");

    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
