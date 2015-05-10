/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import CG.T1;
import javax.swing.JOptionPane;

/**
 * Classe autoexplicativa, responsável por receber os parâmetros e chamar os
 * métodos responsáveis por realizar as animações e demais funções.
 * 
 * @author gustavopinho
 */
public class Interface extends javax.swing.JFrame 
{   
    private String n, r, s, x0, y0;
    private int steps, time;
    
    /**
     * Método construtor.
     */
    public Interface() 
    {   
        initComponents();
        this.steps = 15;
        this.time = 70;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho 1 - Computação Gráfica");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Posição Inicial:"));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(null);

        jLabel5.setText("X0:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 40, 30, 17);

        jLabel6.setText("Y0:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 80, 21, 17);
        jPanel1.add(jFormattedTextField4);
        jFormattedTextField4.setBounds(60, 40, 60, 20);
        jPanel1.add(jFormattedTextField5);
        jFormattedTextField5.setBounds(60, 80, 60, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 180, 140, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Título.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 0, 270, 50);

        jLabel2.setText("Raio:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 70, 17);

        jLabel3.setText("Segmentação:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 100, 110, 17);

        jLabel4.setText("Repetição:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 140, 90, 17);
        getContentPane().add(jFormattedTextField1);
        jFormattedTextField1.setBounds(210, 60, 100, 20);
        getContentPane().add(jFormattedTextField2);
        jFormattedTextField2.setBounds(210, 100, 100, 20);
        getContentPane().add(jFormattedTextField3);
        jFormattedTextField3.setBounds(210, 140, 100, 20);

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 210, 90, 29);

        jMenu1.setText("File");

        jMenuItem1.setText("Clear Fields");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("Steps");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Sustain");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("About");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(343, 362));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método responsável por limpar os campos em que serão digitados os
     * parâmetros.
     * 
     * @param evt java.awt.event.MouseEvent - Corresponde ao clique do mouse.
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        jFormattedTextField1.setText(null);
        jFormattedTextField2.setText(null);
        jFormattedTextField3.setText(null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    /**
     * Método responsável por chamar o método CG com os devidos parâmetros.
     * 
     * @param evt java.awt.event.ActionEvent - Corresponde ao duplo clique do
     * mouse ou ao enter, quando o botão estiver selecionado.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        r = jFormattedTextField1.getText();
        s = jFormattedTextField2.getText();
        n = jFormattedTextField3.getText();
        x0 = jFormattedTextField4.getText();
        y0 = jFormattedTextField5.getText();
        
        try
        {   T1 t1 = new T1 (Integer.parseInt(n), Integer.parseInt(s), Integer.parseInt(r), Integer.parseInt(x0), Integer.parseInt(y0), steps, time); 
            
            this.setVisible(false);
        }
        catch (NumberFormatException e)
        {   JOptionPane.showMessageDialog(null, "Digite parâmetros válidos!", "Error", JOptionPane.ERROR_MESSAGE);            
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * Método responsável por mostrar os componentes do grupo.
     * 
     * @param evt java.awt.event.MouseEvent - Corresponde ao clique do mouse.
     */
    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        
        JOptionPane.showMessageDialog(null, "-Gustavo Pinho\n-Jean Antunes\n-Felipe Prestes\n", "Group", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jMenu3MousePressed
    
    /**
     * Método responsável por ler o número de steps.
     * 
     * @param evt java.awt.event.MouseEvent - Corresponde ao clique do mouse.
     */
    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        
        boolean error = true;
        
        while (error)    
            try
            {   steps = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de steps:"));
                error = false;
            } 
            catch (NumberFormatException e)
            {   JOptionPane.showMessageDialog(null, "Digite um número inteiro!", "Error", JOptionPane.ERROR_MESSAGE); 
            }
    }//GEN-LAST:event_jMenuItem2MousePressed
    
    /**
     * Método responsável por ler o tempo do sustain.
     * 
     * @param evt java.awt.event.MouseEvent - Corresponde ao clique do mouse.
     */
    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
       
        boolean error = true;
        
        while (error)    
            try
            {   time = Integer.parseInt(JOptionPane.showInputDialog("Digite o tempo do sustain:"));
                error = false;
            } 
            catch (NumberFormatException e)
            {   JOptionPane.showMessageDialog(null, "Digite um número inteiro!", "Error", JOptionPane.ERROR_MESSAGE); 
            }
    }//GEN-LAST:event_jMenuItem3MousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JFormattedTextField jFormattedTextField5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
