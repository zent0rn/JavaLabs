package webProgramming.lab4v2.io;

import java.io.IOException;

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
}
