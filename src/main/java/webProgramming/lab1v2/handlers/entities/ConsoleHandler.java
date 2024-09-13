package webProgramming.lab1v2.handlers.entities;

import webProgramming.lab1v2.handlers.interfaces.IOHandler;

import java.util.Scanner;

public class ConsoleHandler implements IOHandler {
    Scanner _scanner;
    /*
   метод создаёт объект типа Scanner
   @ param -
   @ return -
    */
    public ConsoleHandler(){
        _scanner = new Scanner(System.in);
    }

    /*
   метод считывает строчку с помощью созданного объекта типа Scanner
   @ param -
   @ return -
    */
    @Override
    public String read() {
        return _scanner.nextLine();
    }

    /*
   метод выводит на консоль строчку
   @ param - String string - некоторая строка
   @ return -
    */
    @Override
    public void write(String string){
        System.out.print(string);
    }
}
