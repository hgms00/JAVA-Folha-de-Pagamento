package commands;
import java.util.*;
import commands.*;
import main.*;

public class MementoCaretaker {
    private static ArrayList<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);

    }

    public static ArrayList<Memento> getMementos() {
        return mementos;
    }

    public Memento getMemento() {

        return mementos.get(mementos.size()-2);
    }
}
