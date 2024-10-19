package webProgramming.lab3v1.state.impl;

import webProgramming.lab3v1.menus.impl.CreateShapeMenu;
import webProgramming.lab3v1.menus.impl.EditShapeMenu;
import webProgramming.lab3v1.menus.impl.GetInfoMenu;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.state.State;
import webProgramming.lab3v1.userInterface.impl.ShapesUI;

public class MainState implements State {
    @Override
    public void handleState(ShapesUI shapesUI, char command) {
        switch (command) {
            case '1' -> {
                shapesUI.setMenu(new CreateShapeMenu());
                shapesUI.setState(new CreateShapeState());
            }
            case '2' -> {
                shapesUI.setMenu(new GetInfoMenu());
                shapesUI.setState(new GetInfoState());
            }
            case '3' ->
                shapesUI.getIoHandler().write("Средний периметр фигур с количеством сторон больше 5: " +
                        Shape.getAveragePerimeterOfPolygon(shapesUI.getShapeStorage())
                );

            case '4' ->
                Shape.sortShapesBySquare(shapesUI.getShapeStorage());
            case '5' -> {
                shapesUI.getIoHandler().write("Введите название фигуры: ");
                String shapeName = shapesUI.getIoHandler().read();
                Shape foundShape = Shape.findShapeByName(shapesUI.getShapeStorage(), shapeName);
                if (foundShape != null) {
                    shapesUI.setCurrentShape(foundShape);
                    shapesUI.setMenu(new EditShapeMenu());
                }
            }
            case 'q' -> {
            }
            default ->
                throw new IllegalArgumentException("Некорректный ввод!");
        }
    }
}
