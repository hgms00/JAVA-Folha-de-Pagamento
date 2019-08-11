package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;
import static main.Main.backup_do;
import static main.Main.buscarFuncionario;

public class CommandSells implements Command {
    public void execute()
    {
        int id;
        int indice;
        int aux;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do funcionário");
        id = input.nextInt();
        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        if(indice==-1 || CommandAdd.getEmployee()[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
            return ;
        }

        System.out.println("Digite o dia da venda");
        aux = input.nextInt();
        System.out.println("Digite o valor da venda");
        ((main.Comissionado) CommandAdd.getEmployee()[indice]).setValor_venda(input.nextDouble(),aux);

        System.out.println("Venda computada com sucesso");
        backup_do(main.Main.getBackup(),CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());

    }
}
