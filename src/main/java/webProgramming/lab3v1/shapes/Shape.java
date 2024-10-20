package webProgramming.lab3v1.shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * абстрактный класс Shape
 * необходим для реализации фигур
 */
public abstract class Shape {
    /** имя фигуры */
    protected String _nameOfShape;

    /** цвет фигуры */
    protected String _color;

    /** площадь фигуры */
    protected final double _square;

    /** периметр фигуры */
    protected final double _perimeter;

    /** количество сторон фигуры */
    protected final int _countOfSides;

    /** список с длинами сторон фигуры */
    protected final List<Double> _lengthOfSides;

    /**
     * конструктор абстрактного класса Shape с параметрами
     * @param nameOfShape - имя фигуры
     * @param color - цвет фигуры
     * @param countOfSides - число сторон фигуры
     * @param lengthOfSides - длины сторон фигуры
     */
    public Shape(
            String nameOfShape,
            String color,
            int countOfSides,
            List<Double> lengthOfSides
    ) {
        _nameOfShape = nameOfShape;
        _color = color;
        _countOfSides = countOfSides;
        _lengthOfSides = lengthOfSides;
        _square = this.calculateSquare();
        _perimeter = this.calculatePerimeter();
    }

    /**
     * абстрактный метод, впоследствии будет реализовываться как метод вычисления площади
     * @return -
     */
    public abstract double calculateSquare();

    /**
     * метод вычисляет периметр некоторой фигуры
     * @return perimeter - периметр фигуры
     */
    public double calculatePerimeter() {
        double perimeter = 0;
        for (double currentSideLength : _lengthOfSides) {
            perimeter += currentSideLength;
        }
        return perimeter;
    }

    /**
     * метод необходим для получения площади фигур из списка фигур
     * @param shapes - список фигур
     * @return squares - список площадей фигур
     */
    public static List<Double> getSquares(List<Shape> shapes) {
        List<Double> squares = new ArrayList<>(shapes.size());
        for (int i = 0; i < shapes.size(); i++) {
            squares.set(i, shapes.get(i)._square);
        }
        return squares;
    }

    /**
     * метод вычисляет средний периметр фигур из списка
     * @param shapes - список фигур
     * @return sumOfPeremiters / count - средний периметр фигур
     */
    public static double getAveragePerimeterOfPolygon(List<Shape> shapes) {
        int count = 0;
        double sumOfPeremiters = 0;
        for (Shape shape : shapes) {
            if (shape._countOfSides > 5) {
                count++;
                sumOfPeremiters += shape._perimeter;
            }
        }
        return sumOfPeremiters / count;
    }

    /**
     * метод сортирует список фигур по возрастанию площади (метод пузырька)
     * @param shapes - список фигур
     */
    public static void sortShapesBySquare(List<Shape> shapes) {
        for (int i = 0; i + 1 < shapes.size(); ++i) {
            for (int j = 0; j + 1 < shapes.size() - i; ++j) {
                if (shapes.get(j + 1)._square < shapes.get(j)._square) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * метод ищет в списке фигуру с определенным именем
     * @param shapes - список фигур
     * @param name - имя, по которому будет искаться фигура в списке
     * @return shape - фигура с именем name
     */
    public static Shape findShapeByName(List<Shape> shapes, String name) {
        for (Shape shape : shapes) {
            if (shape._nameOfShape.equals(name)) {
                return shape;
            }
        }
        return null;
    }

    /**
     * метод необходим для получения информации о созданых фигурах
     * @param storage - список созданных фигур
     * @return stringBuilder.toString() - строчка с информацией о фигурах
     */
    public static String getAllShapesInfo(List<Shape> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Shape shape : storage) {
            stringBuilder.append(shape.getInfo()).append('\n');
        }
        return stringBuilder.toString();
    }

    /**
     * абстрактный метод, который будет реализовываться в классах-наследниках
     * @return
     */
    public abstract String getInfo();

    /**
     * метод геттер для поля _nameOfShape
     * @return _nameOfShape - имя фигуры
     */
    public String getNameOfShape() {
        return _nameOfShape;
    }

    /**
     * метод геттер для поля _square
     * @return _square - площадь фигуры
     */
    public double getSquare() {
        return _square;
    }

    /**
     * метод геттер для поля _perimeter
     * @return _perimeter - периметр фигуры
     */
    public double getPerimeter() {
        return _perimeter;
    }

    /**
     * метод геттер для поля _countOfSides
     * @return _countOfSides - число сторон фигуры
     */
    public int getCountOfSides() {
        return _countOfSides;
    }

    /**
     * метод геттер для поля _lengthOfSides
     * @return _lengthOfSides - список со сторонами фигуры
     */
    public List<Double> getLengthOfSides() {
        return _lengthOfSides;
    }

    /**
     * метод сеттер для поля _nameOfShape
     * @param _nameOfShape - новое имя фигуры
     */
    public void setNameOfShape(String _nameOfShape) {
        this._nameOfShape = _nameOfShape;
    }

    /**
     * метод сеттер для поля _color
     * @param color - новый цвет фигуры
     */
    public void setColor(String color) {
        this._color = color;
    }
}
