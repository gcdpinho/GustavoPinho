/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatP2P;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * Classe responsável por responder as requisições feitas pelo peer.
 * 
 * @author gustavopinho
 */
public class Answer 
{   
    private SSLSocket socket;
    private ArrayList<PeerTable> online;
    private Peer peer;
    
    /**
     * Método construtor.
     * 
     * @param socket Socket - Corresponde ao socket da conexão.
     * 
     * @param online ArrayList - Corresponde a lista de peers online.
     * 
     * @param peer Peer - Corresponde ao peer que fez a requisição.
     */
    public Answer(SSLSocket socket, ArrayList<PeerTable> online, Peer peer)
    {
        this.socket = socket;
        this.online = online;
        this.peer = peer;
    }
    
    /**
     * Método responsável enviar a resposta, de acordo com a requisição.
     * 
     * @param check int - Corresponde à requisição.
     * 
     * @throws IOException - Corresponde à exceção referente a manipulação do
     * Socket.
     */
    public void answer(int check) throws IOException
    {   
        DataOutputStream ps = new DataOutputStream(socket.getOutputStream());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        switch(check)
        {   case 1:
                ps.write(("PEER_GROUP " + peerTableToString()+ "\n\n").getBytes());
                
                for (int i=0; i<online.size()-1; i++)
                    update(online.get(i).getPeerIP(), "MASTER_PEER UPDATE " + peerTableToString() + "\n\n");
                break;
            case 3:
                ps.write(("ACCEPT_TALKING " + peer.getMyID() + "\n\n").getBytes());
                break;
            case 5:
            case 8:
                ps.write(("RECV_MSG " + peer.getMyID() + "\n\n").getBytes());
                break;
            case 7:
                for (int i=0; i<online.size(); i++)
                    update(online.get(i).getPeerIP(), "MASTER_PEER UPDATE " + peerTableToString() + "\n\n");
                break;          
        }
    }
    
    /**
     * Método responsável por atualizar a lista de peers online.
     * 
     * @param ip String - Corresponde ao ip do peer.
     * 
     * @param string String - Corresponde à mensagem que se deseja enviar.
     * 
     * @throws IOException - Corresponde à exceção referente à manipulação do
     * Socket e PrintStream.
     */
    private  void update (String ip, String string) throws IOException
    {   
        SSLSocketFactory sslSocketF = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socketAux  = (SSLSocket) sslSocketF.createSocket(ip, 6991); 

        PrintStream ps = new PrintStream (socketAux.getOutputStream());
        ps.write(string.getBytes());
        ExecutorService thread = Executors.newCachedThreadPool();
        thread.execute(new Requests(socketAux, online, peer));
    }
    
    /**
     * Método responsável por transformar a lista de peers online em uma String
     * de acordo com as normas e o cabeçalho.
     * 
     * @return String - Corresponde à string equivalente a lista de peers
     * online.
     */
    private String peerTableToString()
    {
       String string = "";
        
        for (int i=0; i<online.size(); i++)
            string = string + "(" + online.get(i).getPeerID() + "," + online.get(i).getPeerName() + "," + online.get(i).getPeerIP() + "," + String.valueOf(online.get(i).isPeerStatus()) + ")\n";   
        
        return string;
    }
    
}
