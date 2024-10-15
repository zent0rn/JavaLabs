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

    public static Triangle of(String nameTriangle, double[] lengthOfSides) {
        if(nameTriangle.isBlank()){
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        if (lengthOfSides.length != COUNT_SIDES) {
            throw new IllegalArgumentException("Размер массива с длинами сторон треугольника должен быть равен 3!");
        }
        double sum1 = lengthOfSides[0] + lengthOfSides[1];
        double sum2 = lengthOfSides[1] + lengthOfSides[2];
        double sum3 = lengthOfSides[0] + lengthOfSides[2];
        if(sum1 + sum2 <= sum3 || sum2 + sum3 <= sum1 || sum1 + sum3 <= sum2){
            throw new IllegalArgumentException("Сумма длин любых двух сторон должна быть больше длины третьей!");
        }
        if(lengthOfSides[0] <= 0 || lengthOfSides[1] <= 0 || lengthOfSides[2] <= 0){
            throw new IllegalArgumentException("Длина стороны должна быть положительной!");
        }

        boolean isIsosceles = false;
        boolean isEquilateral = false;
        if (lengthOfSides[0] == lengthOfSides[1]
                || lengthOfSides[1] == lengthOfSides[2] || lengthOfSides[0] == lengthOfSides[2]) {
            isIsosceles = true;
        }
        if (lengthOfSides[0] == lengthOfSides[1]
                && lengthOfSides[1] == lengthOfSides[2] && lengthOfSides[0] == lengthOfSides[2]) {
            isEquilateral = true;
        }

        return new Triangle(nameTriangle, lengthOfSides, isIsosceles, isEquilateral);
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
