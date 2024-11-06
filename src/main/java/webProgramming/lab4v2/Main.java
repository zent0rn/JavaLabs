package webProgramming.lab4v2;

import webProgramming.lab4v2.application.ApplicationUI;
import webProgramming.lab4v2.application.impl.StackApplicationUI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationUI applicationUI = new StackApplicationUI();
        applicationUI.run();
    }
}

