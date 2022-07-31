package canvas;

import canvas.Ellipse.*;
import canvas.Rectangle.RectangleAbstract;
import canvas.Rectangle.RectangleFilled;
import canvas.Rectangle.RectangleOutlineFill;
import canvas.Rectangle.RectangleOutlined;
import model.ShapeShadingType;
import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class CreateEllipse extends MouseModeCommandDraw{
    ApplicationState appState;
    PaintCanvasBase paintCanvas;

    EllipseAbstract state;
    ShapeShadingType shadingType;

    Color color;
    Color secondaryColor;
    Point point1;
    Point point2;

    public CreateEllipse(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        super(appState, paintCanvas, history, shapeList);
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shadingType = appState.getActiveShapeShadingType();
        this.secondaryColor = appState.getActiveSecondaryColor().getColor();
        this.color = appState.getActivePrimaryColor().getColor();
    }

    private void setState() {
        if (shadingType == ShapeShadingType.FILLED_IN){
            this.state = new EllipseFilled(color, getStartX(), getStartY(), getWidth(), getHeight(), paintCanvas);
        }
        if (shadingType == ShapeShadingType.OUTLINE){
            this.state = new EllipseOutlined(color, getStartX(), getStartY(), getWidth(), getHeight(), paintCanvas);
        }
        if (shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN){
            this.state = new EllipseOutlinedFilled(color, secondaryColor, getStartX(), getStartY(), getWidth(), getHeight(), paintCanvas);
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

    @Override
    public Point getPoint1() {
        return point1;
    }

    @Override
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

    }

    @Override
    public MouseModeCommandDraw copy() {
        var copy = new CreateEllipse(appState, paintCanvas, history, shapeList);
        copy.color = this.color;
        copy.secondaryColor = this.secondaryColor;
        copy.state = this.state;
        copy.shadingType = this.shadingType;
        return copy;
    }
}
