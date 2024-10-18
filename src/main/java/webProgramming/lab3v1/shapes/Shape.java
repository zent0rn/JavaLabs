package webProgramming.lab3v1.shapes;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
    protected String _nameOfShape;
    protected final double _square;
    protected final double _perimeter;
    protected final int _countOfSides;
    protected final List<Double> _lengthOfSides;

    public Shape(
            String nameOfShape,
            int countOfSides,
            List<Double> lengthOfSides
    ) {
        _nameOfShape = nameOfShape;
        _countOfSides = countOfSides;
        _lengthOfSides = lengthOfSides;
        _square = this.calculateSquare();
        _perimeter = this.calculatePerimeter();
    }

    public abstract double calculateSquare();

    public double calculatePerimeter() {
        double perimeter = 0;
        for (double currentSideLength : _lengthOfSides) {
            perimeter += currentSideLength;
        }
        return perimeter;
    }

    public static List<Double> getSquares(List<Shape> shapes) {
        List<Double> squares = new ArrayList<>(shapes.size());
        for (int i = 0; i < shapes.size(); i++) {
            squares.set(i, shapes.get(i)._square);
        }
        return squares;
    }

    public static double getAveragePerimeterOfPolygon(List<Shape> shapes) {
        int count = 0;
        double sumOfPeremiters = 0;
        for (Shape shape : shapes) {
            if (shape._countOfSides > 5) {
                count++;
                sumOfPeremiters += shape._perimeter;
            }
        }
        return sumOfPeremiters / count;
    }

    public static void sortShapesBySquare(List<Shape> shapes) {
        for (int i = 0; i + 1 < shapes.size(); ++i) {
            for (int j = 0; j + 1 < shapes.size() - i; ++j) {
                if (shapes.get(j + 1)._square < shapes.get(j)._square) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
    }

    public static Shape findShapeByName(List<Shape> shapes, String name) {
        for (Shape shape : shapes) {
            if (shape._nameOfShape.equals(name)) {
                return shape;
            }
        }
        return null;
    }

    public static String getAllShapesInfo(List<Shape> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Shape shape : storage) {
            stringBuilder.append(shape.getInfo()).append('\n');
        }
        return stringBuilder.toString();
    }

    public abstract String getInfo();

    public String getNameOfShape() {
        return _nameOfShape;
    }

    public double getSquare() {
        return _square;
    }

    public double getPerimeter() {
        return _perimeter;
    }

    public int getCountOfSides() {
        return _countOfSides;
    }

    public List<Double> getLengthOfSides() {
        return _lengthOfSides;
    }

    public void setNameOfShape(String _nameOfShape) {
        this._nameOfShape = _nameOfShape;
    }
}
