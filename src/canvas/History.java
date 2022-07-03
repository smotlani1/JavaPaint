package canvas;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {
    private Deque<UndoableCommandInterface> commands = new ArrayDeque<>();

    public void push(UndoableCommandInterface undoableCommand) {
        commands.push(undoableCommand);
    }

    public UndoableCommandInterface pop() {
         return commands.pop();
    }
}
