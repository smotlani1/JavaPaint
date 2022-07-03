package canvas;

import model.persistance.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class UndoCommand implements MouseModeCommandInterface{
    private History history;
    public UndoCommand(History history) {
        this.history = history;
    }


    @Override
    public void onMousePressed() {

    }

    @Override
    public void onMouseReleased() {

    }

    @Override
    public void onMouseClicked() {
        history.pop().unExecute();

    }


}
