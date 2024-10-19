package webProgramming.lab3v1.menus.impl;

import webProgramming.lab3v1.menus.Menu;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.userInterface.impl.ShapesUI;

public class MainMenu implements Menu {
    @Override
    public String getMenu() {
        return """
                [1] Создать фигуру
                [2] Вывести информацию
                [3] Определить средний размер периметра фигур с количеством сторон больше 5
                [4] Упорядочить массив по возрастанию площади
                [5] Найти фигуру по названию
                [q] Выход
                """;
    }

    @Override
    public void handleMenu(ShapesUI shapesUI, char command) {
        switch (command) {
            case '1' -> shapesUI.setMenu(new CreateShapeMenu());

            case '2' -> shapesUI.setMenu(new GetInfoMenu());

            case '3' -> shapesUI.getIoHandler().write("Средний периметр фигур с количеством сторон больше 5: " +
                    Shape.getAveragePerimeterOfPolygon(shapesUI.getShapeStorage())
            );

            case '4' -> Shape.sortShapesBySquare(shapesUI.getShapeStorage());
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
            default -> throw new IllegalArgumentException("Некорректный ввод!");
        }
    }
}
