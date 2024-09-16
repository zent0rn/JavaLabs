package webProgramming.lab1v2.supportEntities;

public class Number {
    private int _value;
    private static final int HAPPINESS_CONDITION = 4;

    /**
     * конструктор по умолчанию
     */
    public Number() {
        _value = 0;
    }

    /**
     * конструктор с аргументом типа Number
     *
     * @param number некоторое число типа int, которое определяет
     * значение переменной _value
     */
    public Number(int number) {
        _value = number;
    }

    /**
     * конструктор с аргументом типа Number
     *
     * @param number - некоторое число в виде типа String, которое определяет
     * значение переменной _value
     */
    public Number(String number) {
        _value = Integer.parseInt(number);
    }


    /**
     * метод-"геттер" класса Number
     *
     * @return _value - поле типа Number, некоторое число
     */
    public int getValue() {
        return _value;
    }

    /**
     * метод-"сеттер" класса Number
     *
     * @param value - некоторое число типа int
     */
    public void setValue(int value) {
        _value = value;
    }

    /**
     * метод для проверки числа на "счастливость"
     *
     * @return значение типа boolean - результат проверки числа
     */
    public boolean checkHappiness() {
        /*
        Число называется счастливым, если сумма квадратов его цифр кратна HAPPINESS_CONDITION
         */
        int copyOfNumber = _value;
        int sum = 0;
        while (copyOfNumber > 0) {
            int currFigure = copyOfNumber % 10;
            sum += currFigure * currFigure;
            copyOfNumber /= 10;
        }
        return (sum % HAPPINESS_CONDITION == 0 && _value != 0);
    }

    /**
     * представление объекта типа Number в виде объекта типа String для
     * корректного вывода в консоли
     *
     * @return строковое представление объекта класса Number
     */
    @Override
    public String toString() {
        return Integer.toString(_value);
    }
}
