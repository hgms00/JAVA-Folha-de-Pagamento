package main;

import commands.CommandAdd;

import java.util.*;

public class Comissionado extends FactoryFuncionario implements Manager {

    private static float percentual;
    private static double salary;
    private static double[] valor_venda = new double[31];
    private static double comissao = 0;

    public static void setComissao() {
        Comissionado.comissao = 0;
    }

    public static float getPercentual() {
        return percentual;
    }

    public static void setPercentual(float percentual) {
        Comissionado.percentual = percentual;
    }

    public static double getSalary() {
        return salary;
    }

    public void setSalary(){

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o salário do funcionário");
        this.salary = input.nextDouble();

        System.out.println("Digite o percentual de venda do funcionário");
        System.out.println("Exemplo : Digite 30, para se referir a 30%");
        this.percentual = input.nextFloat();

    }

    public static void setValor_venda(double valor_venda,int dia) {
        Comissionado.valor_venda[dia] += valor_venda;
        Comissionado.comissao += (percentual/100)*valor_venda;
    }

    public static double getComissao() {
        return comissao;
    }
}