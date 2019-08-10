public class Salariado extends Funcionario implements Manager {

    private static double salary;
    public static double getSalary() {
        return salary;
    }

    public void setSalary(double Salary) {
        this.salary = Salary;
    }
}