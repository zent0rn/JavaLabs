package webProgramming.lab1v2.services.entities;

import webProgramming.lab1v2.handlers.entities.ConsoleHandler;
import webProgramming.lab1v2.services.interfaces.Service;
import webProgramming.lab1v2.supportEntities.Number;

import java.util.Arrays;


public class HappyNumbersService implements Service {
    private final ConsoleHandler _consoleHandler;

    public HappyNumbersService(){
        _consoleHandler = new ConsoleHandler();
    }

    public HappyNumbersService(ConsoleHandler consoleHandler){
        _consoleHandler = consoleHandler;
    }

    public void run(){
        try {
            _consoleHandler.write("Введите количество чисел: ");
            int countNumbers = Integer.parseInt(_consoleHandler.read());

            _consoleHandler.write("Введите числа: ");
            String[] buff = _consoleHandler.read().split(" ");

            Number[] happyNumbers = handleNumbers(countNumbers, buff);

            //вывод на консоль счастливых чисел
            _consoleHandler.write("Счастливые числа: ");
            for(Number happyNumber: happyNumbers){
                _consoleHandler.write(happyNumber + " ");
            }

        } catch (Exception e) {
            _consoleHandler.write("Некорректные входные данные! Повторите попытку!\n");
            run();
        }
    }

    private Number[] handleNumbers(int countNumbers, String[] buff) {
        //создание массива объектов Number из входных данных в виде строк
        Number[] numbers = new Number[countNumbers];
        int currentIndex = 0;
        for(String i: buff){
            numbers[currentIndex++] = new Number(i);
        }

        //если количество записанных объектов не равно
        // изначально заданному количеству чисел
        if(currentIndex != countNumbers){
            throw new RuntimeException();
        }

        //обработка чисел, получение массива счастливых чисел
        Number[] happyNumbers = new Number[countNumbers];
        int countHappyNumbers = 0;
        for(Number number: numbers){
            if(number.checkHappiness()){
                happyNumbers[countHappyNumbers++] = number;
            }
        }
        return Arrays.copyOf(happyNumbers, countHappyNumbers);
    }
}
