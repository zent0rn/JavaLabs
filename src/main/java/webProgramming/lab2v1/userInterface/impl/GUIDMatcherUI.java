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
        try {
            GUID[] guids = GUID.stringToArrayGUIDs(_ioHandler.read());
            for (GUID guid : guids) {
                _ioHandler.write(guid.isGUID());
            }
        }
        catch(IllegalArgumentException e){
            _ioHandler.write(e.getMessage());
        }
    }
}
