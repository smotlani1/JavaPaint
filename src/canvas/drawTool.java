package canvas;

import model.persistance.ApplicationState;

public abstract class drawTool {
    ApplicationState appState;
    public drawTool(ApplicationState appState) {
        this.appState = appState;
    }

    void draw() {

    }
}
