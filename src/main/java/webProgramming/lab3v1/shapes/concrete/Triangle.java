package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-наследник необходим для создания объекта - треугольника
 */
public class Triangle extends Shape {
    /**
     * Число сторон треугольника
     */
    private static final int COUNT_SIDES = 3;

    /**
     * Радиус вписанной в треугольник окружности
     */
    private final double _radOfCircumscribedCircle;

    /**
     * Высота треугольника, проведенная к основанию
     */
    private final double _heightDrawnBase = (2*super._square) / super._lengthOfSides.get(1);

    /**
     * Логическая переменная, определяющая, является ли треугольник равносторонним
     */
    private final boolean _isEquilateral;

    /**
     * Логическая переменная, определяющая, является ли треугольник равнобедренным
     */
    private final boolean _isIsosceles;

    /**
     * Конструктор по умолчанию
     */
    public Triangle(){
        super("", "", COUNT_SIDES, new ArrayList<>());
        _radOfCircumscribedCircle = 0;
        _isIsosceles = false;
        _isEquilateral = false;
    }

    /**
     * Конструктор с параметрами для класса Triangle
     *
     * @param nameOfShape   имя треугольника
     * @param color         цвет треугольника
     * @param lengthOfSides длины сторон треугольника
     * @param isIsosceles   является ли треугольник равнобедренным
     * @param isEquilateral является ли треугольник равносторонним
     */
    private Triangle(String nameOfShape, String color, List<Double> lengthOfSides, double radOfCircumscribedCircle, boolean isIsosceles, boolean isEquilateral) {
        super(nameOfShape, color, COUNT_SIDES, lengthOfSides);
        _radOfCircumscribedCircle = radOfCircumscribedCircle;
        _isIsosceles = isIsosceles;
        _isEquilateral = isEquilateral;
    }

    /**
     * Вычисляет значения полей и
     * проверяет их корректность, а затем возвращает созданный треугольник
     *
     * @param nameTriangle имя треугольника
     * @param color        цвет треугольника
     * @param sides        список с длинами сторон треугольника
     * @return треугольник с соотвествующими параметрами
     */
    public static Triangle of(String nameTriangle, String color, List<Double> sides) {
        if (nameTriangle.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        if (color.isBlank()) {
            throw new IllegalArgumentException("Цвет не может быть пустым!");
        }
        if (sides.size() != 3) {
            throw new IllegalArgumentException("Для треугольника необходимы длины 3-х сторон");
        }

        double a = sides.get(0);
        double b = sides.get(1);
        double c = sides.get(2);
        double p = (a + b + c) / 2;

        double sum1 = a + b;
        double sum2 = a + c;
        double sum3 = b + c;
        if (sum1 <= c || sum2 <= b || sum3 <= a) {
            throw new IllegalArgumentException("Сумма длин любых двух сторон должна быть больше длины третьей!");
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Длина стороны должна быть положительной!");
        }
        boolean isIsosceles = false;
        boolean isEquilateral = false;
        if (a == b || b == c || a == c) {
            isIsosceles = true;
        }
        if (b == c && a == c) {
            isEquilateral = true;

        }
        double radOfCircumscribedCircle = (a * b * c) / (4 * Math.sqrt(p * (p - a) * (p - b) * (p - c)));

        return new Triangle(nameTriangle, color, List.of(a, b, c), radOfCircumscribedCircle, isIsosceles, isEquilateral);
    }

    /**
     * Вычисляет площадь треугольника
     *
     * @return Площадь треугольника
     */
    @Override
    public double calculateSquare() {
        double a = _lengthOfSides.get(0);
        double b = _lengthOfSides.get(1);
        double c = _lengthOfSides.get(2);

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Возвращает информацию о полях данного треугольника
     *
     * @return string - значения полей треугольника
     */
    @Override
    public String getInfo() {
        return "Triangle{" +
                "_radOfCircumscribedCircle=" + _radOfCircumscribedCircle +
                ", _heightDrawnBase=" + _heightDrawnBase +
                ", _isEquilateral=" + _isEquilateral +
                ", _isIsosceles=" + _isIsosceles + ", " +
                super.getInfo();
    }
}
