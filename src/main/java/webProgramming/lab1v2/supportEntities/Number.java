package webProgramming.lab1v2.supportEntities;

public class Number {
    private final int _value;
    private static final int HAPPINESS_CONDITION = 4;

    public Number(){
        _value = 0;
    }

    public Number(int number){
        _value = number;
    }

    public Number(String number){
        _value = Integer.parseInt(number);
    }

    public int getValue() {
        return _value;
    }

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

    @Override
    public String toString() {
        return Integer.toString(_value);
    }
}
