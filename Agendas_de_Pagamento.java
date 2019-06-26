public class Agendas_de_Pagamento {

    private static String name;

    private static int type;

    /* TYPE
    1 -> Mensais
    2 -> Semanais
     */

    //Configurações para mensal
    private static int dia_de_pagamento;

    //Configurações para semanal
    private static int a_cada_semana;
    private static int dia_da_semana;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Agendas_de_Pagamento.name = name;
    }

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        Agendas_de_Pagamento.type = type;
    }

    public static int getDia_de_pagamento() {
        return dia_de_pagamento;
    }

    public static void setDia_de_pagamento(int dia_de_pagamento) {
        Agendas_de_Pagamento.dia_de_pagamento = dia_de_pagamento;
    }

    public static int getA_cada_semana() {
        return a_cada_semana;
    }

    public static void setA_cada_semana(int a_cada_semana) {
        Agendas_de_Pagamento.a_cada_semana = a_cada_semana;
    }

    public static int getDia_da_semana() {
        return dia_da_semana;
    }

    public static void setDia_da_semana(int dia_da_semana) {
        Agendas_de_Pagamento.dia_da_semana = dia_da_semana;
    }

}
