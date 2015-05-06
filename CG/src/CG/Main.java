/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

import Interface.Interface;

/**
 * Classe principal, responsável por iniciar a interface e dar início ao
 * programa.
 * 
 * @author gustavopinho
 */
public class Main 
{
    /**
     * Método principal.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {   
        Interface CG = new Interface();
    
        CG.setVisible(true);        
    }
    
}
