package state.impl;

import webProgramming.lab3v1.menus.impl.MainMenu;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.state.State;
import webProgramming.lab3v1.userInterface.impl.ShapesUI;

import java.util.List;

public class GetInfoState implements State {
    @Override
    public void handleState(ShapesUI shapesUI, char command) {
        switch (command) {
            case '1' -> {
                shapesUI.getIoHandler().write("Введите название фигуры: ");
                String name = shapesUI.getIoHandler().read();
                Shape foundShape = Shape.findShapeByName(shapesUI.getShapeStorage(), name);
                if (foundShape != null){
                    shapesUI.getIoHandler().write(foundShape.getInfo());
                }
            }case '2' ->{
                List<Shape> shapes = shapesUI.getShapeStorage();
                for(Shape shape : shapes){
                    shapesUI.getIoHandler().write(shape.getNameOfShape() + ": " + shape.getSquare());
                }
            }case '3' ->
                shapesUI.getIoHandler().write(Shape.getAllShapesInfo(shapesUI.getShapeStorage()));
            case 'n' -> shapesUI.setMenu(new MainMenu());
            default ->
                throw new IllegalArgumentException("Некорректный ввод!");

        }
    }
}
