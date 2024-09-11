package webProgramming.lab1v2.handlers.entities;

import webProgramming.lab1v2.handlers.interfaces.DataHandler;
import webProgramming.lab1v2.supportEntities.Number;

import java.util.Arrays;

public class NumbersHandler implements DataHandler {
    @Override
    public Number[] handle(String[] buff) {
        //создание массива объектов Number из входных данных в виде строк
        Number[] numbers = new Number[buff.length];
        int currentIndex = 0;
        for(String i: buff){
            numbers[currentIndex++] = new Number(i);
        }

        //обработка чисел, получение массива счастливых чисел
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
