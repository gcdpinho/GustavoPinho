package additional;

/* 
    Uma tipica instrucao em HIPO pode ter duas formas.
    sNNNN ou sIIAA.
    1. s - Significa sinal, + ou -. Usei um char pra representar.
    2. N - Numeral, de 0 à 9, pode ser representados numeros de 0000 à 9999 no HIPO. Passando disso = overflow.
    3. I - Tipo de instrucao. Mais descricoes disso no montador.
    4. A - Endereco de Storage.
    
*/

public class Symbols 
{   //private char signal;
    private String symbol;
    private int address;
    
    public Symbols() 
    {   //signal = '+';
        this.symbol = "";
        this.address = 0;
    }

    public int getAddress() 
    {   return this.address;
    }

    public void setAddress(int address) 
    {   this.address = address;
    }

    public String getSymbol() 
    {   return this.symbol;
    }

    public void setSymbol(String symbol) 
    {   this.symbol = symbol;
    }
    
}
