package webProgramming.lab1v2;

import webProgramming.lab1v2.services.entities.HappyNumbersService;

public class Main {
    /**
     * точка входа
     *
     * @param args параметры командной строки
     */
    public static void main(String[] args) {
        HappyNumbersService happyNumbersService = new HappyNumbersService();
        happyNumbersService.run();
    }
}
