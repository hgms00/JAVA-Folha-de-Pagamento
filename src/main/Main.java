package main;


import commands.*;
import java.util.Scanner;
import java.lang.*;

public class Main {
    private static Agendas_de_Pagamento agendas[] = new Agendas_de_Pagamento[1000];
    private static FactoryFuncionario backup[][] = new FactoryFuncionario[100][1000];
    private static FactoryFuncionario employee[] = new FactoryFuncionario[1000];
    private static int qt_agendas = 3;


    private static int dia=14;
    private static int mes=06;
    private static int hora=7;
    private static int ano=2019;
    private static int dia_da_semana = 5;
    private static int undo = 0;
    private static int redo = 0;
    private static int i = 0;

    public static int getHora() {
        return hora;
    }

    public static Agendas_de_Pagamento[] getAgendas() {
        return agendas;
    }

    public static int getDia() {
        return dia;
    }

    public static void setDia(int dia) {
        Main.dia += dia;
        if(Main.dia > 30)
        {
            Main.dia = Main.dia % 30;
            Main.mes++;
            if(Main.mes > 12)
            {
                Main.mes = Main.mes % 12;
                Main.ano++;
            }
        }

    }

    public static void setMes(int mes) {
        Main.mes += mes;
        if(Main.mes > 12)
        {
            Main.mes = Main.mes % 12;
            Main.ano++;
        }
    }

    public static void setHora(int hora) {
        Main.hora += hora;
        Main.hora = Main.hora % 24;
    }

    public static void setAno(int ano) {
        Main.ano += ano;
    }

    public static int getMes() {
        return mes;
    }

    public static int getAno() {
        return ano;
    }

    public static int getDia_da_semana() {
        return dia_da_semana;
    }

    public static void setDia_da_semana(int dia_da_semana) {
        Main.dia_da_semana += dia_da_semana;
        Main.dia_da_semana = Main.dia_da_semana % 7;
    }

    public static int getQt_agendas() {
        return qt_agendas;
    }

    public static void addQt_agendas() {
        Main.qt_agendas++;
    }

    public static int buscarFuncionario(int id, int qt_funcionario, FactoryFuncionario[] employee)
    {
        int i;


        for(i=1;i<=qt_funcionario;i++)
        {
            if(employee[i].getID()==id)
            {
                return i;
            }
        }
        return -1;
    }

    public static void lastPayment(FactoryFuncionario[] employee, int qt_funcionario, int dias_passados)
    {
        int i;
        for(i=1;i<=qt_funcionario;i++)
        {
            employee[i].setDias_sem_receber(dias_passados);
        }
    }

    public static int buscarFuncionarioSindicato(int id, int qt_funcionario, FactoryFuncionario[] employee)
    {
        int i;
        for(i=1;i<=qt_funcionario;i++)
        {
            if(employee[i].getId_sindicato()==id)
            {
                return i;
            }
        }
        return -1;

    }

