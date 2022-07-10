package canvas;

public interface UndoableCommandInterface extends MouseModeCommandInterface {
    void undo();
    void redo();
}
