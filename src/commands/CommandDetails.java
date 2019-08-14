package commands;

import java.util.*;

import main.TextsandAuxs;
import main.TryCatch;

import static main.Main.*;

public class CommandDetails implements Command{

    public void execute()
    {
        
        int id;
        int indice;
        int type = 0;
        String name = null;
        String adress = null;
        int aux = 0;
        double taxa_sindicato;
        int id_sindicato;
        int sindicato;
        int command_dados;
        
        
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o ID do funcionário para alterar seus dados");
        id = input.nextInt();
        indice = buscarFuncionario(id,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        if(indice==-1 || CommandAdd.getEmployee()[indice].isExiste()==false)
        {
            System.out.println("O funcionário não existe");
            return ; 
        }

        TextsandAuxs.getDetailsText();

        command_dados = TryCatch.detailsTry();
        input.nextLine();
        aux=0;
        switch(command_dados)
        {
            case 1:
                while(aux==0) {
                    System.out.println("Digite o novo nome do funcionário");
                    name = input.nextLine();

                    System.out.println("Deseja alterar o nome do funcionário para : ");
                    System.out.printf(" --> %s\n", name);
                    System.out.println("0 --> Não");
                    System.out.println("1 --> Sim");
                    aux = main.TryCatch.booleanintTry();
                }
                CommandAdd.getEmployee()[indice].setName(name);
                System.out.println("Nome do funcionário alterado com sucesso");
                break;
            case 2:
                while(aux==0)
                {
                    System.out.println("Digite o novo endereço do funcionário");
                    adress = input.nextLine();

                    System.out.println("Deseja alterar o endereço do funcionário para : ");
                    System.out.printf(" --> %s\n", adress);
                    System.out.println("0 --> Não");
                    System.out.println("1 --> Sim");
                    aux = main.TryCatch.booleanintTry();
                }
                CommandAdd.getEmployee()[indice].setAdress(adress);
                System.out.println("Endereço alterado com sucesso");
                break;
            case 3:
                while(aux==0)
                {
                    TextsandAuxs.getDetailsTypeText();
                    type = main.TryCatch.intTry();

                    if(type==1)
                        System.out.println("Deseja alterar o tipo do funcionário para : 'HORISTA' ?");
                    else if(type==2)
                        System.out.println("Deseja alterar o tipo do funcionário para : 'SALARIADO' ?");
                    else if(type==3)
                        System.out.println("Deseja alterar o tipo do funcionário para : 'COMISSIONADO' ?");

                    System.out.println("0 --> Não");
                    System.out.println("1 --> Sim");
                    aux = main.TryCatch.booleanintTry();
                }
                CommandAdd.getEmployee()[indice].setType(type);
                System.out.println("Tipo alterado com sucesso");
                break;
            case 4:
                while(aux==0)
                {
                    TextsandAuxs.getDetailsPaymentText();
                    type = main.TryCatch.intTry();

                    if(type==1)
                        System.out.println("Deseja alterar o endereço do funcionário para : 'CHEQUE PELOS CORREIOS' ?");
                    else if(type==2)
                        System.out.println("Deseja alterar o endereço do funcionário para : 'EM MÃOS' ?");
                    else if(type==3)
                        System.out.println("Deseja alterar o endereço do funcionário para : 'DEPÓSITO BANCÁRIO' ?");

                    System.out.println("0 --> Não");
                    System.out.println("1 --> Sim");
                    aux = main.TryCatch.booleanintTry();
                }
                CommandAdd.getEmployee()[indice].setType(type);
                System.out.println("Tipo alterado com sucesso");

                break;
            case 5:
                System.out.println("O funcionário pertence ao sindicato?");
                System.out.println("0 --> Não");
                System.out.println("1 --> Sim");
                sindicato = main.TryCatch.booleanintTry();
                if(sindicato==1)
                {
                    CommandAdd.getEmployee()[indice].setSindicato(true);
                    System.out.println("Digite a taxa mensal do sindicato");
                    taxa_sindicato = input.nextDouble();
                    CommandAdd.getEmployee()[CommandAdd.getQt_funcionario()].setTaxa_sindical(taxa_sindicato);


                    id_sindicato = (1000) + CommandAdd.getQt_funcionario();
                    CommandAdd.getEmployee()[CommandAdd.getQt_funcionario()].setId_sindicato(id_sindicato);
                    System.out.printf("--> O ID do sindicato do funcionário é : %d\n",id_sindicato);
                }
                else
                {
                    CommandAdd.getEmployee()[indice].setSindicato(false);

                }
                break;
            case 6:
                aux=1;

                while(aux!=0)
                {
                    System.out.println("Digite seu novo ID do sindicato(Até 6 dígitos)");
                    id_sindicato = main.TryCatch.anyIntTry();
                    if(buscarFuncionarioSindicato(id_sindicato,CommandAdd.getQt_funcionario(),CommandAdd.getEmployee())==-1)
                    {
                        aux=0;
                        CommandAdd.getEmployee()[indice].setId_sindicato(id_sindicato);
                    }
                    else
                    {
                        System.out.println("O ID já está em uso;");
                    }

                }
                System.out.printf("--> Seu novo ID do sindicato é : %d",CommandAdd.getEmployee()[indice].getId_sindicato());

                break;
            case 7:
                System.out.println("Digite o novo valor a ser cobrado pela taxa sindical");
                taxa_sindicato = main.TryCatch.doubleTry();

                CommandAdd.getEmployee()[indice].setTaxa_sindical(taxa_sindicato);

                System.out.println("Sua taxa sindical foi alterada com sucesso");
                break;
            case 0:
                break;

        }
    }
}
