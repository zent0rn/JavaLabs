package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс-наследник представляет геометрическую фигуру - правильный шестиугольник
 */
public class RegularHexagon extends Shape {
    /**
     * Большая диагональ правильного шестиугольника
     */
    private final double _largerDiagonal;

    /**
     * Меньшая диагональ правильного шестиугольника
     */
    private final double _smallerDiagonal;

    /**
     * Конструктор по умолчанию
     */
    public RegularHexagon() {
        super("", "", COUNT_SIDES, new ArrayList<>());
        _largerDiagonal = 0;
        _smallerDiagonal = 0;
    }

    /**
     * Конструктор с параметрами
     *
     * @param nameOfShape   имя шестиугольника
     * @param color         цвет шестиугольника
     * @param lengthOfSides длины сторон шестиугольника
     */
    public RegularHexagon(String nameOfShape,
                          String color,
                          List<Double> lengthOfSides,
                          double largerDiagonal,
                          double smallerDiagonal
    ) {
        super(nameOfShape, color, COUNT_SIDES, lengthOfSides);
        _largerDiagonal = largerDiagonal;
        _smallerDiagonal = smallerDiagonal;
    }

    /**
     * Вычисляет площадь шестиугольника
     *
     * @return площадь шестиугольника
     */
    @Override
    public double calculateSquare() {
        return (3 * Math.pow(_lengthOfSides.getFirst(), 2) * Math.sqrt(3) / 2);
    }

    /**
     * Возвращает информацию о полях данного шестиугольника
     *
     * @return string - значения полей шестиугольника
     */
    @Override
    public String getInfo() {
        return "RegularHexagon{ " + super.getInfo() +
                " _diagonal=" + _largerDiagonal +
                "_radOfCircumscribedCircle=" + _smallerDiagonal +
                "}";
    }

    /**
     * Число сторон шестиугольника
     */
    private static final int COUNT_SIDES = 6;

    /**
     * Вычисляет значения полей и
     * проверяет их корректность, а затем возвращает созданный шестиугольник
     *
     * @param nameRegularHexagon имя шестиугольника
     * @param color              цвет шестиугольника
     * @param sides              стороны шестиугольника
     * @return шестиугольник с соответствующими параметрами
     */
    public static RegularHexagon of(String nameRegularHexagon, String color, List<Double> sides) {
        if (nameRegularHexagon.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        if (color.isBlank()) {
            throw new IllegalArgumentException("Цвет не может быть пустым!");
        }
        if (sides.size() != 1) {
            throw new IllegalArgumentException("Для правильного пятиугольника необходима длина только одной стороны!");
        }
        double side = sides.getFirst();

        double largerDiagonal = side * 2;
        double smallerDiagonal = side * Math.sqrt(3);
        return new RegularHexagon(
                nameRegularHexagon,
                color,
                List.of(side, side, side, side, side, side),
                largerDiagonal,
                smallerDiagonal
        );
    }
}