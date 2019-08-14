package main;

import java.util.*;

public class FactoryComissionado extends FactoryFuncionario implements Manager, Cloneable{

    private double percentual;
    private double salary;
    private double[] valor_venda = new double[31];
    private double comissao = 0;

    public void setComissao() {
        this.comissao = 0;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(){

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o salário do funcionário");
        this.salary = main.TryCatch.doubleTry();

        System.out.println("Digite o percentual de venda do funcionário");
        System.out.println("Exemplo : Digite 30, para se referir a 30%");
        this.percentual = main.TryCatch.doubleTry();

    }

    public void setValor_venda(double valor_venda,int dia) {
        this.valor_venda[dia] += valor_venda;
        this.comissao += ((this.percentual)/100)*valor_venda;
    }

    public double getComissao() {
        return comissao;
    }

    public double getSalarybyCopy()
    {
        return salary;
    }
    public void setSalarybyCopy(double salary)
    {
        this.salary = salary;
    }

    public void templateDoCopy(FactoryFuncionario x){

        x.setID(this.getID());
        x.setName(this.getName());
        x.setAdress(this.getAdress());
        x.setExiste(this.isExiste());
        x.setMetodo_de_pagamento(super.getMetodo_de_pagamento());
        x.setTipo_da_agenda(this.getTipo_da_agenda());

        ((FactorySalariado)x).setSalarybyCopy(getSalarybyCopy());
        x.setId_sindicato(super.getId_sindicato());

        ((FactoryComissionado)x).setPercentual(getPercentual());
        for(int i=1;i<31;i++)
        {
            ((FactoryComissionado)x).valor_venda[i]=this.valor_venda[i];
        }

    }


    @Override
    public FactoryComissionado clone() throws CloneNotSupportedException{
        return (FactoryComissionado) super.clone();
    }
}