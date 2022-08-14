package canvas;

import java.util.Stack;

//public class History {
//    private Deque<UndoableCommandInterface> commands = new ArrayDeque<>();
//
//    public void push(UndoableCommandInterface undoableCommand) {
//        commands.push(undoableCommand);
//    }
//
//    public UndoableCommandInterface pop() {
//         return commands.pop();
//    }
//}


public class History {
    public static final Stack<UndoableCommandInterface> undoStack = new Stack<UndoableCommandInterface>();
    private static final Stack<UndoableCommandInterface> redoStack = new Stack<UndoableCommandInterface>();

    public static void push(UndoableCommandInterface cmd) {
        undoStack.push(cmd);
//        redoStack.clear();
    }

    public static UndoableCommandInterface pop() {
        boolean result = !undoStack.empty();
        if (result) {
            UndoableCommandInterface c = undoStack.pop();
            redoStack.push(c);
            return c;
        }
        return null;
    }

    public static UndoableCommandInterface redo() {
        boolean result = !redoStack.empty();
        if (result) {
            UndoableCommandInterface c = redoStack.pop();
            undoStack.push(c);
            return c;
        }
        return null;
    }
}