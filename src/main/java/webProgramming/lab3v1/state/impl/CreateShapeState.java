package webProgramming.lab3v1.state.impl;

import webProgramming.lab3v1.menus.impl.MainMenu;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.shapes.concrete.Rectangle;
import webProgramming.lab3v1.shapes.concrete.RegularHexagon;
import webProgramming.lab3v1.shapes.concrete.Triangle;
import webProgramming.lab3v1.state.State;
import webProgramming.lab3v1.userInterface.impl.ShapesUI;

import java.util.Arrays;
import java.util.List;

public class CreateShapeState implements State {
    @Override
    public void handleState(ShapesUI shapesUI, char command) {
        if (command == '1' || command == '2' || command == '3') {
            Shape shape = null;
            shapesUI.getIoHandler().write("Введите название фигуры: ");
            String shapeName = shapesUI.getIoHandler().read();
            shapesUI.getIoHandler().write("Введите длины фигуры: ");
            List<Double> sides = Arrays.stream(shapesUI.getIoHandler().read().split(" ")).map(Double::parseDouble).toList();
            switch (command) {
                case '1' -> shape = Triangle.of(shapeName, sides);
                case '2' -> shape = Rectangle.of(shapeName, sides);
                case '3' -> shape = RegularHexagon.of(shapeName, sides);
            }
            if (Shape.findShapeByName(shapesUI.getShapeStorage(), shapeName) == null) {
                shapesUI.getShapeStorage().add(shape);
                shapesUI.setMenu(new MainMenu());
            } else {
                throw new IllegalArgumentException("Фигура с таким именем уже существует!");
            }
        } else if (command == 'n') {
            shapesUI.setMenu(new MainMenu());
        } else {
            throw new IllegalArgumentException("Некорректный ввод!");
        }

    }
}
