package webProgramming.lab2v1.userInterface.impl;

import webProgramming.lab2v1.entity.GUID;
import webProgramming.lab2v1.handlers.IOHandler;
import webProgramming.lab2v1.handlers.impl.ConsoleHandler;
import webProgramming.lab2v1.userInterface.UserInterface;

/**
 * Класс GUIDMatcherUI позволяет
 * взаимодействовать с пользователем для обработки введенных строк
 * на соответствие GUID
 */
public class GUIDMatcherUI implements UserInterface {
    private final IOHandler _ioHandler;

    /**
     * конструктор по умолчанию
     */
    public GUIDMatcherUI() {
        _ioHandler = new ConsoleHandler();
    }

    public void run() {
        _ioHandler.write("Введите строки: ");
        GUID[] guids = GUID.stringToArrayGUIDs(_ioHandler.read());
        for (GUID guid : guids) {
            if (guid.isGUID()) {
                _ioHandler.write(guid + " удовлетворяет шаблону (является GUID)\n");
            } else {
                _ioHandler.write(guid + " НЕ удовлетворяет шаблону (НЕ является GUID)\n");
            }
        }
    }
}
