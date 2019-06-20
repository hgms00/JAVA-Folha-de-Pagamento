public class Comissionado extends Funcionario {

     private static float percentual;
     private static double salary;
     private static double[] valor_venda = new double[31];

    public static float getPercentual() {
        return percentual;
    }

    public static void setPercentual(float percentual) {
        Comissionado.percentual = percentual;
    }

    public static double getSalary() {
        return salary;
    }

    public static void setSalary(double salary) {
        Comissionado.salary = salary;
    }
    public static void setValor_venda(double valor_venda,int dia) {
        Comissionado.valor_venda[dia] = valor_venda;
    }
}
