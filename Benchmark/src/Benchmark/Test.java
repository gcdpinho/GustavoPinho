/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Benchmark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavopinho
 */
public class Test 
{   
    private ByteConverter byteConverter;
    private ArrayList<Double> throughputs;
    private Computation computation;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    
    public Test()
    {
        byteConverter = new ByteConverter();
        throughputs = new ArrayList<>();
        computation = new Computation();
        try {
            fileWriter = new FileWriter("Test.txt");
            printWriter = new PrintWriter(fileWriter);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initialTest()
    {   
        Random randomGeneration = new Random();
        double executionTime = 0;
        long fileSize = byteConverter.converterGB(1);
        long packSize = byteConverter.converterKB(4);
        int initial = 0, end = 4, c = 0;
        
        for (int i=0; i<50; i++)
        {   computation.startTime();
            WritingObject writeObj = new WritingObject("Sequential_Write"+randomGeneration.nextInt()+".txt", (int) packSize, fileSize);
            writeObj.sequentialWrite(true);
            executionTime = executionTime + computation.endTime();
            throughputs.add(computation.throughput(fileSize));
        }
        
        printWriter.println("escrita sequencial (4):");
        printWriter.println("Média: "+computation.average(throughputs)+" MB/s\n");
        printWriter.println("Desvio padrão: "+computation.standartDeviation(throughputs)+" MB/s\n");
        printWriter.println("Tempo de execução: "+executionTime+" s");
        
        throughputs.clear();
        executionTime = 0;
        packSize = byteConverter.converterKB(8);
        
        for (int i=0; i<50; i++)
        {   computation.startTime();
            WritingObject writeObj = new WritingObject("Sequential_Write"+randomGeneration.nextInt()+".txt", (int) packSize, fileSize);
            writeObj.sequentialWrite(true);
            executionTime = executionTime + computation.endTime();
            throughputs.add(computation.throughput(fileSize));
        }
        
        printWriter.println("escrita sequencial (8):");
        printWriter.println("Média: "+computation.average(throughputs)+" MB/s\n");
        printWriter.println("Desvio padrão: "+computation.standartDeviation(throughputs)+" MB/s\n");
        printWriter.println("Tempo de execução: "+executionTime+" s");
        
        throughputs.clear();
        executionTime = 0;
        packSize = byteConverter.converterKB(4);
        
        for (int i=0; i<1; i++)
        {   computation.startTime();
            WritingObject writeObj = new WritingObject("Random_Write"+randomGeneration.nextInt()+".txt", (int) packSize, fileSize);
            writeObj.randomWrite(0);
            executionTime = executionTime + computation.endTime();
            throughputs.add(computation.throughput(fileSize));
        }
        
        printWriter.println("escrita randomica (4):");
        printWriter.println("Média: "+computation.average(throughputs)+" MB/s\n");
        printWriter.println("Desvio padrão: "+computation.standartDeviation(throughputs)+" MB/s\n");
        printWriter.println("Tempo de execução: "+executionTime+" s");
        
        throughputs.clear();
        executionTime = 0;
        packSize = byteConverter.converterKB(8);
        
        for (int i=0; i<1; i++)
        {   computation.startTime();
            WritingObject writeObj = new WritingObject("Random_Write"+randomGeneration.nextInt()+".txt", (int) packSize, fileSize);
            writeObj.randomWrite(0);
            executionTime = executionTime + computation.endTime();
            throughputs.add(computation.throughput(fileSize));
        }
        
        printWriter.println("escrita randomica (8):");
        printWriter.println("Média: "+computation.average(throughputs)+" MB/s\n");
        printWriter.println("Desvio padrão: "+computation.standartDeviation(throughputs)+" MB/s\n");
        printWriter.println("Tempo de execução: "+executionTime+" s");
        
        throughputs.clear();
        executionTime = 0;
        packSize = byteConverter.converterKB(4);
        
        for (int i=0; i<50; i++)
        {   if (i == 0 || c == 3)
            {   for (int j=initial; j<end; j++)
                {   WritingObject writeObj = new WritingObject("Read_File"+j+".txt", (int) packSize, fileSize);
                    writeObj.sequentialWrite(false);    
                }
                if (i == 0)
                    c = 0;
                else
                    c = -1;
                initial += 4;
                end += 4;
            }

            computation.startTime();
            ReadingObject readObj = new ReadingObject("Read_File"+i+".txt", (int) packSize);
            readObj.sequentialRead();
            executionTime = executionTime + computation.endTime();
            throughputs.add(computation.throughput(fileSize));
            c++;
        }
        
        printWriter.println("leitura sequencial (4):");
        printWriter.println("Média: "+computation.average(throughputs)+" MB/s\n");
        printWriter.println("Desvio padrão: "+computation.standartDeviation(throughputs)+" MB/s\n");
        printWriter.println("Tempo de execução: "+executionTime+" s");
        
        throughputs.clear();
        executionTime = 0;
        packSize = byteConverter.converterKB(8);
        initial = 0; end = 4; c = 0;
        
        for (int i=0; i<50; i++)
        {   if (i == 0 || c == 3)
            {   for (int j=initial; j<end; j++)
                {   WritingObject writeObj = new WritingObject("Read_File"+j+".txt", (int) packSize, fileSize);
                    writeObj.sequentialWrite(false);    
                }
                if (i == 0)
                    c = 0;
                else
                    c = -1;
                initial += 4;
                end += 4;
            }

            computation.startTime();
            ReadingObject readObj = new ReadingObject("Read_File"+i+".txt", (int) packSize);
            readObj.sequentialRead();
            executionTime = executionTime + computation.endTime();
            throughputs.add(computation.throughput(fileSize));
            c++;
        }
        
        printWriter.println("leitura sequencial (8):");
        printWriter.println("Média: "+computation.average(throughputs)+" MB/s\n");
        printWriter.println("Desvio padrão: "+computation.standartDeviation(throughputs)+" MB/s\n");
        printWriter.println("Tempo de execução: "+executionTime+" s");
        
        throughputs.clear();
        executionTime = 0;
        packSize = byteConverter.converterKB(4);
        initial = 0; end = 4; c = 0;
        
        for (int i=0; i<1; i++)
        {   if (i == 0 || c == 3)
            {   for (int j=initial; j<end; j++)
                {   WritingObject writeObj = new WritingObject("Read_File"+j+".txt", (int) packSize, fileSize);
                    writeObj.sequentialWrite(false);    
                }
                if (i == 0)
                    c = 0;
                else
                    c = -1;
                initial += 4;
                end += 4;
            }

            computation.startTime();
            ReadingObject readObj = new ReadingObject("Read_File"+i+".txt", (int) packSize);
            readObj.randomRead(0);
            executionTime = executionTime + computation.endTime();
            throughputs.add(computation.throughput(fileSize));
            c++;
        }
        
        printWriter.println("leitura randomica (4):");
        printWriter.println("Média: "+computation.average(throughputs)+" MB/s\n");
        printWriter.println("Desvio padrão: "+computation.standartDeviation(throughputs)+" MB/s\n");
        printWriter.println("Tempo de execução: "+executionTime+" s");
        
        throughputs.clear();
        executionTime = 0;
        packSize = byteConverter.converterKB(8);
        initial = 0; end = 4; c = 0;
        
        for (int i=0; i<52; i++)
        {   File file = new File ("Read_File"+i+".txt");
            if (file.exists())
                file.delete();
        }
        
        for (int i=0; i<1; i++)
        {   if (i == 0 || c == 3)
            {   for (int j=initial; j<end; j++)
                {   WritingObject writeObj = new WritingObject("Read_File"+j+".txt", (int) packSize, fileSize);
                    writeObj.sequentialWrite(false);    
                }
                if (i == 0)
                    c = 0;
                else
                    c = -1;
                initial += 4;
                end += 4;
            }

            computation.startTime();
            ReadingObject readObj = new ReadingObject("Read_File"+i+".txt", (int) packSize);
            readObj.randomRead(0);
            executionTime = executionTime + computation.endTime();
            throughputs.add(computation.throughput(fileSize));
            c++;
        }
        
        printWriter.println("leitura randomica (8):");
        printWriter.println("Média: "+computation.average(throughputs)+" MB/s\n");
        printWriter.println("Desvio padrão: "+computation.standartDeviation(throughputs)+" MB/s\n");
        printWriter.println("Tempo de execução: "+executionTime+" s");
        
        printWriter.close();
        
        for (int i=0; i<52; i++)
        {   File file = new File ("Read_File"+i+".txt");
            if (file.exists())
                file.delete();
        }
    }
    
}
