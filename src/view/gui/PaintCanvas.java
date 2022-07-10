package view.gui;

import canvas.MouseModeCommandDraw;
import canvas.ShapeList;
import view.interfaces.PaintCanvasBase;

import javax.swing.JComponent;
import java.awt.*;
import java.util.Iterator;

public class PaintCanvas extends PaintCanvasBase {
    ShapeList shapeList;

    public PaintCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
    }



    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0,0,1000,1000);

        Iterator<MouseModeCommandDraw> it = shapeList.getShapeList().iterator();
        while (it.hasNext()) {
            it.next().draw();
        }
//            System.out.println("draw");
////            graphics2d.setColor(Color.BLUE);
////            graphics2d.fillRect(0,0, 100,300);
////            graphics2d.fillRect(it.next().getPoint1().getX(), it.next().getPoint2().getY(), (it.next().getPoint2().getX()-it.next().getPoint1().getX()), (it.next().getPoint2().getY()-it.next().getPoint1().getY()));
//            System.out.println(it.next());
//        }
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//        super.paint(g);

    }
}
