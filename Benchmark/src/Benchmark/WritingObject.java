/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.SplittableRandom;

/**
 * Classe responsável por realizar escritas em arquivos.
 * 
 * @author gustavopinho
 */
public class WritingObject 
{
    private File archive;
    private int packSize;
    private long fileSize;
    
    /**
     * Método construtor.
     * 
     * @param fileName String - Corresponde ao nome do arquivo a ser escrito.
     * 
     * @param packSize int - Corresponde ao tamanho do bloco do arquivo a ser 
     * escrito.
     * 
     * @param fileSize long - Corresponde ao tamanho total do arquivo a ser
     * escrito.
     */
    public WritingObject(String fileName, int packSize, long fileSize)
    {
        this.archive = new File (fileName);
        this.packSize = packSize;
        this.fileSize = fileSize;
    }
    
    /**
     * Método responsável por escrever em um arquivo de forma sequencial.
     * 
     * @param flag boolean - Corresponde ao flag que diferencia a operação write
     * da geração de um arquivo para a operação leitura.
     */
    public void sequentialWrite(boolean flag)
    {   
        Random writerGeneration = new Random();
        byte[] byteFile = new byte[this.packSize];
        
        try (RandomAccessFile file = new RandomAccessFile(archive, "rw"))
        {   while (file.length() < this.fileSize)
            {   writerGeneration.nextBytes(byteFile);
                file.write(byteFile, 0, byteFile.length);
            }
        }
        catch (IOException e)
        {   e.printStackTrace();
            System.exit(1);
        }
        
        if (flag)
            archive.delete();
    }
    
    /**
     * Método reponsável por escrever em um arquivo de forma aleatória.
     * 
     * @param iteration int - Corresponde ao número de iterações da leitura
     * (0 - tamanho total do arquivo).
     */
    public void randomWrite(int iteration)
    {   
        Random writerGeneration = new Random();
        SplittableRandom randomGeneration = new SplittableRandom();
        byte[] byteFile = new byte[this.packSize];
        long numIteration;
        
        try (RandomAccessFile file = new RandomAccessFile(archive, "rw"))
        {   if (iteration == 0)
                numIteration = this.fileSize/this.packSize;
            else
                numIteration = iteration;
            for (int i=0; i<numIteration; i++)
            {   file.seek(randomGeneration.nextLong(this.fileSize));
                writerGeneration.nextBytes(byteFile);
                file.write(byteFile, 0, byteFile.length);                
            }
        }
        catch (IOException e)
        {   e.printStackTrace();
            System.exit(1);
        }
        
        archive.delete();
    }
    
}
