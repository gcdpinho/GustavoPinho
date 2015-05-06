/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatP2P;

import static ChatP2P.Peer.changeButton;
import static ChatP2P.Peer.chatText;
import static ChatP2P.Peer.setText;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

/**
 * Classe responsável por atender as requisições dos peers.
 * 
 * @author gustavopinho
 */
public class Requests implements Runnable
{   
    private Socket socket;
    private ArrayList<PeerTable> online;
    private Peer peer;
    private static String chat, sender;
    
    /**
     * Método construtor.
     * 
     * @param socket Socket - Corresponde ao socket da conexão.
     * 
     * @param online ArrayList - Corresponde à lista de peers online.
     * 
     * @param peer Peer - Corresponde ao peer que fez a requisição.
     */
    public Requests(Socket socket, ArrayList<PeerTable> online, Peer peer)
    {   
        this.socket = socket;
        this.online = online;
        this.peer = peer;
        chat = "";
        sender = "";
    }
    
    /**
     * Método responsável por ler a mensagem de requisição.
     * 
     * @param socket Socket - Corresponde ao socket da conexão.
     * 
     * @return String - Corresponde à requisição recebida.
     * 
     * @throws IOException - Corresponde à exceção referente à manipulação do
     * Socket, BufferedReader e InputStreamReader.
     */
    private static String getMessage(Socket socket) throws IOException
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String string = "";
        int c, i=0;
 
        while ((c = br.read()) != -1)
            string = string + (char) c;
        
