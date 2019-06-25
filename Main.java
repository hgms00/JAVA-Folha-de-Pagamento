import java.util.Scanner;
import java.math.*;
import java.util.*;
import java.lang.*;

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
    private static int buscarFuncionarioSindicato(int id,int qt_funcionario,Funcionario[] employee)
    {
        int i;
        for(i=1;i<=qt_funcionario;i++)
        {
            if(employee[i].getId_sindicato()==id)
            {
                return i;
            }
        }
        return -1;

    }

    private static void rodarFolhadePagamento(int i,Agendas_de_Pagamento[] agendas,Funcionario[] employee,int dia,int mes)
    {
        int type_agenda = employee[i].getTipo_da_agenda();

        if(agendas[type_agenda].getType()==1)
        {
            if(agendas[type_agenda].getDia_de_pagamento()==dia)
            {
                System.out.println("================CONTRA-CHEQUE======================");
                System.out.printf("Referente ao funcionário %s",employee[i].getName());

                System.out.printf(" ---> Valor descontado pelo sindicato %.2lf",employee[i].getTaxa_sindical());
                System.out.printf(" ---> Valor descontado por taxa de serviços %.2lf",employee[i].getTaxa_servico());

                if(employee[i] instanceof Comissionado)
                {
                    System.out.println("---> Valor obtido a partir de comissão em vendas %.2lf",((Comissionado)employee[i]).getComissao();
                    double salary = ((Comissionado) employee[i]).getSalary() + ((Comissionado)employee[i]).getComissao() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                    System.out.printf("Salário total recebido : %lf",salary);
                }
                else if ()
                
                

                if(employee[i].getMetodo_de_pagamento()==1)
                    System.out.println("Pagamento realizado pelo método : Cheque pelos Correios");
                else if(employee[i].getMetodo_de_pagamento()==2)
                    System.out.println("Pagamento realizado pelo método : Em mãos");
                else if (employee[i].getMetodo_de_pagamento()==3)
                    System.out.println("Pagamento realizado pelo método : Depósito bancário");
            }
            else
                return;
        }
    }

    private static void setAgendasDefault(Agendas_de_Pagamento[] agendas)
    {
        String aux;

        //---------1

        agendas[1].setName("semanalmente");
        agendas[1].setType(2);
        agendas[1].setA_cada_semana(2);
        agendas[1].setDia_da_semana(5);
        agendas[1].setDia_de_pagamento(-1);
        //---------2
        agendas[2].setName("mensalmente");
        agendas[2].setType(1);
        agendas[2].setA_cada_semana(-1);
        agendas[2].setDia_da_semana(-1);
        agendas[2].setDia_de_pagamento(30);
        //---------3
        agendas[3].setName("bi-semanalmente");
        agendas[3].setType(2);
        agendas[3].setA_cada_semana(2);
        agendas[3].setDia_da_semana(5);
        agendas[3].setDia_de_pagamento(-1);
        //----------------
    }
    private static int charToInt(char c) {
        if (c == '0')
            return 0;
        if (c == '1')
            return 1;
        if (c == '2')
            return 2;
        if (c == '3')
            return 3;
        if (c == '4')
            return 4;
        if (c == '5')
            return 5;
        if (c == '6')
            return 6;
        if (c == '7')
            return 7;
        if (c == '8')
            return 8;
        if (c == '9')
            return 9;

        return 0;
    }

    private static int stringToInt(String numero)
    {
        int i;
        int numero_int = 0;
        char aux_c;
        for(i=0;i<numero.length();i++)
        {

            numero_int += (charToInt(numero.charAt(i))*Math.pow(10,numero.length()-1-i));
        }
        return numero_int;
    }


    private void setAgendas(Agendas_de_Pagamento[] agendas, String name, int qt_agendas)
    {
        int i;
        String numero = null;
        agendas[qt_agendas].setName(name);

        if (name.equals("semanal"))
        {
            agendas[qt_agendas].setType(2);
            agendas[qt_agendas].setA_cada_semana(charToInt(name.charAt(8)));

            if(name.substring(10).equals("domingo"))
            {
                agendas[qt_agendas].setDia_da_semana(0);
            }
            else if(name.substring(10).equals("segunda"))
            {
                agendas[qt_agendas].setDia_da_semana(1);
            }
            else if(name.substring(10).equals("terça"))
            {
                agendas[qt_agendas].setDia_da_semana(2);
            }
            else if(name.substring(10).equals("quarta"))
            {
                agendas[qt_agendas].setDia_da_semana(3);
            }
            else if(name.substring(10).equals("quinta"))
            {
                agendas[qt_agendas].setDia_da_semana(4);
            }
            else if(name.substring(10).equals("sexta"))
            {
                agendas[qt_agendas].setDia_da_semana(5);
            }
            else if(name.substring(10).equals("sabado"))
            {
                agendas[qt_agendas].setDia_da_semana(6);
            }
        }
        else
        {
            agendas[qt_agendas].setType(1);
            numero = name.substring(6);
            agendas[qt_agendas].setDia_de_pagamento(stringToInt(numero));
        }
    }

    public void main(String[] args)
    {
        Funcionario employee[] = new Funcionario[1000];
        Agendas_de_Pagamento agendas[] = new Agendas_de_Pagamento[1000];
        int qt_agendas = 3;

        int command = 1;
        String name = null;
        String adress = null;
        double salary;
        int type = 0;
        int id;
        int qt_funcionario = 0;
        int id_sindicato;
        int sindicato;
        int indice;
        int horas_passadas=0;
        float percentual;
        int payment_type;
        double taxa_sindicato;
        double taxa_servico;
        int command_dados;

        int aux;

        setAgendasDefault(agendas);

        while(command!=0)
        {
            System.out.printf("----> Horário Atual : %d:00\n",hora);
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
                    if(type==1)
                    {
                        employee[qt_funcionario].setTipo_da_agenda(1);
                    }
                    else if(type==2)
                    {
                        employee[qt_funcionario].setTipo_da_agenda(2);
                    }
                    else if(type==3)
                    {
                        employee[qt_funcionario].setTipo_da_agenda(3);
                    }
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

                    command_dados = input.nextInt();
                    aux=0;
                    switch(command_dados)
                    {
                        case 1:
                            while(aux==0) {
                                input.nextLine();
                                System.out.println("Digite o novo nome do funcionário");
                                name = input.nextLine();

                                System.out.println("Deseja alterar o nome do funcionário para : ");
                                System.out.printf(" --> %s\n", name);
                                System.out.println("0 --> Não");
                                System.out.println("1 --> Sim");
                                aux = input.nextInt();
                            }
                            employee[indice].setName(name);
                            System.out.println("Nome do funcionário alterado com sucesso");
                            break;
                        case 2:
                            while(aux==0)
                            {
                                input.nextLine();
                                System.out.println("Digite o novo endereço do funcionário");
                                adress = input.nextLine();

                                System.out.println("Deseja alterar o endereço do funcionário para : ");
                                System.out.printf(" --> %s\n", adress);
                                System.out.println("0 --> Não");
                                System.out.println("1 --> Sim");
                                aux = input.nextInt();
                            }
                            employee[indice].setAdress(adress);
                            System.out.println("Endereço alterado com sucesso");
                            break;
                        case 3:
                            while(aux==0)
                            {
                                input.nextLine();
                                System.out.println("Digite o novo tipo do funcionário");
                                System.out.println("1 -> Horista");
                                System.out.println("2 -> Salariado");
                                System.out.println("3 -> Comissionado");
                                type = input.nextInt();

                                if(type==1)
                                    System.out.println("Deseja alterar o endereço do funcionário para : 'HORISTA' ?");
                                else if(type==2)
                                    System.out.println("Deseja alterar o endereço do funcionário para : 'SALARIADO' ?");
                                else if(type==3)
                                    System.out.println("Deseja alterar o endereço do funcionário para : 'COMISSIONADO' ?");

                                System.out.println("0 --> Não");
                                System.out.println("1 --> Sim");
                                aux = input.nextInt();
                            }
                            employee[indice].setType(type);
                            System.out.println("Tipo alterado com sucesso");
                            break;
                        case 4:
                            while(aux==0)
                            {
                                input.nextLine();
                                System.out.println("Digite o novo tipo do funcionário");
                                System.out.println("1 -> Cheque pelos correios");
                                System.out.println("2 -> Em mãos");
                                System.out.println("3 -> Depósito bancário");
                                type = input.nextInt();

                                if(type==1)
                                    System.out.println("Deseja alterar o endereço do funcionário para : 'CHEQUE PELOS CORREIOS' ?");
                                else if(type==2)
                                    System.out.println("Deseja alterar o endereço do funcionário para : 'EM MÃOS' ?");
                                else if(type==3)
                                    System.out.println("Deseja alterar o endereço do funcionário para : 'DEPÓSITO BANCÁRIO' ?");

                                System.out.println("0 --> Não");
                                System.out.println("1 --> Sim");
                                aux = input.nextInt();
                            }
                            employee[indice].setType(type);
                            System.out.println("Tipo alterado com sucesso");

                            break;
                        case 5:
                            input.nextLine();
                            System.out.println("O funcionário pertence ao sindicato?");
                            System.out.println("0 --> Não");
                            System.out.println("1 --> Sim");
                            sindicato = input.nextInt();
                            if(sindicato==1)
                            {
                                employee[indice].setSindicato(true);
                                System.out.println("Digite a taxa mensal do sindicato");
                                taxa_sindicato = input.nextDouble();
                                employee[qt_funcionario].setTaxa_sindical(taxa_sindicato);


                                id_sindicato = (1000) + qt_funcionario;
                                employee[qt_funcionario].setId_sindicato(id_sindicato);
                                System.out.printf("--> O ID do sindicato do funcionário é : %d\n",id_sindicato);
                            }
                            else
                            {
                                employee[indice].setSindicato(false);

                            }
                            break;
                        case 6:
                            aux=1;

                            while(aux!=0)
                            {
                                System.out.println("Digite seu novo ID do sindicato(Até 6 dígitos)");
                                id_sindicato = input.nextInt();
                                if(buscarFuncionarioSindicato(id_sindicato,qt_funcionario,employee)==-1)
                                {
                                    aux=0;
                                    employee[indice].setId_sindicato(id_sindicato);
                                }
                                else
                                {
                                    System.out.println("O ID já está em uso;");
                                }

                            }
                            System.out.printf("--> Seu novo ID do sindicato é : %d",employee[indice].getId_sindicato());

                            break;
                        case 7:
                            System.out.println("Digite o novo valor a ser cobrado pela taxa sindical");
                            taxa_sindicato = input.nextDouble();

                            employee[indice].setTaxa_sindical(taxa_sindicato);

                            System.out.println("Sua taxa sindical foi alterada com sucesso");
                            break;
                        case 0:
                            break;

                    }
                    break;
                case 7:
                    // folha de pagamento
                    for(aux=1;aux<=qt_funcionario;aux++)
                    {
                        rodarFolhadePagamento(aux,agendas,employee,dia,mes);
                    }

                    break;
                case 8:
                    //undo/redo
                    break;
                case 9:
                    System.out.println("Digite o ID do funcionário que terá a agenda de pagamento modificada");
                    id = input.nextInt();
                    indice = buscarFuncionario(id,qt_funcionario,employee);
                    if(indice==-1 || employee[indice].isExiste()==false)
                    {
                        System.out.println("O funcionário não existe");
                        break;
                    }


                    System.out.println("SELECIONE UMA DAS AGENDAS DE PAGAMENTOS DISPONÍVEIS\n");
                    for(aux=1;aux<=qt_agendas;aux++)
                    {
                        System.out.printf("%d --> %s",aux,agendas[aux].getName());
                    }
                    aux = input.nextInt();
                    employee[indice].setTipo_da_agenda(aux);

                    System.out.println("Agenda de pagamento alterada com sucesso");


                    break;
                case 10:
                    qt_agendas++;
                    input.nextLine();
                    System.out.println("Digite o tipo de agenda a ser adicionada");

                    name = input.nextLine();

                    setAgendas(agendas,name,qt_agendas);

                    System.out.println("Agenda adicionada como sucesso");


                    break;
                case 11:
                    System.out.println("Digite quantas horas você quer passar (Digite 8 para passar um turno de trabalho) : ");
                    horas_passadas=input.nextInt();

                    hora+=horas_passadas;

                    horas_passadas =0;

                    System.out.printf("----> Horário Atual : %d:00\n",hora);
                    break;
            }
        }
    }

}
