/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */

import java.util.*;

public class Converter implements APIConvert , APISearch{
    
    
    @Override
    public void toAFND(String[] regular,String[] chain){
        
        Funciones funciones = new Funciones(regular);
        int i = 0;                
        ArrayList<String> sigma = new ArrayList<>();     
        ArrayList<Integer> group = new ArrayList<>();         
        while(i!=positions(regular,"(").length)
        {
            int open  = positions(regular,"(")[i]; 
            int j = positions(regular,")").length-1;
            int close = positions(regular,")")[j];
            while (open>close){
                 close = positions(regular,")")[j];                 
                 j--;
            }         
            while(group.contains(close))
                     close = positions(regular,")")[j--];
            group.add(open);  
            group.add(close);
            System.out.println(open+" "+close);
            System.out.println(group.toString());            
            i++;            
        }        
        System.out.println("");
        
        for(int k=0; k < group.size() ;k=k+2)
        {           
            funciones.desarmador(group.get(k), group.get(k+1));
        }
             
               
    }
    
    
    @Override
    public void toAFD (String[] regular,String[] chain){        
    }
    
    @Override
    public int[] positions(String[] array, String key){   
        int [] temp;
        int count = 0;
        for(int i = array.length-1;i != -1;i--)    
            if (array[i].equals(key)){                
               count++;
            }        
        temp = new int[count]; 
        count=0;
        for(int i = array.length-1;i != -1;i--)    
            if (array[i].equals(key)){                
               temp[count]=i;
               count++;
            }  
        return temp;
    } 
}
