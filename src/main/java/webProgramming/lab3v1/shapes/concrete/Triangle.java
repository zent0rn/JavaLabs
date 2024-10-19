package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.List;

public class Triangle extends Shape {
    private static final int COUNT_SIDES = 3;
    private final boolean _isEquilateral;
    private final boolean _isIsosceles;

    private Triangle(String nameOfShape, String color, List<Double> lengthOfSides, boolean isIsosceles, boolean isEquilateral) {
        super(nameOfShape, color, COUNT_SIDES, lengthOfSides);
        _isIsosceles = isIsosceles;
        _isEquilateral = isEquilateral;
    }

    public static Triangle of(String nameTriangle, String color, List<Double> sides) {
        if (nameTriangle.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        if(color.isBlank()){
            throw new IllegalArgumentException("Цвет не может быть пустым!");
        }
        if (sides.size() != 3) {
            throw new IllegalArgumentException("Для треугольника необходимы длины 3-х сторон");
        }

        double a = sides.get(0);
        double b = sides.get(1);
        double c = sides.get(2);

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

        return new Triangle(nameTriangle, color, List.of(a, b, c), isIsosceles, isEquilateral);
    }

    @Override
    public double calculateSquare() {
        double a = _lengthOfSides.get(0);
        double b = _lengthOfSides.get(1);
        double c = _lengthOfSides.get(2);

        double p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public String getInfo() {
        StringBuilder repr = new StringBuilder();
        repr.append("Triangle{_isEquilateral=").append(_isEquilateral).append(", _isIsosceles=").append(_isIsosceles)
                .append(", _nameOfShape='").append(_nameOfShape).append('\'').append(", _square=").append(_square)
                .append(", _perimeter=").append(_perimeter).append(", _countOfSides=").append(_countOfSides)
                .append(", _lengthOfSides=").append(_lengthOfSides.toString()).append('}');
        return repr.toString();
    }
}
