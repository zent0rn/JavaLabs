package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

public class Rectangle extends Shape {

    public Rectangle(String nameOfShape, double square, double perimeter, double[] lengthOfSides, double height) {
        super(nameOfShape, square, perimeter, 4, lengthOfSides, -1);
    }

    @Override
    public double calculateSquare(Shape shape) {
        double square = _lengthOfSides[0] * _lengthOfSides[1];
        return square;
    }

    @Override
    public double calculatePerimeter(Shape shape) {
        double perimeter = (_lengthOfSides[0] + _lengthOfSides[1]) * 2;
        return perimeter;
    }

    @Override
    public double[] getSquares(Shape[] shapes) {
        return new double[0];
    }


}