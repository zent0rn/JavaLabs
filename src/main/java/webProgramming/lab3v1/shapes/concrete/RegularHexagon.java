package webProgramming.lab3v1.shapes.concrete;

import webProgramming.lab3v1.shapes.Shape;

import java.util.List;

public class RegularHexagon extends Shape {
    private static final int COUNT_SIDES = 6;

    public RegularHexagon(String nameOfShape, List<Double> lengthOfSides) {
        super(nameOfShape, COUNT_SIDES, lengthOfSides);
    }

    public static RegularHexagon of(String nameRegularHexagon, List<Double> sides) {
        if (nameRegularHexagon.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        }
        if(sides.size() != 1){
            throw new IllegalArgumentException("Для правильного пятиугольника необходима длина только одной стороны!");
        }
        double side = sides.getFirst();
        return new RegularHexagon(nameRegularHexagon, List.of(side, side, side, side, side, side));
    }

    @Override
    public double calculateSquare() {
        return (3 * Math.pow(_lengthOfSides.get(0), 2) * Math.sqrt(3) / 2);
    }

    @Override
    public String getInfo() {
        StringBuilder repr = new StringBuilder();
        repr.append("RegularHexagon{_nameOfShape='").append(_nameOfShape).append('\'').append(", _square=")
                .append(_square).append(", _perimeter=").append(_perimeter).append(", _countOfSides=")
                .append(_countOfSides).append(", _lengthOfSides=").append(_lengthOfSides.toString()).append('}');
        return repr.toString();
    }
}