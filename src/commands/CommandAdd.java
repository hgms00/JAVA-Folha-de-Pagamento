package commands;


import java.util.Scanner;
import main.*;


public class CommandAdd implements Command{
    public static FactoryFuncionario[] employee = new FactoryFuncionario[1000];
    private static int qt_funcionario = 0;

    public static int getQt_funcionario() {
        return qt_funcionario;
    }

    public static FactoryFuncionario[] getEmployee() {
        return employee;
    }

    public static void setEmployee(FactoryFuncionario[] employee) {
        //CommandAdd.employee = employee;
    }

    public static FactoryFuncionario addFuncionario(int type)
    {
        if(type==1) {
            return new FactoryHorista();
        }
        else if (type==2) {

            return new FactorySalariado();
        }
        else {
            return new FactoryComissionado();
        }
    }
    public void execute()
    {
        Manager slot;
        int type;
        String name;
        String adress;
        int payment_type;
        double salary;
        int ID;
        int sindicato;
        int id_sindicato;
        float percentual;
        double taxa_sindicato;
        int id;

        Scanner input = new Scanner(System.in);

        qt_funcionario++;

        //-----------------TYPE-----------------------------
        System.out.println("Selecione o tipo do funcionário");
        System.out.println("1 --> FactoryHorista");
        System.out.println("2 --> FactorySalariado");
        System.out.println("3 --> FactoryComissionado");

        type = main.TryCatch.intTry();


        employee[qt_funcionario] = CommandAdd.addFuncionario(type);
        employee[qt_funcionario].setTipo_da_agenda(type);
        employee[qt_funcionario].setType(type);
        //--------------------------------------------

        //----------------NOME-----------------------
        System.out.println("Digite o nome do funcionário");
        name = input.nextLine();
        employee[qt_funcionario].setName(name);
        //--------------------------------------------

        //----------------ADRESS-------------------
        System.out.println("Digite o endereço do funcionário");
        adress = input.nextLine();
        employee[qt_funcionario].setAdress(adress);
        //--------------------------------------------


        //Setando a existência
        employee[qt_funcionario].setExiste(true);



        //----------------SALARY-------------------------
        slot = (Manager) employee[qt_funcionario];
        slot.setSalary();

        //--------------------------------------------

        //---------Payment_Type-----------------------
        System.out.println("Selecione o seu método de pagamento");
        System.out.println("1 -> Cheque pelos correios");
        System.out.println("2 -> Em mãos");
        System.out.println("3 -> Depósito em conta bancária");

        payment_type = main.TryCatch.intTry();
        employee[qt_funcionario].setMetodo_de_pagamento(payment_type);

        //-------------SINDICATO---------------------------
        System.out.println("O funcionário pertence ao sindicato?");
        System.out.println("0 --> NÃO");
        System.out.println("1 --> SIM");

        sindicato = main.TryCatch.booleanintTry();
        if(sindicato==1)
            employee[qt_funcionario].setSindicato(true);
        else
            employee[qt_funcionario].setSindicato(false);

        if(sindicato == 1)
        {
            System.out.println("Digite a taxa mensal do sindicato");
            taxa_sindicato = main.TryCatch.doubleTry();
            employee[qt_funcionario].setTaxa_sindical(taxa_sindicato);


            id_sindicato = (1000) + qt_funcionario;
            employee[qt_funcionario].setId_sindicato(id_sindicato);
            System.out.printf("--> O ID do sindicato do funcionário é : %d\n",id_sindicato);
        }
        //--------------------------------------------


        //----------Setando o ID---------------------
        id = (2019*1000) + qt_funcionario;
        employee[qt_funcionario].setID(id);

        System.out.printf("--> O ID de funcionário é : %d\n",id);
    }


}
