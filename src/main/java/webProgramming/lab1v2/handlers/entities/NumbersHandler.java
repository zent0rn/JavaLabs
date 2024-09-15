package webProgramming.lab1v2.handlers.entities;

import webProgramming.lab1v2.handlers.interfaces.DataHandler;
import webProgramming.lab1v2.supportEntities.Number;

import java.util.Arrays;

public class NumbersHandler implements DataHandler {


    /**
     * метод handle создает массив объектов Number из входных данных
     * в виде строк, затем обрабатывает числа и получает массив счастливых чисел
     * @param buff массив чисел, которые вводил пользователь типа String
     * @return - Arrays.copyOf(happyNumbers, countHappyNumbers) - копия
     * массива happyNumber длиной countHappyNumbers
     */
    @Override
    public Number[] handle(String[] buff) {
        Number[] numbers = new Number[buff.length];
        int currentIndex = 0;
        for(String i: buff){
            numbers[currentIndex++] = new Number(i);
        }

        Number[] happyNumbers = new Number[numbers.length];
        int countHappyNumbers = 0;
        for(Number number: numbers){
            if(number.checkHappiness()){
                happyNumbers[countHappyNumbers++] = number;
            }
        }
        return Arrays.copyOf(happyNumbers, countHappyNumbers);
    }
}
