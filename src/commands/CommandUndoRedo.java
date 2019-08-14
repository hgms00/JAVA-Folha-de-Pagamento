package commands;

import java.util.*;

import commands.Memento.*;
import commands.MementoCaretaker.*;
import commands.MementoOriginator.*;
import main.Main.*;
import commands.CommandAdd;
import main.TextsandAuxs;

import static main.Main.*;


public class CommandUndoRedo implements Command{
    private static int undoredoPointer = 0;
    public static Stack<Memento> MementoStack = new Stack<>();


    public static int getUndoredoPointer() {
        return undoredoPointer;
    }

    public static void addUndoredoPointer(int i) {
        undoredoPointer += i;
    }

    public void undo()
    {
        MementoCaretaker caretaker = Singleton.getInstance();
        MementoOriginator originator = Singleton.getInstanceO();

        if(undoredoPointer<1)
        {
            System.out.println("Não há UNDOs disponíveis");
            return ;
        }
        else if (undoredoPointer==1)
        {
            TextsandAuxs.setEmployeenull();
            undoredoPointer--;
            return ;
        }

        originator.restore(caretaker.getMemento());
        undoredoPointer--;

        System.out.println("Undo realizado com sucesso");
    }
    public void redo()
    {
        if(getUndoredoPointer() == MementoCaretaker.getMementos().size() ) {
            System.out.println("Não há REDOs disponíveis");
            return;
        }
        MementoCaretaker caretaker = Singleton.getInstance();
        MementoOriginator originator = Singleton.getInstanceO();
        undoredoPointer++;

        Memento state = MementoCaretaker.getMementos().get(undoredoPointer-1);
        originator.restore(state);
        System.out.println("Redo realizado com sucesso");
    }

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
            undo();
        }
        else if (aux==2)
        {
            redo();
        }
    }

}
