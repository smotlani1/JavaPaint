package canvas;

import canvas.Rectangle.*;
import model.ShapeShadingType;
import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

import model.persistance.Point;

import java.awt.*;

public class CreateRectangle extends MouseModeCommandDraw {
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
//    Graphics2D graphics2d;
    RectangleAbstract state;
    ShapeShadingType shadingType;

    Color color;
    Color secondaryColor;
    Point point1;
    Point point2;

    public CreateRectangle(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        super(appState, paintCanvas, history, shapeList);
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shadingType = appState.getActiveShapeShadingType();
        this.secondaryColor = appState.getActiveSecondaryColor().getColor();
        this.color = appState.getActivePrimaryColor().getColor();


    }
    private void setState() {
        if (shadingType == ShapeShadingType.FILLED_IN){
            this.state = new RectangleFilled(color, getStartX(), getStartY(), getWidth(), getHeight(), paintCanvas);
        }
        if (shadingType == ShapeShadingType.OUTLINE){
            this.state = new RectangleOutlined(color, getStartX(), getStartY(), getWidth(), getHeight(), paintCanvas);
        }
        if (shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN){
            this.state = new RectangleOutlineFill(color, secondaryColor, getStartX(), getStartY(), getWidth(), getHeight(), paintCanvas);
        }
    }
    @Override
    public void setPoint1(Point point) {
        this.point1 = point;
    }

    @Override
    public void setPoint2(Point point) {
        this.point2 = point;
    }

//    @Override
//    public void setColor(Color color) {
//        this.color = color;
//    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }
    private int getStartX() {
        return Math.min(point1.getX(), point2.getX());
    }

    private int getStartY() {
        return Math.min(point1.getY(), point2.getY());
    }

    private int getWidth() {
        return Math.abs(point2.getX()-point1.getX());
    }

    private int getHeight(){
        return Math.abs(point2.getY()-point1.getY());
    }



    @Override
    public void draw() {
        setState();
        this.state.draw();
//        graphics2d = paintCanvas.getGraphics2D();
//        graphics2d.setColor(color);
//        graphics2d.fillRect(getStartX(), getStartY(), getWidth(), getHeight());
    }
}