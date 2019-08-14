package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;
import static main.Main.buscarFuncionario;

public class CommandServiceTax implements Command{
    public void execute()
    {
        int id;
        int indice;
        double taxa_servico;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do que será cobrada as taxas de serviços");
        id = main.TryCatch.anyIntTry();
        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        if(indice==-1 || CommandAdd.getEmployee()[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
            return ;
        }

        if(CommandAdd.getEmployee()[indice].isSindicato()==false)
        {
            System.out.println("O funcionário não pertence ao sindicato");
            return ;
        }

        System.out.println("Digite o valor da taxa de serviço a ser descontada");
        taxa_servico = main.TryCatch.doubleTry();

        CommandAdd.getEmployee()[indice].setTaxa_servico(taxa_servico);

    }
}
