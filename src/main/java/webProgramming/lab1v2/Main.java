package webProgramming.lab1v2;

import webProgramming.lab1v2.services.entities.HappyNumbersService;

public class Main {
    /**
     * метод main является точкой входа
     * @param args
     */
    public static void main(String[] args) {
        HappyNumbersService happyNumbersService = new HappyNumbersService();
        happyNumbersService.run();
    }
}
