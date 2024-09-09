package webProgramming.lab1;

import java.util.Scanner;

public class InputOutputTool {
    private final Scanner reader;

    public InputOutputTool() {
        reader = new Scanner(System.in);
    }

    public int[] readNumbers(){
        try {
            showMessage("Введите количество чисел: ");
            int n = Integer.parseInt(reader.nextLine());
            if(n <= 0){
                throw new NumberFormatException();
            }
            int[] buff = new int[n];
            showMessage("Введите числа: ");
            int indexCounter = 0;
            for(String i: reader.nextLine().split(" ")){
                buff[indexCounter++] = Integer.parseInt(i);
            }
            if(indexCounter != n){
                throw new IndexOutOfBoundsException();
            }
            return buff;
        }catch(NumberFormatException e){
            throw new NumberFormatException("Ожидаются только целые положительные числа!");

        }catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Неверное количество чисел! Введите n чисел в строку!");
        }catch (Exception e){
            throw new RuntimeException("Неизвестная ошибка!");
        }
    }

    public void showNumbers(int[] buff) {
        showMessage("Результат: ");
        if(buff.length == 0){
            showMessage("счастливых чисел нет");
        }
        for (int i : buff) {
            showMessage(i + " ");
        }
    }

    public void showMessage(String message){
        System.out.print(message);
    }
}
