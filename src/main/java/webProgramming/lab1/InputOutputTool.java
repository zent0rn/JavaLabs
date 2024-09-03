package webProgramming.lab1;

import java.util.Scanner;

public class InputOutputTool {
   private Scanner reader;

   public InputOutputTool(){
       reader = new Scanner(System.in);
   }
   
    public int[] readNumbers(){
        int n = reader.nextInt();
        int[] buff = new int[n];
        for(int i = 0; i < n; i++){
            buff[i] = reader.nextInt();
        }
        return buff;
    }
}
