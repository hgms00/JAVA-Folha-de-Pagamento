public class Horista extends Funcionario{

    //semanal
    private static int a_cada_semana;
    private static int semanal_dia_receber;
    private static double salary_semanal;
    private static double salario_por_hora;

    private static int horas_diarias;

    public static void setHoras_diarias(int horas_diarias) {
        Horista.horas_diarias = horas_diarias;
        if(horas_diarias>8)
        {
            salary_semanal += (horas_diarias-8)*(salario_por_hora)*1.5;
            horas_diarias = (horas_diarias-8);
            salary_semanal += (horas_diarias)*salario_por_hora;
        }
        else
        {
            salary_semanal += horas_diarias * salario_por_hora;
        }
        Horista.horas_diarias =0;
    }

    public static int getHoras_diarias() {
        return horas_diarias;
    }

    public static double getSalario_por_hora() {
        return salario_por_hora;
    }

    public static double getSalary_semanal() {
        return salary_semanal;
    }

    public static void setSalary_semanal() {
        Horista.salary_semanal = 0;
    }

    public static void setSalario_por_hora(double salario_por_hora) {
        Horista.salario_por_hora = salario_por_hora;
    }
}
