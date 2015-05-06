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

public class Mounter 
{   private ArrayList <Symbols> symbolTable;
    private int address;

    String readLine;
    String symbols[];
    boolean stop = false;
    
    public Mounter()
    {   this.symbolTable = new ArrayList();
        this.address = 1;
    }
    
    public ArrayList<Symbols> getSymbolTable()
    {   return symbolTable;        
    }
    
    public int getAddress()
    {   return this.address;        
    }
    
    public void firstStep(String c) throws FileNotFoundException, IOException 
    {   File file = new File("temp"+c+".txt");
        if (!file.exists())    
            file.createNewFile(); // Cria um arquivo (vazio)
        
        // Escreve no arquivo
        FileWriter fw = new FileWriter(file);
        BufferedWriter fileWriter = new BufferedWriter(fw);

        // Faz a leitura do arquivo.
        try (BufferedReader fileReader = new BufferedReader(new FileReader("in"+c+".txt"))) 
        {   while ((readLine = fileReader.readLine()) != null) 
            {   symbols = readLine.split(Pattern.quote(" ")); // Separa os simbolos pelo espaço. Ex: "Read Line", sera, "Read" e "Line".
                firstTranslation(symbols[0], fileWriter, 0); // Chama o tradutor com o primeiro simbolo da linha.
            }
        } 
        catch (IOException e) 
        {   setText ("ERRO 1: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
        }
        
        fileWriter.close();
        fw.close();
        
        secondStep(c);
    }

    public void firstTranslation(String symbol, BufferedWriter fileWriter, int index) throws IOException 
    {   // Tratamento do indice.
        if (index == 1) 
            index = 2;
        else 
            index = 1;   
        
        switch (symbol) 
        {   /* BEGIN LOAD/STORE
                11 {LDA} Load the contents of the storage position with address AA into the accumulator.
                12 {STA} Store the contents of the accumulator into the storage position with address AA.
            */
            case "LDA":
                fileWriter.write("+11"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "STA":
                fileWriter.write("+12"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            // END LOAD/STORE
                
            /* BEGIN ARITHMETICS
                21 {ADD} Add the contents of storage position AA to the accumulator, and leave the result in the accumulator.
                22 {SUB} Idem, subtract.
                23 {MUL} Idem, multiply.
                24 {DIV} Divide the contents of the accumulator by the contents of storage position AA, and leave the quotient in the accumulator.
                25 {REM} Idem, leaving the remainder of the (integer) division in the accumulator.
                29 {REV} Reverts the sign of the contents of the accumulator, that is, + is turned to - and vice-versa.
            */
                
            case "ADD":
                fileWriter.write("+21"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "SUB":
                fileWriter.write("+22"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "MUL":
                fileWriter.write("+23"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "DIV":
                fileWriter.write("+24"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "REM":
                fileWriter.write("+25"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "REV":
                fileWriter.write("+29"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            // END ARITHMETICS
                
            /* BEGIN INPUT/OUTPUT
                31 {INN} Input a number from the keyboard, and store into in the position AA.
                41 {PRN} Print numerically the contents of the position AA.
            */
            case "INN":
                fileWriter.write("+31"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "PRN":
                fileWriter.write("+41"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            // END INPUT/OUTPUT
                
            /* BEGIN JUMP INSTRUCTIONS
                50 {NOP} No operation.
                51 {JMP} Unconditional jump to the instruction at address AA.
                52 {JLE} Jump to the instruction at AA if the contents of the accumulator is less than or equal to zero.
                53 {JDZ} Idem, different than zero.
                54 {JGT} Idem, greater than zero.
                55 {JEQ} Idem, equal to zero.
                56 {JLT} Idem, less than zero.
                57 {JGT} Idem, greater than zero. - ATENCAO, INSTRUCAO DUPLICADA!
                58 {JGE} Idem, greater than or equal to zero.
            */
            case "NOP":
                fileWriter.write("+50"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "JMP":
                fileWriter.write("+51"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "JLE":
                fileWriter.write("+52"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "JDZ":
                fileWriter.write("+53"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "JGT":
                fileWriter.write("+54"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "JEQ":
                fileWriter.write("+55"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "JLT":
                fileWriter.write("+56"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            case "JGE":
                fileWriter.write("+58"+" "+symbols[index]);
                fileWriter.newLine();
                address += 1;
                break;
            // END JUMP INSTRUCTIONS
            
            /* BEGIN MISCELANEOUS
                70 {STP} Stop. When executing this instruction, HIPO stops and waits for any keyboard key to be pressed, returning to the command options menu (see section 5).
            */
            case "STP":
                fileWriter.write("+7000");
                fileWriter.newLine();
                address += 1;
                stop = true;
                break;   
            // END MISCELANEOUS
                          
            default:
                Symbols addSymbol = new Symbols();
                // Se nao for o fim, significa que eh um Label.
                if (!stop) 
                {   addSymbol.setAddress(address);
                    addSymbol.setSymbol(symbol);
                    
                    symbolTable.add(addSymbol);
                    // Chama o tradutor novamente. Label nao eh contado no endereco.
                    firstTranslation(symbols[1], fileWriter, 1);
                } 
                else 
                {   // Se for o fim, eh uma variavel.
                    addSymbol.setAddress(address);
                    addSymbol.setSymbol(symbol);
                    
                    // Adiciona o simbolo na tabela.
                    symbolTable.add(addSymbol);

                    address++;
                }
                break;
        }
    }

    private void secondStep(String c) throws IOException 
    {   stop = false;
        
        File file = new File("out"+c+".txt");
        if (!file.exists())   
            file.createNewFile(); // Cria um arquivo (vazio)
        
        // Escreve no arquivo
        FileWriter fw = new FileWriter(file);
        BufferedWriter fileWriter = new BufferedWriter(fw);
        
        try (BufferedReader fileReader = new BufferedReader(new FileReader("temp"+c+".txt"))) 
        {   while ((readLine = fileReader.readLine()) != null) 
            {   symbols = readLine.split(Pattern.quote(" ")); // Separa os simbolos pelo espaço. Ex: "Read Line", sera, "Read" e "Line".
                if (!symbols[0].equals("+7000"))
                    secondTranslation(symbols[1], fileWriter); // Chama o tradutor com o primeiro simbolo da linha.
            }
        } 
        catch (IOException e) 
        {   setText ("ERRO 2: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
        } 
        fileWriter.write("+7000");
        
        fileWriter.close();
        fw.close();
    }

    private void secondTranslation(String symbol, BufferedWriter fileWriter) throws IOException 
    {   int cont;
        boolean flag = false;
        
        for (cont = 0; cont < symbolTable.size(); cont++) 
        {   if (symbolTable.get(cont).getSymbol().equals(symbol)) 
            {   if (symbolTable.get(cont).getAddress() < 10) 
                    fileWriter.write(symbols[0]+"0"+symbolTable.get(cont).getAddress());
                else 
                    fileWriter.write(symbols[0]+symbolTable.get(cont).getAddress());
                fileWriter.newLine();
                flag = true;
                break;
            }
        }
        if (!flag)
        {   fileWriter.write(symbols[0]+"00");
            fileWriter.newLine();
        }
    }
       
}
