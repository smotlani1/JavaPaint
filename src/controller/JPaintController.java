package controller;

import canvas.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private History history;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, History history) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.history = history;
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
        uiModule.addEvent(EventName.PASTE, () -> new Paste().execute());
        uiModule.addEvent(EventName.DELETE, () -> new Delete().execute());
    }
}
