package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.List;

/**
 * класс-наследник абстрактного класса Shape
 * необходим для создания правильного шестиугольника
 */
public class RegularHexagon extends Shape {
    /** число сторон шестиугольника */
    private static final int COUNT_SIDES = 6;

    /**
     * конструктор с параметрами класса RegularHexagon
     * @param nameOfShape - имя шестиугольника
     * @param color - цвет шестиугольника
     * @param lengthOfSides - длины сторон шестиугольника
     */
    public RegularHexagon(String nameOfShape, String color, List<Double> lengthOfSides) {
        super(nameOfShape, color, COUNT_SIDES, lengthOfSides);
    }

    /**
     * данный статический метод вычисляет значения полей и
     * проверяет их корректность, а затем возвращает созданный шестиугольник
     * @param nameRegularHexagon - имя шестиугольника
     * @param color - цвет шестиугольника
     * @param sides - стороны шестиугольника
     * @return new RegularHexagon(nameRegularHexagon, color, List.of(side, side, side, side, side, side)) -
     * шестиугольник с соответствующими параметрами
     */
    public static RegularHexagon of(String nameRegularHexagon, String color, List<Double> sides) {
        if (nameRegularHexagon.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        if(color.isBlank()){
            throw new IllegalArgumentException("Цвет не может быть пустым!");
        }
        if(sides.size() != 1){
            throw new IllegalArgumentException("Для правильного пятиугольника необходима длина только одной стороны!");
        }
        double side = sides.getFirst();
        return new RegularHexagon(nameRegularHexagon, color, List.of(side, side, side, side, side, side));
    }

    /**
     * метод для вычислений площади шестиугольника
     * @return (3 * Math.pow(_lengthOfSides.getFirst(), 2) * Math.sqrt(3) / 2) -
     * площадь шестиугольника
     */
    @Override
    public double calculateSquare() {
        return (3 * Math.pow(_lengthOfSides.getFirst(), 2) * Math.sqrt(3) / 2);
    }

    /**
     * метод необходим для получения информации о полях данного шестиугольника
     * @return string - значения полей шестиугольника
     */
    @Override
    public String getInfo() {
        return "RegularHexagon{" +
                "_nameOfShape='" + _nameOfShape + '\'' +
                ", _color='" + _color + '\'' +
                ", _square=" + _square +
                ", _perimeter=" + _perimeter +
                ", _countOfSides=" + _countOfSides +
                ", _lengthOfSides=" + _lengthOfSides +
                '}';
    }
}