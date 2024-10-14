package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;
public class Triangle extends Shape {

    public Triangle(String nameOfShape, double square, double perimeter, double[] lengthOfSides, double height) {
        super(nameOfShape, square, perimeter, 3, lengthOfSides, height);
    }

    /**
     * метод считает площадь (считаем, что _lengthOfSides[3] - это именно основание треугольника)
     *
     * @param shape
     * @return
     */
    @Override
    public double calculateSquare(Shape shape) {
        double square = (_height * _lengthOfSides[3]) / 2;
        return square;
    }

    @Override
    public double calculatePerimeter(Shape shape) {
        double perimeter = (_lengthOfSides[1] + _lengthOfSides[2] + _lengthOfSides[3]);
        return perimeter;
    }

    @Override
    public double[] getSquares(Shape[] shapes) {
        return new double[0];
    }

}
