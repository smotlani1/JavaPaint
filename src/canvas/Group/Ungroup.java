package canvas.Group;

import canvas.MouseModeCommandDraw;
import canvas.MouseModeCommandSelect;

import java.util.Iterator;

public class Ungroup {
    public void execute() {
        Iterator<MouseModeCommandDraw> iterator = MouseModeCommandSelect.selectedShapes.iterator();
        while (iterator.hasNext()) {
            MouseModeCommandDraw shape = iterator.next();
            shape.undo();
        }
    }
}
