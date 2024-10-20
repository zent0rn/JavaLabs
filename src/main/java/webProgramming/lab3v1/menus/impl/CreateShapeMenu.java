package webProgramming.lab3v1.menus.impl;

import webProgramming.lab3v1.menus.Menu;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.shapes.concrete.Rectangle;
import webProgramming.lab3v1.shapes.concrete.RegularHexagon;
import webProgramming.lab3v1.shapes.concrete.Triangle;
import webProgramming.lab3v1.userInterface.impl.ShapesUI;

import java.util.Arrays;
import java.util.List;

/**
 * класс реализует интерфейс Menu и
 * необходим для взаимодейсвтия с пользователем
 */
public class CreateShapeMenu implements Menu {
    /**
     * метод выводит возможные команды для создания фигур
     * @return string - строка с возможными командами
     */
    @Override
    public String getMenu() {
        return """
                [1] Создать треугольник
                [2] Создать прямоугольник
                [3] Создать правильный шестиугольник
                [n] Назад
                [q] Выход
                """;
    }

    /**
     * метод необходим для обработки команд, введённых пользователем
     * @param shapesUI - объект класса ShapesUI
     * @param command - команда, введённая пользователем
     */
    @Override
    public void handleMenu(ShapesUI shapesUI, char command) {
        if (command == '1' || command == '2' || command == '3') {
            Shape shape = null;
            shapesUI.getIoHandler().write("Введите название фигуры: ");
            String shapeName = shapesUI.getIoHandler().read();
            shapesUI.getIoHandler().write("Введите цвет фигуры: ");
            String shapeColor = shapesUI.getIoHandler().read();
            shapesUI.getIoHandler().write("Введите длины фигуры (через пробел): ");
            List<Double> sides;
            if (!shapesUI.getIoHandler().read().isBlank()) {
                sides = Arrays.stream(shapesUI.getIoHandler().read().split(" ")).map(Double::parseDouble).toList();
            }
            else {
                throw new IllegalArgumentException("Некорретный ввод!\n");
            }
            switch (command) {
                case '1' -> shape = Triangle.of(shapeName, shapeColor, sides);
                case '2' -> shape = Rectangle.of(shapeName, shapeColor, sides);
                case '3' -> shape = RegularHexagon.of(shapeName, shapeColor, sides);
            }
            if (Shape.findShapeByName(shapesUI.getShapeStorage(), shapeName) == null) {
                shapesUI.getShapeStorage().add(shape);
                shapesUI.setMenu(new MainMenu());
            } else {
                throw new IllegalArgumentException("Фигура с таким именем уже существует!\n");
            }
        } else if (command == 'n') {
            shapesUI.setMenu(new MainMenu());
        } else {
            throw new IllegalArgumentException("Некорректный ввод!\n");
        }
    }
}
