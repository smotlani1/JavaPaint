package canvas;

import canvas.Triangle.*;
import model.ShapeShadingType;
import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class CreateTriangle extends MouseModeCommandDraw {
    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    Graphics2D graphics2d;
    TriangleAbstract state;
    ShapeShadingType shadingType;
    boolean selected = false;

    Color color;
    Color secondaryColor;
    Point point1;
    Point point2;
    public CreateTriangle(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
        super(appState, paintCanvas, history, shapeList);
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shadingType = appState.getActiveShapeShadingType();
        this.secondaryColor = appState.getActiveSecondaryColor().getColor();
        this.color = appState.getActivePrimaryColor().getColor();
    }
    private void setState() {
//        if (selectState == true) {
//
//        }
        if (shadingType == ShapeShadingType.FILLED_IN){
            this.state = new TriangleFilled(color, point1, point2, paintCanvas);
        }
        if (shadingType == ShapeShadingType.OUTLINE){
            this.state = new TriangleOutlined(color, point1, point2, paintCanvas);
        }
        if (shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN){
            this.state = new TriangleOutlinedFilled(color, secondaryColor, point1, point2, paintCanvas);
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
//

//    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }


    @Override
    public void draw() {
        if (selected == true) {
            graphics2d = paintCanvas.getGraphics2D();
            float dash1[] = {10.0f};
            Stroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
            graphics2d.setStroke(dashed);
            float slope = ((float)(point2.getY()-point1.getY()) / (point2.getX() - point1.getX()));
            int newRun = (int) ((15f+(point2.getY() - point1.getY())) /slope);
            graphics2d.drawPolygon(new int[]{point1.getX()-5, newRun + (point1.getX()-5), point1.getX()-5}, new int[]{point1.getY()-10, point2.getY()+5, point2.getY()+5}, 3);
        }
        setState();
        this.state.draw();

    }

    @Override
    public MouseModeCommandDraw copy() {
        var copy = new CreateTriangle(appState, paintCanvas, history, shapeList);
        copy.color = this.color;
        copy.secondaryColor = this.secondaryColor;
        copy.state = this.state;
        copy.shadingType = this.shadingType;
        copy.setPoint1(this.getPoint1());
        copy.setPoint2(this.getPoint2());
        return copy;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
