package main;

import canvas.History;
import canvas.ShapeList;
import controller.IJPaintController;
import controller.JPaintController;
import model.clickHandler;
import model.persistance.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        ShapeList shapeList = new ShapeList();
        PaintCanvasBase paintCanvas = new PaintCanvas(shapeList);
        History history = new History();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState, history, paintCanvas);
        controller.setup();

        clickHandler clickHandler = new clickHandler(appState, paintCanvas, history, shapeList);
        paintCanvas.addMouseListener(clickHandler);


        // For example purposes only; remove all lines below from your final project.

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        var rectangle = new drawRectangle(paintCanvas, appState);
//        rectangle.draw();



        // Filled in rectangle
//        Graphics2D graphics2d = paintCanvas.getGraphics2D();
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);

        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
    }
}

//Test