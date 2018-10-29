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
       
       int i = 0,j = 0,x = 0;
       System.out.println("");
       while (aux1.length!=i){
            if(i==10)
                System.out.print(" " + aux1[i++] + "   ");
            else
                System.out.print(" " + aux1[i++] + " ");
         }
       System.out.println("");
       while (aux1.length!=x)
            System.out.print(" " + x++ + " ");
       System.out.println("");
       while (aux2.length!=j)
            System.out.print(" " + aux2[j++] + " ");
       System.out.println("");
       
       System.out.println("");
       System.out.print("Sigma =" + temp.toSigma(aux1).toString() + " ");
       System.out.println("");
       
       System.out.println("");
       temp.toAFND(aux1,aux2);  
       System.out.println("");
       temp.toAFD(aux1,aux2); 
    }
    
}
