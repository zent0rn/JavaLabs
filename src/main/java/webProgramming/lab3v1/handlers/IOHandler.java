package webProgramming.lab3v1.handlers;

public interface IOHandler {
    /**
     * метод для чтения пользовательского ввода
     *
     * @return объект типа String - строка, введённая пользователем
     */
    String read();

    /**
     * метод для вывода данных
     *
     * @param string сообщение, которое необходимо вывести на консоль
     */
    void write(String string);

    void writeLine(String string);
}
