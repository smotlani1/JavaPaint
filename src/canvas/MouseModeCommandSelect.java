package canvas;

import model.persistance.ApplicationState;
import model.persistance.Point;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MouseModeCommandSelect implements MouseModeCommandInterface {

    ApplicationState appState;
    PaintCanvasBase paintCanvas;
    ShapeList shapeList;
    static List<MouseModeCommandDraw> selectedShapes = new ArrayList<>();

    public MouseModeCommandSelect(ApplicationState appState, PaintCanvasBase paintCanvas, ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        if(selectedShapes != null) {
            Iterator<MouseModeCommandDraw> iterator = this.selectedShapes.iterator();
            while (iterator.hasNext()) {
                MouseModeCommandDraw shape = iterator.next();
                shape.setSelected(false);
            }
            selectedShapes.clear();
        }
        getSelectedObjects();

        if(selectedShapes != null) {
            Iterator<MouseModeCommandDraw> iterator = this.selectedShapes.iterator();
            while (iterator.hasNext()) {
                MouseModeCommandDraw shape = iterator.next();
                shape.setSelected(true);
            }
            paintCanvas.paint(paintCanvas.getGraphics2D());
        }

    }

    private void getSelectedObjects() {
        Iterator<MouseModeCommandDraw> iterator = shapeList.shapeList.iterator();
        CollisionDetection collisionDetection = new CollisionDetection(appState.getPoint1(), appState.getPoint2());

        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            if (collisionDetection.collides(shape)){
               selectedShapes.add(shape);
            }
        }
//        return selectedShapes;
    }




}
