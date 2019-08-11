package main;
import commands.CommandAdd;

import java.util.*;

public class Salariado extends FactoryFuncionario implements Manager {

    private static double salary;
    public static double getSalary() {
        return salary;
    }

    public void setSalary() {
        Scanner input = new Scanner(System.in);

            System.out.println("Digite o salário do funcionário");
            try{
                this.salary = input.nextDouble();
            }catch (Exception e){
                System.err.println(e);
            }

    }
}