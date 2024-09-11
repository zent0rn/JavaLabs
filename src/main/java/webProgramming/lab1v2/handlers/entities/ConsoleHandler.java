package webProgramming.lab1v2.handlers.entities;

import webProgramming.lab1v2.handlers.interfaces.DataHandler;

import java.util.Scanner;

public class ConsoleHandler implements DataHandler {
    Scanner _scanner;
    public ConsoleHandler(){
        _scanner = new Scanner(System.in);
    }

    @Override
    public String read() {
        return _scanner.nextLine();
    }

    @Override
    public void write(String string){
        System.out.print(string);
    }
}
