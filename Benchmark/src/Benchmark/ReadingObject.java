/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.SplittableRandom;

/**
 * Classe responsável por realizar leituras de arquivos.
 * 
 * @author gustavopinho
 */
public class ReadingObject 
{   
    private File archive;
    private int packSize;
    
    /**
     * Método construtor.
     * 
     * @param fileName String - Corresponde ao nome do arquivo a ser lido.
     * 
     * @param packSize int - Corresponde ao tamanho do bloco do arquivo a ser 
     * lido.
     */
    public ReadingObject(String fileName, int packSize)
    {
        this.archive = new File(fileName);
        this.packSize = packSize;
    }
    
    /**
     * Método responsável por ler o arquivo de forma sequencial.
     */
    public void sequentialRead()
    {   
        byte[] byteFile = new byte[this.packSize];
        int readFlag = 0;
        
        try (RandomAccessFile file = new RandomAccessFile(archive, "r"))
        {   while (readFlag != -1)
                readFlag = file.read(byteFile);         
        }
        catch (IOException e)
        {   e.printStackTrace();
            System.exit(1);
        }
        
        archive.delete();
    }
    
    /**
     * Método reponsável por ler o arquivo de forma aleatória.
     * 
     * @param iteration int - Corresponde ao número de iterações da leitura
     * (0 - tamanho total do arquivo).
     */
    public void randomRead(int iteration)
    {
        SplittableRandom randomGeneration = new SplittableRandom();
        byte[] byteFile = new byte[this.packSize];
        long numIteration, fileSize;
        
        try (RandomAccessFile file = new RandomAccessFile(archive, "r"))
        {   fileSize = file.length();
            if (iteration == 0)
                numIteration = fileSize/this.packSize;
            else
                numIteration = iteration;
            for (int i=0; i<numIteration; i++)
            {   file.seek(randomGeneration.nextLong(fileSize));
                file.read(byteFile);                
            }
        }
        catch (IOException e)
        {   e.printStackTrace();
            System.exit(1);
        }
        
        archive.delete();
    }
    
}
