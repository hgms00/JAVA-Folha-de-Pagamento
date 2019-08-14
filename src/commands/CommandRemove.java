package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;
import static main.Main.buscarFuncionario;


public class CommandRemove implements Command {

    public void execute()
    {
        int indice;
        int id;

        System.out.println("Digite o ID do funcionário que vocẽ quer remover");
        Scanner input = new Scanner(System.in);
        id = main.TryCatch.anyIntTry();

        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());

        if(indice==-1 || CommandAdd.getEmployee()[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
        }
        else if(CommandAdd.getEmployee()[indice].isExiste()==true)
        {
            System.out.println("O funcionário foi removido com sucesso");
            CommandAdd.getEmployee()[indice].setExiste(false);
        }
    }
}
