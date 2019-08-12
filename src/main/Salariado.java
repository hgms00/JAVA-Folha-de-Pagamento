package main;
import commands.CommandAdd;

import java.util.*;
import main.TryCatch.*;

public class Salariado extends FactoryFuncionario implements Manager {

    private static double salary;
    public static double getSalary() {
        return salary;
    }

    public void setSalary() {
            System.out.println("Digite o salário do funcionário");
            this.salary = main.TryCatch.doubleTry();

    }
}