/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatP2P;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import sun.security.x509.X500Name;

/**
 *
 * @author João Pedro Bretanha
 */
public class GenCertificate {
    private PublicKey pubKey;
    private Certificate certificate;
    private KeyPair keyPair;
    private char[] password;
    
    
    GenCertificate(String password){
        this.password = password.toCharArray();
    }
    
    public void geraCertificado(String alias, String password) throws FileNotFoundException, KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException, UnrecoverableKeyException{
        this.password = password.toCharArray();
        FileOutputStream arquivo = new FileOutputStream(alias + ".jks");
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
        CertAndKeyGen keypair = new CertAndKeyGen("RSA", "SHA1WithRSA", null);
        X500Name x500Name = new X500Name("chat", "Ufpel", "Ufpel", "Pelotas", "RS", "Brasil");
        keypair.generate(1024);
        PrivateKey privateKey = keypair.getPrivateKey();

        X509Certificate[] selfCertificate = new X509Certificate[1];
        selfCertificate[0] = keypair.getSelfCertificate(x500Name, new Date(), 2000000);
        keyStore.setKeyEntry(alias, privateKey, password.toCharArray(), selfCertificate);
        keyStore.store(arquivo, password.toCharArray());
        
        FileInputStream is = new FileInputStream(alias + ".jks");

        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(is, this.password);

        Key key = keystore.getKey(alias, this.password);

        if (key instanceof PrivateKey) {
            // Get certificate of public key
            this.certificate = keystore.getCertificate(alias);

            // Get public key
            this.pubKey = certificate.getPublicKey();

            // Return a key pair
            this.keyPair = new KeyPair(pubKey, (PrivateKey) key);
        }
            is.close();
        
    }
    public static void storeCert(Certificate certificado, String nomeDoCertificado, String senha) {
        try {

            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(null, null);
            ks.setCertificateEntry("servidor", certificado);
            FileOutputStream output = new FileOutputStream(nomeDoCertificado + ".jks");
            ks.store(output, senha.toCharArray());
            output.close();
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException ex) {
            System.out.println("aeHOOO");
        }
    }
    public KeyPair getKeyPair() {
        return keyPair;
    }

    public PublicKey getPubKey() {
        return pubKey;
    }

    public Certificate getCertificate() {
        return certificate;
    }
}
