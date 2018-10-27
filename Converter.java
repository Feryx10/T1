/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */

public class Converter implements APIConvert , APISearch{
    
    public Converter(){
    }
    
    @Override
    public void toAFND(String[] regular,String[] chain){    
        
    }
    
    @Override
    public void toAFD (String[] regular,String[] chain){        
    }
    
    @Override
    public int Position(String[] array, String key){       
      for(int i = 0;i < array.length;i++){                   
        if (array[i].equals(key)) return i;                
      }
      return -1;
    } 
}
