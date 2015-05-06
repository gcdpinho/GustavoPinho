
package hipo;

import Interface.FormMain;
import static Interface.FormMain.setText;
import java.io.IOException;
import javax.swing.JOptionPane;

public class VirtualMachine 
{   private Loader loader;
    private int[] memory;
    private int carga, end, acc, ai;
    private int address[];
    private boolean overflow, stop;
    
    int op, opd, countNeighbors=0, aux, index=0;
    
    public VirtualMachine(int mod, int carga) throws IOException
    {   this.loader = new Loader (mod, carga);
        this.memory = new int[100];
        this.carga = carga;
        this.overflow = false;
        this.stop = false;
        this.loader.firstStep();
        this.memory = this.loader.getMemory();
        this.end = this.loader.getEnd();
        this.ai = 1+carga;
        this.address = loader.getAddress();
    }
    
    public void firstStep() throws IOException
    {      
        while (ai < this.end && !stop)
        {   op = memory[ai]/100;
            opd = memory[ai]%100;
            switch (op)
            {   case 11:
                    acc = memory[opd];
                    ai++;
                    break;
                case 12:
                    memory[opd] = acc;
                    ai++;
                    break;
                case 21:
                    acc += memory[opd];
                    ai++;
                    break;
                case 22:
                    acc -= memory[opd];
                    ai++;
                    break;
                case 23:
                    acc *= memory[opd];
                    ai++;
                    break;
                case 24:
                    acc /= memory[opd];
                    ai++;
                    break;
                case 25:
                    acc %= memory[opd];
                    ai++;
                    break;
                case 31:
                    memory[opd] = Integer.parseInt(JOptionPane.showInputDialog("Digite um inteiro:"));
                    ai++;
                    break;
                case 41:
                    setText ("Print: memory["+opd+"]:"+memory[opd]+"\n");
                    ai++;
                    break;
                case 50:
                    ai++;
                    break;
                case 51:
                    ai = opd;
                    break;
                case 52:
                    if (acc > 0)
                        ai = opd;
                    else
                        ai++;
                    break;
                case 53:
                    if (acc >= 0)
                        ai = opd;
                    else
                        ai++;
                    break;
                case 54:
                    if (acc < 0)
                        ai = opd;
                    else
                        ai++;
                    break;
                case 55:
                    if (acc <= 0)
                        ai = opd;
                    else
                        ai++;
                    break;
                case 56:
                    if (acc != 0)
                        ai = opd;
                    else
                        ai++;
                    break;
                case 57:
                    if (acc == 0)
                        ai = opd;
                    else
                        ai++;
                    break;
                case 58:
                    if (!overflow)
                        ai = opd;
                    else
                        ai++;
                    break;
                case 59:
                    if (overflow)
                        ai = opd;
                    else
                        ai++;
                    break;
                case 70:
                    stop = true;
                    break;                    
            }
            if (acc > 9999 || acc < -9999)
            {   acc = 0;
                overflow = true;
            }
            if (overflow)
                acc = 0;
        }
        for (int i=1+carga; i<this.end; i++)
        {   if (memory[i] != 7000)
                countNeighbors++;
            else
            {   i++;
                countNeighbors++;
                aux = this.address[index] - countNeighbors -1;
                index++;
                countNeighbors=1;
                for (int j=0; j<aux; j++)
                {   setText ("memory["+i+"]: "+memory[i]+"\n");
                    i++;
                }
            }                
        }
        setText ("Acumulador:"+acc+"\n");
        setText ("Apotador de instrução:"+ai+"\n");
        if (overflow);
            
    }
    
    public void firstDebuger(FormMain form) throws IOException
    {   index=0;
        countNeighbors=0;
        op = memory[ai]/100;
        opd = memory[ai]%100;
        switch (op)
        {   case 11:
                acc = memory[opd];
                ai++;
                break;
            case 12:
                memory[opd] = acc;
                ai++;
                break;
            case 21:
                acc += memory[opd];
                ai++;
                break;
            case 22:
                acc -= memory[opd];
                ai++;
                break;
            case 23:
                acc *= memory[opd];
                ai++;
                break;
            case 24:
                acc /= memory[opd];
                ai++;
                break;
            case 25:
                acc %= memory[opd];
                ai++;
                break;
            case 31:
                memory[opd] = Integer.parseInt(JOptionPane.showInputDialog("Digite um inteiro:"));
                ai++;
                break;
            case 41:
                setText ("Print: memory["+opd+"]:"+memory[opd]+"\n");
                ai++;
                break;
            case 50:
                ai++;
                break;
            case 51:
                ai = opd;
                break;
            case 52:
                if (acc > 0)
                    ai = opd;
                else
                    ai++;
                break;
            case 53:
                if (acc >= 0)
                    ai = opd;
                else
                    ai++;
                break;
            case 54:
                if (acc < 0)
                    ai = opd;
                else
                    ai++;
                break;
            case 55:
                if (acc <= 0)
                    ai = opd;
                else
                    ai++;
                break;
            case 56:
                if (acc != 0)
                    ai = opd;
                else
                    ai++;
                break;
            case 57:
                if (acc == 0)
                    ai = opd;
                else
                    ai++;
                break;
            case 58:
                if (!overflow)
                    ai = opd;
                else
                    ai++;
                break;
            case 59:
                if (overflow)
                    ai = opd;
                else
                    ai++;
                break;
            case 70:
                stop = true;
                form.B_exec1.setEnabled(false);
                break;                    
        }
        if (acc > 9999 || acc < -9999)
        {   acc = 0;
            overflow = true;
        }
        if (overflow)
            acc = 0;
    
        for (int i=1+carga; i<this.end; i++)
        {   if (memory[i] != 7000)
                countNeighbors++;
            else
            {   i++;
                countNeighbors++;
                aux = this.address[index] - countNeighbors -1;
                index++;
                countNeighbors=1;
                for (int j=0; j<aux; j++)
                {   setText ("memory["+i+"]: "+memory[i]+"\n");
                    i++;
                }
            }                
        }
        setText ("Acumulador:"+acc+"\n");
        setText ("Apotador de instrução:"+ai+"\n");
        if (overflow);

        
    
    }
}
