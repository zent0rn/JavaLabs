package webProgramming.lab4v2.io.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IOConsoleHandlerTest {
    IOConsoleHandler handler;

    @Test
    @DisplayName("Конструктор по умолчанию работает корректно")
    void ensureDefaultConstructorsWorks() {
        handler = new IOConsoleHandler();

        assertThat(handler.getInputStream()).isInstanceOf(Scanner.class);
        assertThat(handler.getOutputStream()).isInstanceOf(PrintStream.class);
    }

    @Test
    @DisplayName("Конструктор c параметрами работает корректно")
    void ensureParameterizedConstructorsWorks() {
        handler = new IOConsoleHandler(System.in, System.out);

        assertThat(handler.getInputStream()).isInstanceOf(Scanner.class);
        assertThat(handler.getOutputStream()).isInstanceOf(PrintStream.class);
    }


    @Test
    @Disabled
    @DisplayName("Метод чтения работает корректно")
    void ensureReadWorksCorrectly() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("data from input".getBytes());
        handler = new IOConsoleHandler(byteArrayInputStream, System.out);

        assertEquals("data from input", handler.read());
    }

    @Test
    @Disabled
    @DisplayName("Метод вывода работает корректно")
    void ensureWriteMessageWorksCorrectly() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        handler = new IOConsoleHandler(System.in, byteArrayOutputStream);

        handler.write("data to output");

        assertEquals("data to output", byteArrayOutputStream.toString());
    }
}