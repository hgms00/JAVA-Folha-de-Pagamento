package commands;

import java.util.*;

import main.FactoryComissionado;
import main.FactoryHorista;
import main.FactorySalariado;

import static main.Main.buscarFuncionario;

public class CommandDetailsView implements Command{

    public void execute()
    {
        int id;
        int indice;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o ID do funcionário para visualizar seus dados");
        id = main.TryCatch.anyIntTry();
        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.employee);
        if(indice==-1 || CommandAdd.employee[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
            return ;
        }

        System.out.printf("NOME : %s\n",CommandAdd.employee[indice].getName());
        System.out.printf("ENDEREÇO: %s\n",CommandAdd.employee[indice].getAdress());
        if(CommandAdd.getEmployee()[indice].getType()==1) {
            System.out.printf("TIPO : HORISTA\n");
            if(CommandAdd.getEmployee()[indice] instanceof FactoryHorista)
            {
                System.out.printf("SALARIO : %.2f\n",((FactoryHorista)CommandAdd.employee[indice]).getSalario_por_hora());
            }
        }
        if(CommandAdd.getEmployee()[indice].getType()==2) {
            System.out.printf("TIPO : SALARIADO\n");
            if(CommandAdd.getEmployee()[indice] instanceof FactorySalariado)
            {
                System.out.printf("SALARIO : %.2f\n",((FactorySalariado)CommandAdd.employee[indice]).getSalary());
            }
        }
        if(CommandAdd.getEmployee()[indice].getType()==3 ) {
            System.out.printf("TIPO : COMISSIONADO\n");
            if(CommandAdd.getEmployee()[indice] instanceof FactoryComissionado)
            {
                System.out.printf("SALARIO : %.2f\n",((FactoryComissionado)CommandAdd.getEmployee()[indice]).getSalary());
            }
        }

        if(CommandAdd.getEmployee()[indice].isSindicato()==true)
            System.out.printf("PERTENCE AO SINDICATO\n");
        else
            System.out.printf("NÃO PERTENCE AO SINDICATO\n");

    }
}
