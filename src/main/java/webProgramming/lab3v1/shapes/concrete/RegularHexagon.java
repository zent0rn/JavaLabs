package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.List;

public class RegularHexagon extends Shape {
    private static final int COUNT_SIDES = 6;

    public RegularHexagon(String nameOfShape, String color, List<Double> lengthOfSides) {
        super(nameOfShape, color, COUNT_SIDES, lengthOfSides);
    }

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

    @Override
    public double calculateSquare() {
        return (3 * Math.pow(_lengthOfSides.getFirst(), 2) * Math.sqrt(3) / 2);
    }

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