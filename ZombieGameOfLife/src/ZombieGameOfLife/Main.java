/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZombieGameOfLife;

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
    * @param args String[] - Correspondente aos parâmetros do método principal.
    */
    public static void main(String[] args) 
    {   Interface t1 = new Interface();
        
        t1.setVisible(true);        
     
    }
    
}
