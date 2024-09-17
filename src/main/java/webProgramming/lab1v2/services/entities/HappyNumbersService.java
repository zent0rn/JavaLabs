package webProgramming.lab1v2.services.entities;

import webProgramming.lab1v2.handlers.entities.ConsoleHandler;
import webProgramming.lab1v2.handlers.entities.NumbersHandler;
import webProgramming.lab1v2.services.interfaces.Service;
import webProgramming.lab1v2.supportEntities.Number;


public class HappyNumbersService implements Service {
    private final ConsoleHandler _consoleHandler;
    private final NumbersHandler _numbersHandler;

    /**
     * конструктор по умолчанию
     */
    public HappyNumbersService() {
        _consoleHandler = new ConsoleHandler();
        _numbersHandler = new NumbersHandler();
    }

    /**
     * единственный метод класса, запускает HappyNumbersService для взаимодействия с пользователем,
     * содержит обработку некорректного ввода
     */
    public void run() {
        try {
            _consoleHandler.write("Введите количество чисел: ");
            int countNumbers = Integer.parseInt(_consoleHandler.read());

            if(countNumbers < 1){
                throw new RuntimeException("неверное количество чисел!");
            }

            _consoleHandler.write("Введите числа: ");
            String[] buff = _consoleHandler.read().split(" ");

            //если количество записанных объектов не равно
            // изначально заданному количеству чисел
            if (buff.length != countNumbers) {
                throw new RuntimeException("неверное количество чисел!");
            }

            Number[] happyNumbers = _numbersHandler.handle(buff);

            //вывод на консоль счастливых чисел
            _consoleHandler.write("Счастливые числа: ");
            for (Number happyNumber : happyNumbers) {
                _consoleHandler.write(happyNumber + " ");
            }

        } catch (Exception e) {
            _consoleHandler.write("Некорректные входные данные!" + e.getMessage() + "Повторите попытку!\n");
            run();
        }
    }
}