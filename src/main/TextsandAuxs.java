package main;

import commands.CommandAdd;

public class TextsandAuxs {

    public static void setEmployeenull()
    {
        for(int i=1;i<= CommandAdd.getQt_funcionario();i++)
        {
            CommandAdd.getEmployee()[i].setExiste(false);
        }

    }

    public static void getInitialText()
    {
        System.out.printf("----> Horário Atual : %d:00\n",main.Main.getHora());
        if(main.Main.getDia_da_semana()==0)
            System.out.printf("Domingo, %d/%d\n",main.Main.getDia(),main.Main.getMes());
        if(main.Main.getDia_da_semana()==1)
            System.out.printf("Segunda, %d/%d\n",main.Main.getDia(),main.Main.getMes());
        if(main.Main.getDia_da_semana()==2)
            System.out.printf("Terça, %d/%d\n",main.Main.getDia(),main.Main.getMes());
        if(main.Main.getDia_da_semana()==3)
            System.out.printf("Quarta, %d/%d\n",main.Main.getDia(),main.Main.getMes());
        if(main.Main.getDia_da_semana()==4)
            System.out.printf("Quinta, %d/%d\n",main.Main.getDia(),main.Main.getMes());
        if(main.Main.getDia_da_semana()==5)
            System.out.printf("Sexta, %d/%d\n",main.Main.getDia(),main.Main.getMes());
        if(main.Main.getDia_da_semana()==6)
            System.out.printf("Sábado, %d/%d\n",main.Main.getDia(),main.Main.getMes());

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
        System.out.println("11. Alterar tempo");
        System.out.println("12. Verificar dados de um empregado");
        System.out.println("0. Sair");

    }
    public static void getTimeTexts()
    {
        System.out.println("O que você deseja avançar?");
        System.out.println("1 - DIA");
        System.out.println("2 - HORAS");
        System.out.println("3 - MÊS");
    }
    public static void getDetailsText()
    {
        System.out.println("O que você deseja alterar?\n");
        System.out.println("1. Nome");
        System.out.println("2. Endereço");
        System.out.println("3. Tipo");
        System.out.println("4. Método de Pagamento");
        System.out.println("5. Adesão ao sindicato");
        System.out.println("6. Identificação no sindicato");
        System.out.println("7. Taxa Sindical");
        System.out.println("0. Cancelar");
    }

    public static void getDetailsTypeText()
    {
        System.out.println("Digite o novo tipo do funcionário");
        System.out.println("1 -> FactoryHorista");
        System.out.println("2 -> FactorySalariado");
        System.out.println("3 -> FactoryComissionado");
    }

    public static void getDetailsPaymentText()
    {
        System.out.println("Digite o novo tipo do funcionário");
        System.out.println("1 -> Cheque pelos correios");
        System.out.println("2 -> Em mãos");
        System.out.println("3 -> Depósito bancário");
    }
}
