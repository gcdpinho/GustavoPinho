/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

import java.util.ArrayList;

/**
 * Classe responsável por calcular os pontos do circulo.
 * 
 * @author gustavopinho
 */
public class Bresenham 
{   
    private int x0, y0, r;
    
    /**
     * Método construtor.
     * 
     * @param x0 int - Corresponde à cordenada x inicial.
     * 
     * @param y0 int - Corresponde à cordenada y inicial.
     * 
     * @param r int - Corresponde ao raio do circulo.
     */
    public Bresenham (int x0, int y0, int r)
    {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }
    
    /**
     * Método responsável por calcular os pontos do circulo apartir do algoritmo
     * de bresanham.
     * 
     * @return ArrayList - Corresponde à lista de pontos calculada.
     */
    public ArrayList<Point> midPointCircle()
    {   
        ArrayList<Point> points = new ArrayList<>();
        int d = 1-r, x=0, y=r;
        
        do {    points.add(new Point (x0-y, y0+x));
                points.add(new Point (x0-x, y0+y));
                points.add(new Point (x0+x, y0+y));
                points.add(new Point (x0+y, y0+x));

                if (d < 0) 
                    d = d + (2 * x) + 1;
                else 
                {   d = d + 2 * (x + 1) - 2*y;
                    y--;
                }
                x++;
            }while(x <= y);

        return points;       
    }
    
}
