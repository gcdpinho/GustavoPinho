
package Interface;
import hipo.VirtualMachine;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FormMain extends javax.swing.JFrame {
    int carga = 0, mod = 2;
    String readLine, temp;
    String symbols[];
    VirtualMachine virtualMachine;
    
    public FormMain() {
        initComponents();
        setSize(850,638);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        B_exec = new javax.swing.JButton();
        B_execpassoapasso = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        B_sobre2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        B_exec1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        B_abriarquivo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        B_sobre = new javax.swing.JMenu();
        Grupo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HIPO");

        jPanel2.setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(38, 38, 38));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(254, 254, 254));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 380, 790, 170);

        B_exec.setText("Executar");
        B_exec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_execActionPerformed(evt);
            }
        });
        jPanel2.add(B_exec);
        B_exec.setBounds(600, 100, 180, 29);

        B_execpassoapasso.setText("Passo a passo");
        B_execpassoapasso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_execpassoapassoActionPerformed(evt);
            }
        });
        jPanel2.add(B_execpassoapasso);
        B_execpassoapasso.setBounds(600, 140, 180, 29);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(600, 220, 180, 29);

        B_sobre2.setText("Sobre");
        B_sobre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_sobre2ActionPerformed(evt);
            }
        });
        jPanel2.add(B_sobre2);
        B_sobre2.setBounds(600, 180, 180, 29);

        jScrollPane3.setBackground(new java.awt.Color(38, 38, 38));
        jScrollPane3.setForeground(new java.awt.Color(254, 254, 254));

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(38, 38, 38));
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        jTextArea3.setForeground(new java.awt.Color(254, 254, 254));
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(320, 80, 210, 240);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(38, 38, 38));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Liberation Mono", 0, 15)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(254, 254, 254));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(60, 80, 210, 240);

        jLabel5.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(254, 254, 254));
        jLabel5.setText("Módulo 2:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(370, 40, 120, 30);

        B_exec1.setText("Próximo");
        B_exec1.setEnabled(false);
        B_exec1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_exec1ActionPerformed(evt);
            }
        });
        jPanel2.add(B_exec1);
        B_exec1.setBounds(600, 290, 180, 29);

        jLabel6.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(254, 254, 254));
        jLabel6.setText("Log:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 340, 120, 30);

        jLabel4.setFont(new java.awt.Font("Liberation Mono", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(254, 254, 254));
        jLabel4.setText("Módulo 1:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(110, 40, 120, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/cooltext1834332321.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(610, 0, 160, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/texture-abstract-red-shades-background_1152x864_sc.jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, -3, 1020, 590);

        jMenu1.setText("Arquivo");

        B_abriarquivo.setText("Abrir Arquivo");
        B_abriarquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_abriarquivoActionPerformed(evt);
            }
        });
        jMenu1.add(B_abriarquivo);

        jMenuItem1.setText("Ajustar Carga");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Ajustar Módulos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        exit.setText("Sair");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        B_sobre.setText("Sobre");

        Grupo.setText("Grupo");
        Grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrupoActionPerformed(evt);
            }
        });
        B_sobre.add(Grupo);

        jMenuBar1.add(B_sobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void setText (String texto)
    {   jTextArea1.append(texto);      
    }
    
    private void B_abriarquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_abriarquivoActionPerformed
      try (BufferedReader fileReader = new BufferedReader(new FileReader("in1.txt")))
        {   while ((readLine = fileReader.readLine()) != null) 
            {   symbols = readLine.split(Pattern.quote(" ")); // Separa os simbolos pelo espaço.
                for (int i=0; i<symbols.length; i++)
                {   jTextArea2.append(symbols[i]);
                    jTextArea2.append(" ");
                }
                jTextArea2.append("\n");
            }
       
        }
        catch (IOException e) 
        {   setText ("ERRO 9: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
        }
      
      try (BufferedReader fileReader = new BufferedReader(new FileReader("in2.txt")))
        {   while ((readLine = fileReader.readLine()) != null) 
            {   symbols = readLine.split(Pattern.quote(" ")); // Separa os simbolos pelo espaço.
                for (int i=0; i<symbols.length; i++)
                {   jTextArea3.append(symbols[i]);
                    jTextArea3.append(" ");
                }
                jTextArea3.append("\n");
            }
       
        }
        catch (IOException e) 
        {   setText ("ERRO 10: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
        }
        
    }//GEN-LAST:event_B_abriarquivoActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void GrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrupoActionPerformed
        JOptionPane.showMessageDialog(null,"Componetes do grupo:\n\n\t- Bruno Santi\n\t- Gustavo Pinho\n\t- Jean Antunes\n\t- Leonardo Yokemura\n\t- Taisson Silveira de Oliveira\n");
    }//GEN-LAST:event_GrupoActionPerformed

    private void B_sobre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_sobre2ActionPerformed
       JOptionPane.showMessageDialog(null,"Componetes do grupo:\n\n\t- Bruno Santi\n\t- Gustavo Pinho\n\t- Jean Antunes\n\t- Leonardo Yokemura\n\t- Taisson Silveira de Oliveira\n");
    }//GEN-LAST:event_B_sobre2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void B_execActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_execActionPerformed
        jTextArea1.setText("");
        try 
        {   virtualMachine = new VirtualMachine (mod, carga);
            virtualMachine.firstStep();
        } 
        catch (IOException ex) 
        {   jTextArea1.setText("ERRO 11.");
        }
    }//GEN-LAST:event_B_execActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        temp = JOptionPane.showInputDialog("Digite um valor para a carga do programa:");
        carga = Integer.parseInt(temp);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void B_execpassoapassoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_execpassoapassoActionPerformed
        jTextArea1.setText("");
        try 
        {   virtualMachine = new VirtualMachine (mod, carga);
        } 
        catch (IOException ex) 
        {   jTextArea1.setText("ERRO 12.");
        }
        B_exec1.setEnabled(true);
    }//GEN-LAST:event_B_execpassoapassoActionPerformed

    private void B_exec1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_exec1ActionPerformed
        try 
        {   virtualMachine.firstDebuger(this);
        } 
        catch (IOException ex) 
        {   jTextArea1.setText("ERRO 13.");
        }
    }//GEN-LAST:event_B_exec1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        temp = JOptionPane.showInputDialog("Digite o número de módulos:");
        mod = Integer.parseInt(temp);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem B_abriarquivo;
    private javax.swing.JButton B_exec;
    public javax.swing.JButton B_exec1;
    private javax.swing.JButton B_execpassoapasso;
    private javax.swing.JMenu B_sobre;
    private javax.swing.JButton B_sobre2;
    private javax.swing.JMenuItem Grupo;
    private javax.swing.JMenuItem exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    // End of variables declaration//GEN-END:variables
}
