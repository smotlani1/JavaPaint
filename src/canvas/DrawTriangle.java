//package canvas;
//
//import model.persistance.ApplicationState;
//import model.persistance.Point;
//import view.interfaces.PaintCanvasBase;
//
//public class DrawTriangle extends MouseModeCommandDraw {
//    Point point1;
//    Point point2;
//
//    @Override
//    public void setPoint1(Point point) {
//        this.point1 = point;
//    }
//    @Override
//    public void setPoint2(Point point) {
//        this.point2 = point;
//    }
//    public DrawTriangle(ApplicationState appState, PaintCanvasBase paintCanvas, History history, ShapeList shapeList) {
//        super(appState, paintCanvas, history, shapeList);
//    }
//
//    @Override
//    public void draw() {
//        System.out.println("Draw Triangle");
//    }
//
////    @Override
////    public void unExecute(){
////        System.out.println("Undoing Triangle");
////    }
//}
