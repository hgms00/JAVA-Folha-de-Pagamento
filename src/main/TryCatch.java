package main;

import java.util.*;

public class TryCatch {
    
    public static int intTry()
    {
        int intTry = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(!flag) {

            try {
                intTry=0;
                flag = true;
                intTry = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor inteiro válido");
                input.nextLine();
                flag = false;
            }
        }

        return intTry;
    }
}
