package webProgramming.lab2v1.userInterface.entities;

import webProgramming.lab2v1.handlers.entities.ConsoleHandler;
import webProgramming.lab2v1.handlers.interfaces.IOHandler;
import webProgramming.lab2v1.services.entities.GUIDMatcherService;
import webProgramming.lab2v1.userInterface.interfaces.UserInteface;

public class GUIDMatcherUI implements UserInteface {
    private final GUIDMatcherService _GUIDMatcherService;
    private final IOHandler _ioHandler;

    /**
     * конструктор по умолчаниюя
     */
    public GUIDMatcherUI(){
        _GUIDMatcherService = new GUIDMatcherService();
        _ioHandler = new ConsoleHandler();
    }

    /**
     * метод запускает GUIDMatcherUI для взаимодействия с пользователем
     */
    public void run(){
        _ioHandler.write("Введите строку: ");
        String[] guidsAsStrings = _ioHandler.read().split(" ");
        for(String guid: guidsAsStrings){
            boolean matchResult = _GUIDMatcherService.match(guid);
            if(matchResult){
                _ioHandler.write(guid + " matches the pattern\n");
            }else{
                _ioHandler.write(guid + " doesn't match the pattern\n");
            }
        }
    }
}
