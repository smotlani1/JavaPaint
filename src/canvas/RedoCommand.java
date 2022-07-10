package canvas;

public class RedoCommand implements MouseModeCommandInterface{
    private History history;
    public RedoCommand(History history) {
        this.history = history;
    }

    @Override
    public void execute() {
        history.redo().redo();

    }
}
