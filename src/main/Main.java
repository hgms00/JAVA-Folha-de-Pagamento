package main;
import commands.*;
import java.util.Scanner;
import java.lang.*;

public class Main {
    private static Agendas_de_Pagamento agendas[] = new Agendas_de_Pagamento[1000];
    private static FactoryFuncionario backup[][] = new FactoryFuncionario[100][1000];

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
            if(employee[i] !=null) {
                if (employee[i].getID() == id) {

                    return i;
                }
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

    public static void main(String[] args)
    {
        int j;
        int command = 1;

        MementoCaretaker caretaker = Singleton.getInstance();
        MementoOriginator originator = Singleton.getInstanceO();
        setAgendasDefault(agendas);

        while(command!=0)
        {
            TextsandAuxs.getInitialText();
            Scanner input = new Scanner(System.in);
            command = TryCatch.initialTry();

            if(command!=0)
                CommandSet.setCommand(command);

            if(command>=1 && command <=7) {
                Memento memento = Singleton.getInstanceM();
                originator.setState(memento);
                caretaker.addMemento(originator.save(   ));
                CommandUndoRedo.addUndoredoPointer(1);
            }
        }
    }
}