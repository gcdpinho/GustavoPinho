/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Classe responsável pela criação do frame, desenho e animação dos elementos
 * requisitados no trabalho 1.
 * 
 * @author gustavopinho
 */
public class T1 extends Frame
{   
    private int x0, y0;
    private static int n, s, r, steps, time, width, height;
    private static ArrayList<Point> points;
    
    /**
     * Método construtor.
     * 
     * @param n int - Corresponde ao número de repetições.
     * 
     * @param s int - Corresponde ao número de segmentos.
     * 
     * @param r int - Corresponde ao raio do circulo.
     * 
     * @param x0 int - Corresponde à coordenada x do ponto inicial.
     * 
     * @param y0 int - Corresponde à coordenada y do ponto inicial.
     * 
     * @param steps int - Corresponde ao número de iterações desejadas para a
     * animação.
     * 
     * @param time int - Corresponde ao sustain desejado para a animação.
     */
    public T1(int n, int s, int r, int x0, int y0, int steps, int time)
    {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screen.getWidth();
        height = (int) screen.getHeight();
        T1.n = n;
        T1.s = s;
        T1.r = r;
        this.x0 = x0;
        this.y0 = y0;
        T1.steps = steps;
        T1.time = time;
        points = new ArrayList<>();
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        addWindowListener(new MyFinishWindow());
    }
    
    /**
     * Método responsável por pintar na tela e mostrar as animações.
     * 
     * @param g Graphics - Corresponde à biblioteca que contém as utilidades
     * gráficas necessárias.
     */
    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform yUp = new AffineTransform();
        AffineTransform translate = new AffineTransform();
        Bresenham bresenham = new Bresenham(this.x0, this.y0, r);
        ArrayList<Point> segments; 
        
        // Tratamento do serrilhamento (Antialiasing)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        clearWindow(g2d);
               
        // Alteração do plano cartesiano para o convencional
        yUp.setToScale(1,-1);
        translate.setToTranslation(0,540);
        yUp.preConcatenate(translate);
        g2d.transform(yUp);
        
        // Cálculo dos pontos
        points = bresenham.midPointCircle();
        Collections.sort(points);
        removeDuplicate();
        segments = printRoad(g2d);
        
        sustain(1000);
        
        // Animação
        animationG2D(g2d, segments);
        
