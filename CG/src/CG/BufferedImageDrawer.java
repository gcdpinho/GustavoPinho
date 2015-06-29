/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

import java.awt.*;
import java.awt.image.*;

/**
* Classe responsável criar o frame e imprimir a imagem bufferizada.
*
* @author Frank Klawonn
* 
* @version gustavopinho
*/
public class BufferedImageDrawer extends Frame
{
    public BufferedImage bi;
    public Graphics2D g2dbi;
    private Graphics2D g2d;

    /**
     * Método construtor.
     * 
     * @param bi BufferedImage - Corresponde à imagem a ser printada.
     * 
     * @param width int - Corresponde à largura do frame.
     * 
     * @param height int - Corresponde à altura do frame.
     */
    public BufferedImageDrawer(BufferedImage bi, int width, int height)
    {
        this.bi = bi;
        g2dbi = this.bi.createGraphics();
        addWindowListener(new MyFinishWindow());

        this.setTitle("Trabalho 2 - Computação Gráfica");
        this.setSize(width,height);
        this.setVisible(true);
    }
    
    /**
     * Método reponsável por chamar o update e printar na tela.
     * 
     * @param g Graphics - Corresponde à biblioteca que contém as utilidades
     * gráficas necessárias.
     */
    @Override
    public void paint(Graphics g)
    {
       update(g);
    }
    
    /**
     * Método responsável por printar na tela.
     * 
     * @param g Graphics - Corresponde à biblioteca que contém as utilidades
     * gráficas necessárias.
     */
    @Override
    public void update(Graphics g)
    {
        g2d = (Graphics2D) g;
        g2d.drawImage(bi,0,0,null);
    }

}


