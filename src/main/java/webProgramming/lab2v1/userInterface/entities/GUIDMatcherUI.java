package webProgramming.lab2v1.userInterface.entities;

import webProgramming.lab1v2.handlers.entities.ConsoleHandler;
import webProgramming.lab1v2.handlers.interfaces.IOHandler;
import webProgramming.lab2v1.services.entities.GUIDMatcherService;
import webProgramming.lab2v1.userInterface.interfaces.UserInteface;

public class GUIDMatcherUI implements UserInteface {
    private final GUIDMatcherService _GUIDMatcherService;
    private final IOHandler _ioHandler;

    public GUIDMatcherUI(){
        _GUIDMatcherService = new GUIDMatcherService();
        _ioHandler = new ConsoleHandler();
    }

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
