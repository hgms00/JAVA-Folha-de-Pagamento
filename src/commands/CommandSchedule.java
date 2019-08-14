package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;
import static main.Main.buscarFuncionario;

public class CommandSchedule implements Command {
    public void execute()
    {
        int id;
        int indice;
        int aux;

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o ID do funcionário que terá a agenda de pagamento modificada");
        id = main.TryCatch.anyIntTry();
        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        if(indice==-1 || CommandAdd.getEmployee()[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
            return ;
        }


        System.out.println("SELECIONE UMA DAS AGENDAS DE PAGAMENTOS DISPONÍVEIS\n");

        for(aux=1;aux<=main.Main.getQt_agendas();aux++)
        {
            System.out.printf("%d --> %s\n",aux,main.Main.getAgendas()[aux].getName());
        }
        aux = main.TryCatch.anyIntTry();
        CommandAdd.getEmployee()[indice].setTipo_da_agenda(aux);

        System.out.println("Agenda de pagamento alterada com sucesso");
    }
}
