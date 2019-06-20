import java.util.Scanner;

public class Main {

    private static int dia=26;
    private static int mes=06;
    private static int hora=7;
    private static int ano=2019;


    private static int buscarFuncionario(int id,int qt_funcionario,Funcionario[] employee)
    {
        int i;

        for(i=1;i<=qt_funcionario;i++)
        {
            if(employee[i].getID()==id)
            {
                return i;
            }
        }
        return -1;
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
        float percentual;
        int payment_type;
        double taxa_sindicato;
        double taxa_servico;
        int command_dados;

        int aux;



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

                    //-----------------TYPE-----------------------------
                    System.out.println("Selecione o tipo do funcionário");
                    System.out.println("1 --> Horista");
                    System.out.println("2 --> Assalariado");
                    System.out.println("3 --> Comissionado");

                    type = input.nextInt();
                    input.nextLine();

                    if(type==1)
                    {
                        employee[qt_funcionario] = new Horista();
                    }
                    else if(type==2)
                    {
                        employee[qt_funcionario] = new Salariado();
                    }
                    else if(type==3)
                    {
                        employee[qt_funcionario] = new Comissionado();
                    }

                    employee[qt_funcionario].setType(type);
                    //--------------------------------------------

                    //----------------NOME-----------------------
                    System.out.println("Digite o nome do funcionário");
                    name = input.nextLine();
                    employee[qt_funcionario].setName(name);
                    //--------------------------------------------

                    //----------------ADRESS-------------------
                    System.out.println("Digite o endereço do funcionário");
                    adress = input.nextLine();
                    employee[qt_funcionario].setAdress(adress);
                    //--------------------------------------------


                    //Setando o pagamento e a existência
                    employee[qt_funcionario].setPayment(type);
                    employee[qt_funcionario].setExiste(true);



                    //----------------SALARY-------------------------
                    if(employee[qt_funcionario] instanceof Salariado)
                    {
                        System.out.println("Digite o salário do funcionário");
                        salary = input.nextDouble();
                        ((Salariado) employee[qt_funcionario]).setSalary(salary);
                    }
                    else if(employee[qt_funcionario] instanceof Comissionado)
                    {
                        System.out.println("Digite o salário do funcionário");
                        salary = input.nextDouble();
                        ((Comissionado) employee[qt_funcionario]).setSalary(salary);
                        System.out.println("Digite o percentual de venda do funcionário");
                        System.out.println("Exemplo : Digite 30, para se referir a 30%");
                        percentual = input.nextFloat();
                        ((Comissionado)employee[qt_funcionario]).setPercentual(percentual);
                    }
                    else if(employee[qt_funcionario] instanceof Horista)
                    {
                        System.out.println("Digite o salário por hora do funcionário");
                        salary = input.nextDouble();
                        ((Horista)employee[qt_funcionario]).setSalario_por_hora(salary);
                    }
                    //--------------------------------------------

                    //---------Payment_Type-----------------------
                    System.out.println("Selecione o seu método de pagamento");
                    System.out.println("1 -> Cheque pelos correios");
                    System.out.println("2 -> Em mãos");
                    System.out.println("3 -> Depósito em conta bancária");

                    payment_type = input.nextInt();
                    employee[qt_funcionario].setMetodo_de_pagamento(payment_type);

                    //-------------SINDICATO---------------------------
                    System.out.println("O funcionário pertence ao sindicato?");
                    System.out.println("0 --> NÃO");
                    System.out.println("1 --> SIM");

                    sindicato = input.nextInt();
                    if(sindicato==1)
                        employee[qt_funcionario].setSindicato(true);
                    else
                        employee[qt_funcionario].setSindicato(false);

                    if(sindicato == 1)
                    {
                        System.out.println("Digite a taxa mensal do sindicato");
                        taxa_sindicato = input.nextDouble();
                        employee[qt_funcionario].setTaxa_sindical(taxa_sindicato);


                        id_sindicato = (1000) + qt_funcionario;
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
                    id = input.nextInt();

                    indice = buscarFuncionario(id,qt_funcionario,employee);

                    if(indice==-1 || employee[indice].isExiste()==false)
                    {
                        System.out.println("O funcionário não existe");
                    }
                    else if(employee[indice].isExiste()==true)
                    {
                        System.out.println("O funcionário foi removido com sucesso");
                        employee[indice].setExiste(false);
                    }

                    break;
                case 3:
                    System.out.println("Digite o ID do funcionário para bater o ponto");
                    id = input.nextInt();

                    indice = buscarFuncionario(id,qt_funcionario,employee);
                    if(indice==-1 || employee[indice].isExiste()==false)
                    {
                        System.out.println("O funcionário não existe");
                        break;
                    }

                    if(employee[indice].isIn_work()==false)
                    {
                        employee[indice].setIn_work(true);
                        employee[indice].setHora_entrada(hora);

                        System.out.println("Ponto de entrada computado com sucesso");
                    }
                    else
                    {
                        employee[indice].setIn_work(false);
                        employee[indice].setHora_saida(hora);

                        if(employee[indice] instanceof Horista)
                        {
                            ((Horista) employee[indice]).setHoras_diarias(((employee[indice].getHora_saida()-(employee[indice].getHora_entrada()))));
                        }

                        System.out.println("Ponto de saída computado com sucesso");
                    }
                    break;
                case 4:

                    System.out.println("Digite o ID do funcionário");
                    id = input.nextInt();
                    indice = buscarFuncionario(id,qt_funcionario,employee);
                    if(indice==-1 || employee[indice].isExiste()==false)
                    {
                        System.out.println("O funcionário não existe");
                        break;
                    }

                    System.out.println("Digite o dia da venda");
                    aux = input.nextInt();
                    System.out.println("Digite o valor da venda");
                    ((Comissionado) employee[indice]).setValor_venda(input.nextDouble(),aux);

                    System.out.println("Venda computada com sucesso");

                    break;
                case 5:
                    System.out.println("Digite o ID do que será cobrada as taxas de serviços");
                    id = input.nextInt();
                    indice = buscarFuncionario(id,qt_funcionario,employee);
                    if(indice==-1 || employee[indice].isExiste()==false)
                    {
                        System.out.println("O funcionário não existe");
                        break;
                    }

                    if(employee[indice].isSindicato()==false)
                    {
                        System.out.println("O funcionário não pertence ao sindicato");
                        break;
                    }

                    System.out.println("Digite o valor da taxa de serviço a ser descontada");
                    taxa_servico = input.nextDouble();

                    employee[indice].setTaxa_servico(taxa_servico);

                    break;
                case 6:
                    System.out.println("Digite o ID do funcionário para alterar seus dados");
                    id = input.nextInt();
                    indice = buscarFuncionario(id,qt_funcionario,employee);
                    if(indice==-1 || employee[indice].isExiste()==false)
                    {
                        System.out.println("O funcionário não existe");
                        break;
                    }

                    System.out.println("O que você deseja alterar?\n");
                    System.out.println("1. Nome");
                    System.out.println("2. Endereço");
                    System.out.println("3. Tipo");
                    System.out.println("4. Método de Pagamento");
                    System.out.println("5. Adesão ao sindicato");
                    System.out.println("6. Identificação no sindicato");
                    System.out.println("7. Taxa Sindical");
                    System.out.println("0. Cancelar");




                    break;

            }

        }
    }

}
