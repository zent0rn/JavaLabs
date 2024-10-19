package webProgramming.lab3v1.userInterface.impl;

import webProgramming.lab3v1.handlers.IOHandler;
import webProgramming.lab3v1.handlers.impl.ConsoleHandler;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.shapes.concrete.Rectangle;
import webProgramming.lab3v1.shapes.concrete.RegularHexagon;
import webProgramming.lab3v1.shapes.concrete.Triangle;
import webProgramming.lab3v1.userInterface.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
[1] Создать фигуру
    [1.1] Создать треугольник
    [1.2] Создать прямоугольник
    [1.3] Создать правильный шестиугольник
        [1.3.1] Введите название
        [1.3.2] Введите длину стороны
[2] Вывести информацию
    [2.1] Вывести информацию о фигуре
        [2.1.2] Введите название фигуры
    [2.2] Вывести информацию о площадях фигур
    [2.3] Вывести всю информацию о всех фигурах
[3] Определить средний размер периметра фигур с количеством сторон больше 5
[4] Упорядочить массив по возрастанию площади
[5] Изменить свойство фигуры
    [5.1] Изменить название фигуры
[q] Выход
 */

/**
 * Класс ShapesUI позволяет
 * взаимодействовать с пользователем для работы с
 * классами геометрических фигур
 */
public class ShapesUI implements UserInterface {
    private final IOHandler _ioHandler;

    private List<Shape> _shapeStorage;

    /**
     * конструктор по умолчанию
     */
    public ShapesUI() {
        _ioHandler = new ConsoleHandler();
        _shapeStorage = new ArrayList<>();
    }

    public void run() {
        char command;
        do {
            _ioHandler.write("""
                    [1] Создать фигуру
                    [2] Вывести информацию
                    [3] Определить средний размер периметра фигур с количеством сторон больше 5
                    [4] Упорядочить массив по возрастанию площади
                    [5] Изменить цвет фигуры
                    [q] Выход
                    """);
            _ioHandler.write("Выберите команду: ");
            command = _ioHandler.read().charAt(0);
            if (command == 'q') {
                break;
            }
            switch (command) {
                case '1' -> manageShapeCreating();
                case '2' -> manageDataShowing();
                case '3' -> _ioHandler.write("Средний периметр фигур с количеством сторон больше 5: "
                        + Shape.getAveragePerimeterOfPolygon(_shapeStorage));
                case '4' -> {
                    Shape.sortShapesBySquare(_shapeStorage);
                    _ioHandler.write(Shape.getAllShapesInfo(_shapeStorage));
                }
                case '5' -> {
                    _ioHandler.write("Введите название фигуры: ");
                    String shapeName = _ioHandler.read();
                    _ioHandler.write("Введите новый цвет: ");
                    String newColor = _ioHandler.read();

                    Shape editedShape = Shape.editColor(_shapeStorage, shapeName, newColor);

                    _ioHandler.writeLine("Фигура изменена: " + editedShape.getInfo());
                }
            }
        } while (true);
        _ioHandler.write("Работа завершена!");
    }

    private void manageShapeCreating() {
        _ioHandler.write(
                """
                        [1] Создать треугольник
                        [2] Создать прямоугольник
                        [3] Создать правильный шестиугольник
                        """
        );
        _ioHandler.write("Выберите команду: ");
        char command = _ioHandler.read().charAt(0);
        if (command == '1' || command == '2' || command == '3') {
            Shape shape = null;
            _ioHandler.write("Введите название фигуры: ");
            String shapeName = _ioHandler.read();
            _ioHandler.write("Введите цвет фигуры: ");
            String shapeColor = _ioHandler.read();
            _ioHandler.write("Введите длины фигуры: ");
            List<Double> sides = Arrays.stream(_ioHandler.read().split(" ")).map(Double::parseDouble).toList();
            switch (command) {
                case '1' -> shape = Triangle.of(shapeName, shapeColor, sides);
                case '2' -> shape = Rectangle.of(shapeName, shapeColor, sides);
                case '3' -> shape = RegularHexagon.of(shapeName, shapeColor, sides);
            }
            if (Shape.findShapeByName(_shapeStorage, shapeName) == null) {
                _shapeStorage.add(shape);
            } else {
                throw new IllegalArgumentException("Фигура с таким именем уже существует!");
            }
        } else {
            throw new IllegalArgumentException("Некорректный ввод");
        }
    }

    private void manageDataShowing() {
        _ioHandler.write(
                """
                        [1] Вывести информацию о фигуре
                        [2] Вывести информацию о площадях фигур
                        [3] Вывести всю информацию о всех фигурах
                        """
        );
        _ioHandler.write("Выберите команду: ");
        char command = _ioHandler.read().charAt(0);
        switch (command) {
            case '1' -> {
                _ioHandler.write("Введите название фигуры: ");
                String name = _ioHandler.read();
                Shape foundShape = Shape.findShapeByName(_shapeStorage, name);
                if (foundShape != null) {
                    _ioHandler.write(foundShape.getInfo());
                } else {
                    _ioHandler.write("Фигура не найдена!");
                }
            }
            case '2' -> {
                for (Shape shape : _shapeStorage) {
                    _ioHandler.write(shape.getNameOfShape() + ": " + shape.getSquare());
                }
            }
            case '3' -> _ioHandler.write(Shape.getAllShapesInfo(_shapeStorage));
            default -> throw new IllegalArgumentException("Некорректный ввод!");

        }
    }
}
