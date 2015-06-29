/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;
import javax.swing.JFrame;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;

/**
 * Classe responsável pela criaçao da cena 3D de acordo com as especificações do
 * Trabalho 3.
 * 
 * @author gustavopinho
 */
public class T3 extends JFrame
{   
    public Canvas3D canvas3D;
    
    /**
     * Método responsável pela criação do Frame e da música tema.
     */
    public T3()
    {    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas3D = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

        SimpleUniverse simpUniv = new SimpleUniverse(canvas3D);
        simpUniv.getViewingPlatform().setNominalViewingTransform();

        createSceneGraph(simpUniv);

        //addLight(simpUniv);

        OrbitBehavior ob = new OrbitBehavior(canvas3D);
        ob.setSchedulingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE));
        simpUniv.getViewingPlatform().setViewPlatformBehavior(ob);

        setTitle("Trabalho 3 - Computação Gráfica");
        setSize(1280,1000);
        getContentPane().add("Center", canvas3D);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        AePlayWave theme = new AePlayWave("ThemeMusic.wav");
        theme.start();
    }
    
    /**
     * Método responsável pela criação da 3D, dos objetos e suas respectivas
     * movimentações.
     * 
     * @param su SimpleUniverse - Corresponde ao universo em que será realizada
     * a cena.
     */
    public static void createSceneGraph(SimpleUniverse su)
    {   
        BranchGroup theScene = new BranchGroup();
        ObjectFile obj = new ObjectFile(ObjectFile.RESIZE);
        Scene[] scene = new Scene[10];
        TransformGroup[] tgObject = new TransformGroup[10];
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0),Double.MAX_VALUE);

        try
        {   scene[0] = obj.load("GreenArrow.obj");
            scene[1] = obj.load("DeathStroke.obj");
            scene[2] = obj.load("Arrow.obj");
            scene[3] = obj.load("CaptainBoomerang.obj");
            scene[4] = obj.load("TheFlash.obj");
        }
        catch (Exception e)
        {   e.printStackTrace();
            System.exit(1);
        }
        
        //Green Arrow
        Transform3D greenArrow = new Transform3D();
        greenArrow.rotY(0.45*Math.PI);
        greenArrow.setScale(0.4);
        greenArrow.setTranslation(new Vector3d(-0.7, -0.25, -0.5));
        
        tgObject[0] = new TransformGroup(greenArrow);
        tgObject[0].addChild(scene[0].getSceneGroup());
        
        //DeathStroke
        Transform3D deathStroke = new Transform3D();
        deathStroke.rotY(-0.2*Math.PI);
        deathStroke.setScale(0.2);
        deathStroke.setTranslation(new Vector3d(0, -0.2, -1.5));
        
        tgObject[1] = new TransformGroup(deathStroke);
        tgObject[9] = new TransformGroup();
        tgObject[1].addChild(scene[1].getSceneGroup());
        
        //Arrow
        Transform3D arrow = new Transform3D();
        arrow.rotY(0.44*Math.PI);        
        arrow.setScale(0.15);
        arrow.setTranslation(new Vector3d(-0.63, -0.09, -0.55));
      
        tgObject[2] = new TransformGroup(arrow);
        tgObject[3] = new TransformGroup();
        
        //Captain Boomerang
        Transform3D captainBoomerang = new Transform3D();
        captainBoomerang.rotY(-0.5*Math.PI);
        captainBoomerang.setScale(0.33);
        captainBoomerang.setTranslation(new Vector3d(1.5, -0.3, -0.5));
        
        tgObject[4] = new TransformGroup(captainBoomerang);
        tgObject[5] = new TransformGroup();
        tgObject[8] = new TransformGroup();
        
        //The Flash
        Transform3D theFlash = new Transform3D();
        theFlash.setScale(0.3);
        theFlash.setTranslation(new Vector3d(0, -1, -15));
        
        tgObject[6] = new TransformGroup(theFlash);
        tgObject[7] = new TransformGroup();
                
        //Movimentação Arrow
        Alpha alphaArrow = new Alpha(1, Alpha.INCREASING_ENABLE, 2000, 2000, 3000, 300, 0, 0, 0, 0);
        
        Transform3D arrowAxis = new Transform3D();
        arrowAxis.rotY(0.87*Math.PI);
        
        PositionInterpolator arrowMoviment = new PositionInterpolator(alphaArrow, tgObject[3] , arrowAxis, 0.0f, -07.5f);
        tgObject[3].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        arrowMoviment.setSchedulingBounds(bounds);
        
        tgObject[2].addChild(tgObject[3]);
        tgObject[3].addChild(arrowMoviment);
        tgObject[3].addChild(scene[2].getSceneGroup());
        
        //Movimentação Captain Boomerang
        Alpha alphaCaptainBoomerang = new Alpha(1, Alpha.INCREASING_ENABLE, 4000, 4000, 2000, 300, 0, 0, 0, 0);
        
        Transform3D captainBoomerangAxis = new Transform3D();
        captainBoomerangAxis.rotY(0.5*Math.PI);
        
        PositionInterpolator captainBoomerangMoviment = new PositionInterpolator(alphaCaptainBoomerang, tgObject[5] , captainBoomerangAxis, 0.0f, -02.5f);
        tgObject[5].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        captainBoomerangMoviment.setSchedulingBounds(bounds);
        
        Alpha alphaCaptainBoomerangCollision = new Alpha(1, Alpha.INCREASING_ENABLE, 10000, 2700, 100, 0, 0, 0, 0, 0);
        
        Transform3D captainBoomerangCollisionAxis = new Transform3D();
        captainBoomerangCollisionAxis.rotZ(1*Math.PI);
        
        PositionInterpolator captainBoomerangCollision = new PositionInterpolator(alphaCaptainBoomerangCollision, tgObject[8] , captainBoomerangCollisionAxis, 0.0f, -6f);
        
        tgObject[8].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        captainBoomerangCollision.setSchedulingBounds(bounds); 
        
        tgObject[4].addChild(tgObject[5]);
        tgObject[5].addChild(captainBoomerangMoviment);
        tgObject[5].addChild(tgObject[8]);
        tgObject[8].addChild(captainBoomerangCollision);
        tgObject[8].addChild(scene[3].getSceneGroup());
        
        //Movimentação The Flash
        Alpha alphaTheFlash = new Alpha(1, Alpha.INCREASING_ENABLE, 8000, 4000, 1000, 300, 0, 0, 0, 0);
        
        Transform3D theFlashAxis = new Transform3D();
        theFlashAxis.rotY(2.0*Math.PI);
        
        float[] pathTheFlashFloat = {0.0f, 0.5f, 1f};
        Point3f[] pathTheFlashPoints = new Point3f[3];
        pathTheFlashPoints[0] = new Point3f(0f, 0f, 0f);
        pathTheFlashPoints[1] = new Point3f(0f, 2.2f, 40f);
        pathTheFlashPoints[2] = new Point3f(2.3f, 2.1f, 60f);
        
        PositionPathInterpolator theFlashMoviment = new PositionPathInterpolator(alphaTheFlash, tgObject[7], theFlashAxis, pathTheFlashFloat, pathTheFlashPoints);
        tgObject[7].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        theFlashMoviment.setSchedulingBounds(bounds);
        
        tgObject[6].addChild(tgObject[7]);
        tgObject[7].addChild(theFlashMoviment);
        tgObject[7].addChild(scene[4].getSceneGroup());
        
        theScene.addChild(tgObject[0]);
        theScene.addChild(tgObject[1]); 
        theScene.addChild(tgObject[2]);
        theScene.addChild(tgObject[4]);
        theScene.addChild(tgObject[6]);
        
        //Background
        TextureLoader textureLoad = new TextureLoader("background.jpg",null);
        Background bgImage = new Background(textureLoad.getImage());
        bgImage.setApplicationBounds(bounds);
        theScene.addChild(bgImage);   

        theScene.compile();
        
        su.addBranchGraph(theScene);
    }  
    
    public static void main(String[] args)
    {
        T3 t3 = new T3();
    }
}
