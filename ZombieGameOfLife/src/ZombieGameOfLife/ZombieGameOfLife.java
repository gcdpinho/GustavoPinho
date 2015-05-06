/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZombieGameOfLife;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela criação do grid inicial e o gerenciamento das 
 * gerações construídas, assim como da divisão dentre os threads.
 * 
 * @author gustavopinho
 */
public class ZombieGameOfLife 
{   
    private Grid gridInput, gridOutput;
    private int size, iteration, numberThreads;
    
    /**
     * Método construtor, com número de threads igual ao número de núcleos do
     * processador.
     * 
     * @param size int - Corresponde ao tamanho do grid.
     * 
     * @param iteration int - Corresponde ao número de iterações que serão
     * calculadas.
     */
    public ZombieGameOfLife(int size, int iteration)
    {   
        Runtime runTime = Runtime.getRuntime();
        
        this.size = size;
        this.iteration = iteration;
        this.gridInput = new Grid(this.size); 
        this.gridOutput = new Grid(this.size);
        this.numberThreads = runTime.availableProcessors();
    }
    
    /**
     * Método construtor com número de threads setado pelo usuário.
     * 
     * @param size int - Corresponde ao tamanho do grid.
     * 
     * @param iteration int - Corresponde ao número de iterações que serão
     * calculadas.
     * 
     * @param numberThreads int - Corresponde ao número de threads que serão
     * utilizados.
     */
    public ZombieGameOfLife(int size, int iteration, int numberThreads)
    {          
        this.size = size;
        this.iteration = iteration;
        this.gridInput = new Grid(this.size); 
        this.gridOutput = new Grid(this.size);
        this.numberThreads = numberThreads;
    }
    
    /**
     * Método responsável pela criação do grid inicial.
     * 
     * @param roadFile String - Corresponde ao caminho do arquivo de entrada.
     */    
    public void buildGrid(String roadFile)
    {   
        ArrayList<Integer> inputArray;
        FileIO input = new FileIO();
        
        inputArray = input.readFile(roadFile);
        try
        {   for (int i=0; i<inputArray.size(); i+=3)
                this.gridInput.setGrid(inputArray.get(i), inputArray.get(i+1),inputArray.get(i+2));      
        }
        catch (IndexOutOfBoundsException e)
        {   JOptionPane.showMessageDialog(null, "O arquivo de configuração possui entradas inválidas!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);       
        }
    }
    
    /**
     * Método responsável por criar uma nova geração baseado no atributo
     * gridInput, dividindo dentre o número de threads definidos.
     */
    public void createNewGeneration()
    {   
        ExecutorService thread = Executors.newCachedThreadPool();
        int piece, initial=0, finale=0;
        
        if (this.numberThreads > 1)
        {   piece = this.size/this.numberThreads;
            for (int i=0; i<this.numberThreads; i++)
            {   finale += piece;
                if (finale < this.size && i == this.numberThreads-1)
                    finale = this.size;
                try
                {   thread.execute(new GameRules(this.size, initial, finale, gridInput, this));
                }
                catch (OutOfMemoryError e)
                {   JOptionPane.showMessageDialog(null, "Não há mais espaço na memória!", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(1);            
                }
                initial+= piece;    
            }
        }
        else
            thread.execute(new GameRules( this.size, 0, this.size, gridInput, this));
        
        thread.shutdown();        
        try 
        {   thread.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } 
        catch (InterruptedException e)
        {   JOptionPane.showMessageDialog(null, "Tempo de execução do thread esgotado!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    /**
     * Método setter, responsável por atribuir valor ao atributo gridOutput.
     * 
     * @param i int - Corresponde à linha do grid.
     * 
     * @param j int - Corresponde à coluna do grid.
     * 
     * @param type int - Corresponde ao tipo da célula (0-morto 1-vivo 2-zumbi).
     */
    public void setGridOutput(int i, int j, int type)
    {
        this.gridOutput.setGrid(i, j, type);
    }
    
    /**
     * Método getter, responsável por retornar o atributo gridOutput.
     * 
     * @return Grid - Corresponde ao grid após a geração ser processada.
     */
    public Grid getGridOutput()
    {
        return this.gridOutput;
    }
    
    /**
     * Método setter, responsável por atribuir valor ao atributo gridInput.
     * 
     * @param i int - Corresponde à linha do grid.
     * 
     * @param j int - Corresponde à coluna do grid.
     * 
     * @param type int - Corresponde ao tipo da célula (0-morto 1-vivo 2-zumbi).
     */
    public void setGridInput(int i, int j, int type)
    {
        this.gridInput.setGrid(i, j, type);
    }
    
    /**
     * Método getter, responsável por retornar o atributo gridInput.
     * 
     * @return Grid - Corresponde ao grid inicial, que será utilizado para o
     * processo de geração.
     */
    public Grid getGridInput()
    {
        return this.gridInput;
    }
    
}
