package webProgramming.lab1v2.supportEntities;

public class Number {
    private int _value;
    private static final int HAPPINESS_CONDITION = 4;


    /**
     * конструктор по умолчанию класса Number
     */
    public Number(){
        _value = 0;
    }

    /**
     * конструктор с параметром класса Number
     * @param number некоторое число типа int
     */
    public Number(int number){
        _value = number;
    }

    /**
     *  конструктор с параметром класса Number
     * @param number - некоторое число типа String
     */
    public Number(String number){
        _value = Integer.parseInt(number);
    }


    /**
     * геттер класса Number
     * @return _value - поле класса Number, некоторое число
     */
    public int getValue() {
        return _value;
    }

    /**
     * сеттер класса Number
     * @param value - некоторое число типа int
     */
    public void setValue(int value) {
        _value = value;
    }

    /**
     *  метод проверяет, является ли число счастливым, а именно,
     *  кратна ли сумма его цифр значению HAPPINESS_CONDITION
     * @return (sum % HAPPINESS_CONDITION == 0 && _value != 0) - проверка, кратна ли
     *  сумма цифр числа значению HAPPINESS_CONDITION
     *  и не равно ли значение поля _value 0
     */
    public boolean checkHappiness(){
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
     * метод является перегрузкой стандаратного метода, так как со стандартным методом
     * не работает вывод, возвращает строковое представление объекта класса
     * @return Integer.toString(_value) - строковое представление объекта класса
     */
    @Override
    public String toString() {
        return Integer.toString(_value);
    }
}
