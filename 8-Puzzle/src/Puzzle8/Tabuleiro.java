package Puzzle8;

import Interface.TelaInicial;
import static Interface.TelaInicial.clearLabel;
import static Interface.TelaInicial.setLabel;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;

public class Tabuleiro 
{   
    public static boolean inversao (Nodo selec)
    {   int c=0;
        
        for (int i=0; i<9; i++)
            for (int j=i; j<9; j++)
                if (selec.getVetorPos(i) > selec.getVetorPos(j) && selec.getVetorPos(j)!=0)
                    c++;
        return c%2==0;    
    }
    
    public static void escreveLabel (int altura, int cont)
    {   clearLabel();
        setLabel ("Estados testados:"+cont+"\n");
        setLabel ("Altura do caminho:"+altura+"\n");
        setLabel ("Caminho:\n");   
    }
    
    public static int achaIndice (Nodo selec)
    {   int[] vetor = new int [9];
        
        vetor = selec.getVetor();
        for (int i=0; i<9; i++)
            if (vetor[i] == 0)
                return i;
        return -1;        
    }

    public static Nodo regraJogo (Nodo selec, int pos, int regra)
    {   Nodo novo = new Nodo (selec.getVetor());
        
        switch (regra)
        {   case 0: novo.setVetorPos(pos, novo.getVetorPos (pos-1));
                    novo.setVetorPos(pos-1, 0);
                    break;
            case 1: novo.setVetorPos(pos, novo.getVetorPos (pos-3));
                    novo.setVetorPos(pos-3, 0);
                    break;
            case 2: novo.setVetorPos(pos, novo.getVetorPos(pos+1));
                    novo.setVetorPos(pos+1, 0);
                    break;
            case 3: novo.setVetorPos (pos, novo.getVetorPos (pos+3));
                    novo.setVetorPos (pos+3, 0);
                    break;
        }
        return novo;
    }
    
    public static boolean testeRepetido (Nodo selec, ArrayList <Nodo> pai)
    {   int c;
        
        for (int i=0; i<pai.size(); i++)
        {   c=0; 
            for (int j=0; j<9; j++)
                if (selec.getVetorPos(j) == pai.get(i).getVetorPos(j))
                    c++;
            if (c == 9)
                return true;
        }
        return false;                 
    }
    
    public static boolean testeFim (Nodo selec, Nodo fim)
    {   int c=0;
        
        for (int i=0; i<9; i++)
            if (selec.getVetorPos(i) == fim.getVetorPos (i))
                c++;
        return c == 9;    
    }
    
