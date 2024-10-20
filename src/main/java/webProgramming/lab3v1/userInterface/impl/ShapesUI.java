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

/**
 * Класс ShapesUI позволяет
 * взаимодействовать с пользователем для работы с
 * классами геометрических фигур
 */
public class ShapesUI implements UserInterface {
    /** объект класса IOHandler */
    private final IOHandler _ioHandler;

    /** Список фигур */
    private List<Shape> _shapeStorage;

    /**
     * конструктор по умолчанию
     */
    public ShapesUI() {
        _ioHandler = new ConsoleHandler();
        _shapeStorage = new ArrayList<>();
    }

    /**
     * метод запускает пользовательский интерфейс:
     * выводит на консоль возможные команды и обрабатывает их
     */
    public void run() {
        char command;
        do {
            try {
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
                    case '3' -> _ioHandler.writeLine("Средний периметр фигур с количеством сторон больше 5: "
                            + Shape.getAveragePerimeterOfPolygon(_shapeStorage) + "\n");
                    case '4' -> {
                        Shape.sortShapesBySquare(_shapeStorage);
                        _ioHandler.writeLine(Shape.getAllShapesInfo(_shapeStorage));
                    }
                    case '5' -> {
                        _ioHandler.write("Введите название фигуры: ");
                        String shapeName = _ioHandler.read();
                        _ioHandler.write("Введите новый цвет: ");
                        String newColor = _ioHandler.read();
                        _ioHandler.writeLine(Shape.editColor(_shapeStorage, shapeName, newColor));
                    }
                }
            }
            catch (Exception e) {
                _ioHandler.write(e.getMessage());
            }
        } while (true);
        _ioHandler.write("Работа завершена!");
    }

    /**
     * метод выводит на консоль возможные команды,
     * связанные с созданием фигур и обрабатывает их
     */
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
                throw new IllegalArgumentException("Фигура с таким именем уже существует!\n");
            }
        } else {
            throw new IllegalArgumentException("Некорректный ввод!\n");
        }
    }

    /**
     * метод выводит на консоль возможные команды,
     * связанные с выводимой на экран информацией и обрабатывает их
     */
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
            default -> throw new IllegalArgumentException("Некорректный ввод!\n");

        }
    }
}
