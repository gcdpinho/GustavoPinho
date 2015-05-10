/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

import java.awt.*;
import java.awt.geom.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.image.BufferedImage;

/**
 * Classe reponsável pela criação das animações com as imagens e demais
 * funcionalidades requisitadas no trabalho 2.
 * 
 * @author gustavopinho
 */
public class T2 extends TimerTask 
{	
    private static int n, s, r, height, x0, y0;
    private int count, index, diffxAnt, diffyAnt, diffx, diffy, width, variation, numberVar;
    private double steps, alpha, deltaAlpha;
    private static ArrayList<Point> pontos, segments;
    private TriangulatedImage imgs[];
    private BufferedImageDrawer bid, bid2;
    private BufferedImage backGround, mix;
    
    /**
     * Método construtor.
     * 
     * @param n int - Corresponde ao número de repetições.
     * 
     * @param s int - Corresponde ao segmentos (s=4 - divisão dos octantes).
     * 
     * @param r int - Corresponde ao raio do círculo.
     * 
     * @param x0 int - Corresponde à coordenada x da posição inicial do centro 
     * do círculo.
     * 
     * @param y0 int - Corresponde à coordenada y da posição inicial do centro
     * do círculo.
     * 
     * @param steps double - Corresponde ao número de passos entre a animação de
     * uma imagem para outra.
     */
    public T2(int n, int s, int r, int x0, int y0, double steps) 
    {          
        segments = new ArrayList<>();
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screen.getWidth();
        height = (int) screen.getHeight();
        this.steps = steps;
        this.deltaAlpha = 1.0/this.steps;
        this.alpha = 0;
	this.index = 0;
	this.diffxAnt = 0;
        this.diffyAnt = 0;
        T2.n = n; 
        T2.s = s;
        T2.r = r;
        this.x0 = x0;
        this.y0 = y0;
        this.variation = 0;
        this.numberVar = 0;
        
        // Background
        backGround = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dBackGround = backGround.createGraphics();
        g2dBackGround.setPaint(Color.white);
        g2dBackGround.fill(new Rectangle(0,0,width,height));
        g2dBackGround.setPaint(Color.black);
        
        this.bid = new BufferedImageDrawer(backGround, width, height);
        
        bid.g2dbi.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Cálculo dos pontos
        Bresenham bresenham = new Bresenham(this.x0, this.y0, T2.r);
        pontos = bresenham.midPointCircle();
        Collections.sort(pontos);
        removeDuplicate();
        generateRoad();
  
        ArrayList<Point> pointsOfInterest = new ArrayList<>();
        
        // Pontos de interesse
        pointsOfInterest.add(new Point(115,85)); // Entre os olhos
        pointsOfInterest.add(new Point(116,117)); // Entre o nariz e a boca
        pointsOfInterest.add(new Point(116,155)); // No final do queixo
        pointsOfInterest.add(new Point(175,212)); // Logo acima do centro do emblema da seleção
        pointsOfInterest.add(new Point(50,255)); // Abaixo do símbolo da nike
                                
        imgs = new TriangulatedImage[15];    
        Image loadImage;
        
        for (int i=0; i<=s*n; i++) 
        {   imgs[i] = new TriangulatedImage();
            imgs[i].bi = new BufferedImage(224, 300, 2);
            Graphics2D g2dImage = imgs[i].bi.createGraphics();
            loadImage = new javax.swing.ImageIcon(("image" + i + ".png")).getImage();
            
            g2dImage.drawImage(loadImage, 0, 0, null);

            // Pontos das imagens
            imgs[i].tPoints = new Point2D[12];
            
            imgs[i].tPoints[0] = new Point2D.Double(0, 0);
            imgs[i].tPoints[1] = new Point2D.Double(0, 180);
            imgs[i].tPoints[2] = new Point2D.Double(0, 300);
            imgs[i].tPoints[3] = new Point2D.Double(224, 0);
            imgs[i].tPoints[4] = new Point2D.Double(224, 150);
            imgs[i].tPoints[5] = new Point2D.Double(224, 300);
            imgs[i].tPoints[6] = new Point2D.Double(112, 300);
            imgs[i].tPoints[7] = new Point2D.Double(pointsOfInterest.get(0).getX()+variation,pointsOfInterest.get(0).getY());
            imgs[i].tPoints[8] = new Point2D.Double(pointsOfInterest.get(1).getX()+variation,pointsOfInterest.get(1).getY());
            imgs[i].tPoints[9] = new Point2D.Double(pointsOfInterest.get(2).getX()+variation,pointsOfInterest.get(2).getY());
            imgs[i].tPoints[10] = new Point2D.Double(pointsOfInterest.get(3).getX()+variation,pointsOfInterest.get(3).getY());
            imgs[i].tPoints[11] = new Point2D.Double(pointsOfInterest.get(4).getX()+variation,pointsOfInterest.get(4).getY());

            // Triângulos das imagens
            imgs[i].triangles = new int[15][3];
            
            imgs[i].triangles[0][0] = 0;
            imgs[i].triangles[0][1] = 7;
            imgs[i].triangles[0][2] = 3;
            
            imgs[i].triangles[1][0] = 0;
            imgs[i].triangles[1][1] = 7;
            imgs[i].triangles[1][2] = 1;
            
            imgs[i].triangles[2][0] = 3;
            imgs[i].triangles[2][1] = 7;
            imgs[i].triangles[2][2] = 4;
            
            imgs[i].triangles[3][0] = 1;
            imgs[i].triangles[3][1] = 7;
            imgs[i].triangles[3][2] = 8;
            
            imgs[i].triangles[4][0] = 7;
            imgs[i].triangles[4][1] = 8;
            imgs[i].triangles[4][2] = 4;
            
            imgs[i].triangles[5][0] = 1;
            imgs[i].triangles[5][1] = 8;
            imgs[i].triangles[5][2] = 11;
            
            imgs[i].triangles[6][0] = 8;
            imgs[i].triangles[6][1] = 11;
            imgs[i].triangles[6][2] = 9;
            
            imgs[i].triangles[7][0] = 8;
            imgs[i].triangles[7][1] = 9;
            imgs[i].triangles[7][2] = 10;
            
            imgs[i].triangles[8][0] = 8;
            imgs[i].triangles[8][1] = 10;
            imgs[i].triangles[8][2] = 4;
            
            imgs[i].triangles[9][0] = 1;
            imgs[i].triangles[9][1] = 2;
            imgs[i].triangles[9][2] = 11;
            
            imgs[i].triangles[10][0] = 2;
            imgs[i].triangles[10][1] = 11;
            imgs[i].triangles[10][2] = 6;
            
            imgs[i].triangles[11][0] = 11;
            imgs[i].triangles[11][1] = 10;
            imgs[i].triangles[11][2] = 6;
            
            imgs[i].triangles[12][0] = 6;
            imgs[i].triangles[12][1] = 10;
            imgs[i].triangles[12][2] = 5;
            
            imgs[i].triangles[13][0] = 11;
            imgs[i].triangles[13][1] = 4;
            imgs[i].triangles[13][2] = 5;
            
            imgs[i].triangles[14][0] = 11;
            imgs[i].triangles[14][1] = 8;
            imgs[i].triangles[14][2] = 10;
            
            // Responsável por variar a trinagularização
            switch(numberVar)
            {   case 0:
                    this.variation = +15;
                    break;
                case 1:
                    this.variation = +30;
                    break;
                case 2:
                    this.variation = 0;
                    numberVar = -1;
                    break;                
            }
            numberVar++;   
        }
    }
    
