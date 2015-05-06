package Rainhas;

import static Interace.Principal.setText;
import java.util.Random;

public class State 
{   private int[][] board;
    private int h, g, f;
    private State parent;
    
    public State()
    {   Random gerador = new Random();
        this.board = new int[8][8];
        this.clearBoard();
        for (int j=0; j<8; j++)
            this.board[gerador.nextInt(8)][j] = -1; //Randomiza uma rainha em cada coluna (Estado inicial)
        g = 0;
        h = 0;
        parent = null;
        this.cost(); 
        f = h+g;
    }
    
    public State (State parent, int linha, int coluna)
    {   this.board = new int[8][8];
        for (int i=0; i<8; i++)
            System.arraycopy(parent.board[i], 0, this.board[i], 0, 8);
        this.clearQueen(coluna);
        this.setQueen(linha, coluna);
        this.g = parent.getG() + 1;
        h=0;
        this.cost();
        f = h+g;
        this.parent = parent;
    }
    
    //Calcula o custo (h)
    public void cost()
    {   int linha, num=0;
        
        for (int i=0; i<8; i++)
        {   linha = getQueen (i);
            for (int j=0; j<8; j++)
                if (this.board[linha][j] == -1 && j!= i) //Linha
                    h++;
        }
        //Diagonais:
        for (int j=0; j<8; j++)
        {   int aux = j;
            int i = getQueen (j);
            while (aux>0 && i>0) // --
            {   aux--;
                i--;
                if (this.board[i][aux] == -1)
                    h++;               
            }
            aux = j;
            i = getQueen (j);
            while (aux>0 && i<7) //-+
            {   aux--;
                i++;
                if (this.board[i][aux] == -1)
                    h++;               
            }
            aux = j;
            i = getQueen (j);
            while (aux<7 && i>0) //+-
            {   aux++;
                i--;
                if (this.board[i][aux] == -1)
                    h++;               
            }
            aux = j;
            i = getQueen (j);
            while (aux<7 && i<7) // ++
            {   aux++;
                i++;
                if (this.board[i][aux] == -1)
                    h++;              
            }
        }
    }
               
    public int getQueen(int coluna) //retorna a linha da rainha
    {   for (int i=0; i<8; i++)
            if (this.board[i][coluna] == -1)
                return i;
        return -1;        
    }
        
    public void setQueen(int linha, int coluna)//seta uma rainha
    {   this.board[linha][coluna] = -1;        
    }
    
    public void clearQueen(int coluna)//elimina a rainha
    {   this.board[getQueen(coluna)][coluna] = 0;   
    }
    
    public void clearBoard() //limpa o tabuleiro
    {   for (int i=0; i<8; i++)
            for (int j=0; j<8; j++)
                this.board[i][j] = 0;
    }
    
    public int getHeuristic() 
    {   return this.h;        
    }
        
    public int[][] getBoard() 
    {   return this.board;        
    }
    
    public int getG()
    {   return this.g;        
    }
    
    public int getF()
    {   return this.f;
    }
        
    public boolean inLine (int linha, int coluna) //verifica se existe mais de uma rainha em uma linha
    {   int c=0;
        
        for (int j=0; j<coluna; j++)
            if (this.board[linha][j] == -1)
                c++;
        return c>1;        
    }
    
    public int getBoardPos (int linha, int coluna)
    {   return this.board[linha][coluna];        
    }
            
    public void printBoardClimb()
    {   for (int i=0; i<8; i++)
        {   for (int j=0; j<8; j++)
                if (this.board[i][j] == -1)
                    setText ("R ");
                else
                    setText (this.board[i][j]+" ");
            setText("\n");
        }
        setText("h:"+this.h+"\n");
    }
    
    public State getParent()
    {   return this.parent;        
    }
    
    public void printBoardStar()
    {   if (this.parent != null)
            this.parent.printBoardStar();
        for (int i=0; i<8; i++)
        {   for (int j=0; j<8; j++)
                if (this.board[i][j] == -1)
                    setText ("R ");
                else
                    setText (this.board[i][j]+" ");
            setText("\n");
        }
        setText("f:"+this.f+"\n");
        setText("g:"+this.g+"\n");
        setText("h:"+this.h+"\n");
    }
}
