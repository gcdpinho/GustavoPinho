/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZombieGameOfLife;

import javax.swing.JOptionPane;

/**
 * Classe responsável pela aplicação das regras do jogo, e é a classe que "se
 * dividirá" dentre as threads.
 * 
 * @author gustavopinho
 */
public class GameRules implements Runnable
{   
    private Grid gridOutput; 
    private static Grid gridInput;
    private int iInitial, iFinale;
    private static int size;
    private ZombieGameOfLife game;
    
    /**
     * Método construtor.
     * 
     * @param size int - Corresponde ao tamanho do grid.
     * 
     * @param iInitial int - Corresponde a linha que começará a ser analisada.
     * 
     * @param iFinale int - Corresponde a linha em que terminará a análise.
     * 
     * @param gridInput Grid - Corresponde ao grid de entrada que será analisado
     * para o cálculo da nova geração.
     * 
     * @param game ZombieGameOfLife - Corresponde ao objeto responsável por
     * criar uma instância dessa clase. A utilização dessa parâmetro é para,
     * através desse objeto, modificar o gridOutput do "pai" (game).
     */
    public GameRules(int size, int iInitial, int iFinale, Grid gridInput, ZombieGameOfLife game)
    {   
        GameRules.size = size;
        try
        {   this.gridOutput = new Grid(size);
        }
        catch (OutOfMemoryError e)
        {   JOptionPane.showMessageDialog(null, "Não há mais espaço na memória!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);            
        }
        this.iInitial = iInitial;
        this.iFinale = iFinale;
        GameRules.gridInput = gridInput;
        this.game = game;
    }
    
    /**
     * Método reponsável por aplicar as oito regras no grid de entrada, e com o 
     * auxílio do método countNeighbors, constrói a próxima geração.
     * 
     * @param i int - Corresponde à linha do grid.
     * 
     * @param j int - Corresponde à coluna do grid.
     */
    public void applyRules(int i, int j)
    {   
        int count[] = new int[2], type = gridInput.getGrid(i, j);
        
        count = countNeighbors(i, j);
        
        if (type == 1)
        {   if (count[0] < 2)
                this.gridOutput.setGrid(i, j, 0); // Morre de solidão (regra 1).
            else
                if (count[0] > 3)
                    this.gridOutput.setGrid(i, j, 0); // Morre de superpopulação (regra 2).
                else    
                    if (count[0]==2 || count[0]==3)
                        this.gridOutput.setGrid(i, j, type); // Mantém o estado (vivo) (regra 4).
            if (count[1] > 0)
                this.gridOutput.setGrid(i, j, 2); // Vira zumbi (regra 5).
            if (count[0] == 8)
                this.gridOutput.setGrid(i, j, 2); // Vira zumbi (regra 6).
        }
        else
        {   if (type == 0)
            {   if (count[0] == 3)
                    this.gridOutput.setGrid(i, j, 1);
            }
            else
                if (type == 2)
                {   if (count[0] == 0)
                        this.gridOutput.setGrid(i, j, 0); // Morre por não ter vizinhos (regra 7).
                    else
                        if (count[0] > 0)
                            this.gridOutput.setGrid(i, j, type); // Mantém estado (zumbi) (regra 8).                  
                } 
        }
    }
    
    /**
     * Método responsável pela contagem dos vizinhos vivos e vizinhos zumbis.
     * 
     * @param i int - Corresponde à linha do grid.
     * 
     * @param j int - Corresponde à coluna do grid.
     *  
     * @return int[] - Retorna um vetor de duas posições que contém o contador
     * de vizinhos vivos e o contador de vizinhos zumbis, respectivamente.
     */
    private static int[] countNeighbors(int i, int j)
    {        
        int countNeighbors = 0, countZumbi = 0, count[] = new int[2];
        
        // Canto superior esquerdo
        if (i==0 && j==0) 
        {   if (gridInput.getGrid(i+1, j)==1)
                countNeighbors++;
            else
                if (gridInput.getGrid(i+1, j)==2)
                    countZumbi++;
            if (gridInput.getGrid(i, j+1)==1)
                countNeighbors++;
            else
                if (gridInput.getGrid(i, j+1)==2)
                    countZumbi++;
            if (gridInput.getGrid(i+1, j+1)==1)
                countNeighbors++;
            else
                if (gridInput.getGrid(i+1, j+1)==2)
                    countZumbi++;
        }
        else // Canto inferior direito
            if (i==size-1 && j==size-1) 
            {   if (gridInput.getGrid(i-1, j)==1)
                    countNeighbors++;
                else
                    if (gridInput.getGrid(i-1, j)==2)
                        countZumbi++;
                if (gridInput.getGrid(i, j-1)==1)
                    countNeighbors++;
                else
                    if (gridInput.getGrid(i, j-1)==2)
                        countZumbi++;
                if (gridInput.getGrid(i-1, j-1)==1)
                    countNeighbors++;
                else
                    if (gridInput.getGrid(i-1, j-1)==2)
                        countZumbi++;
            }
            else // Canto superior direito
                if (i==0 && j==size-1) 
                {   if (gridInput.getGrid(i+1, j)==1)
                        countNeighbors++;
                    else
                        if (gridInput.getGrid(i+1, j)==2)
                            countZumbi++;
                    if (gridInput.getGrid(i, j-1)==1)
                        countNeighbors++;
                    else
                        if (gridInput.getGrid(i, j-1)==2)
                            countZumbi++;
                    if (gridInput.getGrid(i+1, j-1)==1)
                        countNeighbors++;
                    else
                        if (gridInput.getGrid(i+1, j-1)==2)
                            countZumbi++;
                }
                else // Canto inferior esquerdo
                    if (i==size-1 && j==0) 
                    {   if (gridInput.getGrid(i-1, j)==1)
                            countNeighbors++;
                        else
                            if (gridInput.getGrid(i-1, j)==2)
                                countZumbi++;
                        if (gridInput.getGrid(i, j+1)==1)
                            countNeighbors++;
                        else
                            if (gridInput.getGrid(i, j+1)==2)
                                countZumbi++;
                        if (gridInput.getGrid(i-1, j+1)==1)
                            countNeighbors++;
                        else
                            if (gridInput.getGrid(i-1, j+1)==2)
                                countZumbi++;
                    }
                    else // Parte superior
                        if (i==0 && (j>0 && j<size-1)) 
                        {   if (gridInput.getGrid(i+1, j)==1)
                                countNeighbors++;
                            else
                                if (gridInput.getGrid(i+1, j)==2)
                                    countZumbi++;
                            if (gridInput.getGrid(i, j-1)==1)
                                countNeighbors++;
                            else
                                if (gridInput.getGrid(i, j-1)==2)
                                    countZumbi++;
                            if (gridInput.getGrid(i, j+1)==1)
                                countNeighbors++;
                            else
                                if (gridInput.getGrid(i, j+1)==2)
                                    countZumbi++;
                            if (gridInput.getGrid(i+1, j-1)==1)
                                countNeighbors++;
                            else
                                if (gridInput.getGrid(i+1, j-1)==2)
                                    countZumbi++;
                            if (gridInput.getGrid(i+1,j+1)==1)
                                countNeighbors++;
                            else
                                if (gridInput.getGrid(i+1, j+1)==2)
                                    countZumbi++;
                        }
                        else // Parte inferior
                            if (i==size-1 && (j>0 && j<size-1)) 
                            {   if (gridInput.getGrid(i-1, j)==1)
                                    countNeighbors++;
                                else
                                    if (gridInput.getGrid(i-1, j)==2)
                                        countZumbi++;
                                if (gridInput.getGrid(i, j-1)==1)
                                    countNeighbors++;
                                else
                                    if (gridInput.getGrid(i, j-1)==2)
                                        countZumbi++;
                                if (gridInput.getGrid(i, j+1)==1)
                                    countNeighbors++;
                                else
                                    if (gridInput.getGrid(i, j+1)==2)
                                        countZumbi++;
                                if (gridInput.getGrid(i-1, j-1)==1)
                                    countNeighbors++;
                                else
                                    if (gridInput.getGrid(i-1, j-1)==2)
                                        countZumbi++;
                                if (gridInput.getGrid(i-1, j+1)==1)
                                    countNeighbors++;
                                else
                                    if (gridInput.getGrid(i-1, j+1)==2)
                                        countZumbi++;
                            }
                            else // Lado esquerdo
                                if ((i>0 && i<size-1) && j==0) 
                                {   if (gridInput.getGrid(i-1, j)==1)
                                        countNeighbors++;
                                    else
                                        if (gridInput.getGrid(i-1, j)==2)
                                            countZumbi++;
                                    if (gridInput.getGrid(i+1, j)==1)
                                        countNeighbors++;
                                    else
                                        if (gridInput.getGrid(i+1, j)==2)
                                            countZumbi++;
                                    if (gridInput.getGrid(i, j+1)==1)
                                        countNeighbors++;
                                    else
                                        if (gridInput.getGrid(i, j+1)==2)
                                            countZumbi++;
                                    if (gridInput.getGrid(i-1, j+1)==1)
                                        countNeighbors++;
                                    else
                                        if (gridInput.getGrid(i-1, j+1)==2)
                                            countZumbi++;
                                    if (gridInput.getGrid(i+1, j+1)==1)
                                        countNeighbors++;
                                    else
                                        if (gridInput.getGrid(i+1, j+1)==2)
                                            countZumbi++;
                                }
                                else // Lado direito
                                    if ((i>0 && i<size-1) && j==size-1) 
                                    {   if (gridInput.getGrid(i-1, j)==1)
                                            countNeighbors++;
                                        else
                                            if (gridInput.getGrid(i-1, j)==2)
                                                countZumbi++;
                                        if (gridInput.getGrid(i+1, j)==1)
                                            countNeighbors++;
                                        else
                                            if (gridInput.getGrid(i+1, j)==2)
                                                countZumbi++;
                                        if (gridInput.getGrid(i, j-1)==1)
                                            countNeighbors++;
                                        else
                                            if (gridInput.getGrid(i, j-1)==2)
                                                countZumbi++;
                                        if (gridInput.getGrid(i-1, j-1)==1)
                                            countNeighbors++;
                                        else
                                            if (gridInput.getGrid(i-1, j-1)==2)
                                                countZumbi++;
                                        if (gridInput.getGrid(i+1, j-1)==1)
                                            countNeighbors++;
                                        else
                                            if (gridInput.getGrid(i+1, j-1)==2)
                                                countZumbi++;
                                    }
                                    else // Centro (demais posições)
                                        if ((i>0 && i<size-1) && (j>0 && j<size-1)) 
                                        {   if (gridInput.getGrid(i-1, j)==1)
                                                countNeighbors++;
                                            else
                                                if (gridInput.getGrid(i-1, j)==2)
                                                    countZumbi++;
                                            if (gridInput.getGrid(i+1, j)==1)
                                                countNeighbors++;
                                            else
                                                if (gridInput.getGrid(i+1, j)==2)
                                                    countZumbi++;
                                            if (gridInput.getGrid(i, j-1)==1)
                                                countNeighbors++;
                                            else
                                                if (gridInput.getGrid(i, j-1)==2)
                                                    countZumbi++;
                                            if (gridInput.getGrid(i, j+1)==1)
                                                countNeighbors++;
                                            else
                                                if (gridInput.getGrid(i, j+1)==2)
                                                    countZumbi++;
                                            if (gridInput.getGrid(i-1, j-1)==1)
                                                countNeighbors++;
                                            else
                                                if (gridInput.getGrid(i-1, j-1)==2)
                                                    countZumbi++;
                                            if (gridInput.getGrid(i-1, j+1)==1)
                                                countNeighbors++;
                                            else
                                                if (gridInput.getGrid(i-1, j+1)==2)
                                                    countZumbi++;
                                            if (gridInput.getGrid(i+1, j-1)==1)
                                                countNeighbors++;
                                            else
                                                if (gridInput.getGrid(i+1, j-1)==2)
                                                    countZumbi++;
                                            if (gridInput.getGrid(i+1, j+1)==1)
                                                countNeighbors++;
                                            else
                                                if (gridInput.getGrid(i+1, j+1)==2)
                                                    countZumbi++;
                                        }
        count[0] = countNeighbors;
        count[1] = countZumbi;
        
        return count;        
    }
    
    /**
     * Método getter, responsável por retornar o atributo gridOutput.
     * 
     * @return Grid - Corresponde ao grid após a aplicação das regras.
     */
    public Grid getGridOutput()
    {   
        return this.gridOutput;
    }
    
    /**
     * Método responsável por chamar o método que aplica as regras dividas entre
     * as threads; por isso a utilização dos parâmetros iInitial e iFinale.
     */
    @Override
    public void run()
    {   
        for (int i=this.iInitial; i<this.iFinale; i++)
            for (int j=0; j<size; j++)
                this.applyRules(i, j);
        // "Passa" para o pai (game) o grid resultante
        for (int i=this.iInitial; i<this.iFinale; i++)
            for (int j=0; j<size; j++)
                game.setGridOutput(i, j, this.gridOutput.getGrid(i, j));
    }
    
}
