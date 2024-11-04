package webProgramming.lab4v2.application.impl;

import lombok.Getter;
import webProgramming.lab4v2.application.ApplicationUI;
import webProgramming.lab4v2.io.IOHandler;
import webProgramming.lab4v2.stack.MyStack;
import webProgramming.lab4v2.io.impl.IOHandlerImpl;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.NoSuchElementException;

/**
 *
 */
@Getter
public class StackApplicationUI implements ApplicationUI {
    private IOHandler _consoleHandler;
    private IOHandler _fileHandler;

    private MyStack myStack;

    public StackApplicationUI(){
        _consoleHandler = new IOHandlerImpl();
        _fileHandler = new IOHandlerImpl();
    }

    public StackApplicationUI(IOHandler consoleHandler, IOHandler fileHandler){
        _consoleHandler = consoleHandler;
        _fileHandler = fileHandler;
    }

    @Override
    public void run() throws IOException {
        String str = _fileHandler.read();
        myStack = new MyStack();
        _consoleHandler.write(str);

    }

    private static final Path DEFAULT_FILE_PATH = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
            + "/src/main/resources/fileForLab4.txt");
}
