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

    public static void main(File[] args) throws FileNotFoundException{
        
       Scanner reader = new Scanner (args[0]);       
       Converter temp = new Converter();
       String regular = reader.next();
       String chain = reader.next();
       System.out.print(regular + "  " + chain);   
        
    }
    
}

