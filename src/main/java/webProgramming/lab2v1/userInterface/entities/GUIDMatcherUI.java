package webProgramming.lab2v1.userInterface.entities;

import webProgramming.lab2v1.handlers.entities.ConsoleHandler;
import webProgramming.lab2v1.handlers.interfaces.IOHandler;
import webProgramming.lab2v1.services.entities.GUIDMatcherService;
import webProgramming.lab2v1.userInterface.interfaces.UserInterface;

/**
 * Класс GUIDMatcherUI позволяет
 * взаимодействовать с пользователем для обработки введенных строк
 * на соответствие GUID
 */
public class GUIDMatcherUI implements UserInterface {
    private final GUIDMatcherService _GUIDMatcherService;
    private final IOHandler _ioHandler;

    /**
     * конструктор по умолчанию
     */
    public GUIDMatcherUI() {
        _GUIDMatcherService = new GUIDMatcherService();
        _ioHandler = new ConsoleHandler();
    }

    public void run() {
        _ioHandler.write("Введите строку: ");
        String[] guidsAsStrings = _ioHandler.read().split(" ");
        for (String guid : guidsAsStrings) {
            if (guid.isBlank()) {
                continue;
            }
            boolean matchResult = _GUIDMatcherService.match(guid);
            if (matchResult) {
                _ioHandler.write(guid + " удовлетворяет шаблону (является GUID)\n");
            } else {
                _ioHandler.write(guid + " НЕ удовлетворяет шаблону (НЕ является GUID)\n");
            }
        }
    }
}
