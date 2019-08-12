package commands;

import java.util.*;
import main.Main.*;
import commands.CommandAdd;

import static main.Main.*;

public class CommandUndoRedo implements Command{
    public void execute()
    {
        int aux;
        Scanner input = new Scanner(System.in);

        System.out.println("O que você deseja fazer?");
        System.out.println("1 --> UNDO");
        System.out.println("2 --> REDO");
        aux = main.TryCatch.undoredoTry();

        if (aux==1)
        {
            undo(main.Main.getBackup(),CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        }
        else if (aux==2)
        {
            redo(main.Main.getBackup(),CommandAdd.getQt_funcionario(),CommandAdd.getEmployee());
        }
    }

}
