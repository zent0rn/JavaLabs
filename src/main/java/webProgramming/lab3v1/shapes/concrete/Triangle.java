package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.Arrays;

public class Triangle extends Shape {
    private static final int COUNT_SIDES = 3;
    private final boolean _isEquilateral;
    private final boolean _isIsosceles;

    private Triangle(String nameOfShape, double[] lengthOfSides, boolean isIsosceles, boolean isEquilateral) {
        super(nameOfShape, COUNT_SIDES, lengthOfSides);
        _isIsosceles = isIsosceles;
        _isEquilateral = isEquilateral;
    }

    public static Triangle of(String nameTriangle, int a, int b, int c) {
        if (nameTriangle.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        double sum1 = a + b;
        double sum2 = a + c;
        double sum3 = b + c;
        if (sum1 + sum2 <= sum3 || sum2 + sum3 <= sum1 || sum1 + sum3 <= sum2) {
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

        return new Triangle(nameTriangle, new double[]{a, b, c}, isIsosceles, isEquilateral);
    }

    @Override
    public double calculateSquare() {
        double a = _lengthOfSides[0];
        double b = _lengthOfSides[1];
        double c = _lengthOfSides[2];

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String getInfo() {
        StringBuilder repr = new StringBuilder();
        repr.append("Triangle{_isEquilateral=").append(_isEquilateral).append(", _isIsosceles=").append(_isIsosceles)
                .append(", _nameOfShape='").append(_nameOfShape).append('\'').append(", _square=").append(_square)
                .append(", _perimeter=").append(_perimeter).append(", _countOfSides=").append(_countOfSides)
                .append(", _lengthOfSides=").append(Arrays.toString(_lengthOfSides)).append('}');
        return repr.toString();
    }
}
