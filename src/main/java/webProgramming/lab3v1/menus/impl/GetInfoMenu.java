package webProgramming.lab3v1.menus.impl;

import webProgramming.lab3v1.menus.Menu;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.userInterface.impl.ShapesUI;

import java.util.List;

/**
 * класс GetInfoMenu реализует интерфейс Menu и необходим для вывода информации о фигурах
 */
public class GetInfoMenu implements Menu {
    /**
     * метод выводит на консоль команды, которые могут быть выполнены
     * @return string - строчка с командами
     */
    @Override
    public String getMenu() {
        return """
                [1] Вывести информацию о фигуре
                [2] Вывести информацию о площадях фигур
                [3] Вывести всю информацию о всех фигурах
                [n] Назад
                [q] Выход
                """;
    }

    /**
     * метод обрабатывает команды, введенные пользователем и
     * выводит на экран результат их выполнения
     * @param shapesUI - объект класса ShapesUI
     * @param command - комманда, которую ввёл пользователь
     */
    @Override
    public void handleMenu(ShapesUI shapesUI, char command) {
        switch (command) {
            case '1' -> {
                shapesUI.getIoHandler().write("Введите название фигуры: ");
                String name = shapesUI.getIoHandler().read();
                Shape foundShape = Shape.findShapeByName(shapesUI.getShapeStorage(), name);
                if (foundShape != null) {
                    shapesUI.getIoHandler().write(foundShape.getInfo() + "\n");
                }
            }
            case '2' -> {
                List<Shape> shapes = shapesUI.getShapeStorage();
                for (Shape shape : shapes) {
                    shapesUI.getIoHandler().write(shape.getNameOfShape() + ": " + shape.getSquare() + "\n");
                }
            }
            case '3' -> shapesUI.getIoHandler().write(Shape.getAllShapesInfo(shapesUI.getShapeStorage()));
            case 'n' -> shapesUI.setMenu(new MainMenu());

            default -> throw new IllegalArgumentException("Некорректный ввод!");

        }
    }
}
