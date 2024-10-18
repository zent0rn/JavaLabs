package webProgramming.lab3v1.state;

import webProgramming.lab3v1.userInterface.impl.ShapesUI;

public interface State {
    public void handleState(ShapesUI shapesUI, char command);
}
