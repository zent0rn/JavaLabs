package webProgramming.lab4v2.application.impl;

import lombok.Getter;
import webProgramming.lab4v2.application.ApplicationUI;
import webProgramming.lab4v2.io.IOHandler;
import webProgramming.lab4v2.stack.MyStack;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 *
 */
@Getter
public class StackApplicationUI implements ApplicationUI {
    private IOHandler consoleHandler;
    private IOHandler fileHandler;

    private MyStack<String> myStack;

    public StackApplicationUI(){

    }

    public StackApplicationUI(IOHandler consoleHandler, IOHandler fileHandler){

    }

    @Override
    public void run() {

    }

    private static final Path DEFAULT_FILE_PATH = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
            + "/src/main/resources/fileForLab4.txt");
}
