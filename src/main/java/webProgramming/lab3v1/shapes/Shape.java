package webProgramming.lab3v1.shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс необходим для реализации фигур
 */
public abstract class Shape {
    /**
     * Имя фигуры
     */
    protected String _nameOfShape;

    /**
     * Цвет фигуры
     */
    protected String _color;

    /**
     * Площадь фигуры
     */
    protected final double _square;

    /**
     * Периметр фигуры
     */
    protected final double _perimeter;

    /**
     * Количество сторон фигуры
     */
    protected final int _countOfSides;

    /**
     * Список с длинами сторон фигуры
     */
    protected final List<Double> _lengthOfSides;

    /**
     * Конструктор с параметрами
     *
     * @param nameOfShape   имя фигуры
     * @param color         цвет фигуры
     * @param countOfSides  число сторон фигуры
     * @param lengthOfSides длины сторон фигуры
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
     * Вычисляет площадь фигуры
     *
     * @return - значение площади фигуры
     */
    public abstract double calculateSquare();

    /**
     * Вычисляет периметр фигуры
     *
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
     * Возвращает площади фигур из списка фигур
     *
     * @return squares - список площадей фигур
     */
    public static List<Double> getSquares() {
        List<Double> squares = new ArrayList<>(shapes.size());
        for (int i = 0; i < shapes.size(); i++) {
            squares.set(i, shapes.get(i)._square);
        }
        return squares;
    }

    /**
     * Вычисляет средний периметр фигур, количество сторон которых больше 5
     *
     * @return средний периметр фигур
     */
    public static double getAveragePerimeterOfPolygon() {
        int count = 0;
        double sumOfPeremiters = 0;
        for (Shape shape : shapes) {
            if (shape._countOfSides > 5) {
                count++;
                sumOfPeremiters += shape._perimeter;
            }
        }
        return (count == 0 ? 0.0 : sumOfPeremiters / count);
    }

    /**
     * Сортирует список фигур по возрастанию площади (методом пузырька)
     */
    public static void sortShapesBySquare() {
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
     * Возвращает информацию о фигуре
     *
     * @return информация о фигуре (тип, название, цвет, площадь и т.д.)
     */
    public String getInfo() {
        return "_nameOfShape='" + _nameOfShape + '\'' +
                ", _color='" + _color + '\'' +
                ", _square=" + _square +
                ", _perimeter=" + _perimeter +
                ", _countOfSides=" + _countOfSides +
                ", _lengthOfSides=" + _lengthOfSides;
    }

    /**
     * Возвращает значение поля _nameOfShape
     *
     * @return _nameOfShape имя фигуры
     */
    public String getNameOfShape() {
        return _nameOfShape;
    }

    /**
     * Возвращает значение поля _square
     *
     * @return _square площадь фигуры
     */
    public double getSquare() {
        return _square;
    }

    /**
     * Устанавливает новое значение для поля {@code _color}
     *
     * @param color новый цвет фигуры
     */
    public void setColor(String color) {
        this._color = color;
    }

    /**
     * Редактирует цвет фигуры
     *
     * @param shape фигура
     * @param newColor  новый цвет
     * @return результат изменения цвета (true - цвет изменен, false - цвет не изменен)
     */
    public static boolean editColor(Shape shape, String newColor) {
        if (shape == null) {
            return false;
        }
        shape.setColor(newColor);
        return true;
    }

    /**
     * Возвращает информацию о созданых фигурах
     *
     * @return информация о всех фигурах из списка (тип, название, цвет, площадь и т. д.)
     */
    public static String getAllShapesInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Shape shape : shapes) {
            stringBuilder.append(shape.getInfo()).append('\n');
        }
        return stringBuilder.toString();
    }

    /**
     * Ищет в списке фигуру с определенным именем
     *
     * @param name имя, по которому будет искаться фигура в списке
     * @return shape - фигура с именем name
     */
    public static Shape findShapeByName(String name) {
        for (Shape shape : shapes) {
            if (shape._nameOfShape.equals(name)) {
                return shape;
            }
        }
        return null;
    }

    /**
     * Список - хранилище фигур
     */
    public static List<Shape> shapes = new ArrayList<>();
}
