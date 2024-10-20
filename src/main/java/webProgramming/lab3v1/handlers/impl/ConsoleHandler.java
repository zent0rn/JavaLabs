package webProgramming.lab3v1.handlers.impl;

import webProgramming.lab3v1.handlers.IOHandler;

import java.util.Scanner;

public class ConsoleHandler implements IOHandler {
    /** объект класса Scanner */
    private final Scanner _scanner;

    /**
     * конструктор по умолчанию
     */
    public ConsoleHandler() {
        _scanner = new Scanner(System.in);
    }


    /**
     * метод считывает строчку
     * @return _scanner.nextLine() - строчка
     */
    @Override
    public String read() {
        return _scanner.nextLine();
    }

    /**
     * метод выводит на консоль строчку
     * @param string строка, которую необходимо вывести на консоль
     */
    @Override
    public void write(String string) {
        System.out.print(string);
    }

    /**
     * метод выводит на консоль строчку
     * @param string строка, которую необходимо вывести на консоль
     */
    @Override
    public void writeLine(String string){System.out.println(string);}
}
