package webProgramming.lab4v2.application.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webProgramming.lab4v2.io.IOHandler;
import webProgramming.lab4v2.io.impl.IOHandlerImpl;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StackApplicationUITest {
    private StackApplicationUI applicationUI;

    @Test
    @DisplayName("Конструктор по умолчанию работает корректно")
    void ensureDefaultConstructorWorks() {
        applicationUI = new StackApplicationUI();

        assertNotNull(applicationUI.get_consoleHandler());
    }

    @Test
    @DisplayName("Конструктор с параметрами работает корректно")
    void ensureParameterizedConstructorWorks() throws FileNotFoundException {
        IOHandler console = new IOHandlerImpl(System.in, System.out);
        Path path = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
                + "/src/main/resources/fileForLab4.txt");

        applicationUI = new StackApplicationUI(console, path);

        assertNotNull(applicationUI.get_consoleHandler());
    }

    @Test
    @DisplayName("Метод run работает")
    void ensureRunWorks() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOHandler console = new IOHandlerImpl(System.in, byteArrayOutputStream);
        Path path = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
                + "/src/test/java/webProgramming/lab4v2/application/impl/testFile.txt");
        applicationUI = new StackApplicationUI(console, path);
        applicationUI.run();

        String[] actualConsoleOutput = byteArrayOutputStream.toString().split("\n");
        assertEquals("Размер стека: 3", actualConsoleOutput[0]);
        assertEquals("Наибольшая строка: string 33", actualConsoleOutput[1]);
    }
}