package webProgramming.lab3v1.menus.impl;

import webProgramming.lab3v1.menus.Menu;

public class MainMenu implements Menu {
    @Override
    public String getMenu() {
        return """
                [1] Создать фигуру
                [2] Вывести информацию
                [3] Определить средний размер периметра фигур с количеством сторон больше 5
                [4] Упорядочить массив по возрастанию площади
                [5] Найти фигуру по названию
                [q] Выход
                """;
    }
}