        sustain(1000);
        System.exit(0);
    }
    
    /**
     * Método responsável por limpar a tela.
     * 
     * @param g2d Gaphics2D - Corresponde à ao objeto em que se deseja
     * desenhar.
     */
    public static void clearWindow(Graphics2D g2d)
    {   g2d.setPaint(Color.white);
        g2d.fillRect(0, 0, width, height);
        g2d.setPaint(Color.black);
    }
        
    /**
     * Método responsável por imprimir a lista de pontos.
     */
    public static void printPoint()
    {
        for (int i=0; i<points.size(); i++)
            System.out.println(points.get(i).getX()+" "+points.get(i).getY());
    }
    
    /**
     * Método responsável por remover os pontos duplicados da lista e retornar
     * o número de pontos removidos.
     * 
     * @return int - Corresponde ao número de pontos duplicados.
     */
    public static int removeDuplicate()
    {   
        int count = 0;
        
        Point elected;
        for (int i=0; i<points.size()-1; i++)
        {   elected = points.get(i);
            for (int j=i+1; j<points.size(); j++)
                if (elected.getX()==points.get(j).getX() && elected.getY()==points.get(j).getY())
                {   count++;
                    points.remove(j);
                }
        }
        
        return count;
    }
    
    /**
     * Método responsável por imprimir o caminho e retornar a lista de pontos
     * usada para realizar a animação.
     * 
     * @param g2d Graphics2D - Corresponde à ao objeto em que se deseja
     * desenhar.
     * 
     * @return ArrayList - Corresponde à lista de pontos dos segmentos usada
     * para a animação.
     */
    public static ArrayList<Point> printRoad(Graphics2D g2d)
    {   
        int count, countSection, section = points.size()/s, prox = 0;
        ArrayList<Point> segments = new ArrayList<>();
        
        // Desenho do caminho
        for (int i=0; i<n; i++)
        {   count = 0;
            countSection = 0;
            for (int j=0; j<points.size(); j++)
            {   g2d.fillOval(points.get(j).getX()+prox, points.get(j).getY(), 1, 1);
                if ((count == section && countSection < s) || count == 0)
                {   segments.add(new Point(points.get(j).getX()+prox, points.get(j).getY()));
                    count = 0;
                    countSection++;                    
                }
                count++;                
            }
            prox = prox + 2 * r;
        }
        segments.add(new Point (points.get(0).getX()+prox, points.get(0).getY()));
        
        // Desenho dos segmentos
        for (int i=0; i<segments.size(); i++)
            g2d.fillOval(segments.get(i).getX(), segments.get(i).getY(), 3, 3);
        
        return segments;
    }
    
    /**
     * Método responsável por realizar um delay, permitindo a visualização dos
     * objetos.
     * 
     * @param t long - Corresponde ao valor do delay.
     */
    @SuppressWarnings("empty-statement")
    public static void sustain(long t)
    {   
        long finish = (new Date()).getTime() + t;
    
        while ((new Date()).getTime() < finish);
    }
    
    /**
     * Método responsável por realizar aumentar o tamanho do objeto sem
     * translada-lo.
     * 
     * @param x int - Corresponde a coordenada x do centro do objeto.
     * 
     * @param y int - Corresponde a coordenada y do centro do objeto.
     * 
     * @param xs int - Corresponde ao valor da mudança de tamanho na coordenada
     * x.
     * 
     * @param ys int - Corresponde ao valor da mudança de tamanho na coordenada
     * y.
     * 
     * @return AffineTransform - Corresponde ao resultado da transformação 
     * final.
     */
    public static AffineTransform scaleWithoutTranslate(double x, double y, double xs, double ys)
    {   
        AffineTransform at = new AffineTransform();

        at.translate(x,y);
        at.scale(xs,ys);
        at.translate(-x,-y);

        return at;
    }
    
    /**
     * Método responsável por realizar a combinação convexa.
     * 
     * @param a double[] - Corresponde à matriz de transformação inicial.
     * 
     * @param b double[] - Corresponde à matriz de transformação final.
     * 
     * @param alpha double - Corresponde à relação entre a iterção atual e o
     * número de steps.
     * 
     * @return double[] - Corresponde à matriz da transformação convexa.
     */
    public static double[] convexCombination(double[] a, double[] b, double alpha)
    {   
        double[] result = new double[a.length];

        for (int i=0; i<result.length; i++)
          result[i] = (1-alpha)*a[i] + alpha*b[i];

        return result;
    }
    
    /**
     * Método responsável pela animação do trabalho 1 (g2d).
     * 
     * @param g2d Graphics2D - Corresponde à ao objeto em que se deseja
     * desenhar.
     * 
     * @param segments ArrayList - Corresponde à lista que contém os pontos
     * necessário para realziar a animação.
     */
    public static void animationG2D(Graphics2D g2d, ArrayList<Point> segments)
    {
        boolean flag = false;
        int difx = segments.get(1).getX() - segments.get(0).getX(), dify = segments.get(1).getY() - segments.get(0).getY(), count = 0;
        double xmid = segments.get(0).getX() + 10/2.0, ymid = segments.get(0).getY() + 10/2.0;
        Rectangle2D.Double r2d = new Rectangle2D.Double (segments.get(0).getX(), segments.get(0).getY(), 10, 10);
        double[] initialMatrix = new double[6], finalMatrix = new double[6];
        AffineTransform initialTransform = new AffineTransform(), finalTransform = new AffineTransform(), intermediateTransform;
        Shape shape;
        
        initialTransform.getMatrix(initialMatrix);
        
        finalTransform.setToTranslation(difx, dify);
        finalTransform.rotate(Math.PI/4, xmid, ymid);
        finalTransform.concatenate(scaleWithoutTranslate(xmid, ymid, 1.5, 1.5));
        finalTransform.getMatrix(finalMatrix);
        
        for (int j=2; j<=segments.size(); j++)
        {   for (int i=0; i<=steps; i++)
            {   intermediateTransform = new AffineTransform(convexCombination(initialMatrix,finalMatrix,i/(double)steps));

                shape = intermediateTransform.createTransformedShape(r2d);
              
                sustain(time);
                clearWindow(g2d);

                g2d.fill(shape);
            }
            count++;
            if (j != segments.size())
            {   initialTransform.setTransform(finalTransform);
                initialTransform.getMatrix(initialMatrix);
                
                finalTransform = new AffineTransform();
                
                difx = segments.get(j).getX() - segments.get(j-1).getX()+difx;
                if (count == s)
                {   dify = segments.get(j).getY() - segments.get(j-1).getY();
                    count = 0;
                }
                else
                    dify = segments.get(j).getY() - segments.get(j-1).getY()+dify;
                finalTransform.setToTranslation(difx, dify);

                if (!flag)
                {   finalTransform.concatenate(scaleWithoutTranslate(xmid, ymid, 1, 1));
                    flag = true;
                }
                else
                {   finalTransform.rotate(Math.PI/4, xmid, ymid);
                    finalTransform.concatenate(scaleWithoutTranslate(xmid, ymid, 1.5, 1.5));
                    flag = false;
                }
                finalTransform.getMatrix(finalMatrix);
            }
        }       
    }
    
}
