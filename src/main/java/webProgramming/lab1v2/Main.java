// Сазонов, Зимин, 23ВП1, 2 вариант
//Ввести с консоли n целых чисел и поместить их в массив. На консоль
//вывести "счастливые" числа. Критерий «счастливого» числа
//программист определяет сам.
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
