public class Funcionario {

    private static String[] name;
    private static String[] adress;
    private static int ID;
    private static double salary;
    private static int type;

    /* 1 --> horista
       2 --> salaried
       3 --> commisioned
     */

    public void setName(String name)
    {
        this.name=name;
    }
    public void getName(int id)
    {
        return name;
    }

    public void setAdress(String name)
    {
        this.adress=adress;
    }
    public void getAdress(int id)
    {
        return adress;
    }

    public void setSalary(double salary)
    {
        this.salary=salary;
    }
    public void getSalary()
    {
        return salary;
    }

    public void pagarEmpregado()
    {

    }

    public void getID()
    {
        return ID;
    }
    public void setID(int id)
    {
        this.ID=id;
    }
    public void setType(int type)
    {
        this.type=type;
    }


}
