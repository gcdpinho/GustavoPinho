/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatP2P;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela interface e das requisições para o servidor/peer.
 * 
 * @author gustavopinho
 */
public class Peer extends javax.swing.JFrame 
{   
    private ArrayList<PeerTable> online;
    private SSLSocket socket;
    private String serverIP, myName, myID, myIP;
    private Certificate certificate;

    /**
     * Método construtor.
     */
    public Peer() 
    {
        ExecutorService thread = Executors.newCachedThreadPool();
        
        thread.execute(new Server(this));
       
        
        online = new ArrayList<>();
        myName = null;
        
        initComponents();   
    }
    
    /**
     * Método responsável por adicionar um peerTable na lista de peers online.
     * 
     * @param peerTable PeerTable - Corresponde ao PeerTable do peer que está
     * online.
     */
    public void addOnline(PeerTable peerTable)
    {
        this.online.add(peerTable);
    }
    
    /**
     * Método setter, responsável por atribuir um valor ao atributo myID.
     * 
     * @param id String - Corresponde ao valor que se deseja setar.
     */
    public void setMyID(String id)
    {
        this.myID = id;
    }
    
    /**
     * Método getter, responsável por retornar o valor do ID do peer.
     * 
     * @return String - Corresponde ao atributo myID.
     */
    public String getMyID()
    {
        return this.myID;
    }
    
    /**
     * Método setter, responsável por atribuir um valor ao atributo myIP.
     * 
     * @param ip String - Corresponde ao valor que se deseja setar.
     */
    public void setMyIP(String ip)
    {
        this.myIP = ip;
    }
    
    public String getMyIP()
    {
        return this.myIP;
    }
       
    
    /**
     * Método getter, responsável por retornar o nome do peer.
     * 
     * @return String - Corresponde ao atributo myName.
     */
    public String getMyName()
    {
        return this.myName;
    }
    
    /**
     * Método responsável por escrever no log.
     * 
     * @param text String - Corresponde à string que deve ser escrita.
     */
    public static void setText(String text)
    {
        jTextArea1.append(text);
    }
    
    /**
     * Método responsável por alterar o botão send e o jTextArea quando receber
     * uma resposta ACCEPT_TALKING.
     */
    public static void changeButton()
    {   
        jTextArea3.setEditable(true);
        jButton3.setEnabled(true);
        jButton2.setEnabled(false);
    }
    
    /**
     * Método responsável por mostrar na tela do chat a conversa entre os peers.
     * 
     * @param text String - Corresponde à mensagem enviada pelos peers.
     */
    public static void chatText(String text)
    {
        jTextArea2.append(text);
    }
    
    /**
     * Método responsável por zerar a tabela de peers ativos.
     */
    public void clearOnline()
    {
        online.clear();
    }
    
