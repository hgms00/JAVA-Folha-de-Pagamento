package main;
import java.util.*;

public class Horista extends FactoryFuncionario implements Manager {

    //semanal
    private static double salary_semanal;
    private static double salario_por_hora;

    private static int horas_diarias;

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
        Horista.horas_diarias =0;
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
        this.salary_semanal = main.TryCatch.doubleTry();
    }

    public void setSalario_por_hora(double salario_por_hora) {
        this.salario_por_hora = salario_por_hora;
    }
}