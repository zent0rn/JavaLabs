package webProgramming.lab1v2.handlers.entities;

import webProgramming.lab1v2.handlers.interfaces.IOHandler;

import java.util.Scanner;

public class ConsoleHandler implements IOHandler {
    private final Scanner _scanner;

    /**
     * конструктор по умолчанию
     */
    public ConsoleHandler() {
        _scanner = new Scanner(System.in);
    }

    /**
     * метод для чтения пользовательского ввода
     *
     * @return объект типа String - строка, введённая пользователем
     */
    @Override
    public String read() {
        return _scanner.nextLine();
    }

    /**
     * метод для вывода данных
     *
     * @param string сообщение, которое необхоодимо вывести на консоль
     */
    @Override
    public void write(String string) {
        System.out.print(string);
    }
}
