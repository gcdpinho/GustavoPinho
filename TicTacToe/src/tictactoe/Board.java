package tictactoe;

import static graphicinterface.FormMain.setText;

public class Board 
{   private char[] board;
    private int cost;
    private Board parent;

    public Board()
    {   this.board = new char[9];
        for (int i=0; i<9; i++)
            this.board[i] = ' ';
        this.cost = 999999;
        this.parent = null; 
    }
    
    public Board(Board parent)
    {   this.board = new char[9];
        for (int i=0; i<9; i++)
            this.board[i] = parent.getChar(i);
        this.cost = 999999;
        this.parent = parent;
    }
    
    public int getCost()
    {   return this.cost;
    }
    
    public char getChar(int index)
    {   return this.board[index];
    }
    
    public Board getParent()
    {   return this.parent;     
    }
    
    public void setParent(Board parent)
    {   this.parent = parent;        
    }
    
    public int getPlayer()
    {   int countNeighborsX=0, countNeighborsO=0;
        
        for (int i=0; i<9; i++)
            if (this.board[i] == 'X')
                countNeighborsX++;
            else
                if (this.board[i] == 'O')
                    countNeighborsO++;
        if (countNeighborsX > countNeighborsO)
            return 1;
        else
            return 2;
            
    }
    
    public boolean checkWinner()
    {   int index=0;
   
        for (int i=0; i<3; i++)
        {   //Verifica as linhas
            if (this.board[index] == this.board[index+1] && this.board[index] == this.board[index+2] && this.board[index] != ' ')
                return true;
            //Verifica as colunas
            if (this.board[i] == this.board[i+3] && this.board[i] == this.board[i+6] && this.board[i] != ' ')
                return true;
            index += 3;
        }
        //Verifica Diagonal Principal
        if (this.board[0] == this.board[4] && this.board[0] == this.board[8] && this.board[0] != ' ')
            return true;
        //Verifica Diagonal Secundária
        if (this.board[2] == this.board[4] && this.board[2] == this.board[6] && this.board[2] != ' ')
            return true;
        
        return false;    
    }
    
    private boolean checkBoard(int index, boolean stop)
    {   return (this.board[index] == ' ' && !stop);            
    }
       
    public boolean changeBoard(int index, int player, boolean stop)
    {   if (player == 1)
        {   if (checkBoard(index, stop))
            {   this.board[index] = 'X';
                return true;
            }
        }
        else
            if (checkBoard(index, stop))
            {   this.board[index] = 'O';
                return true;
            }
        return false;
    }
    
    public void cost(int player, int mod)
    {   int costPlayer1=0, costPlayer2=0, index=0;
        
        for (int i=0; i<3; i++)
        {   //Verifica as linhas
            if (this.board[index+1] != 'O' && this.board[index+2] != 'O' && this.board[index] != 'O')
                costPlayer1++;
            if (this.board[index+1] != 'X' && this.board[index+2] != 'X' && this.board[index] != 'X')
                costPlayer2++;
            //Verifica as colunas
            if (this.board[i+3] != 'O' && this.board[i+6] != 'O' && this.board[i] != 'O')
                costPlayer1++;
            if (this.board[i+3] != 'X' && this.board[i+6] != 'X' && this.board[i] != 'X')
                costPlayer2++;
            index += 3;
        }
        //Verifica Diagonal Principal
        if (this.board[4] != 'O' && this.board[8] != 'O' && this.board[0] != 'O')
            costPlayer1++;
        if (this.board[4] != 'X' && this.board[8] != 'X' && this.board[0] != 'X')
            costPlayer2++;
        //Verifica Diagonal Secundária
        if (this.board[4] != 'O' && this.board[6] != 'O' && this.board[2] != 'O')
            costPlayer1++;
        if (this.board[4] != 'X' && this.board[6] != 'X' && this.board[2] != 'X')
            costPlayer2++;
        if (mod == 1)
            this.cost = costPlayer1 - costPlayer2;
        else
            if (player == 1)
                this.cost = costPlayer1 - costPlayer2;
            else
                this.cost = costPlayer2 - costPlayer1;
    }