    public static void buscaLargura (Nodo inicio, int limite, ArrayList <int[]> caminho)
    {   Nodo fim = new Nodo (0,1,2,3,4,5,6,7,8);
        Queue <Nodo> fila1 = new LinkedList <Nodo> ();
        Queue <Nodo> fila2 = new LinkedList <Nodo> ();
        ArrayList <Nodo> pai = new ArrayList ();
        Nodo selec;
        int pos, altura=1, cteste=0, t;
        Nodo aux; 
        
          if (testeFim (inicio, fim))
            {   escreveLabel(1, 1);
                inicio.imprimeVetor(caminho);
                return;
            }
            fila1.offer (inicio);
            while (altura < limite) 
            {   while (!fila1.isEmpty())
                {   selec = fila1.poll();
                    cteste++;
                    pos = achaIndice (selec);
                    switch (pos)
                    {   case 0: aux = regraJogo (selec, pos, 3);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 2);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;
                        case 1: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 3);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 2);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;
                        case 2: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 3);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);;
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;
                        case 3: aux = regraJogo (selec, pos, 3);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 2);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 1);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;
                        case 4: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 3);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 2);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 1);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;
                        case 5: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 3);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 1);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;
                        case 6: aux = regraJogo (selec, pos, 2);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 1);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;
                        case 7: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 2);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 1);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;
                        case 8: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                aux = regraJogo (selec, pos, 1);
                                if (testeFim (aux, fim))
                                {   escreveLabel(altura+1, cteste);
                                    aux.setPai (selec);
                                    aux.imprimeVetor(caminho);
                                    return;
                                }
                                if (!testeRepetido (aux, pai))
                                {   fila2.offer (aux);
                                    aux.setPai(selec);
                                }
                                break;           
                        }
                    pai.add (selec);
                }
            t = fila2.size();
            for (int i=0; i<t; i++)
                fila1.offer (fila2.poll());
            altura++;
            }
        clearLabel ();
        setLabel ("Não foi possível resolver o problema \ncom altura igual a "+limite+".");
    }
    
    public static void buscaProfundidade (Nodo inicio, int limite, ArrayList <int[]> caminho)
    {   Stack <Nodo> pilha = new Stack();
        ArrayList <Nodo> pai = new ArrayList ();
        Nodo fim = new Nodo (0,1,2,3,4,5,6,7,8);
        int pos, altura=1, cteste=0;
        Nodo selec, aux;
      
        if (testeFim (inicio, fim))
            {   escreveLabel(altura, cteste+1);
                inicio.imprimeVetor(caminho);
                return;  
            }
            pilha.push (inicio);
            while (!pilha.isEmpty())
            {   while (altura < limite)
                {   if (pilha.size() == 0)
                    {   clearLabel ();
                        setLabel ("Não foi possível resolver o problema \ncom altura igual a "+limite+"."); 
                        return;
                    }
                    selec = pilha.peek();
                    cteste++;
                    pos = achaIndice (selec);
                    switch (pos)
                    {   case 0: aux = regraJogo (selec, pos, 2);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai (selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 3);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {   pilha.push (aux);
                                        altura++;
                                        aux.setPai (selec);
                                    }
                                    else
                                    {   altura--;
                                        pilha.pop();
                                        break;
                                    }
                                }
                                break;
                        case 1: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai(selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 3);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {   pilha.push (aux);
                                        altura++;
                                        aux.setPai (selec);
                                    }
                                    else
                                    {   aux = regraJogo (selec, pos, 2);
                                        if (testeFim (aux, fim))
                                        {   altura++;
                                            escreveLabel (altura, cteste);
                                            aux.setPai(selec);
                                            aux.imprimeVetor(caminho);
                                            return;  
                                        }
                                        if (!testeRepetido (aux, pai))
                                        {   pilha.push (aux);
                                            altura++;
                                            aux.setPai (selec);
                                        }
                                        else
                                        {   altura--;
                                            pilha.pop();
                                            break;                                        
                                        }
                                    } 
                                }
                                break;
                        case 2: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai(selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 3);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {   pilha.push (aux);
                                        altura++;
                                        aux.setPai(selec);
                                    }
                                    else
                                    {   altura--;
                                        pilha.pop();
                                        break;                                   
                                    }    
                                }
                                break;
                        case 3: aux = regraJogo (selec, pos, 1);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai (selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 2);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {   pilha.push (aux);
                                        altura++;
                                        aux.setPai (selec);
                                    }
                                    else
                                    {   aux = regraJogo (selec, pos, 3);
                                        if (testeFim (aux, fim))
                                        {   altura++;
                                            escreveLabel (altura, cteste);
                                            aux.setPai(selec);
                                            aux.imprimeVetor(caminho);
                                            return;  
                                        }
                                        if (!testeRepetido (aux, pai))
                                        {   pilha.push (aux);
                                            altura++;
                                            aux.setPai (selec);
                                        }
                                        else
                                        {   altura--;
                                            pilha.pop();
                                            break;                                        
                                        }
                                    } 
                                }
                                break;
                        case 4: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai(selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 1);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {   pilha.push (aux);
                                        altura++;
                                        aux.setPai(selec);
                                    }
                                    else
                                    {   aux = regraJogo (selec, pos, 2);
                                        if (testeFim (aux, fim))
                                        {   altura++;
                                            escreveLabel (altura, cteste);
                                            aux.setPai(selec);
                                            aux.imprimeVetor(caminho);
                                            return;  
                                        }
                                        if (!testeRepetido (aux, pai))
                                        {   pilha.push (aux);
                                            altura++;
                                            aux.setPai(selec);
                                        }
                                        else
                                        {   aux = regraJogo (selec, pos, 3);
                                            if (testeFim (aux, fim))
                                            {   altura++;
                                                escreveLabel (altura, cteste);
                                                aux.setPai(selec);
                                                aux.imprimeVetor(caminho);
                                                return;  
                                            }
                                            if (!testeRepetido (aux, pai))
                                            {   pilha.push (aux);
                                                altura++;
                                                aux.setPai(selec);
                                            }
                                            else
                                            {   altura--;
                                                pilha.pop();
                                                break;
                                            }
                                        }
                                    }                               
                                }
                                break;
                        case 5: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai(selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 1);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {   pilha.push (aux);
                                        altura++;
                                        aux.setPai(selec);
                                    }
                                    else
                                    {   aux = regraJogo (selec, pos, 3);
                                        if (testeFim (aux, fim))
                                        {   altura++;
                                            escreveLabel (altura, cteste);
                                            aux.setPai(selec);
                                            aux.imprimeVetor(caminho);
                                            return;  
                                        }
                                        if (!testeRepetido (aux, pai))
                                        {   pilha.push (aux);
                                            altura++;
                                            aux.setPai(selec);
                                        }
                                        else
                                        {   altura--;
                                            pilha.pop();
                                            break;
                                        }      
                                    }
                                }
                                break;
                        case 6: aux = regraJogo (selec, pos, 1);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai(selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 2);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {   pilha.push (aux);
                                        altura++;
                                        aux.setPai(selec);
                                    }
                                    else
                                    {   altura--;
                                        pilha.pop();
                                        break;
                                    }
                                }
                                break;
                        case 7: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai (selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 1);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {    pilha.push (aux);
                                         altura++;
                                         aux.setPai(selec);
                                    }
                                    else
                                    {   aux = regraJogo (selec, pos, 2);
                                        if (testeFim (aux, fim))
                                        {   altura++;
                                            escreveLabel (altura, cteste);
                                            aux.setPai(selec);
                                            aux.imprimeVetor(caminho);
                                            return;  
                                        }
                                        if (!testeRepetido (aux, pai))
                                        {   pilha.push (aux);
                                            altura++;
                                            aux.setPai (selec);
                                        }
                                        else
                                        {   altura--;
                                            pilha.pop();
                                            break;
                                        }   
                                    }   
                                }
                                break;
                        case 8: aux = regraJogo (selec, pos, 0);
                                if (testeFim (aux, fim))
                                {   altura++;
                                    escreveLabel (altura, cteste);
                                    aux.setPai(selec);
                                    aux.imprimeVetor(caminho);
                                    return;  
                                }
                                if (!testeRepetido (aux, pai))
                                {   pilha.push (aux);
                                    altura++;
                                    aux.setPai(selec);
                                }
                                else
                                {   aux = regraJogo (selec, pos, 1);
                                    if (testeFim (aux, fim))
                                    {   altura++;
                                        escreveLabel (altura, cteste);
                                        aux.setPai(selec);
                                        aux.imprimeVetor(caminho);
                                        return;  
                                    }
                                    if (!testeRepetido (aux, pai))
                                    {   pilha.push (aux);
                                        altura++;
                                        aux.setPai(selec);
                                    }
                                    else
                                    {   altura--;
                                        pilha.pop();
                                        break;
                                    }   
                                }
                                break;
                    }
                    pai.add (selec);
                }
                pai.add (pilha.pop());
                altura--;
            }
        }
   
    public static void main (String[] args)
    {   TelaInicial nova = new TelaInicial ();
        
        nova.setVisible(true);  
    }
}
