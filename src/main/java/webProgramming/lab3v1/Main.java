package webProgramming.lab3v1;

import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.shapes.concrete.Triangle;

public class Main {
    public static void main(String[] args) {
        Shape tr = Triangle.of("Мой треуг", new double[]{3, 4, 5});
    }
}