    public boolean priority(int player)
    {   int index =0;
        
        for (int i=0; i<3; i++)
        {   //Verifica as linhas
            if ((this.board[index] == this.board[index+1] && this.board[index] == 'X') || (this.board[index] == this.board[index+2] && this.board[index] == 'X') || (this.board[index+1] == this.board[index+2] && this.board[index+1] == 'X'))
            {   if (changeBoard(index, player, false))
                    if (player == 2)
                    {   this.cost = -9999;
                        return true;
                    }
                if (changeBoard(index+1, player, false))
                    if (player == 2)
                    {   this.cost = -9999;
                        return true;
                    }
                if  (changeBoard(index+2, player, false))
                    if (player == 2)
                    {   this.cost = -9999;
                        return true;
                    }
            }
            if ((this.board[index] == this.board[index+1] && this.board[index] == 'O') || (this.board[index] == this.board[index+2] && this.board[index] == 'O') || (this.board[index+1] == this.board[index+2] && this.board[index+1] == 'O'))
            {   if (changeBoard(index, player, false))
                    if (player == 1)
                    {   this.cost = 9999;
                        return true;
                    }
                if (changeBoard(index+1, player, false))
                     if (player == 1)
                    {   this.cost = 9999;
                        return true;
                    }
                if (changeBoard(index+2, player, false))
                     if (player == 1)
                    {   this.cost = 9999;
                        return true;
                    }
            }
            //Verifica as colunas
            if ((this.board[i] == this.board[i+3] && this.board[i] == 'X') || (this.board[i] == this.board[i+6] && this.board[i] == 'X') || (this.board[i+3] == this.board[i+6] && this.board[i+3] == 'X'))
            {   if (changeBoard(i, player, false))
                    if (player == 2)
                    {   this.cost = -9999;
                        return true;
                    }
                if (changeBoard(i+3, player, false))
                    if (player == 2)
                    {   this.cost = -9999;
                        return true;
                    }
                if (changeBoard(i+6, player, false))
                    if (player == 2)
                    {   this.cost = -9999;
                        return true;
                    }
            }
            if ((this.board[i] == this.board[i+3] && this.board[i] == 'O') || (this.board[i] == this.board[i+6] && this.board[i] == 'O') || (this.board[i+3] == this.board[i+6] && this.board[i+3] == 'O'))
            {   if (changeBoard(i, player, false))
                    if (player == 1)
                    {   this.cost = 9999;
                        return true;
                    }
                if (changeBoard(i+3, player, false))
                    if (player == 1)
                    {   this.cost = 9999;
                        return true;
                    }
                if (changeBoard(i+6, player, false))
                    if (player == 1)
                    {   this.cost = 9999;
                        return true;
                    }
            }
            index += 3;
        }
        //Verifica Diagonal Principal
        if ((this.board[0] == this.board[4] && this.board[0] == 'X') || (this.board[0] == this.board[8] && this.board[0] == 'X') || (this.board[4] == this.board[8] && this.board[4] == 'X'))
        {   if (changeBoard(0, player, false))
                if (player == 2)
                {   this.cost = -9999;
                    return true;
                }
             if (changeBoard(4, player, false))
                 if (player == 2)
                {   this.cost = -9999;
                    return true;
                }
             if (changeBoard(8, player, false))
                 if (player == 2)
                {   this.cost = -9999;
                    return true;
                }
        }   
         if ((this.board[0] == this.board[4] && this.board[0] == 'O') || (this.board[0] == this.board[8] && this.board[0] == 'O') || (this.board[4] == this.board[8] && this.board[4] == 'O'))
        {   if (changeBoard(0, player, false))
                if (player == 1)
                {   this.cost = 9999;
                    return true;
                }
            if (changeBoard(4, player, false))
                 if (player == 1)
                {   this.cost = 9999;
                    return true;
                }
             if (changeBoard(8, player, false))
                 if (player == 1)
                {   this.cost = 9999;
                    return true;
                }
        }
        //Verifica Diagonal Secundária
        if ((this.board[2] == this.board[4] && this.board[2] == 'X') || (this.board[2] == this.board[6] && this.board[2] == 'X') || (this.board[4] == this.board[6] && this.board[4] == 'X'))
        {   if (changeBoard(2, player, false))
                if (player == 2)
                {   this.cost = -9999;
                    return true;
                }
            if (changeBoard(4, player, false))
                if (player == 2)
                {   this.cost = -9999;
                    return true;
                }
            if (changeBoard(6, player, false))
                if (player == 2)
                {   this.cost = -9999;
                    return true;
                }
        }
        if ((this.board[2] == this.board[4] && this.board[2] == 'O') || (this.board[2] == this.board[6] && this.board[2] == 'O') || (this.board[4] == this.board[6] && this.board[4] == 'O'))
        {   if (changeBoard(2, player, false))
                if (player == 1)
                {   this.cost = 9999;
                    return true;
                }
            if (changeBoard(4, player, false))
                if (player == 1)
                {   this.cost = 9999;
                    return true;
                }
            if (changeBoard(6, player, false))
                if (player == 1)
                {   this.cost = 9999;
                    return true;
                }
        }
        return false;
    }
    
    public void imprimeBoard()
    {   for (int i=0; i<9; i++)
        {   if (this.board[i] != ' ') 
                setText (this.board[i]+" ");
            else
                setText ("- ");
            if (i == 2 || i == 5)
                setText("\n");                
        }
        setText ("\n\n");        
    }
}
