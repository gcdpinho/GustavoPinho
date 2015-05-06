
package tictactoe;

import java.util.ArrayList;

public class PhodaAlfaBeta extends Minimax
{   private ArrayList <Board> phoda;

    public PhodaAlfaBeta(int player, Board board, int totalPlayes) 
    {   super(player, board, totalPlayes);
        phoda = new ArrayList();
    }
    
    public void methodPhodaAlfaBeta()
    {   Board aux;
                
        if (this.stop)
            return;
        suc.clear();
        for (int i=0; i<9; i++)
        {   aux = new Board (this.current);
            if (aux.checkWinner())
            {   this.best = aux;
                this.stop = true;
                return;
            } 
            if (aux.changeBoard(i, this.player, this.stop))
            {   if (aux.checkWinner())
                {   this.best = aux;
                    this.stop = true;
                    return;
                }            
                aux.cost(this.player,2);
                aux.setParent(this.current);    
                if (!phodaAlfaBeta(this.player, aux, aux.getCost()))
                    suc.add (aux);
            }
            aux = new Board (this.current);
            if (aux.priority(player))
            {   aux.setParent(this.current);
                if (!phodaAlfaBeta(this.player, aux, aux.getCost()))
                    suc.add (aux);
            }
        }
        choiceSuc();
        changePlayer();
        totalPlayes++;        
    }

    private boolean phodaAlfaBeta(int player, Board board, int cost)
    {   int costaux;
        
        for (Board aux = board; aux != null; aux = aux.getParent())
        {   if ((costaux = aux.getCost()) != 999999)
                if (player == 1)
                {   if (aux.getCost() <= 0)
                        if (cost < costaux)
                            return true;
                }
                else
                    if (aux.getCost() >= 0)    
                        if (cost > costaux)
                            return true;
        }
        return false;
    }

}
