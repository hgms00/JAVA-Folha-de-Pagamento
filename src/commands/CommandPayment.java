package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;

import static main.Main.*;



public class CommandPayment implements Command{
    public void execute()
    {
        int aux;
        // folha de pagamento
        //System.out.printf("--> DIA DA SEMANA : %d",agendas[1].getDia_da_semana());
        for(aux=1;aux<=CommandAdd.getQt_funcionario();aux++)
        {
            if(CommandAdd.getEmployee()[aux].isExiste()==true)
                rodarFolhadePagamento(aux,main.Main.getAgendas(),CommandAdd.getEmployee(),main.Main.getDia(),main.Main.getMes(),main.Main.getDia_da_semana());
        }
        backup_do(main.Main.getBackup(),CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());

    }
}
