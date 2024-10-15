package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.Arrays;

public class RegularHexagon extends Shape {
    private static final int COUNT_SIDES = 6;
    public RegularHexagon(String nameOfShape, double[] lengthOfSides) {
        super(nameOfShape, COUNT_SIDES, lengthOfSides);
    }

    public static RegularHexagon of(String nameRegularHexagon, double[] lengthOfSides) {
        if (lengthOfSides.length != COUNT_SIDES) {
            throw new IllegalArgumentException("Размер массива с длинами сторон шестиугольника должен быть равен 6!");
        }

        return new RegularHexagon(nameRegularHexagon, lengthOfSides);
    }

    @Override
    public double calculateSquare() {
        return (3 * Math.pow(_lengthOfSides[0], 2) * Math.sqrt(3) / 2);
    }

    @Override
    public String getInfo() {
        StringBuilder repr = new StringBuilder();
        repr.append("RegularHexagon{_nameOfShape='").append(_nameOfShape).append('\'').append(", _square=")
                .append(_square).append(", _perimeter=").append(_perimeter).append(", _countOfSides=")
                .append(_countOfSides).append(", _lengthOfSides=").append(Arrays.toString(_lengthOfSides)).append('}');
        return repr.toString();
    }
}