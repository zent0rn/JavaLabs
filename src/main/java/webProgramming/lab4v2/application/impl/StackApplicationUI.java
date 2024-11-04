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
 *
 */
@Getter
public class StackApplicationUI implements ApplicationUI {
    private IOHandler _consoleHandler;
    private Path pathToFile;

    private final MyStack myStack;

    public StackApplicationUI(){
        myStack = new MyStack();
        _consoleHandler = new IOHandlerImpl();
        pathToFile = DEFAULT_FILE_PATH;
    }

    public StackApplicationUI(IOHandler consoleHandler, Path path){
        this();
        _consoleHandler = consoleHandler;
        pathToFile = path;
    }

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

    private static final Path DEFAULT_FILE_PATH = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
            + "/src/main/resources/fileForLab4.txt");
}
