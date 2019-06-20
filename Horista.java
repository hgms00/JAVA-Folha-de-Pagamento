public class Horista extends Funcionario{

    //semanal
    private static int a_cada_semana;
    private static int semanal_dia_receber;
    private static double salary_semanal;
    private static double salario_por_hora;

    private static int horas_diarias;

    public static void setHoras_diarias(int horas_diarias) {
        Horista.horas_diarias = horas_diarias;
    }

    public static int getHoras_diarias() {
        return horas_diarias;
    }

    public static double getSalario_por_hora() {
        return salario_por_hora;
    }

    public static void setSalario_por_hora(double salario_por_hora) {
        Horista.salario_por_hora = salario_por_hora;
    }
}
