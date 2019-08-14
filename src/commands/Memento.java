package commands;

import main.FactoryFuncionario;

import main.*;

public class Memento
{
    FactoryFuncionario[] myObject = new FactoryFuncionario[1000];

    public FactoryFuncionario[] getState()
    {
        return myObject;
    }

    public Memento(FactoryFuncionario[] state)
    {
        for(int i=0;i<=999;i++)
        {
            if(state[i] !=null)
            {
                if(state[i] instanceof FactoryHorista) {
                    myObject[i]=new FactoryHorista();
                    ((FactoryFuncionario)CommandAdd.getEmployee()[i]).templateDoCopy(myObject[i]);
                }
                if(state[i] instanceof FactorySalariado) {
                    myObject[i]=new FactorySalariado();
                    ((FactoryFuncionario) CommandAdd.getEmployee()[i]).templateDoCopy(myObject[i]);
                }
                if(state[i] instanceof FactoryComissionado) {
                    myObject[i]=new FactoryComissionado();
                   ((FactoryFuncionario)CommandAdd.getEmployee()[i]).templateDoCopy(myObject[i]);
                }
            }
        }
    }


}