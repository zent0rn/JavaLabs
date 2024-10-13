package webProgramming.lab3v1.shapes;

public abstract class Shape {
    private final String _nameOfShape;
    private final double _square;
    private final double _perimeter;
    private final int _countOfSides;
    private final double[] _lengthOfSides;

    public Shape(
            String nameOfShape,
            double square,
            double perimeter,
            int countOfSides,
            double[] lengthOfSides
    ) {
        _nameOfShape = nameOfShape;
        _square = square;
        _perimeter = perimeter;
        _countOfSides = countOfSides;
        _lengthOfSides = lengthOfSides;
    }

    public abstract double calculateSquare(Shape shape);

    public abstract double calculatePerimeter(Shape shape);

    public abstract double[] getSquares(Shape[] shapes);

    public abstract double[] getAveragePerimeterOfPolygon();

    public abstract Shape[] sortShapesBySquare(Shape[] shapes);

    public abstract Shape findShapeByName(Shape[] shapes);


}
