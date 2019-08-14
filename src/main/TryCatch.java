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
                if (intTry < 1 || intTry > 3)
                    throw new Exception("Fora do intervalo");

            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor inteiro válido");
                input.nextLine();
                flag = false;
            }
        }

        return intTry;
    }

    public static int intDayTry()
    {
        int intTry = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(!flag) {

            try {
                intTry=0;
                flag = true;
                intTry = input.nextInt();
                if (intTry <= 0 || intTry > 30)
                    throw new Exception("Fora do intervalo");

            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor inteiro válido");
                input.nextLine();
                flag = false;
            }
        }

        return intTry;
    }
    public static int anyIntTry()
    {
        int intTry = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(!flag) {

            try {
                intTry=0;
                flag = true;
                intTry = input.nextInt();

            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor inteiro válido");
                input.nextLine();
                flag = false;
            }
        }
        return intTry;
    }

    public static int booleanintTry()
    {
        int intTry = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(!flag) {

            try {
                intTry=0;
                flag = true;
                intTry = input.nextInt();
                if (intTry != 0 && intTry != 1)
                    throw new Exception("Fora do intervalo");

            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor inteiro válido");
                input.nextLine();
                flag = false;
            }
        }

        return intTry;
    }
    public static int undoredoTry()
    {
        int intTry = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(!flag) {

            try {
                intTry=0;
                flag = true;
                intTry = input.nextInt();
                if (intTry != 1 && intTry != 2)
                    throw new Exception("Fora do intervalo");

            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor inteiro válido");
                input.nextLine();
                flag = false;
            }
        }

        return intTry;
    }

    public static double doubleTry()
    {
        double doubleTry = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(!flag) {

            try {
                doubleTry=0;
                flag = true;
                doubleTry = input.nextDouble();


            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor válido");
                input.nextLine();
                flag = false;
            }
        }
        return doubleTry;
    }
    public static int initialTry()
    {
        int intTry = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(!flag) {

            try {
                intTry=0;
                flag = true;
                intTry = input.nextInt();
                if (intTry < 0 || intTry > 12)
                    throw new Exception("Fora do intervalo");

            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor inteiro válido");
                input.nextLine();
                flag = false;
            }
        }

        return intTry;
    }
    public static int detailsTry()
    {
        int intTry = 0;
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while(!flag) {

            try {
                intTry=0;
                flag = true;
                intTry = input.nextInt();
                if (intTry < 0 || intTry > 7)
                    throw new Exception("Fora do intervalo");

            } catch (Exception e) {
                System.out.println("Por favor, coloque um valor inteiro válido");
                input.nextLine();
                flag = false;
            }
        }

        return intTry;
    }
}
