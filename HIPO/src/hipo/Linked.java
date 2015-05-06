
package hipo;

import static Interface.FormMain.setText;
import additional.Symbols;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Linked 
{   private ArrayList <Symbols> symbolTableGlobal;
    private int numMod; //Número de módulos, por padrão = 2.
    private ArrayList <Mounter> modulos;
    private int address[];
    
    String readLine;
    String symbols[];
        
    public Linked(int mod)
    {   this.symbolTableGlobal = new ArrayList();
        this.numMod = mod;
        this.modulos = new ArrayList();
        for (int i=0; i<this.numMod; i++)
            this.modulos.add(new Mounter());
        this.address = new int[numMod];
    }   
    
    public ArrayList <Symbols> getSymbolTableGlobal()
    {   return this.symbolTableGlobal;        
    }
    
    public int[] getAddress()
    {   return this.address;        
    }
    
    public void firstStep() throws IOException
    {   //Montando os modulos
        for (int i=0; i<this.numMod; i++)
        {   this.modulos.get(i).firstStep(""+(i+1));
            this.address[i] = modulos.get(i).getAddress();
        } 
        secondStep();
        thirdStep();
        fourthStep();
    }
    
    //Faz a junção dos modulos com os labels
    private void secondStep() throws IOException
    {   File file = new File("templinked.txt");
        if (!file.exists())    
            file.createNewFile(); // Cria um arquivo (vazio)
        
        // Escreve no arquivo 
        FileWriter fw = new FileWriter(file);
        BufferedWriter fileWriter = new BufferedWriter(fw);
        
        // Faz a leitura do arquivo.
        for (int i=0; i<numMod; i++)
            try (BufferedReader fileReader = new BufferedReader(new FileReader("temp"+(i+1)+".txt")))
            {   while ((readLine = fileReader.readLine()) != null) 
                {   symbols = readLine.split(Pattern.quote(" ")); // Separa os simbolos pelo espaço.
                    for (int j=0; j<symbols.length; j++)
                        fileWriter.write(symbols[j]+" ");
                    fileWriter.newLine();    
                }
            }
            catch (IOException e) 
            {   setText ("ERRO 3: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
            }
        fileWriter.close();
        fw.close();   
    }
    
    private void thirdStep()
    {   int countNeighbors=1, add=0;
        //Construção da tabela de símbolos global
        for (int i=0; i<numMod; i++)
        {   for (int j=0; j<modulos.get(i).getSymbolTable().size(); j++)
            {   Symbols aux = new Symbols();
                aux.setSymbol(modulos.get(i).getSymbolTable().get(j).getSymbol());
                aux.setAddress (modulos.get(i).getSymbolTable().get(j).getAddress()+add);
                this.symbolTableGlobal.add (aux);
                countNeighbors = this.symbolTableGlobal.get(j).getAddress()+add;
            }
            add = countNeighbors;
        }
    }
    
    //Termina o linkamento arrumando os indices dos labels
    private void fourthStep() throws IOException
    {   File file = new File("outlinked.txt");
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
        {   setText ("ERRO 4: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
        }
        fileWriter.close();
        fw.close(); 
    }
    
    private void SearchTable(String symbol, BufferedWriter fileWriter) throws IOException
    {   boolean flag = false;
        //Procura na tabela de simbolos "global"
        for (int i=0; i<this.symbolTableGlobal.size(); i++)
            if (symbol.equals(symbolTableGlobal.get(i).getSymbol()))
            {   if (symbolTableGlobal.get(i).getAddress() < 10)
                    fileWriter.write("0"+symbolTableGlobal.get(i).getAddress());
                else
                    fileWriter.write(""+symbolTableGlobal.get(i).getAddress());
                fileWriter.newLine();
                flag = true;
                break;
            }
        if (!flag)
        {   setText ("ERRO 6: LABEL NÃO DECLARADO EM NENHUM DOS MODULOS.");
            System.exit(0);            
        }
                
        
    }   
}
