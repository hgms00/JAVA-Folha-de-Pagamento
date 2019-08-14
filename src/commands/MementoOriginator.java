package commands;

import main.*;

public class MementoOriginator {
    private Memento memento;

    public void setState(Memento m) {
        this.memento = new Memento(CommandAdd.getEmployee());

    }

    public Memento save() {
        return new Memento(memento.getState());
    }

    public void restore(Memento m) {
        for(int i=0;i<=999;i++) {

            if(m.getState()[i] instanceof FactoryHorista) {
                if(CommandAdd.getEmployee()[i]==null)
                    CommandAdd.getEmployee()[i] = new FactoryHorista();
                ((FactoryFuncionario) m.getState()[i]).templateDoCopy(CommandAdd.getEmployee()[i]);
            }
            if(m.getState()[i] instanceof FactorySalariado) {
                if(CommandAdd.getEmployee()[i]==null)
                    CommandAdd.getEmployee()[i] = new FactorySalariado();
                ((FactoryFuncionario) m.getState()[i]).templateDoCopy(CommandAdd.getEmployee()[i]);
            }

            if(m.getState()[i] instanceof FactoryComissionado) {
                if(CommandAdd.getEmployee()[i]==null)
                    CommandAdd.getEmployee()[i] = new FactoryComissionado();
                ((FactoryFuncionario) m.getState()[i]).templateDoCopy(CommandAdd.getEmployee()[i]);
            }

            if(m.getState()[i] == null)
                CommandAdd.getEmployee()[i] = null;

        }

    }
}

