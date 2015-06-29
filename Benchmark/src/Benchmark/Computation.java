/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

import java.util.ArrayList;

/**
 * Classe responsável pelos cálculos de tempo e taxa de transferência.
 * 
 * @author gustavopinho
 */
public class Computation 
{   
    private double startTime, endTime;
    
    /**
     * Método responsável por capturar o horário.
     */
    public void startTime()
    {
        startTime = System.nanoTime();
    }
    
    /**
     * Método responsável por calcular o tempo de execução.
     * 
     * @return double - Corresponde ao tempo de execução do programa.
     */
    public  double endTime()
    {   
        endTime = (System.nanoTime()- startTime) / 1000000000;
        
        return endTime;        
    }
    
    /**
     * Método responsável por calcular a taxa de transferência da execução do
     * programa.
     * 
     * @param fileSize long - Corresponde ao tamanho do arquivo em bytes.
     * 
     * @return double - Corresponde à taxa de transferência em MB.
     */
    public double throughput(long fileSize)
    {
        return fileSize / (endTime * 1024L * 1024L);
    }
    
    /**
     * Método responsável por calcular a média dentre as taxas de transferência.
     * 
     * @param throughputs ArrayList - Corresponde à lista de taxas de
     * transferência.
     * 
     * @return double - Corresponde à média calculada.
     */
    public double average(ArrayList<Double> throughputs)
    {   
        double average = 0;
        
        for (int i=0; i<throughputs.size(); i++)
            average += throughputs.get(i);
        
        return average / throughputs.size();
    }
    
    /**
     * Método responsável por calcular a variância dentre as taxas de
     * transferência.
     * 
     * @param throughputs ArrayList - Corresponde à lista de taxas de
     * transferência.
     * 
     * @return double - Corresponde à variância calculada.
     */
    public double variance(ArrayList<Double> throughputs)
    {   
        double variance = 0;
        double average = average(throughputs);
        
        for (int i=0; i<throughputs.size(); i++)
            variance = Math.pow ((throughputs.get(i) - average), 2);
        
        return variance / (throughputs.size() - 1);        
    }
    
    /**
     * Método responsável por calcular o desvio padrão dentre as taxas de
     * transferência.
     * 
     * @param throughputs ArrayList - Corresponde à lista de taxas de
     * transferência.
     * 
     * @return double - Corresponde ao desvio padrão calculado.
     */
    public double standartDeviation(ArrayList<Double> throughputs)
    {
        return Math.sqrt(variance(throughputs));
    }
    
    
}
