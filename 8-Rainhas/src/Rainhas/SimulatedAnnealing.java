package Rainhas;

import static Interace.Principal.setText;
import java.util.Random;

public class SimulatedAnnealing 
{   private int cont=0;
    private double deltaE, p, T;
    
    public void SimulatedAnnealing(State start)
    {   State current, newState;
        Random random = new Random();
        double aux;
         
        current = start;
        T = current.getHeuristic();
        cont++;
        while (T != 0)
        {   newState = new State (current, random.nextInt(8), random.nextInt(8));
            deltaE = newState.getHeuristic() - current.getHeuristic();
            if (deltaE <= 0)
            {   current = newState;
                cont++;
            }
            else //probabilidade de acontecer (retrocesso)
            {   p = Math.pow(Math.E, (-deltaE / T));
                aux = (double) (Math.abs(random.nextDouble()) %1);
                if (p > aux)
                {   current = newState;
                    cont++;
                }
            }
            T = current.getHeuristic();
        }
        current.printBoardClimb();
        setText ("Número de estados testados:"+cont+"\n");
    }
    
}
