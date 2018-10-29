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
        System.out.println("asdads");
        while(i!=positions(regular,"(").length)
        {
            int open  = positions(regular,"(")[i];
            int close = positions(regular,")")[positions(regular,")").length-1-i];
            group.add(open);
            group.add(close);
            i++;
            System.out.println("agg");
        }
        
        System.out.println(group.size());
        
        for(int k=0; k < group.size() ;k=k+2)
        {
            System.out.println(k);
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
