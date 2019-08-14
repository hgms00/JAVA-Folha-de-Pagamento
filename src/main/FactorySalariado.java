package main;

public class FactorySalariado extends FactoryFuncionario implements Manager,Cloneable{

    private double salary;
    public double getSalary() {
        return salary;
    }

    public void setSalary() {
            System.out.println("Digite o salário do funcionário");
            this.salary = main.TryCatch.doubleTry();

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
    }

    @Override
    public FactorySalariado clone() throws CloneNotSupportedException{
        return (FactorySalariado) super.clone();
    }
}