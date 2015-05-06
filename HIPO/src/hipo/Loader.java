
package hipo;

import static Interface.FormMain.setText;
import additional.Symbols;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Loader 
{   private Linked linked;
    private int carga;
    private ArrayList <Symbols> symbolTable;
    private int memory[];
    private int address[];
    private int end;
    
    String readLine;
    String symbols[];
    
    public Loader(int mod, int carga)
    {   this.linked = new Linked(mod);
        this.carga = carga;
        this.symbolTable = new ArrayList();
        this.memory = new int[100];
        this.end = 0;
    }
    
    public int[] getMemory()
    {   return this.memory;        
    }
    
    public int getEnd()
    {   return end;        
    }
    
     public int[] getAddress()
    {   return this.address;        
    }
    
    
    public void firstStep() throws IOException
    {   this.linked.firstStep();
        this.symbolTable = this.linked.getSymbolTableGlobal();
        //Atualização da carga na tabela de simbolos
        for (int i=0; i<symbolTable.size(); i++)
            this.symbolTable.get(i).setAddress(this.symbolTable.get(i).getAddress()+this.carga);
        this.address = this.linked.getAddress();
        secondStep();
        thirdStep();
    }
    
    //Criação do codigo objeto pós carga
    private void secondStep() throws IOException
    {   File file = new File("outloader.txt");
        if (!file.exists())    
            file.createNewFile(); // Cria um arquivo (vazio)
        
        // Escreve no arquivo 
        FileWriter fw = new FileWriter(file);
        BufferedWriter fileWriter = new BufferedWriter(fw);
        
        
        // Faz a leitura do arquivo.
        try (BufferedReader fileReader = new BufferedReader(new FileReader("templinked.txt")))
        {   while ((readLine = fileReader.readLine()) != null) 
            {   symbols = readLine.split(Pattern.quote(" ")); // Separa os simbolos pelo espaço.
                fileWriter.write(symbols[0]);
                if (symbols.length > 1)
                    SearchTable (symbols[1], fileWriter);   
                else
                    fileWriter.newLine();
            }
        }
        catch (IOException e) 
        {   setText ("ERRO 7: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
        }
        fileWriter.close();
        fw.close();
    }
    
    private void SearchTable(String symbol, BufferedWriter fileWriter) throws IOException
    {   //Procura na tabela de simbolos "global" pós carga
        for (int i=0; i<this.symbolTable.size(); i++)
            if (symbol.equals(symbolTable.get(i).getSymbol()))
            {   if (symbolTable.get(i).getAddress() < 10)
                    fileWriter.write("0"+symbolTable.get(i).getAddress());
                else
                    fileWriter.write(""+symbolTable.get(i).getAddress());
                fileWriter.newLine();
                break;
            }              
    }
    
    //Faz a carga do programa na memória
    private void thirdStep() throws FileNotFoundException
    {   int index = 1 + this.carga, countNeighbors=0, i=0, aux;
        
        // Faz a leitura do arquivo.
        try (BufferedReader fileReader = new BufferedReader(new FileReader("outloader.txt")))
        {   while ((readLine = fileReader.readLine()) != null)
            {   symbols = readLine.split(Pattern.quote("+")); // Separa os simbolos pelo +.
                if (!"7000".equals(symbols[1]))
                {   memory[index] = Integer.parseInt(symbols[1]);
                    index++;
                    countNeighbors++;
                }
                else
                {   memory[index] = Integer.parseInt(symbols[1]);
                    aux = this.address[i] - countNeighbors - 1;
                    index += aux;
                    countNeighbors = 0;
                    i++;
                }
            }
        }
        catch (IOException e) 
        {   setText ("ERRO 8: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
        }
        end = index;
    }
    
}
