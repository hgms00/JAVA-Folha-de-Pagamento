package commands;

import java.util.*;

import main.FactoryHorista;

import static main.Main.buscarFuncionario;

public class CommandTimecard implements Command {

    public void execute()
    {
        int indice;
        int id;

        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do funcionário para bater o ponto");
        id = main.TryCatch.anyIntTry();

        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        if(indice==-1 || CommandAdd.getEmployee()[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
            return ;
        }

        if(CommandAdd.getEmployee()[indice].isIn_work()==false)
        {
            CommandAdd.getEmployee()[indice].setIn_work(true);
            CommandAdd.getEmployee()[indice].setHora_entrada(main.Main.getHora());

            System.out.println("Ponto de entrada computado com sucesso");
        }
        else
        {
            CommandAdd.getEmployee()[indice].setIn_work(false);
            CommandAdd.getEmployee()[indice].setHora_saida(main.Main.getHora());

            if(CommandAdd.getEmployee()[indice] instanceof FactoryHorista)
            {
                ((FactoryHorista) CommandAdd.getEmployee()[indice]).setHoras_diarias(((CommandAdd.getEmployee()[indice].getHora_saida()-(CommandAdd.getEmployee()[indice].getHora_entrada()))));
                CommandAdd.getEmployee()[indice].setHora_entrada(0);
                CommandAdd.getEmployee()[indice].setHora_saida(0);
            }

            System.out.println("Ponto de saída computado com sucesso");
        }
    }
}
