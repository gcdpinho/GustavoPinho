
package graphicinterface;

import java.util.Random;
import tictactoe.Board;
import tictactoe.Minimax;
import tictactoe.PhodaAlfaBeta;

public class FormMain extends javax.swing.JFrame 
{   Board board = new Board();
    Minimax game = new Minimax (1, board, 0);
    int totalPlayes = 0, depth=9;
    boolean flag = false, flaggame=true, flagphoda=true;
    PhodaAlfaBeta phoda = new PhodaAlfaBeta(1, board, 0);
    int countNeighbors =0, aux;
    Random random = new Random();

      
    public FormMain() 
    {   initComponents();
    }

    public void update()
    {   jButton1.setText (""+board.getChar(0));
        jButton2.setText (""+board.getChar(1));
        jButton3.setText (""+board.getChar(2));
        jButton4.setText (""+board.getChar(3));
        jButton5.setText (""+board.getChar(4));
        jButton6.setText (""+board.getChar(5));
        jButton7.setText (""+board.getChar(6));
        jButton8.setText (""+board.getChar(7));
        jButton9.setText (""+board.getChar(8));
                
    }
    
    public void clear()
    {   jButton1.setText ("");
        jButton2.setText ("");
        jButton3.setText ("");
        jButton4.setText ("");
        jButton5.setText ("");
        jButton6.setText ("");
        jButton7.setText ("");
        jButton8.setText ("");
        jButton9.setText ("");   
    }
    
    public static void setText (String text)
    {   jTextArea1.append(text);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel11 = new javax.swing.JLabel();

        jButton10.setText("jButton10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic-Tac-Toe");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9});

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 100, 290, 257);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 15))); // NOI18N

        jLabel1.setText("Player  1        Symbol: X       ");

        jLabel2.setText("Wins: ");

        jLabel3.setText("Player 2         Symbol: O");

        jLabel4.setText("Wins:");

        jLabel5.setText("Draw: ");

        jLabel6.setText("0");

        jLabel7.setText("0");

        jLabel8.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(350, 10, 180, 195);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 15))); // NOI18N

        jButton11.setText("New Game");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton13.setText("Print Route");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setText("Exit");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(350, 210, 180, 143);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Minimax", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 15))); // NOI18N

        jButton12.setText("Step");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton14.setText("Auto");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Phoda AlfaBeta");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton12, jButton14});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(350, 360, 180, 132);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 380, 290, 150);

        jLabel9.setText("9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(500, 500, 8, 17);

        jLabel10.setText("1");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(390, 500, 8, 17);

        jSlider1.setMaximum(9);
        getContentPane().add(jSlider1);
        jSlider1.setBounds(380, 530, 131, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cooltext1838326071.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 30, 322, 40);

        setSize(new java.awt.Dimension(548, 592));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(0, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(0, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
        countNeighbors++;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(1, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(1, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
       countNeighbors++;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(2, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(2, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
        countNeighbors++;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(3, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(3, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
        countNeighbors++;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(4, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(4, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
        countNeighbors++;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(5, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(5, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
        countNeighbors++;
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(6, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(6, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
        countNeighbors++;
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(7, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(7, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
        countNeighbors++;
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (!jCheckBox1.isSelected())   
        {   if (totalPlayes < 9 && !game.getStop())
            {   if (board.changeBoard(8, game.getPlayer(), game.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   game.setStop();
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    game.changePlayer();
                }
            }
        }
        else
            if (totalPlayes < 9 && !phoda.getStop())
            {   if (board.changeBoard(8, phoda.getPlayer(), phoda.getStop()))
                {   update();
                    totalPlayes++;
                    if (board.checkWinner())
                    {   phoda.setStop();
                        if (phoda.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    }
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                    phoda.changePlayer();
                }
            }
        countNeighbors++;
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        clear();
        board = new Board();
        totalPlayes = 0;
        game = new Minimax (1, board, 0);
        phoda = new PhodaAlfaBeta( 1, board, 0);
        flag = false;
        countNeighbors = 0;
        flaggame=true;
        flagphoda=true;
        jTextArea1.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (!jCheckBox1.isSelected())    
        {   if (countNeighbors != 0 && flaggame)    
            {   if (totalPlayes < 9 && !game.getStop())    
                {   game = new Minimax (game.getPlayer(), board, totalPlayes);
                    game.methodMinimax();
                    board = new Board (game.getBest());
                    update();
                    totalPlayes++;
                    if (game.getStop())
                        if (game.getPlayer() == 1)
                            jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                        else
                            jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                    else
                        if (totalPlayes == 9)
                            jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                }
            }
            else
            {   board.changeBoard(random.nextInt(9), game.getPlayer(), game.getStop());
                totalPlayes++;
                countNeighbors++;
                game.changePlayer();
                update();
            }
            flagphoda=false;
        }
        else
        {    if (totalPlayes < 9 && !phoda.getStop() && flagphoda)    
            {   phoda = new PhodaAlfaBeta (phoda.getPlayer(), board, totalPlayes);
                phoda.methodPhodaAlfaBeta();
                board = new Board (phoda.getBest());
                update();
                totalPlayes++;
                if (phoda.getStop())
                    if (game.getPlayer() == 1)
                        jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                    else
                        jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                else
                    if (totalPlayes == 9)
                        jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
            }
            flaggame=false;    
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (!jCheckBox1.isSelected()) 
            game.getRoute();
        else
            phoda.getRoute();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        depth = jSlider1.getValue();
        if (!jCheckBox1.isSelected())    
        {   if (!flag && !game.getStop())   
            {   for (int i=0; i<depth; i++)
                {   game = new Minimax (game.getPlayer(), board, totalPlayes);
                    game.methodMinimax();
                    board = new Board (game.getBest());
                    this.totalPlayes++;
                    if (game.getStop() || totalPlayes == 9)
                        break;
                }
                update();
                 if (game.getStop())
                    if (game.getPlayer() == 1)
                        jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                    else
                        jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                else
                    if (totalPlayes == 9)
                        jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                flag = true;
            }
        }
        else
        {   if (!flag && !game.getStop())   
            {   for (int i=0; i<depth; i++)
                {   phoda = new PhodaAlfaBeta (phoda.getPlayer(), board, totalPlayes);
                    phoda.methodPhodaAlfaBeta();
                    board = new Board (phoda.getBest());
                    this.totalPlayes++;
                    if (phoda.getStop() || totalPlayes == 9)
                        break;
                }
                update();
                 if (phoda.getStop())
                    if (phoda.getPlayer() == 1)
                        jLabel6.setText (String.valueOf(Integer.parseInt(jLabel6.getText())+1));
                    else
                        jLabel7.setText (String.valueOf(Integer.parseInt(jLabel7.getText())+1));
                else
                    if (totalPlayes == 9)
                        jLabel8.setText (String.valueOf(Integer.parseInt(jLabel8.getText())+1));
                flag = true;
            }
            
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSlider jSlider1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