    public static void rodarFolhadePagamento(int i, Agendas_de_Pagamento[] agendas, FactoryFuncionario[] employee, int dia_atual, int mes, int dia_semana_atual)
    {
        int type_agenda = employee[i].getTipo_da_agenda();
        System.out.printf("TIPO DA AGENDA DO FUNCIONARIO %d",type_agenda);

        if(agendas[type_agenda].getType()==1)
        {
            if(agendas[type_agenda].getDia_de_pagamento()==dia_atual || (dia_atual==28 && dia_semana_atual==5) || (dia_atual==29 && dia_semana_atual==5) )
            {
                employee[i].zerarDias_sem_receber();
                System.out.println("================CONTRA-CHEQUE======================");
                System.out.printf("Referente ao funcionário %s\n",employee[i].getName());

                System.out.printf(" ---> Valor descontado pelo sindicato %.2f\n",employee[i].getTaxa_sindical());
                System.out.printf(" ---> Valor descontado por taxa de serviços %.2f\n",employee[i].getTaxa_servico());

                if(employee[i] instanceof Comissionado)
                {
                    System.out.printf("---> Valor obtido a partir de comissão em vendas %.2f\n",((Comissionado)employee[i]).getComissao());
                    double salary = ((Comissionado) employee[i]).getSalary() + ((Comissionado)employee[i]).getComissao() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                    System.out.printf("Salário total recebido : %.2f\n",salary);
                    ((Comissionado)employee[i]).setComissao();
                }
                else if (employee[i] instanceof Horista)
                {
                    double salary =((Horista)employee[i]).getSalary_semanal() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                    System.out.printf("Salário total recebido : %.2f\n",salary);
                    ((Horista)employee[i]).setSalary_semanal();
                }
                else if (employee[i] instanceof Salariado)
                {
                    double salary = ((Salariado)employee[i]).getSalary() - - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                    System.out.printf("Salário total recebido : %.2f\n",salary);
                }
                if(employee[i].getMetodo_de_pagamento()==1)
                    System.out.println("Pagamento realizado pelo método : Cheque pelos Correios");
                else if(employee[i].getMetodo_de_pagamento()==2)
                    System.out.println("Pagamento realizado pelo método : Em mãos");
                else if (employee[i].getMetodo_de_pagamento()==3)
                    System.out.println("Pagamento realizado pelo método : Depósito bancário");

                System.out.println("===================================================");
            }
            else
                return;
        }
        else if(agendas[type_agenda].getType()==2)
        {
            if(agendas[type_agenda].getDia_da_semana()==dia_semana_atual)
            {
                System.out.printf("DIAS SEM RECEBER ---> %d\n",employee[i].getDias_sem_receber());
                System.out.printf("a cada semana --> %d\n",agendas[0].getA_cada_semana());
                System.out.printf("TIPO DA AGENDA --> %d\n",type_agenda);
                if((agendas[type_agenda].getA_cada_semana()*7)<=employee[i].getDias_sem_receber())
                {
                    employee[i].zerarDias_sem_receber();
                    System.out.println("================CONTRA-CHEQUE======================");
                    System.out.printf("Referente ao funcionário %s\n",employee[i].getName());

                    System.out.printf(" ---> Valor descontado pelo sindicato %.2f\n",employee[i].getTaxa_sindical());
                    System.out.printf(" ---> Valor descontado por taxa de serviços %.2f\n",employee[i].getTaxa_servico());

                    if(employee[i] instanceof Comissionado)
                    {
                        System.out.printf("---> Valor obtido a partir de comissão em vendas %.2f\n",((Comissionado)employee[i]).getComissao());
                        double salary = ((Comissionado) employee[i]).getSalary() + ((Comissionado)employee[i]).getComissao() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                        System.out.printf("Salário total recebido : %.2f\n",salary);
                        ((Comissionado)employee[i]).setComissao();
                    }
                    else if (employee[i] instanceof Horista)
                    {
                        double salary =((Horista)employee[i]).getSalary_semanal() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                        System.out.printf("Salário total recebido : %.2f\n",salary);
                        ((Horista)employee[i]).setSalary_semanal();
                    }
                    else if (employee[i] instanceof Salariado)
                    {
                        double salary = ((Salariado)employee[i]).getSalary() - - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                        System.out.printf("Salário total recebido : %.2f\n",salary);
                    }
                    if(employee[i].getMetodo_de_pagamento()==1)
                        System.out.println("Pagamento realizado pelo método : Cheque pelos Correios");
                    else if(employee[i].getMetodo_de_pagamento()==2)
                        System.out.println("Pagamento realizado pelo método : Em mãos");
                    else if (employee[i].getMetodo_de_pagamento()==3)
                        System.out.println("Pagamento realizado pelo método : Depósito bancário");

                    System.out.println("===================================================");
                }
                else
                    return;
            }
        }
    }

