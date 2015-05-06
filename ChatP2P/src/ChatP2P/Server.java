/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatP2P;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Classe responsável por receber as requisições.
 * 
 * @author gustavopinho
 */
public class Server implements Runnable
{   
    private ServerSocket serverSocket;
    private Socket socket;
    private Peer peer;
    private ArrayList<PeerTable> online;
    
    /**
     * Método construtor.
     * 
     * @param peer Peer - Corresponde ao peer que "chamou" a classe.
     */
    public Server(Peer peer)
    {   
        Upnp upnp = new Upnp();
        upnp.portMap(6991);
        
        this.peer = peer;
        this.online = new ArrayList<>();
        try
        {   this.serverSocket = new ServerSocket(6991);            
        }
        catch (IOException e)
        {   e.printStackTrace();
        }   
    }
    
    /**
     * Método responsável por esperar a requisição do peer e chamar a classe
     * para tratá-la.
     */
    @Override
    public void run() 
    {   
        while (true)    
            try
            {   this.socket = serverSocket.accept();

                ExecutorService thread = Executors.newCachedThreadPool();
                thread.execute(new Requests(this.socket, online, peer));
            }
            catch (IOException e)
            {   e.printStackTrace();
            }    
    }
  
}
