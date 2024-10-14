package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

public class Hexagon extends Shape {
    public Hexagon(String nameOfShape, double square, double perimeter, double[] lengthOfSides, double height) {
        super(nameOfShape, square, perimeter, 6, lengthOfSides, -1);
    }

    @Override
    public double calculateSquare(Shape shape) {
        double square = 6 * Math.pow(_lengthOfSides[0], 2) * Math.sqrt(3) / 4;
        return square;
    }

    @Override
    public double calculatePerimeter(Shape shape) {
        double perimeter = _lengthOfSides[0] * 6;
        return perimeter;
    }

    @Override
    public double[] getSquares(Shape[] shapes) {
        return new double[0];
    }

}