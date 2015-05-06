package Rainhas;

import static Interace.Principal.setText;
import java.util.ArrayList;

public class Astar 
{   private static ArrayList<State> open = new ArrayList<State>();
    private ArrayList<State> close = new ArrayList<State>();
    private boolean win = false;
    private int cont=0, altura=1;
   
    public void Astar(State start)
    {   State current, newState;
        
        open.clear();
        close.clear();
        open.add(start);
        while (!open.isEmpty())
        {   for (int i=0; i<8; i++)
            {   current = choiceState();
                cont++;
                if (current.getHeuristic() == 0)
                {   this.win = true;
                    current.printBoardStar();
                    setText ("Número de estados testados:"+cont+"\n");
                    while (current.getParent() != null)
                    {   current = current.getParent();
                        altura++;
                    }
                    setText ("Número de estados do caminho:"+altura+"\n");
                    return;
                }
                open.remove(current);
                close.add(current);
                for (int j=0; j<8; j++) //Expansão dos filhos
                {   newState = new State(current, j, i);
                    if (close.contains(newState))
                        continue;
                    if (!open.contains(newState))
                        open.add(newState);
                }
            }
        }
    }
    
    //Escolha do estado com menor heuristica
    private static State choiceState()
    {   State choose = open.get(0);
        
        for (int i=0; i<open.size(); i++)
            if (choose.getF() > open.get(i).getF())
                choose = open.get(i);
        return choose;        
    }
}
