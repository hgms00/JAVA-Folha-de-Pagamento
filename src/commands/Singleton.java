package commands;

public class Singleton{
    private static MementoCaretaker caretaker ;
    private static MementoOriginator originator;
    private static Memento memento;

    public static MementoCaretaker getInstance()
    {
        if(caretaker == null)
            caretaker = new MementoCaretaker();

        return caretaker;
    }

    public static MementoOriginator getInstanceO()
    {
        if(originator == null)
            originator = new MementoOriginator();

        return originator;
    }

    public static Memento getInstanceM()
    {
        if(memento == null)
            memento = new Memento(CommandAdd.getEmployee());

        return memento;
    }

}
