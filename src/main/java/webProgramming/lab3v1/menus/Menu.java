package webProgramming.lab3v1.menus;

import webProgramming.lab3v1.userInterface.impl.ShapesUI;

public interface Menu {
    String getMenu();

    void handleMenu(ShapesUI shapesUI, char command);
}
