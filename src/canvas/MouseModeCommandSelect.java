package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MouseModeCommandSelect implements MouseModeCommandInterface {

    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    ShapeList shapeList;
    List<MouseModeCommandDraw> selectedShapes = new ArrayList<>();

    public MouseModeCommandSelect(ApplicationState appState, PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        MouseModeCommandDraw shape = getSelectedObject();

        if(shape != null) {
            System.out.println(shape);
            selectedShapes.add(shape);
        }
        else {
            System.out.println("all objects deselected");
            selectedShapes.clear();
        }


    }

    private MouseModeCommandDraw getSelectedObject() {
        Iterator<MouseModeCommandDraw> iterator = shapeList.shapeList.iterator();

        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            if (containsPoint(shape)){
               return shape;
            }
        }
        return null;
    }

    private boolean containsPoint(MouseModeCommandDraw shape){
        int x1 = appState.getPoint2().getX();
        int y1 = appState.getPoint2().getY();

        if (x1 >= Math.min(shape.getPoint1().getX(), shape.getPoint2().getX()) && x1 <= Math.max(shape.getPoint1().getX(), shape.getPoint2().getX())) {
            if (y1 >= Math.min(shape.getPoint1().getY(), shape.getPoint2().getY()) && y1 <= Math.max(shape.getPoint1().getY(), shape.getPoint2().getY()))
                return true;
        }
        return false;
    }


}
