
package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class Minimax 
{   protected Board current;
    protected Board best;
    protected int player, totalPlayes;
    protected boolean stop;
    protected ArrayList <Board> suc;
    
    public Minimax(int player, Board board, int totalPlayes)
    {   this.current = new Board(board);
        this.best = null;
        this.player = player;
        this.stop = false;
        this.suc = new ArrayList();
        this.totalPlayes = totalPlayes;
    }
    
    public Board getBest()
    {   return best;        
    }        
    
    public int getPlayer()
    {   return this.player;
    }
        
    public boolean getStop()
    {   return this.stop;        
    }
    
    public void getRoute()
    {   for (Board aux = this.best; aux != null; aux = aux.getParent())
            if (aux.getCost() != 999999)    
                aux.imprimeBoard();
        //this.best.imprimeBoard();
    }
    
    public void setStop()
    {   this.stop = true;        
    }
    
    public void changePlayer()
    {   if (this.player == 1)
            this.player = 2;
        else
            this.player = 1;
    }
    
    public void methodMinimax()
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
                aux.cost(this.player,1);
                aux.setParent(this.current);
                suc.add (aux);
            }
            aux = new Board (this.current);
            if (aux.priority(player))
            {   aux.setParent(this.current);
                suc.add(aux);
            }
            
        }
        choiceSuc();
        changePlayer();
        totalPlayes++;
                    
    }

    public void choiceSuc()
    {   Random random = new Random();
        int num;
        
        this.best = this.suc.get(0);
        for (int i=0; i<suc.size(); i++)
        {   if (this.player == 1)
            {   if (this.best.getCost() < this.suc.get(i).getCost())
                    this.best = this.suc.get(i);
                else
                    if (this.best.getCost() == this.suc.get(i).getCost())
                    {   num = random.nextInt(2);
                        if (num == 1)
                            this.best = this.suc.get(i);
                    }
            }
            else
                if (this.best.getCost() > this.suc.get(i).getCost())
                    this.best = this.suc.get(i);
                else
                    if (this.best.getCost() == this.suc.get(i).getCost())
                    {   num = random.nextInt(2);
                        if (num == 1)
                            this.best = this.suc.get(i);
                    }
        }        
    }
}
