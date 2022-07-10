package canvas;

public class UndoCommand implements MouseModeCommandInterface{
    private History history;
    public UndoCommand(History history) {
        this.history = history;
    }

    @Override
    public void execute() {
        history.pop().undo();

    }
}

    //    @Override
//    public void onMousePressed() {
//
//    }
//
//    @Override
//    public void onMouseReleased() {
//
//    }




