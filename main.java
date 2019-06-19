import java.util.Scanner;

public class Main {

    private static int buscarFuncionario(int id,int qt_funcionario,Funcionario employee)
    {
        int i;

        for(i=1;i<=qt_funcionario;i++)
        {
            if(employee[i].getID==id)
            {
                return i;
            }
        }
    }


     public static void main(String[] args)
    {
         Funcionario employee[] = new Funcionario[1000];
         int command = 1;
         String name;
         String adress;
         double salary;
         int type;
         int id;
         int qt_funcionario = 0;
         int id_sindicato;
         int sindicato;
         int indice;
         double taxa_sindicato;



        while(command!=0)
        {
            System.out.println("O que você deseja fazer?\n");
            System.out.println("1. Adicionar um novo funcionário");
            System.out.println("2. Remover um funcionário existente");
            System.out.println("3. Lançar um Cartão de Ponto");
            System.out.println("4. Lançar um Resultado Venda");
            System.out.println("5. Lançar uma taxa de serviço");
            System.out.println("6. Alterar detalhes de um empregado");
            System.out.println("7. Rodar a folha de pagamento para hoje");
            System.out.println("8. Undo/redo");
            System.out.println("9. Agenda de pagamento");
            System.out.println("10. Criar nova agenda de pagamento");
            System.out.println("0. Sair");

            Scanner input = new Scanner(System.in);
            command = input.nextInt();
            input.nextLine();


            switch(command)
            {
                case 1:
                    qt_funcionario++;
                    employee[qt_funcionario] = new Funcionario();

                    //--------------------------------------------
                    System.out.println("Digite o nome do funcionário");
                    //--------------------------------------------


                    name = input.nextLine();
                    employee[qt_funcionario].setName(name);

                    //--------------------------------------------
                    System.out.println("Digite o endereço do funcionário");
                    //--------------------------------------------

                    adress = input.nextLine();
                    employee[qt_funcionario].setAdress(adress);

                    //--------------------------------------------
                    System.out.println("Selecione o tipo do funcionário");
                    System.out.println("1 --> Horista");
                    System.out.println("2 --> Assalariado");
                    System.out.println("3 --> Comissionado");
                    //--------------------------------------------


                    type = input.nextInt();
                    employee[qt_funcionario].setType(type);


                    //Setando o pagamento e a existência
                    employee[qt_funcionario].setPayment(type);
                    employee[qt_funcionario].setExiste(true);



                    //--------------------------------------------
                    System.out.println("Digite o salário do funcionário");
                    //--------------------------------------------


                    salary = input.nextDouble();
                    employee[qt_funcionario].setSalary(salary);


                    //--------------------------------------------
                    System.out.println("O funcionário pertence ao sindicato?");
                    System.out.println("0 --> NÃO");
                    System.out.println("1 --> SIM");

                    sindicato = input.nextInt();
                    employee[qt_funcionario].setSindicato(sindicato);

                    if(sindicato == 1)
                    {
                        System.out.println("Digite a taxa mensal do sindicato");
                        taxa_sindicato = input.nextDouble();
                        employee[qt_funcionario].setTaxa_sindical(taxa_sindicato);


                        id_sindicato = (2019*10) + qt_funcionario;
                        employee[qt_funcionario].setId_sindicato(id_sindicato);
                        System.out.printf("--> O ID do sindicato do funcionário é : %d\n",id_sindicato);
                    }
                    //--------------------------------------------


                    //----------Setando o ID---------------------
                    id = (2019*1000) + qt_funcionario;
                    employee[qt_funcionario].setID(id);

                    System.out.printf("--> O ID de funcionário é : %d\n",id);

                    break;
                case 2:

                    System.out.println("Digite o ID do funcionário que vocẽ quer remover");
                    id = nextInt();

                    indice = buscarFuncionario(id,qt_funcionario,employee);

                    if(employee[indice].isExiste()==false)
                    {
                        System.out.println("O funcionário não existe");
                    }



                    break;
            }

        }
    }

}
