package canvas;

public interface UndoableCommandInterface extends MouseModeCommandInterface {
    void unExecute();
}
