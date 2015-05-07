/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CG;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.image.BufferedImage;

/**
 * 
 * @author gustavopinho
 */
public class T2 extends TimerTask
{
    private BufferedImageDrawer buffid;
    private Dimension screen;
    private BufferedImage bg;
    private double frameSize;
    private double handLength;		
    private double handWidth;
    private Rectangle2D.Double clockFrame;
    private Rectangle2D.Double clockHand;
    private AffineTransform singleRotation;
    private AffineTransform accumulatedRotation;
    private AffineTransform singleTranslation;
    private AffineTransform accumulatedTranslation;
    private AffineTransform handTransform;
    private int width, height;

public T2(int delay)
{
        
        this.screen = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screen.getWidth();
        height = (int) screen.getHeight();
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        buffid = new BufferedImageDrawer(bi,width,height);
        //The lines should have a thickness of 3.0 instead of 1.0.
        buffid.g2dbi.setStroke(new BasicStroke(3.0f));

        //Use of antialiasing to have nicer lines.
        buffid.g2dbi.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /*yUp defines a translation allowing the specification of objects in "real"
          coordinates where the y-axis points upwards and the origin of the coordinate
          system is located in the lower left corner of the window.
        */
        AffineTransform yUp = new AffineTransform();
        yUp.setToScale(1, -1);
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(0, height);
        yUp.preConcatenate(translate);

        //Apply the transformation to the Graphics2D object to draw everything
        //in "real" coordinates.
        buffid.g2dbi.transform(yUp);

        buffid.g2dbi.setPaint(Color.black);

        bg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dBackGround = bg.createGraphics();
        g2dBackGround.setPaint(Color.white);
        g2dBackGround.fill(new Rectangle(0,0,width,height));

        //Specification of the size parameters for drawing

        frameSize = 100;
        handLength = 40;
        handWidth = 5;

        clockFrame = new Rectangle2D.Double(-frameSize/2,-frameSize/2,
                                            frameSize,frameSize);

        clockHand = new Rectangle2D.Double(-handWidth/2,0,
                                           handWidth,handLength);


        singleRotation = new AffineTransform();
        singleRotation.setToRotation(-delay*Math.PI/30000);

        accumulatedRotation = new AffineTransform();

        singleTranslation = new AffineTransform();
        singleTranslation.setToTranslation(2,1);

        accumulatedTranslation = new AffineTransform();
        //In order to position the clock inside the window in the beginning
        //of the animation, the translation incorporates already a shift 
        //to the right and upwards.
        accumulatedTranslation.setToTranslation(150,150);

        handTransform = new AffineTransform();
}


  //This method is called in regular intervals. This method computes
  //the updated image/frame and calls the repaint method to draw the
  //updated image on the window.
  public void run()
  {
     //Accumulated transformation of the second hand: First rotate, then translate.
     handTransform.setTransform(accumulatedRotation);
     handTransform.preConcatenate(accumulatedTranslation);

     //Draw the background.
     buffid.g2dbi.drawImage(bg,0,0,null);

     //Draw the frame of the clock.
     buffid.g2dbi.draw(accumulatedTranslation.createTransformedShape(clockFrame));

     //Draw the second hand.
     buffid.g2dbi.fill(handTransform.createTransformedShape(clockHand));

     //This will update the image/frame in the window.
     buffid.repaint();


     //Computation of the accumulated translation of the clock.
     accumulatedTranslation.preConcatenate(singleTranslation);

     //Computation of the accumulated rotation of the second hand.
     accumulatedRotation.preConcatenate(singleRotation);


  }




}

