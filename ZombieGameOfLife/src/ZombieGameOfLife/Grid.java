/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZombieGameOfLife;

import static Interface.Interface.setText;

/**
 * Classe, autoexplicativa, que representa o grid no qual o jogo utiliza,
 * tanto para leitura, quanto para manipulação das gerações, e posteriormente,
 * a escrita em um arquivo.
 *
 * @author gustavopinho
 */
public class Grid 
{   
    private int[][] grid;
    
    /**
     * Método construtor.
     * 
     * @param size int - Tamanho do grid.
     */
    public Grid(int size)
    {   
        this.grid = new int[size][size];
        //Zera a matriz
        for (int i=0; i<size; i++)
            for (int j=0; j<size; j++)
                this.grid[i][j] = 0;
    }
    
    /**
     * Método getter, responsável por retornar o valor do grid desejado.
     * 
     * @param i int - Corresponde à linha da matriz.
     * 
     * @param j int - Corresponde à coluna da matriz.
     * 
     * @return int - Retorna o valor referente a linha e coluna dadas como
     * parâmetro.
     */
    public int getGrid(int i, int j)
    {   
        return this.grid[i][j];        
    }
    
    /**
     * Método setter, responsável por modificar o valor do grid desejado.
     * 
     * @param i int - Corresponde à linha da matriz.
     * 
     * @param j int - Corresponde à coluna da matriz.
     * 
     * @param type  int - Corresponde ao valor que será modificado no grid.
     */
    public void setGrid(int i, int j, int type)
    {   
        this.grid[i][j] = type;     
    }
    
    /**
     * Método responsável por imprimir o grid na forma de matriz, para uma
     * melhor visualização.
     */
    public void printGrid()
    {   
        for (int i=0; i<this.grid.length; i++)
        {   for (int j=0; j<this.grid.length; j++)
                setText(this.grid[i][j]+ " ");
            setText("\n");
        }
        setText("\n");
    }
    
}
