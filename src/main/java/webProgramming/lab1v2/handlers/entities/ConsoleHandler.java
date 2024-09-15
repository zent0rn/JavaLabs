package webProgramming.lab1v2.handlers.entities;

import webProgramming.lab1v2.handlers.interfaces.IOHandler;

import java.util.Scanner;

public class ConsoleHandler implements IOHandler {
    Scanner _scanner;

    /**
     * метод создаёт объект типа Scanner
     */
    public ConsoleHandler(){
        _scanner = new Scanner(System.in);
    }

    /**
     * метод считывает строчку с помощью созданного объекта типа Scanner
     * @return _scanner.nextLine() - строчка, введённая пользователем
     */
    @Override
    public String read() {
        return _scanner.nextLine();
    }

    /**
     * метод выводит на консоль строчку
     * @param string - некоторая строка типа String
     */
    @Override
    public void write(String string){
        System.out.print(string);
    }
}
