package webProgramming.lab4v2;

import webProgramming.lab4v2.application.ApplicationUI;
import webProgramming.lab4v2.application.impl.StackApplicationUI;
import webProgramming.lab4v2.io.IOHandler;
import webProgramming.lab4v2.io.impl.IOHandlerImpl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path file = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
                + "/src/main/resources/fileForLab4.txt");
        IOHandler consoleHandler = new IOHandlerImpl();
        IOHandler fileHandler = new IOHandlerImpl(
                new FileInputStream(file.toFile()),
                new FileOutputStream(file.toFile())
        );
        ApplicationUI applicationUI = new StackApplicationUI(consoleHandler, fileHandler);
        applicationUI.run();
    }
}
