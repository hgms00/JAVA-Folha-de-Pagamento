package Commands;


public class Set{
    private static Command slot;

    public void setCommand(int Command)
    {
        if(Command==1)
            slot = CommandAdd;
        else if(Command==2)
            slot = CommandRemove;
        else if(Command==3)
            slot = CommandTimecard;
        else if(Command==4)
            slot = CommandSells;
        else if (Command==5)
            slot = CommandServiceTax;
        else if (Command==6)
            slot = CommandDetails;
        else if (Command==7)
            slot = CommandPayment;
        else if (Command==8)
            slot = CommandUndoRedo;
        else if (Command==9)
            slot = CommandSchedule;
        else if (Command==10)
            slot = CommandNewSchedule;

        slot.execute();
    }
}
