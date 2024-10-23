package webProgramming.lab3v1.shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс необходим для реализации фигур
 */
public abstract class Shape {
    /**
     * Список - хранилище фигур
     */
    public static List<Shape> shapes = new ArrayList<>();

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
     * Конструктор абстрактного класса Shape с параметрами
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
     * Абстрактный метод вычисления площади фигуры
     *
     * @return - значение площади фигуры
     */
    public abstract double calculateSquare();

    /**
     * Метод вычисляет периметр фигуры
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
     * Метод необходим для получения площади фигур из списка фигур
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
     * Метод вычисляет средний периметр фигур, количество сторон которых больше 5
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
     * Метод сортирует список фигур по возрастанию площади (методом пузырька)
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
     * Метод ищет в списке фигуру с определенным именем
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
     * Метод необходим для получения информации о созданых фигурах
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
     * Абстрактный метод для получения информации о фигуре
     *
     * @return информация о фигуре (тип, название, цвет, площадь и т.д.)
     */
    public abstract String getInfo();

    /**
     * Метод геттер для поля _nameOfShape
     *
     * @return _nameOfShape - имя фигуры
     */
    public String getNameOfShape() {
        return _nameOfShape;
    }

    /**
     * метод геттер для поля _square
     *
     * @return _square - площадь фигуры
     */
    public double getSquare() {
        return _square;
    }

    /**
     * метод сеттер для поля _color
     *
     * @param color - новый цвет фигуры
     */
    public void setColor(String color) {
        this._color = color;
    }

    /**
     * Метод необходим для редактирования цвета фигуры
     *
     * @param shapeName имя фигуры
     * @param newColor  новый цвет
     * @return результат изменения цвета
     */
    public static String editColor(String shapeName, String newColor) {
        Shape foundShape = Shape.findShapeByName(shapeName);
        if (foundShape == null) {
            throw new IllegalArgumentException("Фигура " + shapeName + " не найдена!");
        }
        foundShape.setColor(newColor);
        return "Фигура изменена: " + foundShape.getInfo();

    }
}
