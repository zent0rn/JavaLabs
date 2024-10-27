package webProgramming.lab3v1.handlers;

public interface IOHandler {
    /**
     * Читает пользовательский ввод
     *
     * @return объект типа String - строка, введённая пользователем
     */
    String read();

    /**
     * Выводит некоторые данные, сообщение
     *
     * @param string сообщение, которое необходимо вывести на консоль
     */
    void write(String string);

    void writeLine(String string);
}