    public void printOnline()
    {
        System.out.println(online.size());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(53, 54, 58));
        setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Discovery Request");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Request Peer");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea3KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea3);

        jButton3.setText("Send");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("177.194.198.169");

        jMenu1.setText("Options");

        jMenuItem1.setText("Disconnect");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Método referente ao botão Discovery Request, responsável por mandar uma
     * requisição para o servidor central e receber a lista de peers online.
     * 
     * @param evt java.awt.event.ActionEvent evt - Corresponde ao clique do
     * mouse.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        myName = null;
        
        try
        {   //serverIP = JOptionPane.showInputDialog(null, "Informe o ip do servidor:", "Discovery Request", JOptionPane.PLAIN_MESSAGE);
            //socket = new Socket (serverIP, 6991);
            serverIP = "177.194.198.169";
            
            SSLSocketFactory sslSocketF = (SSLSocketFactory) SSLSocketFactory.getDefault();
            socket = (SSLSocket) sslSocketF.createSocket(serverIP, 6991);
            DataOutputStream ps = new DataOutputStream(socket.getOutputStream());

            while (myName == null)    
                myName = JOptionPane.showInputDialog(null, "Digite o nome desejado:", "Discovery Request", JOptionPane.PLAIN_MESSAGE);
            
            GenCertificate myCertificate = new GenCertificate("redes");
            myCertificate.geraCertificado(myName, "redes");
            this.certificate = myCertificate.getCertificate();
            
            ps.write(("MASTER_PEER CONNECT " + myName + "\n\n").getBytes());

        }
        catch (IOException | HeadlessException | KeyStoreException | NoSuchAlgorithmException | CertificateException | NoSuchProviderException | InvalidKeyException | SignatureException | UnrecoverableKeyException ex)
        {   ex.printStackTrace();
        }
        
        ExecutorService thread = Executors.newCachedThreadPool();
        thread.execute(new Requests(this.socket, online, this));
        
        
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * Método referente ao botão Request Peer, responsável por mandar uma 
     * requisição para começar a "conversar" entre peers.
     * 
     * @param evt java.awt.event.ActionEvent evt - Corresponde ao clique do
     * mouse. 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (online.isEmpty())
            JOptionPane.showMessageDialog(null, "Não há peers ativos!", "Message", JOptionPane.PLAIN_MESSAGE);
        else
            for (int i=0; i<online.size(); i++)
                if (online.get(i).isPeerStatus() && !online.get(i).getPeerID().equals(myID))
                    try 
                    {   SSLSocketFactory sslSocketF = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        socket = (SSLSocket) sslSocketF.createSocket(online.get(i).getPeerIP(), 6991);
                        DataOutputStream ps = new DataOutputStream(socket.getOutputStream());

                        ps.write(("TALK_TO " + myID + "\n\n").getBytes());
 
                    } 
                    catch (IOException e) 
                    {   e.printStackTrace();
                    }
        
        ExecutorService thread = Executors.newCachedThreadPool();
        thread.execute(new Requests(this.socket, online, this));
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * Método referente ao botão Send, responsável por mandar uma mensagem para
     * os peers conectados.
     * 
     * @param evt java.awt.event.ActionEvent evt - Corresponde ao clique do
     * mouse.  
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String message = jTextArea3.getText();
        
        for (int i=0; i<online.size(); i++)
            if (online.get(i).isPeerStatus() && !online.get(i).getPeerID().equals(myID))
            {   try 
                {   SSLSocketFactory sslSocketF = (SSLSocketFactory) SSLSocketFactory.getDefault();
                    socket = (SSLSocket) sslSocketF.createSocket(online.get(i).getPeerIP(), 6991);
                    DataOutputStream ps = new DataOutputStream(socket.getOutputStream());

                    ps.write(("SEND_MSG " + message.length() + " " + getMyID() + message + "\n\n").getBytes()); 
                } 
                catch (IOException e) 
                {   e.printStackTrace();
                }
               
                ExecutorService thread = Executors.newCachedThreadPool();
                thread.execute(new Requests(this.socket, online, this));
                    
                jTextArea3.setEditable(false);
                jButton3.setEnabled(false);
                jButton2.setEnabled(true);
            }
        jTextArea2.append(myID+ " says: " + message + "\n"); 
        jTextArea3.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed
    
    /**
     * Método referente ao item de menu Disconnect, responsável por desconectar
     * o peer do chat.
     * 
     * @param evt java.awt.event.MouseEvent evt - Corresponde ao clique do
     * mouse.  
     */
    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        
        try 
        {   if (getName().equals(""))
                JOptionPane.showMessageDialog(null, "Você não está conectado a nenhum server!", "Error", JOptionPane.ERROR_MESSAGE); 
            else
            {   SSLSocketFactory sslSocketF = (SSLSocketFactory) SSLSocketFactory.getDefault();
                socket = (SSLSocket) sslSocketF.createSocket(serverIP, 6991);
                DataOutputStream ps = new DataOutputStream(socket.getOutputStream());
                
                ps.write(("MASTER_PEER DISCONNECT " + getMyID()+ "\n\n").getBytes());
                
                jTextArea3.setEditable(false);
                jButton3.setEnabled(false);
                jButton2.setEnabled(false);
                jButton1.setEnabled(true);
                jTextArea1.setText("");
                online.clear();
                
            }
        } 
        catch (IOException e) 
        {   e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jTextArea3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea3KeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {   String message = jTextArea3.getText();
        
            for (int i=0; i<online.size(); i++)
                if (online.get(i).isPeerStatus() && !online.get(i).getPeerID().equals(myID))
                {   try 
                    {   SSLSocketFactory sslSocketF = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        socket = (SSLSocket) sslSocketF.createSocket(online.get(i).getPeerIP(), 6991);
                        DataOutputStream ps = new DataOutputStream(socket.getOutputStream());

                        ps.write(("SEND_MSG " + message.length() + " " + getMyID() + message + "\n\n").getBytes()); 
                    } 
                    catch (IOException e) 
                    {   e.printStackTrace();
                    }

                    ExecutorService thread = Executors.newCachedThreadPool();
                    thread.execute(new Requests(this.socket, online, this));

                    jTextArea3.setEditable(false);
                    jButton3.setEnabled(false);
                    jButton2.setEnabled(true);
                }
            jTextArea2.append(myID+ " says: " + message + "\n"); 
            jTextArea3.setText("");        
             
        }
    }//GEN-LAST:event_jTextArea3KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private static javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTextArea jTextArea2;
    private static javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
