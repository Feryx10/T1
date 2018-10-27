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
        String expression = null;
        ArrayList<String> sigma = new ArrayList<>();                               
        while(i!=regular.length){
            int open  = positions(regular,'(')[0];
            int close = positions(regular,')')[positions(regular,')').length-1];
            if(open!=null){
            
                switch(regular[i]){
                    case"[a-zA-Z0-9]":
                        sigma.add(regular[i]);
                    case ".":
                        expression = regular[i--]+regular[i++];    
                    case "*":
                        
                    case "~":
                    
                    case "|":
                        
                    case "_":     
                        
                }
            }
        }
                
               
    }        
    
    
    @Override
    public void toAFD (String[] regular,String[] chain){        
    }
    
    @Override
    public int[] positions(String[] array, char key){   
        int[] temp = null;
        int j = 0;
        for(int i = array.length-1;i != 0;i--)    
            if (array[i].equals(key)){
               temp[j]=i; 
               j++;
            }
        return temp;
    } 
}
