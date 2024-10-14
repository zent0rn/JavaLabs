package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

public class Triangle extends Shape {
    private final boolean _isEquilateral;
    private final boolean _isIsosceles;

    private Triangle(String nameOfShape, double[] lengthOfSides, boolean isIsosceles, boolean isEquilateral) {
        super(nameOfShape, lengthOfSides);
        _isIsosceles = isIsosceles;
        _isEquilateral = isEquilateral;
    }

    public static Triangle of(String nameTriangle, double[] lengthOfSides) {
        if (lengthOfSides.length != 3) {
            throw new IllegalArgumentException("Размер массива с длинами сторон треугольника должен быть равен 3!");
        }

        boolean isIsosceles = false;
        boolean isEquilateral = false;
        if(lengthOfSides[0] == lengthOfSides[1]
                || lengthOfSides[1] == lengthOfSides[2] || lengthOfSides[0] == lengthOfSides[2]){
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

}
