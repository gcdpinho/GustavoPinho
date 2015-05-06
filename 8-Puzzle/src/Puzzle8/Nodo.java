package Puzzle8;

import static Interface.TelaInicial.setLabel;
import java.util.ArrayList;
import java.util.Random;

public class Nodo
{   private int[] vetor;
    private Nodo pai;
    

    public Nodo (int e0, int e1, int e2, int e3, int e4, int e5, int e6, int e7, int e8)
    {   this.vetor = new int[9];
        pai = null;
    
        this.vetor[0] = e0;
        this.vetor[1] = e1;
        this.vetor[2] = e2;
        this.vetor[3] = e3;
        this.vetor[4] = e4;
        this.vetor[5] = e5;
        this.vetor[6] = e6;
        this.vetor[7] = e7;
        this.vetor[8] = e8;  
    }
    
    public Nodo (int[] novo)
    {   this.vetor = new int[9];
        pai = null;
    
        System.arraycopy(novo, 0, this.vetor, 0, 9);  
    }
    
    public Nodo ()
    {   Random rand = new Random();
        int[] controle = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        this.vetor = new int[9];
        int aux, t=0;
        boolean flag;
        
        for (int i=0; i<9; i++)
        {   do {    flag = false;
                    aux = rand.nextInt(9);
                    for (int j=0; j<9; j++)
                        if (controle[j] == aux)
                            flag = true;             
                } while (flag == true);
            controle[t] = aux;
            t++;
            this.vetor[i] = aux;
        } 
    }
    
    public int[] getVetor ()
    {   return this.vetor;        
    }
    
    public int getVetorPos (int pos)
    {   return this.vetor[pos];
    }
    
    public void setVetor (int[] novo)
    {   System.arraycopy(novo, 0, this.vetor, 0, 9);
    }
        
    public void setVetorPos (int pos, int num)
    {   this.vetor[pos] = num;     
    }
    
    public Nodo getPai ()
    {   return this.pai;    
    }
    
    public void setPai (Nodo no)
    {   this.pai = no;     
    }
    
    public void imprimeVetor (ArrayList <int[]> caminho)
    {   if (this.pai != null)
            this.pai.imprimeVetor(caminho);
        
        for (int i=0; i<9; i++)
        {   setLabel (Integer.toString(this.vetor[i]));
            if (i == 2 || i == 5)
                setLabel ("\n"); 
        }
        setLabel ("\n\n");  
        caminho.add (this.vetor);
    }
}
