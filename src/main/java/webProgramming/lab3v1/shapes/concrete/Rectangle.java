package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-наследник необходим для создания объекта - прямоугольника
 */
public class Rectangle extends Shape {
    /**
     * Число сторон прямоугольника
     */
    private static final int COUNT_SIDES = 4;

    /**
     * Конструктор по умолчанию
     */
    public Rectangle(){
        super("", "", COUNT_SIDES, new ArrayList<>());
    }

    /**
     * Конструктор с параметрами для класса Rectangle
     *
     * @param nameOfShape   имя прямоугольника
     * @param color         цвет прямоугольника
     * @param lengthOfSides длины сторон прямоугольника
     */
    public Rectangle(String nameOfShape, String color, List<Double> lengthOfSides) {
        super(nameOfShape, color, COUNT_SIDES, lengthOfSides);
    }

    /**
     * Статический метод вычисляет значения полей и
     * проверяет их корректность, а затем возвращает созданный прямоугольник
     *
     * @param nameRectangle имя прямоугольника
     * @param color         цвет прямоугольника
     * @param sides         длины сторон прямоугольника
     * @return прямоугольник с соответствующими параметрами
     */
    public static Rectangle of(String nameRectangle, String color, List<Double> sides) {
        if (nameRectangle.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        if (color.isBlank()) {
            throw new IllegalArgumentException("Цвет не может быть пустым!");
        }
        if (sides.size() != 2) {
            throw new IllegalArgumentException("Для прямоугольника необходимо ввести высоту и ширину");
        }

        double height = sides.get(0);
        double width = sides.get(1);

        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Длина и ширина прямоугольника должны быть положительными!");
        }
        return new Rectangle(nameRectangle, color, List.of(height, width, height, width));
    }

    /**
     * Вычисляет площадь прямоугольника
     *
     * @return площадь прямоугольника
     */
    @Override
    public double calculateSquare() {
        return _lengthOfSides.get(0) * _lengthOfSides.get(1);
    }

    /**
     * Возвращает информацию о полях данного прямоугольника
     *
     * @return string - значения полей прямоугольника
     */
    @Override
    public String getInfo() {
        return "Rectangle{" +
                "_nameOfShape='" + _nameOfShape + '\'' +
                ", _color='" + _color + '\'' +
                ", _square=" + _square +
                ", _perimeter=" + _perimeter +
                ", _countOfSides=" + _countOfSides +
                ", _lengthOfSides=" + _lengthOfSides +
                '}';
    }
}