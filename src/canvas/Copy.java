package canvas;

import java.util.ArrayList;
import java.util.List;

public class Copy {
    static List<MouseModeCommandDraw> clipBoard = new ArrayList<>();

    public Copy() {

    }

    public void execute() {
        clipBoard.clear();
        clipBoard.addAll(MouseModeCommandSelect.selectedShapes);
        System.out.println(clipBoard);
    }
}
