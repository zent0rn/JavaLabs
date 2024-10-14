package webProgramming.lab3v1;

import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.shapes.concrete.Rectangle;
import webProgramming.lab3v1.shapes.concrete.Triangle;

public class Main {
    public static void main(String[] args) {
        Shape tr = Triangle.of("Мой треуг", new double[]{3, 4, 5});
        Shape rect = Rectangle.of("Прямоугольник1", new double[]{2, 3, 4});
    }
}
