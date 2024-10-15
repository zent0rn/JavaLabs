package webProgramming.lab3v1.shapes.concrete;

import org.w3c.dom.css.Rect;
import webProgramming.lab3v1.shapes.Shape;

import java.util.Arrays;

public class Rectangle extends Shape {

    public Rectangle(String nameOfShape, double[] lengthOfSides) {
        super(nameOfShape, lengthOfSides);
    }

    public static Rectangle of(String nameRectangle, double[] lengthOfSides) {
        if (lengthOfSides.length != 4) {
            throw new IllegalArgumentException("Размер массива с длинами сторон прямоугольника должен быть равен 4!");
        }

        return new Rectangle(nameRectangle, lengthOfSides);
    }

    @Override
    public double calculateSquare() {
        return _lengthOfSides[0] * _lengthOfSides[1];
    }

    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();
        repr.append("Rectangle{_nameOfShape='").append(_nameOfShape).append('\'').append(", _square=").append(_square)
                .append(", _perimeter=").append(_perimeter).append(", _countOfSides=").append(_countOfSides)
                .append(", _lengthOfSides=").append(Arrays.toString(_lengthOfSides)).append('}');
        return repr.toString();
    }
}