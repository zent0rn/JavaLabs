package webProgramming.lab1;

import java.util.Arrays;

public class Solve {
    private int[] data;
    private final InputOutputTool iot;

    public Solve() {
        iot = new InputOutputTool();
    }

    public void readNumbers() {
        data = iot.readNumbers();
    }

    public void displayHappyNumbers() {
        int[] temp = new int[data.length];
        int tempInd = 0;
        for (int i : data) {
            if (checkNumber(i)) {
                temp[tempInd++] = i;
            }
        }
        iot.showNumbers(Arrays.copyOf(temp, tempInd));
    }

    private boolean checkNumber(int number) {
        /*
        Число называется счастливым, если сумма квадратов его цифр кратна 4
         */
        int copyOfNumber = number;
        int sum = 0;
        while (copyOfNumber > 0) {
            int currFigure = copyOfNumber % 10;
            sum += currFigure * currFigure;
            copyOfNumber /= 10;
        }
        return (sum % 4 == 0);
    }

}
