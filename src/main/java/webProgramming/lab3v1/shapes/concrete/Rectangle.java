package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.Arrays;

public class Rectangle extends Shape {
    private static final int COUNT_SIDES = 4;

    public Rectangle(String nameOfShape, double[] lengthOfSides) {
        super(nameOfShape, COUNT_SIDES, lengthOfSides);
    }

    public static Rectangle of(String nameRectangle, double height, double width) {
        if (nameRectangle.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Длина и ширина прямоугольника должны быть положительными!");
        }
        return new Rectangle(nameRectangle, new double[]{height, width, height, width});
    }

    @Override
    public double calculateSquare() {
        return _lengthOfSides[0] * _lengthOfSides[1];
    }

    @Override
    public String getInfo() {
        StringBuilder repr = new StringBuilder();
        repr.append("Rectangle{_nameOfShape='").append(_nameOfShape).append('\'').append(", _square=").append(_square)
                .append(", _perimeter=").append(_perimeter).append(", _countOfSides=").append(_countOfSides)
                .append(", _lengthOfSides=").append(Arrays.toString(_lengthOfSides)).append('}');
        return repr.toString();
    }
}