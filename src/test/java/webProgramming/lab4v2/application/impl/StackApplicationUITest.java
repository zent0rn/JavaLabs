package webProgramming.lab4v2.application.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webProgramming.lab4v2.io.IOHandler;
import webProgramming.lab4v2.io.impl.IOHandlerImpl;

import java.io.*;
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
        assertNotNull(applicationUI.get_fileHandler());
    }

    @Test
    @DisplayName("Конструктор с параметрами работает корректно")
    void ensureParameterizedConstructorWorks() throws FileNotFoundException {
        IOHandler console = new IOHandlerImpl(System.in, System.out);
        Path path = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
                + "/src/main/resources/fileForLab4.txt");
        IOHandler file = new IOHandlerImpl(
                new FileInputStream(path.toFile()),
                new FileOutputStream(path.toFile())
        );

        applicationUI = new StackApplicationUI(console, file);

        assertNotNull(applicationUI.get_consoleHandler());
        assertNotNull(applicationUI.get_fileHandler());
    }

    @Test
    @DisplayName("Метод run работает")
    void ensureRunWorks() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOHandler console = new IOHandlerImpl(System.in, System.out);
        Path path = Path.of(FileSystems.getDefault().getPath(".").toAbsolutePath()
                + "/src/test/java/webProgramming/lab4v2/testFile.txt");
        IOHandler file = new IOHandlerImpl(
                new FileInputStream(path.toFile()),
                byteArrayOutputStream
        );

        applicationUI.run();

        assertEquals(3, applicationUI.getMyStack().getSize());
        assertEquals("string 33", applicationUI.getMyStack().getLargestValue());
        assertEquals("""
                string 33
                str 2
                string 1
                """, byteArrayOutputStream.toString());
    }
}