    /**
     * Método reponsável por realizar a animação das imagens entre os pontos
     * calculados.
     */
    @Override
    public void run() 
    {   
        if (this.count <= n*s-1)
        {   for (int j = 0; j < steps; j++)
            {   this.alpha = alpha + deltaAlpha;
                diffxAnt = diffx;
                diffyAnt = diffy;
                diffx = (int) ((1 - j/steps) * segments.get(index).getX()) + (int)((j/steps) * segments.get(index + 1).getX());
                diffy = (int) ((1 - j/steps) * segments.get(index).getY()) + (int)((j/steps) * segments.get(index + 1).getY());
                mix = imgs[count].mixWith(imgs[count+1], alpha);

                bid.g2dbi.drawImage(backGround, diffxAnt, diffyAnt, null);			
                bid.g2dbi.drawImage(mix, diffx, diffy, null);
                bid.repaint();
                sustain(10);
            }
            alpha = 0;
            count++;
            index++;            
        }
    }
    
    /**
     * Método responsável por aplicar um delay, auxiliando a visualização da
     * imagem.
     * 
     * @param t long - Corresponde ao número referente ao delay.
     */
    @SuppressWarnings("empty-statement")
    public static void sustain(long t) 
    {
        long finish = (new Date()).getTime() + t;
        while( (new Date()).getTime() < finish );
    }

    /**
     * Método responsável por gerar o caminho da animação.
     */
    public static void generateRoad()
    {   
        int count, countSection, section = pontos.size()/s, prox = 0;
        
        for (int i=0; i<n; i++)
        {   count = 0;
            countSection = 0;
            for (int j=0; j<pontos.size(); j++)
            {   if ((count == section && countSection < s) || count == 0)
                {   segments.add(new Point(pontos.get(j).getX()+prox, height/2 - y0 - pontos.get(j).getY()));
                    count = 0;
                    countSection++;                    
                }
                count++;                
            }
            prox = prox + 2 * r;
        }
        segments.add(new Point (pontos.get(0).getX()+prox, height/2 - y0 - pontos.get(0).getY()));
    }
    
    /**
     * Método responsável por remover os pontos duplicados.
     * 
     * @return int - Corresponde ao número de elementos removidos.
     */
    public static int removeDuplicate()
    {   
        int count = 0;
        
        Point elected;
        for (int i=0; i<pontos.size()-1; i++)
        {   elected = pontos.get(i);
            for (int j=i+1; j<pontos.size(); j++)
                if (elected.getX()==pontos.get(j).getX() && elected.getY()==pontos.get(j).getY())
                {   count++;
                    pontos.remove(j);
                }
        }
        
        return count;
    }
    
}
