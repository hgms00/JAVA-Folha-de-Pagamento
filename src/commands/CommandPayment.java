package commands;



import main.Agendas_de_Pagamento;
import main.FactoryFuncionario;
import main.*;

public class CommandPayment implements Command{

    public void execute()
    {
        int aux;
        // folha de pagamento
        for(aux=1;aux<=CommandAdd.getQt_funcionario();aux++)
        {
            if(CommandAdd.getEmployee()[aux]!=null) {
                if (CommandAdd.getEmployee()[aux].isExiste() == true) {
                    rodarFolhadePagamento(aux,Main.getAgendas(), CommandAdd.getEmployee(), main.Main.getDia(), main.Main.getMes(), main.Main.getDia_da_semana());
                }
            }
        }
        System.out.println("Fim dos pagamentos diários");
    }

    private void rodarFolhadePagamento(int i, Agendas_de_Pagamento[] agendas, FactoryFuncionario[] employee, int dia_atual, int mes_atual, int dia_semana_atual) {
        int type_agenda = employee[i].getTipo_da_agenda();

        try {
            if (agendas[type_agenda].getType() == 1) {
                if (agendas[type_agenda].getDia_de_pagamento() == dia_atual || (dia_atual == 28 && dia_semana_atual == 5) || (dia_atual == 29 && dia_semana_atual == 5)) {
                    employee[i].zerarDias_sem_receber();
                    System.out.println("================CONTRA-CHEQUE======================");
                    System.out.printf("Referente ao funcionário %s\n", employee[i].getName());

                    System.out.printf(" ---> Valor descontado pelo sindicato %.2f\n", employee[i].getTaxa_sindical());
                    System.out.printf(" ---> Valor descontado por taxa de serviços %.2f\n", employee[i].getTaxa_servico());

                    if (employee[i] instanceof FactoryComissionado) {
                        System.out.printf("---> Valor obtido a partir de comissão em vendas %.2f\n", ((FactoryComissionado) employee[i]).getComissao());
                        double salary = ((FactoryComissionado) employee[i]).getSalary() + ((FactoryComissionado) employee[i]).getComissao() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                        System.out.printf("Salário total recebido : %.2f\n", salary);
                        ((FactoryComissionado) employee[i]).setComissao();
                    } else if (employee[i] instanceof FactoryHorista) {
                        double salary = ((FactoryHorista) employee[i]).getSalary_semanal() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                        System.out.printf("Salário total recebido : %.2f\n", salary);
                        ((FactoryHorista) employee[i]).setSalary_semanal();
                    } else if (employee[i] instanceof FactorySalariado) {
                        double salary = ((FactorySalariado) employee[i]).getSalary() - -employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                        System.out.printf("Salário total recebido : %.2f\n", salary);
                    }
                    if (employee[i].getMetodo_de_pagamento() == 1)
                        System.out.println("Pagamento realizado pelo método : Cheque pelos Correios");
                    else if (employee[i].getMetodo_de_pagamento() == 2)
                        System.out.println("Pagamento realizado pelo método : Em mãos");
                    else if (employee[i].getMetodo_de_pagamento() == 3)
                        System.out.println("Pagamento realizado pelo método : Depósito bancário");

                    System.out.println("===================================================");
                } else
                    return;
            } else if (agendas[type_agenda].getType() == 2) {
                if (agendas[type_agenda].getDia_da_semana() == dia_semana_atual) {
                    if ((agendas[type_agenda].getA_cada_semana() * 7) <= employee[i].getDias_sem_receber()) {
                        employee[i].zerarDias_sem_receber();
                        System.out.println("================CONTRA-CHEQUE======================");
                        System.out.printf("Referente ao funcionário %s\n", employee[i].getName());

                        System.out.printf(" ---> Valor descontado pelo sindicato %.2f\n", employee[i].getTaxa_sindical());
                        System.out.printf(" ---> Valor descontado por taxa de serviços %.2f\n", employee[i].getTaxa_servico());

                        if (employee[i] instanceof FactoryComissionado) {
                            System.out.printf("---> Valor obtido a partir de comissão em vendas %.2f\n", ((FactoryComissionado) employee[i]).getComissao());
                            double salary = ((FactoryComissionado) employee[i]).getSalary() + ((FactoryComissionado) employee[i]).getComissao() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                            System.out.printf("Salário total recebido : %.2f\n", salary);
                            ((FactoryComissionado) employee[i]).setComissao();
                        } else if (employee[i] instanceof FactoryHorista) {
                            double salary = ((FactoryHorista) employee[i]).getSalary_semanal() - employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                            System.out.printf("Salário total recebido : %.2f\n", salary);
                            ((FactoryHorista) employee[i]).setSalary_semanal();
                        } else if (employee[i] instanceof FactorySalariado) {
                            double salary = ((FactorySalariado) employee[i]).getSalary() - -employee[i].getTaxa_sindical() - employee[i].getTaxa_servico();
                            System.out.printf("Salário total recebido : %.2f\n", salary);
                        }
                        if (employee[i].getMetodo_de_pagamento() == 1)
                            System.out.println("Pagamento realizado pelo método : Cheque pelos Correios");
                        else if (employee[i].getMetodo_de_pagamento() == 2)
                            System.out.println("Pagamento realizado pelo método : Em mãos");
                        else if (employee[i].getMetodo_de_pagamento() == 3)
                            System.out.println("Pagamento realizado pelo método : Depósito bancário");

                        System.out.println("===================================================");
                    } else
                        return;
                }
            }
        }
        catch(Exception e)
        {
            System.err.println(e);
        }
    }


}
