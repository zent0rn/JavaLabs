package webProgramming.lab2v1.handlers.entities;

import webProgramming.lab2v1.handlers.IOHandler;

import java.util.Scanner;

public class ConsoleHandler implements IOHandler {
    private final Scanner _scanner;

    /**
     * конструктор по умолчанию
     */
    public ConsoleHandler() {
        _scanner = new Scanner(System.in);
    }


    @Override
    public String read() {
        return _scanner.nextLine();
    }

    @Override
    public void write(String string) {
        System.out.print(string);
    }
}
