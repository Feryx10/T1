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

    public static void main(String[] args) throws FileNotFoundException{
        
       Scanner reader = new Scanner (args[0]);       
       Converter temp = new Converter();
       
       String regular = reader.next();
       String chain   = reader.next();
       
       String[] aux1  = regular.split("");
       String[] aux2  = regular.split("");
       int i = 0;
       int j = 0;
       while(aux1.length==i && aux1.length==j)
       System.out.print(aux1[i] + "  " + aux2[j]);   
        
    }
    
}

