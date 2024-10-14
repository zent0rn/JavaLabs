package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

public class RegularHexagon extends Shape {
    public RegularHexagon(String nameOfShape, double[] lengthOfSides) {
        super(nameOfShape, lengthOfSides);
    }


    public static RegularHexagon of(String nameRegularHexagon, double[] lengthOfSides) {
        if (lengthOfSides.length != 6) {
            throw new IllegalArgumentException("Размер массива с длинами сторон шестиугольника должен быть равен 6!");
        }

        return new RegularHexagon(nameRegularHexagon, lengthOfSides);
    }

    @Override
    public double calculateSquare() {
        return (3 * Math.pow(_lengthOfSides[0], 2) * Math.sqrt(3) / 2);
    }

}