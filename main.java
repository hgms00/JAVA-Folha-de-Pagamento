import java.util.Scanner;

public class main {

    private static void main(String[] args)
    {
            private static int command = 1;

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


                        break;
                }

            }
    }

}
