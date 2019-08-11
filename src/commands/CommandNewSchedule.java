package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;

import static main.Main.*;

public class CommandNewSchedule implements Command{

    public void execute()
    {
        String name;
        Scanner input = new Scanner(System.in);


        main.Main.addQt_agendas();
        System.out.println("Digite o tipo de agenda a ser adicionada");

        name = input.nextLine();

        setAgendas(main.Main.getAgendas(),name,main.Main.getQt_agendas());

        System.out.println("Agenda adicionada como sucesso");


    }
}
