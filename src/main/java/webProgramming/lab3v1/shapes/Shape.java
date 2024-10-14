package webProgramming.lab3v1.shapes;

import static java.util.Collections.swap;

public abstract class Shape {
    protected final String _nameOfShape;
    protected final double _square;
    protected final double _perimeter;
    protected final int _countOfSides;
    protected final double[] _lengthOfSides;
    protected final double _height;

    public Shape(
            String nameOfShape,
            double square,
            double perimeter,
            int countOfSides,
            double[] lengthOfSides,
            double height
    ) {
        _nameOfShape = nameOfShape;
        _square = square;
        _perimeter = perimeter;
        _countOfSides = countOfSides;
        _lengthOfSides = lengthOfSides;
        _height = height;
    }

    public abstract double calculateSquare(Shape shape);

    public abstract double calculatePerimeter(Shape shape);

    public abstract double[] getSquares(Shape[] shapes);

    public static double getAveragePerimeterOfPolygon(Shape[] shapes) {
        int count = 0;
        double sumOfPeremiters = 0;
        for (Shape shape : shapes) {
            if (shape._countOfSides > 5) {
                count++;
                sumOfPeremiters += shape._perimeter;
            }
        }
        double averagePerimeter = sumOfPeremiters / count;
        return averagePerimeter;
    }

    public static void sortShapesBySquare(Shape[] shapes) {
        for (int i = 0; i + 1 < shapes.length; ++i) {
            for (int j = 0; j + 1 < shapes.length - i; ++j) {
                if (shapes[j + 1]._square < shapes[j]._square) {
                    Shape temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                }
            }
        }
    }

    public static Shape findShapeByName(Shape[] shapes, String name) {
        for (Shape shape : shapes) {
            if (shape._nameOfShape.equals(name)) {
                return shape;
            }
        }
        return null;
    }


}
