package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;
import static main.Main.backup_do;
import static main.Main.buscarFuncionario;

public class CommandDetailsView implements Command{

    public void execute()
    {
        int id;
        int indice;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o ID do funcionário para visualizar seus dados");
        id = main.TryCatch.anyIntTry();
        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        if(indice==-1 || CommandAdd.getEmployee()[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
            return ;
        }

        System.out.printf("NOME : %s\n",CommandAdd.getEmployee()[indice].getName());
        System.out.printf("ENDEREÇO: %s\n",CommandAdd.getEmployee()[indice].getAdress());
        if(CommandAdd.getEmployee()[indice].getType()==1) {
            System.out.printf("TIPO : HORISTA\n");
            if(CommandAdd.getEmployee()[indice] instanceof main.Horista)
            {
                System.out.printf("SALARIO : %.2f\n",((main.Horista)CommandAdd.getEmployee()[indice]).getSalario_por_hora());
            }
        }
        if(CommandAdd.getEmployee()[indice].getType()==2) {
            System.out.printf("TIPO : SALARIADO\n");
            if(CommandAdd.getEmployee()[indice] instanceof main.Salariado)
            {
                System.out.printf("SALARIO : %.2f\n",((main.Salariado)CommandAdd.getEmployee()[indice]).getSalary());
            }
        }
        if(CommandAdd.getEmployee()[indice].getType()==3 ) {
            System.out.printf("TIPO : COMISSIONADO\n");
            if(CommandAdd.getEmployee()[indice] instanceof main.Comissionado)
            {
                System.out.printf("SALARIO : %.2f\n",((main.Comissionado)CommandAdd.getEmployee()[indice]).getSalary());
            }
        }

        if(CommandAdd.getEmployee()[indice].isSindicato()==true)
            System.out.printf("PERTENCE AO SINDICATO\n");
        else
            System.out.printf("NÃO PERTENCE AO SINDICATO\n");

    }
}
