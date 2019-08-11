package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;
import main.Texts.*;

import static main.Main.*;

public class CommandTime implements Command {

    public void execute()
    {
        int command;
        int horas_passadas;

        Scanner input = new Scanner(System.in);

        main.Texts.getTimeTexts();

        command = input.nextInt();
        input.nextLine();

        if(command==0)
        {
            System.out.println("Digite quantos dias você quer passar:");
            horas_passadas = input.nextInt();
            input.nextLine();

            main.Main.setDia(horas_passadas);
            lastPayment(CommandAdd.getEmployee(),CommandAdd.getQt_funcionario(),horas_passadas);
            main.Main.setDia_da_semana(horas_passadas);

            horas_passadas=0;
        }
        else if (command==1)
        {
            System.out.println("Digite quantas horas você quer passar (Digite 8 para passar um turno de trabalho) : ");
            System.out.println("---> Não passe mais de 24 horas (utilize a opção 'passar dia') ");
            horas_passadas=input.nextInt();
            input.nextLine();

            main.Main.setHora(horas_passadas);

            horas_passadas=0;
        }
        else if (command==2)
        {
            main.Main.setMes(1);

            System.out.println("Um mês foi passado");
        }

    }
}
