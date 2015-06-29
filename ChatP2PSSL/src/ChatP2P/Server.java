/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatP2P;

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
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/**
 * Classe responsável por receber as requisições.
 * 
 * @author gustavopinho
 */
public class Server implements Runnable
{   
    private SSLServerSocket serverSocket;
    private SSLSocket socket;
    private Peer peer;
    private ArrayList<PeerTable> online;
    private Certificate certificate;
    
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
        System.setProperty("javax.net.ssl.keyStore","keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","gustavo");
        System.setProperty("javax.net.ssl.trustStore", "truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","gustavo");
        SSLServerSocketFactory sslserversocketfactory;
        sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try
        {   
            serverSocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(6991);           
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
            {   this.socket = (SSLSocket) serverSocket.accept();

                ExecutorService thread = Executors.newCachedThreadPool();
                thread.execute(new Requests(this.socket, online, peer));
            }
            catch (IOException e)
            {   e.printStackTrace();
            }    
    }
  
}
