package Commands;


import java.util.Scanner;
import Funcionario.*;

public class CommandAdd implements Command{
    Funcionario employee[] = new Funcionario[1000];

    public void execute()
    {
        int type;
        String name;
        String adress;
        int payment_type;
        double salary;
        int ID;
        Scanner input = new Scanner();

        qt_funcionario++;

        //-----------------TYPE-----------------------------
        System.out.println("Selecione o tipo do funcionário");
        System.out.println("1 --> Horista");
        System.out.println("2 --> Assalariado");
        System.out.println("3 --> Comissionado");

        type = input.nextInt();
        input.nextLine();

        employee[qt_funcionario] = employee[qt_funcionario].addFuncionario(type);
        employee[qt_funcionario].setType(type);
        //--------------------------------------------

        //----------------NOME-----------------------
        System.out.println("Digite o nome do funcionário");
        name = input.nextLine();
        employee[qt_funcionario].setName(name);
        //--------------------------------------------

        //----------------ADRESS-------------------
        System.out.println("Digite o endereço do funcionário");
        String adress = input.nextLine();
        employee[qt_funcionario].setAdress(adress);
        //--------------------------------------------


        //Setando a existência
        employee[qt_funcionario].setExiste(true);



        //----------------SALARY-------------------------

        if(employee[qt_funcionario] instanceof Salariado)
        {
            System.out.println("Digite o salário do funcionário");
            try{
                salary = input.nextDouble();
                ((Salariado) employee[qt_funcionario]).setSalary(salary);

            }catch (Exception e){
                System.err.println(e);
            }

        }
        else if(employee[qt_funcionario] instanceof Comissionado)
        {
            System.out.println("Digite o salário do funcionário");
            salary = input.nextDouble();
            ((Comissionado) employee[qt_funcionario]).setSalary(salary);
            System.out.println("Digite o percentual de venda do funcionário");
            System.out.println("Exemplo : Digite 30, para se referir a 30%");
            percentual = input.nextFloat();
            ((Comissionado)employee[qt_funcionario]).setPercentual(percentual);
        }
        else if(employee[qt_funcionario] instanceof Horista)
        {
            System.out.println("Digite o salário por hora do funcionário");
            salary = input.nextDouble();
            ((Horista)employee[qt_funcionario]).setSalary(salary);
        }
        //--------------------------------------------

        //---------Payment_Type-----------------------
        System.out.println("Selecione o seu método de pagamento");
        System.out.println("1 -> Cheque pelos correios");
        System.out.println("2 -> Em mãos");
        System.out.println("3 -> Depósito em conta bancária");

        payment_type = input.nextInt();
        employee[qt_funcionario].setMetodo_de_pagamento(payment_type);

        //-------------SINDICATO---------------------------
        System.out.println("O funcionário pertence ao sindicato?");
        System.out.println("0 --> NÃO");
        System.out.println("1 --> SIM");

        sindicato = input.nextInt();
        if(sindicato==1)
            employee[qt_funcionario].setSindicato(true);
        else
            employee[qt_funcionario].setSindicato(false);

        if(sindicato == 1)
        {
            System.out.println("Digite a taxa mensal do sindicato");
            taxa_sindicato = input.nextDouble();
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
        backup_do(backup,qt_funcionario,employee);

        break;
    }


}
