package webProgramming.lab3v1.menus.impl;

import webProgramming.lab3v1.menus.Menu;

public class GetInfoMenu implements Menu {
    @Override
    public String getMenu() {
        return """
                [1] Вывести информацию о фигуре
                [2] Вывести информацию о площадях фигур
                [3] Вывести всю информацию о всех фигурах
                [n] Назад
                [q] Выход
                """;
    }
}
