package main;
import java.util.*;

public class FactoryHorista extends FactoryFuncionario implements Manager, Cloneable{

    //semanal
    private double salary_semanal;
    private double salario_por_hora;

    private int horas_diarias;

    public void setHoras_diarias(int horas_diarias) {
        this.horas_diarias = horas_diarias;
        if(horas_diarias>8)
        {
            salary_semanal += (horas_diarias-8)*(salario_por_hora)*1.5;
            horas_diarias = (horas_diarias-8);
            salary_semanal += (horas_diarias)*salario_por_hora;
        }
        else
        {
            salary_semanal += horas_diarias * salario_por_hora;
        }
        this.horas_diarias =0;
    }

    public int getHoras_diarias() {
        return this.horas_diarias;
    }

    public double getSalario_por_hora() {
        return this.salario_por_hora;
    }

    public double getSalary_semanal() {
        return this.salary_semanal;
    }

    public void setSalary_semanal() {
        this.salary_semanal = 0;
    }
    public void setSalary()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o salário por hora do funcionário");
        this.salario_por_hora = main.TryCatch.doubleTry();
    }

    public void setSalario_por_hora(double salario_por_hora) {
        this.salario_por_hora = salario_por_hora;
    }

    public void templateDoCopy(FactoryFuncionario x) {



        x.setID(this.getID());
        x.setName(this.getName());
        x.setAdress(this.getAdress());
        x.setExiste(this.isExiste());
        x.setMetodo_de_pagamento(super.getMetodo_de_pagamento());
        x.setTipo_da_agenda(this.getTipo_da_agenda());

        ((FactoryHorista)x).setSalario_por_hora(getSalario_por_hora());
        x.setId_sindicato(super.getId_sindicato());
        ((FactoryHorista)x).setHoras_diarias(getHoras_diarias());
    }

    @Override
    public FactoryHorista clone() throws CloneNotSupportedException{
        return (FactoryHorista) super.clone();
    }
}