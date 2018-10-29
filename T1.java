/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */

import java.io.*;
import java.util.*;

public class T1 {

    public static void main(String[] args) throws FileNotFoundException { 
               
        File file = new File(args[0]);
        Scanner reader  = new Scanner (file);
        Converter temp  = new Converter();

        String  regular = reader.nextLine();
        String  chain   = reader.nextLine();

        regular=("("+regular+")");
        
        String[] aux1   = regular.split("");
        String[] aux2   = chain.split("");
        int i = 0,j = 0;

        temp.toAFND(aux1,aux2); 
        temp.toAFD(aux1,aux2); 
    }
    
}
