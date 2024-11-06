package webProgramming.lab4v2.application.impl;

import lombok.Getter;
import webProgramming.lab4v2.application.ApplicationUI;
import webProgramming.lab4v2.data.MyString;
import webProgramming.lab4v2.io.IOHandler;
import webProgramming.lab4v2.io.impl.IOConsoleHandler;
import webProgramming.lab4v2.io.impl.IOFileHandler;
import webProgramming.lab4v2.stack.MyStack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Пользовательский интерфейс, позволяющий взаимодействовать
 * с программой
 */
@Getter
public class StackApplicationUI implements ApplicationUI {
    /**
     * Объект класса IOHandler, содержащий потоки ввода/вывода для консоли
     */
    private final IOHandler _consoleHandler;

    /**
     * Объект класса IOHandler, содержащий поток ввода/вывода для файла
     */
    private final IOHandler _fileHandler;

    /**
     * Конструктор по умолчанию
     */
    public StackApplicationUI() throws FileNotFoundException {
        _consoleHandler = new IOConsoleHandler();
        _fileHandler = new IOFileHandler();
    }

    /**
     * Конструктор с параметрами
     *
     * @param consoleHandler объект класса IOHandler для работы с потоком ввода/вывода
     */
    public StackApplicationUI(IOHandler consoleHandler, IOHandler fileHandler) throws FileNotFoundException {
        _consoleHandler = consoleHandler;
        _fileHandler = fileHandler;
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
        List<MyString> myStringList = MyString.getMyStrings(_fileHandler.readLines());

        MyStack myStack = MyStack.getStringStack(myStringList);
        if (myStack.getSize() == 0) {
            _consoleHandler.write("Файл пуст");
            return;
        }

        _consoleHandler.write("Размер стека: " + myStack.getSize() + '\n');
        _consoleHandler.write("Наибольшая строка: " + myStack.getLargestValue().getValue() + '\n');

        _fileHandler.writeLines(MyString.getValues(myStack.getAllData()));
    }


}