    private static void setAgendasDefault(Agendas_de_Pagamento[] agendas)
    {
        String aux;
        //-----NULL
        agendas[0]= new Agendas_de_Pagamento();
        agendas[0].setType(-1);
        agendas[0].setA_cada_semana(-1);
        agendas[0].setDia_da_semana(-1);
        agendas[0].setDia_de_pagamento(-1);
        //---------1
        agendas[1] = new Agendas_de_Pagamento();
        agendas[1].setName("semanalmente");
        agendas[1].setType(2);
        agendas[1].setA_cada_semana(1);
        agendas[1].setDia_da_semana(5);
        agendas[1].setDia_de_pagamento(-1);
        //---------2
        agendas[2] = new Agendas_de_Pagamento();
        agendas[2].setName("mensalmente");
        agendas[2].setType(1);
        agendas[2].setA_cada_semana(-1);
        agendas[2].setDia_da_semana(-1);
        agendas[2].setDia_de_pagamento(30);
        //---------3
        agendas[3] = new Agendas_de_Pagamento();
        agendas[3].setName("bi-semanalmente");
        agendas[3].setType(2);
        agendas[3].setA_cada_semana(2);
        agendas[3].setDia_da_semana(5);
        agendas[3].setDia_de_pagamento(-1);
        //----------------
    }

    private static int charToInt(char c) {

        if (c == '0')
            return 0;
        if (c == '1')
            return 1;
        if (c == '2')
            return 2;
        if (c == '3')
            return 3;
        if (c == '4')
            return 4;
        if (c == '5')
            return 5;
        if (c == '6')
            return 6;
        if (c == '7')
            return 7;
        if (c == '8')
            return 8;
        if (c == '9')
            return 9;

        return 0;
    }

    private static int stringToInt(String numero)
    {
        int i;
        int numero_int = 0;
        char aux_c;
        for(i=0;i<numero.length();i++)
        {

            numero_int += (charToInt(numero.charAt(i))*Math.pow(10,numero.length()-1-i));
        }
        return numero_int;
    }


    public static void setAgendas(Agendas_de_Pagamento[] agendas, String name, int qt_agendas)
    {
        int i;
        String numero ;
        agendas[qt_agendas]=new Agendas_de_Pagamento();
        agendas[qt_agendas].setName(name);

        if (name.equals("semanal"))
        {
            agendas[qt_agendas].setType(2);
            agendas[qt_agendas].setA_cada_semana(charToInt(name.charAt(8)));

            if(name.substring(10).equals("domingo"))
            {
                agendas[qt_agendas].setDia_da_semana(0);
            }
            else if(name.substring(10).equals("segunda"))
            {
                agendas[qt_agendas].setDia_da_semana(1);
            }
            else if(name.substring(10).equals("terça"))
            {
                agendas[qt_agendas].setDia_da_semana(2);
            }
            else if(name.substring(10).equals("quarta"))
            {
                agendas[qt_agendas].setDia_da_semana(3);
            }
            else if(name.substring(10).equals("quinta"))
            {
                agendas[qt_agendas].setDia_da_semana(4);
            }
            else if(name.substring(10).equals("sexta"))
            {
                agendas[qt_agendas].setDia_da_semana(5);
            }
            else if(name.substring(10).equals("sabado"))
            {
                agendas[qt_agendas].setDia_da_semana(6);
            }
        }
        else
        {
            agendas[qt_agendas].setType(1);
            numero = name.substring(6);
            agendas[qt_agendas].setDia_de_pagamento(stringToInt(numero));
        }
    }



