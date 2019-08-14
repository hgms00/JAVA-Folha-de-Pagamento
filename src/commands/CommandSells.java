package commands;

import java.util.*;

import main.FactoryComissionado;
import static main.Main.buscarFuncionario;

public class CommandSells implements Command {
    public void execute()
    {
        int id;
        int indice;
        int aux;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do funcionário");
        id = main.TryCatch.anyIntTry();
        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        if(indice==-1 || CommandAdd.getEmployee()[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
            return ;
        }

        System.out.println("Digite o dia da venda");
        aux = main.TryCatch.intDayTry();
        System.out.println("Digite o valor da venda");
        if( CommandAdd.getEmployee()[indice] instanceof FactoryComissionado)
            ((FactoryComissionado) CommandAdd.getEmployee()[indice]).setValor_venda(input.nextDouble(),aux);

        System.out.println("Venda computada com sucesso");
    }
}
