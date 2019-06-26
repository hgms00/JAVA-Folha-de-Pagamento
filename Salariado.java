
public class Salariado extends Funcionario {

    private static double salary;

    public static double getSalary() {
        return salary;
    }

    public static void setSalary(double salary) {
        Salariado.salary = salary;
    }
}