    public static void backup_do(FactoryFuncionario[][] backup, int qt_funcionario, FactoryFuncionario[] employee)
    {
        undo++;
        for(int i=1;i<=qt_funcionario;i++)
        {
            backup[undo][i].setName(employee[i].getName());
            backup[undo][i].setAdress(employee[i].getAdress());
            backup[undo][i].setType(employee[i].getType());
            backup[undo][i].setID(employee[i].getID());
            backup[undo][i].setId_sindicato(employee[i].getId_sindicato());
            backup[undo][i].setTaxa_sindical(employee[i].getTaxa_sindical());
            backup[undo][i].setTaxa_servico(employee[i].getTaxa_servico());
            backup[undo][i].setExiste(employee[i].isExiste());
            backup[undo][i].setMetodo_de_pagamento(employee[i].getMetodo_de_pagamento());
            backup[undo][i].setDias_sem_receber(employee[i].getDias_sem_receber()) ;
            backup[undo][i].setTipo_da_agenda(employee[i].getTipo_da_agenda());
        }

    }

    public static void undo(FactoryFuncionario[][] backup, int qt_funcionario, FactoryFuncionario[] employee)
    {
        if(undo == 1)
        {
            System.out.println("Não há mais undos disponíveis");
            return ;
        }
        System.out.println("Undo realizado com sucesso!");

        undo--;
        redo++;
        for(i=1;i<=qt_funcionario;i++)
        {
            employee[i].setName(backup[undo][i].getName());
            employee[i].setAdress(backup[undo][i].getAdress());
            employee[i].setType(backup[undo][i].getType());
            employee[i].setID(backup[undo][i].getID());
            employee[i].setId_sindicato(backup[undo][i].getId_sindicato());
            employee[i].setTaxa_sindical(backup[undo][i].getTaxa_sindical());
            employee[i].setTaxa_servico(backup[undo][i].getTaxa_servico());
            employee[i].setExiste(backup[undo][i].isExiste());
            employee[i].setMetodo_de_pagamento(backup[undo][i].getMetodo_de_pagamento());
            employee[i].setDias_sem_receber(backup[undo][i].getDias_sem_receber());
            employee[i].setTipo_da_agenda(backup[undo][i].getTipo_da_agenda());
        }
    }

    public static void redo(FactoryFuncionario[][] backup, int qt_funcionario, FactoryFuncionario[] employee)
    {
        if(redo==0)
        {
            System.out.println("Não há mais redos disponíveis");
            return ;
        }
        System.out.println("Redo realizado com sucesso!");
        undo++;
        redo--;
        for(i=1;i<=qt_funcionario;i++)
        {
            employee[i].setName(backup[undo][i].getName());
            employee[i].setAdress(backup[undo][i].getAdress());
            employee[i].setType(backup[undo][i].getType());
            employee[i].setID(backup[undo][i].getID());
            employee[i].setId_sindicato(backup[undo][i].getId_sindicato());
            employee[i].setTaxa_sindical(backup[undo][i].getTaxa_sindical());
            employee[i].setTaxa_servico(backup[undo][i].getTaxa_servico());
            employee[i].setExiste(backup[undo][i].isExiste());
            employee[i].setMetodo_de_pagamento(backup[undo][i].getMetodo_de_pagamento());
            employee[i].setDias_sem_receber(backup[undo][i].getDias_sem_receber());
            employee[i].setTipo_da_agenda(backup[undo][i].getTipo_da_agenda());
        }
    }

    public static int getUndo() {
        return undo;
    }

    public static FactoryFuncionario[][] getBackup()
    {
        return backup;
    }

    public static void main(String[] args)
    {
        int j;
        for(i=0;i<100;i++)
        {
            for(j=0;j<100;j++)
            {
                backup[i][j] = new FactoryFuncionario();
                backup[i][j].setExiste(false);
                backup[i][j].setName(null);
                backup[i][j].setAdress(null);
            }

        }
        int command = 1;
        int qt_funcionario = 0;

        backup_do(backup,qt_funcionario, CommandAdd.getEmployee());
        setAgendasDefault(agendas);

        while(command!=0)
        {
            main.Texts.getInitialText();
            Scanner input = new Scanner(System.in);
            command = input.nextInt();
            input.nextLine();

            if(command!=0)
                commands.Set.setCommand(command);

        }
    }

}