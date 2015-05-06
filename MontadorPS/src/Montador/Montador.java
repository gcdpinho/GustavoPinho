package Montador;

import static Interface.Principal.setText;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Montador 
{   int address  = 100;   // Controla numero do endereço. Começara em 100 por padrao.
    boolean stopFlag = false; // Flag para quando for o final do programa(após receber uma instrução tipo STOP).
    String readLine; // Linha que foi lida (sem ser quebrada em simbolos).
    String[] symbols;  // Simbolos que serao lidos.
    //ArrayList<String> codeTable  = new ArrayList<>(); // Tablea com os codigos. Ex: "ADD", "READ", etc.
    ArrayList <String> labelTable = new ArrayList(); // Tablea com os labels/variaveis. Ex: "HEAD", "N", "IDX", etc.
    ArrayList <String> auxTable = new ArrayList(); // Tablea com os símbolos da Label lidos em ordem, utilizada para buscar os indices depois.
    
    public void primeiroPasso() throws FileNotFoundException, IOException 
    {   File file = new File("temp.txt");
        if (!file.exists()) 
        {   file.createNewFile(); // Cria um arquivo (vazio)
        }
        
        // Escreve no arquivo
        FileWriter fw = new FileWriter(file);
        BufferedWriter fileWriter = new BufferedWriter(fw);

        // Faz a leitura do arquivo.
        try (BufferedReader fileReader = new BufferedReader(new FileReader("entrada.txt"))) 
        {   while ((readLine = fileReader.readLine()) != null) 
            {   symbols = readLine.split(Pattern.quote(" ")); // Separa os simbolos pelo espaço. Ex: "Read Line", sera, "Read" e "Line".
                tradutorSimbolosPassoUm(symbols[0], fileWriter, 0); // Chama o tradutor com o primeiro simbolo da linha.
            }
        } 
        catch (IOException e) 
        {   setText("ERRO 1: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
            System.exit(0);
        }
        fileWriter.close();
        fw.close();
    }
    
    
    public void segundoPasso() throws FileNotFoundException, IOException 
    {   stopFlag = false;
        File file = new File("saida.txt");
        if (!file.exists()) 
        {   file.createNewFile(); // Cria um arquivo (vazio)
        }
        
        // Escreve no arquivo
        FileWriter fw = new FileWriter(file);
        BufferedWriter fileWriter = new BufferedWriter(fw);
        
        try (BufferedReader fileReader = new BufferedReader(new FileReader("temp.txt"))) 
        {   while ((readLine = fileReader.readLine()) != null) 
            {   symbols = readLine.split(Pattern.quote(" ")); // Separa os simbolos pelo espaço. Ex: "Read Line", sera, "Read" e "Line".
                tradutorSimbolosPassoDois(symbols[0], fileWriter); // Chama o tradutor com o primeiro simbolo da linha.
            }
        } 
        catch (IOException e) 
        {   setText("ERRO 2: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
            System.exit(0);
        } 
        fileWriter.close();
        fw.close();
    }
    
    // Traduz os simbolos e os escreve em um arquivo temporario.
    public void tradutorSimbolosPassoUm(String code, BufferedWriter fileWriter, int index) throws IOException {
        if (index == 1) 
            index = 2;
        else 
            index = 1;      
        switch (code) 
        {   case "BR":
                fileWriter.write("00"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "BRPOS":
                fileWriter.write("01"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "ADD":
                fileWriter.write("02"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "LOAD":
                fileWriter.write("03"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "BRZERO":
                fileWriter.write("04"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "BRNEG":
                fileWriter.write("05"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "SUB":
                fileWriter.write("06"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "STORE":
                fileWriter.write("07"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "WRITE":
                fileWriter.write("08"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "DIVIDE":
                fileWriter.write("10"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "STOP":
                fileWriter.write("11");
                fileWriter.newLine();
                address += 1;
                stopFlag = true;
                break;
            case "READ":
                fileWriter.write("12"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            case "COPY":
                fileWriter.write("13"+" "+symbols[index]+" "+symbols[index+1]);
                fileWriter.newLine();
                address += 3;
                break;
            case "MULT":
                fileWriter.write("14"+" "+symbols[index]);
                fileWriter.newLine();
                address += 2;
                break;
            default:
                // Se nao for o fim, significa que eh um Label.
                if (!stopFlag) 
                {   auxTable.add(code); // Guarda na tablea auxiliar o simbolo.
                    labelTable.add(String.valueOf(address)); // Guarda a traducao do simbolo.
                    // Chama o tradutor novamente. Label nao eh contado no endereco.
                    tradutorSimbolosPassoUm(symbols[1], fileWriter, 1);
                } 
                else 
                {   // Começa o tratamento de  variaveis/constantes.
                    auxTable.add(code); // Guarda na tablea auxiliar o simbolo.
                    labelTable.add(String.valueOf(address)); // Guarda a traducao do simbolo.
                    if (symbols[1].equals("CONST"))
                    {   fileWriter.write(address + " " + symbols[2]);
                        fileWriter.newLine();
                    } 
                    else 
                    {   fileWriter.write(String.valueOf(address));
                        fileWriter.newLine();
                    }
                    address += 1;
                }
                break;
        }
    }
    
    public void tradutorSimbolosPassoDois(String code, BufferedWriter fileWriter) throws IOException {
        int index, index2;
      
        if (!code.equals("11") && !stopFlag) 
        {   if (code.equals("13")) 
            {   index  = auxTable.indexOf(symbols[1]);
                index2 = auxTable.indexOf(symbols[2]);
                fileWriter.write(code + " " + labelTable.get(index) + " " + labelTable.get(index2));
                fileWriter.newLine();
            } 
            else 
            {   index  = auxTable.indexOf(symbols[1]);
                fileWriter.write(code + " " + labelTable.get(index));
                fileWriter.newLine();
            }
        } 
        else 
        {   stopFlag = true;
            for (int i = 0; i < symbols.length; i++)
                fileWriter.write(symbols[i] + " ");            
            fileWriter.newLine();
        }  
    }
}
