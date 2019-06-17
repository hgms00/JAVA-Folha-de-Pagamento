import java.util.Scanner;

public class main {




    private static void main(String[] args)
    {

         Funcionario employee[] = new Funcionario[1000];
            private static int command = 1;
            private static int qt_funcionario = 0;
            private static String[] name;
            private static String[] adress;
            private static double salary;
            private static int type;
            private static int id;


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


                switch(command)
                {
                    case 1:
                        qt_funcionario++;
                        Funcionario[qt_funcionario] = new Funcionario();

                        System.out.println("Digite o nome do funcionário");
                        name = input.nextLine();
                        employee[qt_funcionario].setName(name);

                        System.out.println("Digite o endereço do funcionário");
                        adress = input.nextLine();
                        employee[qt_funcionario].setAdress(adress);

                        System.out.println("Selecione o tipo do funcionário");
                        System.out.println("1 --> Horista");
                        System.out.println("2 --> Assalariado");
                        System.out.println("3 --> Comissionado");

                        type = input.nextInt();
                        employee[qt_funcionario].setType(type);

                        System.out.println("Digite o salário do funcionário");
                        salary = input.nextDouble();
                        employee[qt_funcionario].setSalary(salary);

                        id = (2019*1000) + qt_funcionario;
                        employee[qt_funcionario].setID(id);

                        System.out.printf("--> O ID de funcionário é : %d",id);



                        break;
                }

            }
    }

}
