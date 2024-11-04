package webProgramming.lab4v2.application;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Предоставляет метод run
 * для запуска сеанса взаимодействия с пользователем
 */
public interface ApplicationUI {
    /**
     * Запускает пользовательский интерфейс
     */
    void run() throws IOException;
}
