package webProgramming.lab3v1.menus.impl;

import webProgramming.lab3v1.menus.Menu;

public class CreateShapeMenu implements Menu {
    @Override
    public String getMenu() {
        return """
                [1] Создать треугольник
                [2] Создать прямоугольник
                [3] Создать правильный шестиугольник
                [n] Назад
                [q] Выход
                """;
    }
}
