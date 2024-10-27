package webProgramming.lab3v1.handlers.impl;

import webProgramming.lab3v1.handlers.IOHandler;

import java.util.Scanner;

public class ConsoleHandler implements IOHandler {
    /**
     * Объект класса Scanner хранит поток ввода
     */
    private final Scanner _scanner;

    /**
     * Конструктор по умолчанию
     */
    public ConsoleHandler() {
        _scanner = new Scanner(System.in);
    }


    /**
     * Считывает данные из входного потока
     *
     * @return прочитанная строка
     */
    @Override
    public String read() {
        return _scanner.nextLine();
    }

    /**
     * Выводит на консоль данные - объект типа String
     *
     * @param string строка, которую необходимо вывести на консоль
     */
    @Override
    public void write(String string) {
        System.out.print(string);
    }

    /**
     * Выводит на консоль данные с добавлением переноса строки
     *
     * @param string строка, которую необходимо вывести на консоль
     */
    @Override
    public void writeLine(String string) {
        System.out.println(string);
    }
}
