package webProgramming.lab4v2.io;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс предоставляет операции чтения и записи
 */
public interface IOHandler {
    /**
     * Записывает строку в поток вывода
     *
     * @param data сообщение для вывода
     * @throws IOException если произошла ошибка вывода
     */
    void write(String data) throws IOException;

    /**
     * Считывает строку из входного потока
     *
     * @return сообщение из входного потока
     * @throws IOException если произошла ошибка ввода
     */
    String read() throws IOException;

    /**
     * Считать все строки, содержащиеся в потоке ввода
     * @return список строк
     * @throws IOException если произошла ошибка ввода/вывода
     */
    List<String> readLines() throws IOException;

    /**
     * Записать в поток вывода строки
     * @param lines список строк для записи
     * @throws IOException если произошла ошибка ввода/вывода
     */
    void writeLines(List<String> lines) throws IOException;
}
