/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */
import java.util.*;

public class Converter implements APIConvert , APISearch{
    
    public Converter(){
    }
    
    @Override
    public void toAFND(String[] regular,String[] chain){   
        int i = 0;                
        ArrayList<String> sigma = new ArrayList<>();                               
        while(i!=positions(regular,"(").length){
            int open  = positions(regular,"(")[i];
            int close = positions(regular,")")[positions(regular,")").length-1-i];
            System.out.println(" " + open + " "+ close);
            /*if(open!=-1){
            
                switch(regular[i]){
                    case "a":
                        sigma.add(regular[i]);
                    case ".":
                          
                    case "*":
                        
                    case "~":
                    
                    case "|":
                        
                    case "_":     
                        
                }
            }*/
        i++;
        }
                
               
    }        
    
    
    @Override
    public void toAFD (String[] regular,String[] chain){        
    }
    
    @Override
    public int[] positions(String[] array, String key){   
        int [] temp;
        int count = 0;
        for(int i = array.length-1;i != 0;i--)    
            if (array[i].equals(key)){                
               count++;
            }        
        temp = new int[count]; 
        count=0;
        for(int i = array.length-1;i != 0;i--)    
            if (array[i].equals(key)){                
               temp[count]=i;
               count++;
            }  
        return temp;
    } 
}
