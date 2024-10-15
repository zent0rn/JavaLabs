package webProgramming.lab3v1.shapes;

public abstract class Shape {
    protected final String _nameOfShape;
    protected final double _square;
    protected final double _perimeter;
    protected final int _countOfSides;
    protected final double[] _lengthOfSides;

    public Shape(
            String nameOfShape,
            int countOfSides,
            double[] lengthOfSides
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

    public static double[] getSquares(Shape[] shapes) {
        double[] squares = new double[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            squares[i] = shapes[i]._square;
        }
        return squares;
    }

    public static double getAveragePerimeterOfPolygon(Shape[] shapes) {
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

    public double[] getLengthOfSides() {
        return _lengthOfSides;
    }
}
