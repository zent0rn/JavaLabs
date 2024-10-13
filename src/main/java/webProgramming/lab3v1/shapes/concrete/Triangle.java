package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

public class Triangle extends Shape {

    public Triangle(String nameOfShape, double square, double perimeter, double[] lengthOfSides) {
        super(nameOfShape, square, perimeter, 3, lengthOfSides);
    }

    @Override
    public double calculateSquare(Shape shape) {
        return 0;
    }

    @Override
    public double calculatePerimeter(Shape shape) {
        return 0;
    }

    @Override
    public double[] getSquares(Shape[] shapes) {
        return new double[0];
    }

    @Override
    public double[] getAveragePerimeterOfPolygon() {
        return new double[0];
    }

    @Override
    public Shape[] sortShapesBySquare(Shape[] shapes) {
        return new Shape[0];
    }

    @Override
    public Shape findShapeByName(Shape[] shapes) {
        return null;
    }
}
