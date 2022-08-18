package controller;

import canvas.*;
//import canvas.Group.Group;
import canvas.Group.Group;
import canvas.Group.Ungroup;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private History history;
    private PaintCanvasBase paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, History history, PaintCanvasBase paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.history = history;
        this.paintCanvas = paintCanvas;


    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand(history).execute());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand(history).execute());
        uiModule.addEvent(EventName.COPY, () -> new Copy().execute());
        uiModule.addEvent(EventName.PASTE, () -> new Paste(paintCanvas).execute());
        uiModule.addEvent(EventName.DELETE, () -> new Delete().execute());
        uiModule.addEvent(EventName.GROUP, () -> new Group(paintCanvas).execute());
        uiModule.addEvent(EventName.UNGROUP, () -> new Ungroup().execute());
    }
}
