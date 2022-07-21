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
        getSelectedObjects();

        if(selectedShapes != null) {
            System.out.println(selectedShapes);
        }
        else {
            System.out.println("all objects deselected");
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
