/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZombieGameOfLife;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
* Classe responsável pela leitura do arquivo de configuração e posteriormente,
 * a escrita da saída do programa e do arquivo de estatísticas.
 * 
 * @author gustavopinho
 */
public class FileIO 
{   
    private File file;
    private FileWriter fw;
    private BufferedWriter fileWriter;
    
    /**
     * Método Construtor para escrita em um arquivo.
     * 
     * @param fileName String - Corresponde ao nome do arquivo de saída.
     */
    public FileIO(String fileName) 
    {
        this.file = new File(fileName);
        try
        {   if (!this.file.exists())
                this.file.createNewFile();            
        }
        catch (IOException e)
        {   JOptionPane.showMessageDialog(null, "Não foi possível criar aquivo!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
                
        
        try 
        {   this.fw = new FileWriter(file);
        } 
        catch (IOException e) 
        {   JOptionPane.showMessageDialog(null, "Não foi possível usar o aquivo para escrever!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        this.fileWriter = new BufferedWriter(fw);       
    }
    
    /**
     * Método construtor para leitura de um arquivo.
     */
    public FileIO()
    {        
    }
    
    /**
    * Método responsável pela leitura de um arquivo (entrada), e construção de
    * um array contendo os parâmetros para criação do grid inicial.
    * 
    * @param fileName String - Nome do arquivo de entrada usado para leitura.
    * 
    * @return ArrayList - Retorna o array com os parâmetros para a criação do 
    * grid inicial.
    */
    public ArrayList<Integer> readFile (String fileName)
    {   
        ArrayList<Integer> input = new ArrayList<>();
        String readLine, tempSpace[];
        
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName)))
        {   while ((readLine = fileReader.readLine()) != null)
            {   tempSpace = readLine.split(Pattern.quote(" "));
                addInput(tempSpace, input);
            }
        }
        catch (IOException e)
        {   JOptionPane.showMessageDialog(null, "O arquivo não foi encontrado no diretório!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        
        return input;
    }
    
    /**
     * Método responsável pela adição dos parâmetros, usados para criação do
     * grid inicial em um array.
     * 
     * @param tempSpace String - String auxiliar que contém os parâmetros
     * divididos pelos espaços.
     * 
     * @param input ArrayList - Array em que será adicionado os parâmetros para
     * construção do grid inicial.
     */
    private static void addInput(String tempSpace[], ArrayList<Integer> input)
    {   
        String tempComma[];
    
        try 
        {   tempComma = tempSpace[0].split(Pattern.quote(","));
            input.add(Integer.parseInt(tempComma[0]));
            input.add(Integer.parseInt(tempComma[1]));
            input.add(Integer.parseInt(tempSpace[1]));
        }
        catch (IndexOutOfBoundsException | NumberFormatException  e)
        {   JOptionPane.showMessageDialog(null, "O arquivo de configuração possui entradas inválidas!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }        
    }
    /**
     * Método responsável por escrever no arquivo de saída o grid final de cada
     * geração.
     
     * @param grid Grid - Corresponde ao grid à ser escrito.
     * 
     * @param size int - Corresponde ao tamanho do grid.
     * 
     * @throws java.io.IOException - Exceção correspondente à falha na escrita
     * do arquivo de saída.
     */
    public void writeFile (Grid grid, int size) throws IOException 
    {                
        for (int i=0; i<size; i++)
        {   for (int j=0; j<size; j++)
                this.fileWriter.write(grid.getGrid(i, j)+ " ");

            this.fileWriter.newLine();
        }
        this.fileWriter.newLine();       
    }
    
    public void writeStatistics(long mem, long temp, int i) throws IOException
    {   this.fileWriter.write("Geração "+i+":");
        this.fileWriter.newLine();
        this.fileWriter.write("Memória utilizada: "+mem+" B");
        this.fileWriter.newLine();
        this.fileWriter.write("Tempo gasto: "+temp+" ns");
        this.fileWriter.newLine();
        this.fileWriter.newLine();        
    }
    
    /**
     * Método responsável por fechar os atributos que tem com função escrever no
     * arquivo de saída.
     * 
     * @throws IOException - Exceção caso ocorra algum problema ao fechar os
     * atributos.
     */
    public void closeWriteFile() throws IOException
    {   this.fileWriter.close();
        this.fw.close();        
    }
       
}
