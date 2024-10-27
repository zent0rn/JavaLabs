package webProgramming.lab3v1.userInterface.impl;

import webProgramming.lab3v1.handlers.IOHandler;
import webProgramming.lab3v1.handlers.impl.ConsoleHandler;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.shapes.concrete.Rectangle;
import webProgramming.lab3v1.shapes.concrete.RegularHexagon;
import webProgramming.lab3v1.shapes.concrete.Triangle;
import webProgramming.lab3v1.userInterface.UserInterface;

import java.util.Arrays;
import java.util.List;

/**
 * Класс позволяет
 * взаимодействовать с пользователем для работы с
 * классами геометрических фигур
 */
public class ShapesUI implements UserInterface {
    /**
     * Объект класса IOHandler позволяет взаимодействовать с потоками ввода/вывода
     */
    private final IOHandler _ioHandler;

    /**
     * Конструктор по умолчанию
     */
    public ShapesUI() {
        _ioHandler = new ConsoleHandler();
    }

    /**
     * Запускает сессию взаимодействия с пользователем:
     * выводит на консоль возможные команды, получает запросы пользователя и делегирует их выполнение
     * специальным классам
     */
    public void run() {
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
                char command = pickCommand();
                if (command == 'q') {
                    break;
                }

                switch (command) {
                    case '1' -> manageShapeCreating();
                    case '2' -> manageDataShowing();
                    case '3' -> _ioHandler.writeLine("Средний периметр фигур с количеством сторон больше 5: "
                            + Shape.getAveragePerimeterOfPolygon() + "\n");
                    case '4' -> {
                        if (Shape.shapes.isEmpty()) {
                            _ioHandler.write("Фигур нет");
                            break;
                        }
                        Shape.sortShapesBySquare();
                        _ioHandler.writeLine(Shape.getAllShapesInfo());
                    }
                    case '5' -> {
                        _ioHandler.write("Введите название фигуры: ");
                        String shapeName = _ioHandler.read();

                        _ioHandler.write("Введите новый цвет: ");
                        String newColor = _ioHandler.read();

                        Shape foundShape = Shape.findShapeByName(shapeName);

                        boolean editResult = Shape.editColor(foundShape, newColor);
                        if (editResult) {
                            _ioHandler.write("Цвет фигуры изменен: " + foundShape.getInfo());
                        } else {
                            _ioHandler.write("Цвет фигуры не изменен!");
                        }
                    }
                    default -> throw new RuntimeException("Некорректная команда!");
                }
            } catch (RuntimeException e) {
                _ioHandler.writeLine(e.getMessage());
            }
        } while (true);
        _ioHandler.write("Работа завершена!");
    }

    private Character pickCommand() {
        _ioHandler.write("Выберите команду: ");
        String toRead = _ioHandler.read();
        if (toRead.length() != 1) {
            throw new IllegalArgumentException("Некорректная команда!");
        }
        return toRead.charAt(0);
    }

    /**
     * Выводит на консоль возможные команды,
     * связанные с созданием фигур и добавляет созданные фигуры в хранилище
     */
    private void manageShapeCreating() {
        _ioHandler.write(
                """
                        [1] Создать треугольник
                        [2] Создать прямоугольник
                        [3] Создать правильный шестиугольник
                        """
        );

        char command = pickCommand();

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

            if (Shape.findShapeByName(shapeName) == null) {
                Shape.shapes.add(shape);
            } else {
                throw new IllegalArgumentException("Фигура с таким именем уже существует!\n");
            }
        } else {
            throw new IllegalArgumentException("Некорректный ввод!\n");
        }
    }

    /**
     * Выводит на консоль возможные команды,
     * связанные с информацией о фигурах и вызывает методы для их выполнения
     */
    private void manageDataShowing() {
        _ioHandler.write(
                """
                        [1] Вывести информацию о фигуре
                        [2] Вывести информацию о площадях фигур
                        [3] Вывести всю информацию о всех фигурах
                        """
        );

        char command = pickCommand();

        switch (command) {
            case '1' -> {
                _ioHandler.write("Введите название фигуры: ");
                String name = _ioHandler.read();

                Shape foundShape = Shape.findShapeByName(name);

                if (foundShape != null) {
                    _ioHandler.writeLine(foundShape.getInfo());
                } else {
                    _ioHandler.write("Фигура не найдена!");
                }
            }
            case '2' -> {
                if (Shape.shapes.isEmpty()) {
                    _ioHandler.write("Фигур нет!");
                    break;
                }
                for (Shape shape : Shape.shapes) {
                    _ioHandler.writeLine(shape.getNameOfShape() + ": " + shape.getSquare());
                }
            }
            case '3' -> {
                String info = Shape.getAllShapesInfo();

                if (info.isBlank()) {
                    _ioHandler.write("Фигур нет!");
                } else {
                    _ioHandler.write(Shape.getAllShapesInfo());
                }
            }
            default -> throw new IllegalArgumentException("Некорректный ввод!\n");
        }
    }
}
