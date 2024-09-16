package webProgramming.lab1v2.handlers.entities;

import webProgramming.lab1v2.handlers.interfaces.DataHandler;
import webProgramming.lab1v2.supportEntities.Number;

import java.util.Arrays;

public class NumbersHandler implements DataHandler {
    /**
     * Метод конвертирует массив введенных пользователем чисел
     * в виде объектов типа String в массив "счастливых" чисел
     *
     * @param buff массив чисел типа String - пользовательский ввод
     * @return массив объектов типа Number - "счастливые" числа
     */
    @Override
    public Number[] handle(String[] buff) {
        Number[] numbers = new Number[buff.length];
        int currentIndex = 0;
        for (String i : buff) {
            numbers[currentIndex++] = new Number(i);
        }

        Number[] happyNumbers = new Number[numbers.length];
        int countHappyNumbers = 0;
        for (Number number : numbers) {
            if (number.checkHappiness()) {
                happyNumbers[countHappyNumbers++] = number;
            }
        }
        return Arrays.copyOf(happyNumbers, countHappyNumbers);
    }
}
