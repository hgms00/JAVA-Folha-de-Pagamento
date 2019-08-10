public class Comissionado extends Funcionario implements Manager {

    private static float percentual;
    private static double salary;
    private static double[] valor_venda = new double[31];
    private static double comissao = 0;

    public static void setComissao() {
        Comissionado.comissao = 0;
    }

    public static float getPercentual() {
        return percentual;
    }

    public static void setPercentual(float percentual) {
        Comissionado.percentual = percentual;
    }

    public static double getSalary() {
        return salary;
    }

    public void setSalary(double Salary){
        this.salary = Salary;
    }

    public static void setValor_venda(double valor_venda,int dia) {
        Comissionado.valor_venda[dia] += valor_venda;
        Comissionado.comissao += (percentual/100)*valor_venda;
    }

    public static double getComissao() {
        return comissao;
    }
}