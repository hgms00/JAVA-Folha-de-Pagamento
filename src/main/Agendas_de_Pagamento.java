package main;

public class Agendas_de_Pagamento {

    private String name;

    private int type;

    /* TYPE
    1 -> Mensais
    2 -> Semanais
     */

    //Configurações para mensal
    private int dia_de_pagamento;

    //Configurações para semanal
    private int a_cada_semana;
    private int dia_da_semana;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDia_de_pagamento() {
        return dia_de_pagamento;
    }

    public void setDia_de_pagamento(int dia_de_pagamento) {
        this.dia_de_pagamento = dia_de_pagamento;
    }

    public int getA_cada_semana() {
        return a_cada_semana;
    }

    public void setA_cada_semana(int a_cada_semana) {
        this.a_cada_semana = a_cada_semana;
    }

    public int getDia_da_semana() {
        return dia_da_semana;
    }

    public void setDia_da_semana(int dia_da_semana) {
        this.dia_da_semana = dia_da_semana;
    }

}