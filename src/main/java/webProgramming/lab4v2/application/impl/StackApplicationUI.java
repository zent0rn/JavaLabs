package webProgramming.lab4v2.application.impl;

import lombok.Getter;
import webProgramming.lab4v2.application.ApplicationUI;
import webProgramming.lab4v2.io.IOHandler;
import webProgramming.lab4v2.io.impl.IOHandlerImpl;
import webProgramming.lab4v2.stack.MyStack;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Пользовательский интерфейс, позволяющий взаимодействовать
 * с программой
 */
@Getter
public class StackApplicationUI implements ApplicationUI {
    /**
     * Объект класса IOHandler, содержащий потоки ввода/вывода для консоли
     */
    private IOHandler _consoleHandler;

    /**
     * Путь к файлу
     */
    private Path pathToFile;

    /**
     * Объект класса MyStack - контейнер, обрабатывающий
     * входящие строки
     */
    private final MyStack myStack;

    /**
     * Конструктор по умолчанию
     */
    public StackApplicationUI() {
        myStack = new MyStack();
        _consoleHandler = new IOHandlerImpl();
        pathToFile = DEFAULT_FILE_PATH;
    }

    /**
     * Конструктор с параметрами
     *
     * @param consoleHandler объект класса IOHandler для работы с потоком ввода/вывода
     * @param path           путь к файлу
     */
    public StackApplicationUI(IOHandler consoleHandler, Path path) {
        this();
        _consoleHandler = consoleHandler;
        pathToFile = path;
    }

    /**
     * Считывает строки из файла и записывает в стек,
     * затем выводит на консоль размер и наибольшую строку
     * стека, записывает их файл в обратном порядке
     *
     * @throws IOException если возникли проблемы при выполнении операций ввода-вывода
     */
    @Override
    public void run() throws IOException {
        try (Stream<String> stringStream = Files.lines(pathToFile)) {
            stringStream.forEach(myStack::push);
        }

        _consoleHandler.write("Размер стека: " + myStack.getSize() + '\n');
        _consoleHandler.write("Наибольшая строка: " + myStack.getLargestValue() + '\n');

        try (FileWriter fileWriter = new FileWriter(pathToFile.toFile())) {
            for (String string : myStack.getAllData()) {
                fileWriter.write(string + '\n');
            }
        }
    }

    /**
     * Путь к файлу по умолчанию
     */
    private static final Path DEFAULT_FILE_PATH = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
            + "/src/main/resources/fileForLab4.txt");
}
