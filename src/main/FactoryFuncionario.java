package main;

public class FactoryFuncionario implements Cloneable{

    private String name = null;
    private String adress = null;
    private int ID = 0;
    private int metodo_de_pagamento = 0;
    private int type = 0;
    private boolean existe = false;
    private int tipo_receber = 0;
    private int dias_sem_receber = 0 ;
    /*tipo_receber
    1 -> semanalmente
    2 -> mensalmente
    3 -> semanas determinadas
     */

    /*metodo de pagamento
    1 -> Cheque pelos correios
    2 -> Em Mãos
    3 -> Depósito em conta bancária
     */
    //Agenda de pagamento
    private int tipo_da_agenda = 0;


    //sindicato
    private boolean sindicato = false;
    private double taxa_sindical = 0;
    private int id_sindicato = 0;
    private double taxa_servico = 0;

    //ponto
    private int hora_entrada = 0;
    private int hora_saida = 0;


    private boolean in_work = false;


    /* 1 --> horista
       2 --> salaried
       3 --> commisioned
    */

    public void templateDoCopy(FactoryFuncionario x)
    {
            x.templateDoCopy(x);
    }

    public int getDias_sem_receber() {
        return dias_sem_receber;
    }

    public  void setDias_sem_receber(int dias_sem_receber) {
        this.dias_sem_receber += dias_sem_receber;
    }
    public void zerarDias_sem_receber() {
        dias_sem_receber = 0;
    }

    public double getTaxa_servico() {
        return taxa_servico;
    }

    public  void setTaxa_servico(double taxa_servico) {
        this.taxa_servico += taxa_servico;
    }

    public int getMetodo_de_pagamento() {
        return metodo_de_pagamento;
    }

    public void setMetodo_de_pagamento(int metodo_de_pagamento) {
        this.metodo_de_pagamento = metodo_de_pagamento;
    }

    public int getHora_entrada() {
        return hora_entrada;
    }

    public int getHora_saida() {
        return hora_saida;
    }


    public boolean isIn_work() {
        return in_work;
    }

    public void setIn_work(boolean in_work) {
        this.in_work = in_work;
    }

    public void setHora_entrada(int hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public void setHora_saida(int hora_saida) {
        this.hora_saida = hora_saida;
    }

    public double getTaxa_sindical() {
        return taxa_sindical;
    }

    public void setTaxa_sindical(double taxa_sindical) {
        this.taxa_sindical = taxa_sindical;
    }

    public  int getId_sindicato() {
        return id_sindicato;
    }

    public  void setId_sindicato(int id_sindicato) {
        this.id_sindicato = id_sindicato;
    }

    public boolean isSindicato() {
        return sindicato;
    }

    public void setSindicato(boolean sindicato) {
        this.sindicato = sindicato;
    }

    public int getTipo_da_agenda() {
        return tipo_da_agenda;
    }

    public void setTipo_da_agenda(int tipo_da_agenda) {
        this.tipo_da_agenda = tipo_da_agenda;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    @Override
    public FactoryFuncionario clone() throws CloneNotSupportedException{
        return this.clone();
    }

}