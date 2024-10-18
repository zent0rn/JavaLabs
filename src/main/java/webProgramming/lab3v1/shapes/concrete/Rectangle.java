package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.Arrays;
import java.util.List;

public class Rectangle extends Shape {
    private static final int COUNT_SIDES = 4;

    public Rectangle(String nameOfShape, List<Double> lengthOfSides) {
        super(nameOfShape, COUNT_SIDES, lengthOfSides);
    }

    public static Rectangle of(String nameRectangle, List<Double> sides) {
        if (nameRectangle.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }

        if (sides.size() != 2) {
            throw new IllegalArgumentException("Для прямоугольника необходимо ввести высоту и ширину");
        }

        double height = sides.get(0);
        double width = sides.get(1);

        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Длина и ширина прямоугольника должны быть положительными!");
        }
        return new Rectangle(nameRectangle, List.of(height, width, height, width));
    }

    @Override
    public double calculateSquare() {
        return _lengthOfSides.get(0) * _lengthOfSides.get(1);
    }

    @Override
    public String getInfo() {
        StringBuilder repr = new StringBuilder();
        repr.append("Rectangle{_nameOfShape='").append(_nameOfShape).append('\'').append(", _square=").append(_square)
                .append(", _perimeter=").append(_perimeter).append(", _countOfSides=").append(_countOfSides)
                .append(", _lengthOfSides=").append(_lengthOfSides.toString()).append('}');
        return repr.toString();
    }
}