package webProgramming.lab3v1;

import webProgramming.lab3v1.userInterface.impl.ShapesUI;

public class Main {
    public static void main(String[] args) {
        ShapesUI shapesUI = new ShapesUI();
        try {
            shapesUI.run();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
