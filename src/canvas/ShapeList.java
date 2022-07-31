package canvas;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShapeList {
    static public Deque<MouseModeCommandDraw> shapeList = new ArrayDeque<>();

    public Deque<MouseModeCommandDraw> getShapeList() {
        return shapeList;
    }

    public void addShapeToShapeList(MouseModeCommandDraw shape) {
        shapeList.push(shape);
    }

    public MouseModeCommandDraw removeShape() {

        return shapeList.pop();
    }
}
