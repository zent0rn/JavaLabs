package webProgramming.lab4v2.application.impl;

import lombok.Getter;
import lombok.SneakyThrows;
import webProgramming.lab4v2.application.ApplicationUI;
import webProgramming.lab4v2.io.IOHandler;
import webProgramming.lab4v2.stack.MyStack;
import webProgramming.lab4v2.io.impl.IOHandlerImpl;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * Класс нужен для работы стека с файлами
 */
@Getter
public class StackApplicationUI implements ApplicationUI {
    /**
     * Объект класса IOHandler для работы с потоком ввода/вывода
     */
    private IOHandler _consoleHandler;

    /**
     * Объект класса Path, путь к файлу
     */
    private Path pathToFile;

    /**
     * Объект класса MyStack, с которым будет производится взаимодействие
     */
    private final MyStack myStack;

    /**
     * Конструктор по умолчанию
     */
    public StackApplicationUI(){
        myStack = new MyStack();
        _consoleHandler = new IOHandlerImpl();
        pathToFile = DEFAULT_FILE_PATH;
    }

    /**
     * Конструктор с параметрами
     * @param consoleHandler объект класса IOHandler для работы с потоком ввода/вывода
     * @param path путь к файлу
     */
    public StackApplicationUI(IOHandler consoleHandler, Path path){
        this();
        _consoleHandler = consoleHandler;
        pathToFile = path;
    }

    /**
     * Считывает строки из файла и записывает в стек,
     * затем выводит на консоль размер и наибольшую строку
     * стека, записывает их файл в обратном порядке
     * @throws IOException проблема при выполнении операций ввода-вывода
     */
    @Override
    public void run() throws IOException {
        try(Stream<String> stringStream = Files.lines(pathToFile)){
            stringStream.forEach(myStack::push);
        }

        _consoleHandler.write("Размер стека: " + myStack.getSize() + '\n');
        _consoleHandler.write("Наибольшая строка: " + myStack.getLargestValue() + '\n');

        try(FileWriter fileWriter = new FileWriter(pathToFile.toFile())){
            for(String string: myStack.getAllData()){
                fileWriter.write(string + '\n');
            }
        }
    }

    /**
     * Стандартный путь к файлу
     */
    private static final Path DEFAULT_FILE_PATH = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
            + "/src/main/resources/fileForLab4.txt");
}
