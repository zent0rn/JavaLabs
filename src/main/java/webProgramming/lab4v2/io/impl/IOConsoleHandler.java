package webProgramming.lab4v2.io.impl;

import lombok.Getter;
import webProgramming.lab4v2.io.IOHandler;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * IOHandlerImpl позволяет взаимодействовать с консолью
 * Класс основан на использовании объектов Scanner и PrintStream,
 * которые используют стандартные потоки System.in и System.out или
 * переданные пользователем потоки ввода/вывода
 */
@Getter
public class IOConsoleHandler implements IOHandler {
    /**
     * Входной поток данных
     */
    private final Scanner inputStream;
    /**
     * Поток вывода данных
     */
    private final PrintStream outputStream;

    /**
     * Конструктор по умолчанию, устанавливающий в качестве потоков ввода/вывода
     * стандартные System.in, System.out
     */
    public IOConsoleHandler() {
        inputStream = new Scanner(System.in, StandardCharsets.UTF_8);
        outputStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    }

    /**
     * Конструктор с параметрами - потоками ввода и вывода
     *
     * @param inputStream  входной поток для чтения данных
     * @param outputStream поток для записи данных
     */
    public IOConsoleHandler(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new Scanner(inputStream, StandardCharsets.UTF_8);
        this.outputStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8);
    }

    public void write(String data) {
        outputStream.print(data);
    }

    public String read() {
        return inputStream.nextLine();
    }

    public List<String> readLines(){
        List<String> lines = new ArrayList<>();
        while(inputStream.hasNextLine()){
            lines.add(inputStream.nextLine());
        }
        return lines;
    }

    public void writeLines(List<String> lines){
        for(String line: lines){
            outputStream.print(line);
        }
    }

}

