/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

/**
 * Classe responsável por representar uma coordenada no plano cartesiano.
 * 
 * @author gustavopinho
 */
public class Point implements Comparable<Point>
{   
    private int x, y;
    
    /**
     * Método construtor.
     * 
     * @param x int - Corresponde à coordenada x do ponto.
     * 
     * @param y int - Corresponde à coordenada y do ponto.
     */
    public Point (int x, int y)
    {   
        this.x = x;
        this.y = y;        
    }
    
    /**
     * Método getter, reponsável por retornar a coordenada x do ponto.
     * 
     * @return int - Corresponde à coordenada x do ponto.
     */    
    public int getX()
    {   
        return this.x;    
    }
    
    /**
     * Método getter, responsável por retornar a coordenada y do ponto.
     * 
     * @return int - Corresponde à coordenada y do ponto.
     */
    public int getY()
    {   return this.y;        
    }

    /**
     * Método responsável por realizar as comparações e ordenação da estrutura
     * de dados.
     * 
     * @param otherPoint Point - Corresponde ao ponto a ser comparado.
     * 
     * @return int - Corresponde ao resultado da comparação.
     */
@Override
    public int compareTo (Point otherPoint)
    {   if (x <otherPoint.x)
            return -1;
        else
            if (x > otherPoint.x)
                return 1;
            else
                return 0;        
    }
}
