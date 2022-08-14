package canvas.Group;

import canvas.*;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupShape extends MouseModeCommandDraw {
    private boolean selected;
    private List<MouseModeCommandDraw> groupShapes = new ArrayList<>();
    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;

    Point point1;
    Point point2;

    public GroupShape(PaintCanvasBase paintCanvas) {
        super(paintCanvas);
        this.paintCanvas = paintCanvas;
        this.groupShapes.addAll(MouseModeCommandSelect.selectedShapes);
        this.setPoint1(this.getMinPoint());
        this.setPoint2(this.getMaxPoint());
    }


    public void execute() {
        Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.setSelected(false);
            ShapeList.shapeList.remove(shape);
        }
        System.out.println(groupShapes);
        MouseModeCommandSelect.selectedShapes.clear();
        this.setSelected(true);
        MouseModeCommandSelect.selectedShapes.add(this);
        ShapeList.shapeList.add(this);
        paintCanvas.paint(paintCanvas.getGraphics2D());

//        this.draw();

    }

    @Override
    public void draw() {
        if (selected == true) {
            graphics2d = paintCanvas.getGraphics2D();
            float dash1[] = {10.0f};
            Stroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
            graphics2d.setStroke(dashed);
            graphics2d.drawRect(this.getPoint1().getX() - 3, this.getPoint1().getY() - 3, this.getWidth() + 6, this.getHeight() + 6);
            System.out.println(MouseModeCommandSelect.selectedShapes);
        }
        Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.draw();
        }
    }

    @Override
    public void undo() {
        Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            ShapeList.shapeList.add(shape);
        }
        ShapeList.shapeList.remove(this);
        this.setSelected(false);
        System.out.println(ShapeList.shapeList);
        paintCanvas.paint(paintCanvas.getGraphics2D());
    }

    @Override
    public MouseModeCommandDraw copy() {
        var copy = new GroupShape(paintCanvas);
        copy.groupShapes.clear();
        Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            copy.groupShapes.add(shape.copy());
        }
        return copy;
//        return null;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;

    }

    private Point getMinPoint(){
        Integer minX = Integer.MAX_VALUE;
        Integer minY = Integer.MAX_VALUE;
        Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            minX = Math.min(minX, shape.getPoint1().getX());
            minY = Math.min(minY, shape.getPoint1().getY());
        }
        return new Point(minX, minY);
    }

    private Point getMaxPoint(){
        int maxX = 0;
        int maxY = 0;
        Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            maxX = Math.max(maxX, shape.getPoint2().getX());
            maxY = Math.max(maxY, shape.getPoint2().getY());
        }
        return new Point(maxX, maxY);
    }

    private int getWidth() {
        return Math.abs(point2.getX()-point1.getX());
    }

    private int getHeight(){
        return Math.abs(point2.getY()-point1.getY());
    }

    @Override
    public void setPoint1(Point point) {
        if (point1 != null) {

            int x = point.getX() - getPoint1().getX();
            int y = point.getY() - getPoint1().getY();
            Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
            while (iterator.hasNext()) {
                MouseModeCommandDraw shape = iterator.next();
                shape.setPoint1(new Point((shape.getPoint1().getX() + x), (shape.getPoint1().getY()) + y));
            }
        }

        this.point1 = point;
    }

    @Override
    public void setPoint2(Point point) {
        if (point2 != null) {
            int x = point.getX() - getPoint2().getX();
            int y = point.getY() - getPoint2().getY();
            Iterator<MouseModeCommandDraw> iterator = groupShapes.iterator();
            while (iterator.hasNext()) {
                MouseModeCommandDraw shape = iterator.next();
                shape.setPoint2(new Point((shape.getPoint2().getX() + x), (shape.getPoint2().getY()) + y));
            }
        }
        this.point2 = point;
    }

    @Override
    public Point getPoint1() {
        return this.point1;
    }

    @Override
    public Point getPoint2() {
        return this.point2;
    }
}
