package canvas;

import model.persistance.Point;

import java.util.ArrayList;
import java.util.List;

public class CollisionDetection {
    int leftBoundX;
    int rightBoundX;
    int topBoundY;
    int bottomBoundY;


    public CollisionDetection(Point point1_selection, Point point2_selection) {
        this.leftBoundX = Math.min(point1_selection.getX(), point2_selection.getX());
        this.rightBoundX = Math.max(point1_selection.getX(), point2_selection.getX());
        this.topBoundY = Math.min(point1_selection.getY(), point2_selection.getY());
        this.bottomBoundY = Math.max(point1_selection.getY(), point2_selection.getY());;
    }


    public boolean collides(MouseModeCommandDraw shape) {
        return this.rightBoundX > Math.min(shape.getPoint1().getX(), shape.getPoint2().getX()) &&
                        this.leftBoundX < Math.max(shape.getPoint1().getX(), shape.getPoint2().getX()) &&
                        this.bottomBoundY > Math.min(shape.getPoint1().getY(), shape.getPoint2().getY()) &&
                        this.topBoundY < Math.max(shape.getPoint1().getY(), shape.getPoint2().getY());
    }
}
