/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

import java.awt.event.*;

/**
 * Classe responsável por fechar o frame quando é clicado no X. 
 * 
 * @author Frank Klawonn
 * 
 * @version gustavopinho
 */
public class MyFinishWindow extends WindowAdapter
{   
    /**
     * Método responsável por terminar o programa quando o X é clicado.
     * 
     * @param e WindowEvent - Corresponte ao clique do mouse no X.
     */
    @Override
    public void windowClosing(WindowEvent e)
    {   
        System.exit(0);
    }
    
}


