package ChatP2P;

import Upnp.GatewayDevice;
import Upnp.GatewayDiscover;
import Upnp.PortMappingEntry;
import java.net.InetAddress;
import java.util.Map;
import java.io.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class Upnp{
    Map<InetAddress,GatewayDevice>gateways;
    GatewayDevice activeGW;
    public Upnp() {
        // Objeto utilizado para descobrir os roteadores
        GatewayDiscover gatewayDiscover = new GatewayDiscover();
        try{
            // Lista de roteadores descobertos
            this.gateways=gatewayDiscover.discover();
            // Escolhe um roteador ativo e valido
            activeGW=gatewayDiscover.getValidGateway();
        }catch (SAXException | ParserConfigurationException | IOException ex){
            System.out.println("Roteadores não foram localizados!");
        }
    }
    //roteador em uso
    private boolean roteadorSendoUsado() {
        if (this.gateways.isEmpty()) {
            return false;
        } else if (this.activeGW == null) {
            return false;
        }
        return true;
    }
    public boolean portMap(int internalPort){
        // Objeto que realiza mapeamentos de porta.
        PortMappingEntry portMapping=new PortMappingEntry();
        // Endereco interno
        InetAddress localAddress=activeGW.getLocalAddress();
        try {
            if (this.activeGW.getSpecificPortMappingEntry(6991, "TCP", portMapping)) {
                return false;
            }
            activeGW.addPortMapping(6991, internalPort, localAddress.getHostAddress(), "TCP", "Chat");

        } catch (IOException | SAXException ex) {
            System.out.println("Impossivel realizar o mapeamento da porta " + ex);
        }
        return true;
    }
    
    public boolean revertPortMap() throws IOException, SAXException{
        if(activeGW.deletePortMapping(6991,"TCP")){
           return true;
        }else{
            return false;
        }
    }
}