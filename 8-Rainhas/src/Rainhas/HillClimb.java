package Rainhas;

import static Interace.Principal.setText;
import java.util.Random;

public class HillClimb 
{   private boolean maxGlobal;
    private State best = null;
    private int cont, contaux;
    private State bestaux = null;
    
    public void HillClimb(int iteration)
    {   State start, newState, current;
        
        for (int t=0; t<iteration; t++)
        {   maxGlobal = false;
            cont = 0;
            start = new State();
            current = start;
            cont++;
            for (int i=0; i<8; i++)
            {   for (int j=0; j<8; j++)
                {   cont++;
                    if (current.getHeuristic()== 0)
                    {   if (best == null)
                        {   best = current;
                            contaux = cont;
                            bestaux = start;
                        }
                        else
                        {   if (contaux > cont)
                            {   best = current;
                                contaux = cont;
                                bestaux = start;
                            }
                        }
                        maxGlobal = true;
                        break;
                    }
                    newState = new State (current, j, i);
                    if (current.getHeuristic()> newState.getHeuristic()) //Escolhe o com menor heuristica
                        current = newState;
                    else
                        if (current.getHeuristic() == newState.getHeuristic()) // Se forem iguais: random
                        {   Random random = new Random();
                            int moeda = random.nextInt(1);
                            if (moeda == 0)
                                current = newState;                                                       
                        }
                }
                if (maxGlobal)
                    break;
            }
        }
        if (best != null)    
        {   setText ("Estado inicial:"+"\n");
            bestaux.printBoardClimb();
            best.printBoardClimb();
            setText ("Número de estados testados:"+contaux+"\n");
        }
        else
            setText ("Não foi possível chegar ao estado final\nao longo de "+iteration+" iteraçoes.\n");
    }    
}
