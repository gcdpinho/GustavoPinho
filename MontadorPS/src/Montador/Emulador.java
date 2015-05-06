package Montador;

import static Interface.Principal.setText;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Emulador 
{   int tamanho = 300; // Tamanho padrão da memoria.
    int[] memoria = new int[tamanho]; 
    String readLine;
    String[] symbols;
    int cont=100, pc=100, acc=0, ri, re; //Registradores internos e program countNeighborser
    Stack pilha = new Stack ();// Pilha do sistema
    boolean endProg = false;
    
    public static int modoEnd (int cod, int opd) //Retorno o modo de endereçamento
    {   int mascara=128, temp;
        
        //return 0;
        temp = cod & mascara;
        if (temp == 0)
        {   if (opd == 1)
                mascara = 32;
            else
                mascara = 64;
            temp = cod & mascara;
            if (temp == 0)
                return 0; //Direto
            else
                return 1;//Indireto
        }
        else
            return 2;//Imediato
    }
    
    // De acordo com o end (modo de endereçamento), define como o dado está endereçado
    public int acessaReg (int end, int re) 
    {   if (end == 0)
            return memoria[re];//Direto
        else
          if (end == 1)  
              return memoria[memoria[re]];//Indireto
          else
              return re;//Imediato
    }
    
    public void carregaMemoria () //Carrega o programa na memória
    {   boolean end = false;
    
        try (BufferedReader fileReader = new BufferedReader(new FileReader("saida.txt")))
        {   while ((readLine = fileReader.readLine()) != null)
            {   symbols = readLine.split(Pattern.quote (" "));
                if (!end)    
                    switch (symbols[0])
                    {   case "11": //STOP
                            memoria[cont] = Integer.parseInt(symbols[0]);
                            cont++;
                            end = true;
                            break;
                        case "13": //COPY
                            memoria[cont] = Integer.parseInt(symbols[0]);
                            cont++;
                            memoria[cont] = Integer.parseInt(symbols[1]);
                            cont++;
                            memoria[cont] = Integer.parseInt(symbols[2]);
                            cont++;
                            break;
                        default://DEMAIS
                            memoria[cont] = Integer.parseInt(symbols[0]);
                            cont++;
                            memoria[cont] = Integer.parseInt(symbols[1]);
                            cont++;     
                            break;
                    }
                else
                {   //System.out.println (symbols[0]);
                    if (symbols.length <= 1)//SPACE
                        memoria[Integer.parseInt(symbols[0])] = -9;
                    else//CONST
                        memoria[Integer.parseInt(symbols[0])] = Integer.parseInt (symbols[1]);
                    cont++;
                }  
            }
            memoria[cont] = -10; //Fim do programa
        }
        catch (IOException e) 
        {   setText ("ERRO 1: O ARQUIVO NÃO FOI ENCONTRADO NO DIRETÓRIO.");
            System.exit(0);
	} 
    }
    
    public void rodaPrograma (int mop) //Executa o programa
    {       
        while(!endProg) //Laço até o STOP
        {   ri = memoria[pc];
            re = pc+1;
            //System.out.println (ri+","+memoria[re]);
            if (mop == 1)
            {   if (!endProg)
                    setText ("\nOperação:"+ri+"\n");
                setText ("Program countNeighborser:"+pc+"\n");
                setText ("Acumulator:"+acc+"\n");
            }
            switch (ri)
            {   case 0:
                    pc = re+1;
                    break;
                case 1:
                    if (acc > 0)
                       pc = re+1;
                    else
                        pc += 2;
                    break;
                case 2 :
                    acc += acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 3:
                    acc = acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 4:
                    if (acc == 0)
                        pc = re+1;
                    else
                        pc += 2;
                    break;
                case 5:
                    if (acc < 0)
                        pc = re+1;
                    else
                        pc += 2;
                    break;
                case 6:
                    acc -= acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 7:
                    if (modoEnd (memoria[re], 1) == 0)
                        memoria[re] = acc;
                    else
                        memoria[memoria[re]] = acc;
                    pc += 2;
                    break;
                case 8:
                    setText ("Write:"+acessaReg (modoEnd (memoria[re],1), memoria[re])+"\n");
                    pc += 2;
                    break;
                case 10:
                    acc /= acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 11:
                    endProg = true;
                    pc += 1;
                    break;
                case 12:
                    String entrada;
                    entrada =JOptionPane.showInputDialog("Digite um inteiro:");
                    if (modoEnd (memoria[re], 1) == 0)
                        memoria[re] = Integer.parseInt (entrada);
                    else
                        memoria[memoria[re]] = Integer.parseInt (entrada);
                    pc += 2;
                    break;
                case 13:
                    
                    if (modoEnd (memoria[re], 1) == 0)
                        memoria[re] = acessaReg (modoEnd (memoria[re+1],2), memoria[re+1]);
                    else
                        memoria[memoria[re]] = acessaReg (modoEnd (memoria[re+1],2), memoria[re+1]);
                    pc += 3;
                    break;
                case 14:
                    acc *= acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 15:
                    pilha.push (pc);
                    pc = acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    break;
                case 16:
                    pc = (int) pilha.pop();
                    break;
                default:
                    setText ("ERRO 3: SIMBOLO NAO EXISTENTE.");
                    System.exit(0);               
            }
            if (mop == 1)
            {   setText ("Valores pós-operação:\n");
                setText ("Program countNeighborser:"+pc+"\n");
                setText ("Acumulator:"+acc+"\n");
            if (ri != 11)
                setText ("Memoria["+memoria[re]+"]:"+memoria[memoria[re]]+"\n");
            if (ri == 13)
                setText ("Memoria["+memoria[re+1]+"]:"+memoria[memoria[re+1]]+"\n");
            }
        }
        while (memoria[pc] != -10) //Declaração de label
        {   setText ("Memoria["+pc+"]:"+memoria[pc]+"\n");
            pc += 1;
        }
    }
    
    public boolean depurador ()
    {           
        ri = memoria[pc];
        re = pc+1;
        if (!endProg)
            setText ("Operação:"+ri+"\n");
        setText ("Program countNeighborser:"+pc+"\n");
        setText ("Acumulator:"+acc+"\n");
        if (!endProg)
        {   switch (ri)
            {   case 0:
                    pc = re+1;
                    break;
                case 1:
                    if (acc > 0)
                       pc = re+1;
                    else
                        pc += 2;
                    break;
                case 2 :
                    acc += acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 3:
                    acc = acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 4:
                    if (acc == 0)
                        pc = re+1;
                    else
                        pc += 2;
                    break;
                case 5:
                    if (acc < 0)
                        pc = re+1;
                    else
                        pc += 2;
                    break;
                case 6:
                    acc -= acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 7:
                    if (modoEnd (memoria[re], 1) == 0)
                        memoria[re] = acc;
                    else
                        memoria[memoria[re]] = acc;
                    pc += 2;
                    break;
                case 8:
                    setText ("Write:"+acessaReg (modoEnd (memoria[re],1), memoria[re])+"\n");
                    pc += 2;
                    break;
                case 10:
                    acc /= acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 11:
                    endProg = true;
                    pc += 1;
                    break;
                case 12:
                    String entrada;
                    entrada =JOptionPane.showInputDialog("Digite um inteiro:");
                    if (modoEnd (memoria[re], 1) == 0)
                        memoria[re] = Integer.parseInt (entrada);
                    else
                        memoria[memoria[re]] = Integer.parseInt (entrada);
                    pc += 2;
                    break;
                case 13:

                    if (modoEnd (memoria[re], 1) == 0)
                        memoria[re] = acessaReg (modoEnd (memoria[re+1],2), memoria[re+1]);
                    else
                        memoria[memoria[re]] = acessaReg (modoEnd (memoria[re+1],2), memoria[re+1]);
                    pc += 3;
                    break;
                case 14:
                    acc *= acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    pc += 2;
                    break;
                case 15:
                    pilha.push (pc);
                    pc = acessaReg (modoEnd (memoria[re],1), memoria[re]);
                    break;
                case 16:
                    pc = (int) pilha.pop();
                    break;
                default:
                    setText ("ERRO 3: SIMBOLO NAO EXISTENTE.");
                    System.exit(0);                
            }
        setText ("Valores pós-operação:\n");
        setText ("Program countNeighborser:"+pc+"\n");
        setText ("Acumulator:"+acc+"\n");
        if (ri != 11)
            setText ("Memoria["+memoria[re]+"]:"+memoria[memoria[re]]+"\n");
        if (ri == 13)
            setText ("Memoria["+memoria[re+1]+"]:"+memoria[memoria[re+1]]+"\n");
        }
        else
            if (memoria[pc] != -10)
            {   setText ("Memoria["+pc+"]:"+memoria[pc]+"\n");
                pc += 1;
            }
            else
                return true;
        setText ("\n");
        return false;
        
    }
}
