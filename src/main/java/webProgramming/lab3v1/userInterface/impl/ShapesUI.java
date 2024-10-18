package webProgramming.lab3v1.userInterface.impl;

import webProgramming.lab3v1.handlers.IOHandler;
import webProgramming.lab3v1.handlers.impl.ConsoleHandler;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.shapes.concrete.Rectangle;
import webProgramming.lab3v1.shapes.concrete.RegularHexagon;
import webProgramming.lab3v1.shapes.concrete.Triangle;
import webProgramming.lab3v1.userInterface.UserInterface;

import java.util.List;

/**
 * Класс ShapesUI позволяет
 * взаимодействовать с пользователем для работы с
 * классами геометрических фигур
 */
public class ShapesUI implements UserInterface {
    private final IOHandler _ioHandler;
    /**
     * конструктор по умолчанию
     */
    public ShapesUI() {
        _ioHandler = new ConsoleHandler();
    }

    public void run() {
        Shape triangle = Triangle.of("MyTria", 3,4,5);
        Shape rectangle = Rectangle.of("MyRect", 2, 5);
        Shape hexagon = RegularHexagon.of("MyHex", 6);
        Shape hexagon2 = RegularHexagon.of("MyHex2", 4);

        //Определить площади фигур
        _ioHandler.write("Площади фигур\n");
        _ioHandler.write(triangle.getNameOfShape() + ": " + triangle.getSquare() + "\n");
        _ioHandler.write(rectangle.getNameOfShape() + ": " + rectangle.getSquare() + "\n");
        _ioHandler.write(hexagon.getNameOfShape() + ": " + hexagon.getSquare() + "\n");
        _ioHandler.write(hexagon2.getNameOfShape() + ": " + hexagon2.getSquare() + "\n");

        //Определить средний размер периметра для фигур с количеством сторон больше 5
        List<Shape> shapes = List.of(triangle, rectangle, hexagon, hexagon2);
        _ioHandler.write("Средний периметр: " + Shape.getAveragePerimeterOfPolygon(shapes) + "\n");

        //Упорядочить массив по возрастанию площади
        Shape.sortShapesBySquare(shapes);
        _ioHandler.write("Отсортированный по возрастанию площади массив: \n");
        for(Shape shape: shapes){
            _ioHandler.write(shape.getNameOfShape() + "\n");
        }

        //Организовать поиск по названию фигуры
        String nameToFind = "MyRect";
        Shape foundShape = Shape.findShapeByName(shapes, nameToFind);
        _ioHandler.write(foundShape != null ? foundShape.toString() : "Not found");

    }
}
