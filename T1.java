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
       
       String[] aux1   = regular.split("");
       String[] aux2   = chain.split("");
       
       int i = 0,j = 0;
       while (aux1.length!=i)
            System.out.print(" " + aux1[i++] + " ");
       System.out.println("");
       while (aux2.length!=j)
            System.out.print(" " + aux2[j++] + " ");
       
       temp.toAFND(aux1,aux2);  
       System.out.println("");
       temp.toAFD(aux1,aux2); 
    }
    
}