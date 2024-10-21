package webProgramming.lab3v1.handlers;

public interface IOHandler {
    /**
     * Метод для чтения пользовательского ввода
     *
     * @return объект типа String - строка, введённая пользователем
     */
    String read();

    /**
     * Метод для вывода данных
     *
     * @param string сообщение, которое необходимо вывести на консоль
     */
    void write(String string);

    void writeLine(String string);
}
