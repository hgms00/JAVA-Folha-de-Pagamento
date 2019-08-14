package commands;


public class CommandSet {
    private static Command slot;

    public static void setCommand(int Command)
    {
        if(Command==1)
            slot = new CommandAdd();
        else if(Command==2)
            slot = new CommandRemove();
        else if(Command==3)
            slot = new CommandTimecard();
        else if(Command==4)
            slot = new CommandSells();
        else if (Command==5)
            slot = new CommandServiceTax();
        else if (Command==6)
            slot = new CommandDetails();
        else if (Command==7)
            slot = new CommandPayment();
        else if (Command==8)
            slot = new CommandUndoRedo();
        else if (Command==9)
            slot = new CommandSchedule();
        else if (Command==10)
            slot = new CommandNewSchedule();
        else if(Command==11)
            slot = new CommandTime();
        else if(Command==12)
            slot = new CommandDetailsView();

        slot.execute();
    }
}
