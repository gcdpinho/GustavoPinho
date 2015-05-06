/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatP2P;

/**
 * Classe responsável por armazenar as informações do peer.
 * 
 * @author gustavopinho
 */
public class PeerTable 
{   
    private String peerID;
    private String peerIP;
    private String peerName;
    private boolean peerStatus;
    //private String peerKey;

    /**
     * Método getter, reponsável por retornar peerName.
     * 
     * @return String - Corresponde ao atributo peerName.
     */
    public String getPeerName()
    {
        return peerName;
    }
    
    /**
     * Método setter, responsável por setar o peerName.
     * 
     * @param name String - Corresponde ao nome desejado do peerName.
     */
    public void setPeerName(String name) 
    {
        this.peerName = name;
    }
    
    /**
     * Método getter, responsável por retornar o peerID.
     * 
     * @return String - Corresponde ao atributo peerID.
     */
    public String getPeerID() 
    {
        return peerID;
    }
    
    /**
     * Método setter, responsável por setar o peerID.
     * 
     * @param peerID String - Corresponde ao peerID desejado
     */
    public void setPeerID(String peerID) 
    {
        this.peerID = peerID;
    }
    
    /**
     * Método getter, responsável por retornar o peerIP.
     * 
     * @return String - Corresponde ao atributo peerIP.
     */
    public String getPeerIP() 
    {
        return peerIP;
    }

    /**
     * Método setter, responsável por setar o peerIP.
     * 
     * @param peerIP String - Corresponde ao peerIP desejado.
     */
    public void setPeerIP(String peerIP) 
    {
        this.peerIP = peerIP;
    }
    
    /**
     * Método getter, responsável por retornar o peerStatus.
     * 
     * @return boolean - Corresponde ao atributo peerStatus.
     */
    public boolean isPeerStatus() 
    {
        return peerStatus;
    }

    /**
     * Método setter, responsável por setar o peerStatus.
     * 
     * @param peerStatus boolean - Corresponde ao peerStatus desejado.
     */
    public void setPeerStatus(boolean peerStatus) 
    {
        this.peerStatus = peerStatus;
    }    
    
}
