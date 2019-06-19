public class Funcionario {

    private static String name;
    private static String adress;
    private static int ID;
    private static double salary;
    private static int type;
    private static boolean existe = false;

    private static int tipo_receber;
    /*tipo_receber
    1 -> semanalmente
    2 -> mensalmente
    3 -> semanas determinadas
     */

    //mensal
    private static int mensal_data_receber;

    //semanal
    private static int a_cada_semana;
    private static int semanal_dia_receber;

    //sindicato
    private static int sindicato;
    private static double taxa_sindical;
    private static int id_sindicato;

    //ponto
    private static int hora_entrada;
    private static int hora_saida;
    private static int minuto_entrada;
    private static int minuto_saida;

    private static boolean in_work;


    /* 1 --> horista
       2 --> salaried

       3 --> commisioned
    */


    public static boolean isIn_work() {
        return in_work;
    }

    public static void setIn_work(boolean in_work) {
        Funcionario.in_work = in_work;
    }

    public static void setHora_entrada(int hora_entrada) {
        Funcionario.hora_entrada = hora_entrada;
    }

    public static void setHoras_trabalhada(int horas)
    {
        this.horas_trabalhada=horas;
    }

    public static void setHora_saida(int hora_saida) {
        Funcionario.hora_saida = hora_saida;
    }

    public static double getTaxa_sindical() {
        return taxa_sindical;
    }

    public static void setTaxa_sindical(double taxa_sindical) {
        Funcionario.taxa_sindical = taxa_sindical;
    }

    public static int getId_sindicato() {
        return id_sindicato;
    }

    public static void setId_sindicato(int id_sindicato) {
        Funcionario.id_sindicato = id_sindicato;
    }

    public static int getSindicato() {
        return sindicato;
    }

    public static void setSindicato(int sindicato) {
        Funcionario.sindicato = sindicato;
    }

    public static void setPayment(int type)
    {
        if(type==1)
        {
            tipo_receber = 1;
            a_cada_semana = 1;
            semanal_dia_receber = 5;
            mensal_data_receber=-1;
        }
        else if(type==2)
        {
            tipo_receber=2;
            mensal_data_receber=30;
            a_cada_semana=-1;
            semanal_dia_receber=-1;
        }
        else if(type==3)
        {
            tipo_receber=3;
            mensal_data_receber=-1;
            a_cada_semana=2;
            semanal_dia_receber=5;
        }
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Funcionario.name = name;
    }

    public static String getAdress() {
        return adress;
    }

    public static void setAdress(String adress) {
        Funcionario.adress = adress;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Funcionario.ID = ID;
    }

    public static double getSalary() {
        return salary;
    }

    public static void setSalary(double salary) {
        Funcionario.salary = salary;
    }

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        Funcionario.type = type;
    }

    public static boolean isExiste() {
        return existe;
    }

    public static void setExiste(boolean existe) {
        Funcionario.existe = existe;
    }
}