        return string;                     
    }
    
    /**
     * Método responsável por verificar qual requisição foi enviada.
     * 
     * @param message String - Corresponde à requisição recebida.
     * 
     * @return int - Corresponde ao tipo de requisição recebida.
     */
    private static int checkRequests(String message)
    {
        int check = 0;
        String[] splitSpace = message.split(" ");
        char c1, c2, c3, c;
        
        switch(splitSpace[0])
        {   case "MASTER_PEER":
                c1 = splitSpace[2].charAt(splitSpace[2].length()-1);
                c2 = splitSpace[2].charAt(splitSpace[2].length()-2);
                
                switch(splitSpace[1])
                {   case "CONNECT":
                        if (c1 == '\n' && c2 == '\n')
                            check = 1;
                        break;
                    case "DISCONNECT":
                        if (c1 == '\n' && c2 == '\n')
                        {   sender = splitSpace[2].replaceAll("\\\n", "");
                            check = 7;
                        }
                        break;
                    case "UPDATE":
                        if (c1 == '\n' && c2 == '\n')
                            check = 8;
                        break;
                }
                break;
            case "PEER_GROUP":
                c1 = splitSpace[splitSpace.length-1].charAt(splitSpace[splitSpace.length-1].length()-1);
                c2 = splitSpace[splitSpace.length-1].charAt(splitSpace[splitSpace.length-1].length()-2);
                c3 = splitSpace[splitSpace.length-1].charAt(splitSpace[splitSpace.length-1].length()-3);
                
                if (c1 == '\n' && c2 == '\n' && c3 == '\n')
                    check = 2;
                break;
            case "TALK_TO":
                c1 = splitSpace[1].charAt(splitSpace[1].length()-1);
                c2 = splitSpace[1].charAt(splitSpace[1].length()-2);
                
                if (c1 == '\n' && c2 == '\n')
                    check = 3;
                break;
            case "ACCEPT_TALKING":
                c1 = splitSpace[1].charAt(splitSpace[1].length()-1);
                c2 = splitSpace[1].charAt(splitSpace[1].length()-2);
                
                if (c1 == '\n' && c2 == '\n')
                    check = 4;
                break;
            case "SEND_MSG":
                c1 = splitSpace[splitSpace.length-1].charAt(splitSpace[splitSpace.length-1].length()-1);
                c2 = splitSpace[splitSpace.length-1].charAt(splitSpace[splitSpace.length-1].length()-2);
                
                if (c1 == '\n' && c2 == '\n')
                {   
                    for (int i=message.length()-3; i>message.length()-3-Integer.parseInt(splitSpace[1]); i--)
                    {   c = message.charAt(i);
                        chat = c + chat;                        
                    }
                    
                    for (int j=message.length()-3-Integer.parseInt(splitSpace[1]); message.charAt(j)!=' '; j--)
                    {   c = message.charAt(j);
                        sender = c + sender;                        
                    }
                    check = 5;
                }
                break;
            case "RECV_MSG":
                c1 = splitSpace[1].charAt(splitSpace[1].length()-1);
                c2 = splitSpace[1].charAt(splitSpace[1].length()-2);
                
                if (c1 == '\n' && c2 == '\n')
                    check = 6;
                break;
        }
        
        return check;
    }
    
    /**
     * Método responsável por remover um peer da tabela de peers online através
     * do seu id.
     * 
     * @param peerId String - Corresponde ao id do peer.
     */
    private void removePeer(String peerId)
    {
        for (int i=0; i<online.size(); i++)
            if(peerId.equals(online.get(i).getPeerID()))
            {   online.remove(online.get(i));
                break;
            }
    }
    
    /**
     * Método responsável por criar um PeerTable para o peer.
     * 
     * @param split String[] - Corresponde à mensagem splitada por nova linha.
     * 
     * @return PeerTable - Corresponde ao peerTable referente ao peer. 
     */
    private PeerTable setPeerTable(String[] split)
    {
        PeerTable peerTable = new PeerTable();
        
        peerTable.setPeerIP(socket.getInetAddress().getHostAddress());
        peerTable.setPeerID(String.valueOf(peerTable.getPeerIP().hashCode()));
        peerTable.setPeerName(split[0]);
        peerTable.setPeerStatus(true);
        
        return peerTable;
    }
    
    /**
     * Método responsável por converter a mensagem recebida em PeerTable.
     * 
     * @param message String - Corresponde à requisição recebida.
     * 
     * @return PeerTable - Corresponde ao peerTable do peer, referente à
     * requisição recebida.
     */
    public static PeerTable getPeerTable(String message)
    {
        PeerTable peerTable = new PeerTable();
        String[] splitComma = message.split(",");
        String conc = "";
        boolean flag = false;
        char c;

        peerTable.setPeerName(splitComma[1]);
        peerTable.setPeerIP(splitComma[2]);
        
        for (int i=0; i<splitComma[0].length(); i++)    
        {   c = splitComma[0].charAt(i);
            if (flag)
                conc = conc + c;
            if (c == '(')
                flag = true;            
        }
        peerTable.setPeerID(conc);
        
       conc = splitComma[splitComma.length-1].replaceAll("\\)", "");
       peerTable.setPeerStatus(Boolean.valueOf(conc));       

        return peerTable;     
    }
    
    /**
     * Método responsável retornar o nick através id do peer.
     * 
     * @param id String - Corresponde ao id do peer.
     * 
     * @return String - Corresponde ao nick do peer.
     */
    private String giveIdReturnName(String id)
    {    
        for (int i=0; i<online.size(); i++)
            if (online.get(i).getPeerID().equals(id))
                return online.get(i).getPeerName();
                
        
        return null;
    }
    
    /**
     * Método responsável por realizar as decisões do tipo de requisição e
     * chamas as classes para atende/responde-las.
     */
    @Override
    public void run() 
    {   
        String message;
        int check;
        String[] split;
        Answer answer;
        
        try
        {   message = getMessage(socket);
            System.out.println (message);
            check = checkRequests(message);
            
            switch(check)
            {   case 1:
                    split = message.split(" ");
                    split = split[2].split("\n");
                    
                    online.add(setPeerTable(split));

                    answer = new Answer(socket, online, peer);
                    answer.answer(check);
                    break;
                case 2: 
                    split = message.split("\n");
                    
                    for (int i=0; i<split.length; i++)
                        peer.addOnline(getPeerTable(split[i]));

                    peer.setMyID(online.get(online.size()-1).getPeerID());
                    peer.setMyIP(online.get(online.size()-1).getPeerIP());
                    
                    setText(message);
                    break;
                case 3:
                    answer = new Answer(socket, online, peer);
                    answer.answer(check);
                    setText(message);
                    break;
                case 4:
                    changeButton();
                    setText(message);
                    break;
                case 5:
                    answer = new Answer(socket, online, peer);
                    answer.answer(check);
                    setText(message);                   
                    chatText(giveIdReturnName(sender) + " says: " + chat + "\n");
                    break;
                case 6:
                    setText(message);
                    break;
                case 7:
                    removePeer(sender);
                    answer = new Answer(socket, online, peer);
                    answer.answer(check);
                    break;
                case 8:
                    split = message.split("\n");
                    peer.clearOnline();
                    
                    for (int i=0; i<split.length; i++)
                        peer.addOnline(getPeerTable(split[i]));

                    answer = new Answer(socket, online, peer);
                    answer.answer(check);
                    setText(message);
                    break;
            }   
        }
        catch (IOException e)
        {   e.printStackTrace();
        } 
    }
    
}
