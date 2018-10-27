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
        String x = Positions(regular,'(');              
        if (x==null){
            while(i!=regular.length){
                switch(regular[i]){
                    case "[a-zA-Z0-9]":
                        sigma.add(regular[i]);
                    case ".":
                        expression = regular[i--]+regular[i++];                    
                }
            }
                
        }        
    }        
    
    
    @Override
    public void toAFD (String[] regular,String[] chain){        
    }
    
    @Override
    public String Positions(String[] array, char key){   
        String temp = null;
        for(int i = 0;i < array.length;i++)    
            if (array[i].equals(key)) temp+=i;          
        return temp;
    } 
}
