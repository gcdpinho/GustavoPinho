/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

/**
 * Classe responsável por converter para bytes, o parâmetro dado.
 * 
 * @author gustavopinho
 */
public class ByteConverter 
{   
    /**
     * Método responsável por converter de K bytes para bytes.
     * 
     * @param kb long - Correponsde ao número em K bytes.
     * 
     * @return long - Corresponde ao número em bytes, após a conversão.
     */
    public long converterKB(long kb)
    {
        return kb * 1024L;
    }
    
     /**
     * Método responsável por converter de M bytes para bytes.
     * 
     * @param mb long - Correponsde ao número em M bytes.
     * 
     * @return long - Corresponde ao número em bytes, após a conversão.
     */
    public long converterMB(long mb)
    {
        return mb * 1024L * 1024L;
    }
    
     /**
     * Método responsável por converter de G bytes para bytes.
     * 
     * @param gb long - Correponsde ao número em G bytes.
     * 
     * @return long - Corresponde ao número em bytes, após a conversão.
     */
    public long converterGB(long gb)
    {
        return gb * 1024L * 1024L * 1024L;
    }
    
    /**
     * Método responsável por converter de bytes para K bytes.
     * 
     * @param b long - Corresponde ao número em bytes.
     * 
     * @return long - Corresponde ao número em K bytes, após a conversão.
     */
    public long converterToKB(long b)
    {
        return b / 1024L;
    }
    
    /**
     * Método responsável por converter de bytes para M bytes.
     * 
     * @param b long - Corresponde ao número em bytes.
     * 
     * @return long - Corresponde ao número em M bytes, após a conversão.
     */
    public long converterToMB(long b)
    {
        return b / (1024L * 1024L);
    }
    
    /**
     * Método responsável por converter de bytes para G bytes.
     * 
     * @param b long - Corresponde ao número em bytes.
     * 
     * @return long - Corresponde ao número em G bytes, após a conversão.
     */
    public long converterToGB(long b)
    {
        return b / (1024L * 1024L * 1024L);
    }
    
}
