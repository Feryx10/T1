/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter implements APIConvert , APISearch{
    
    ArrayList<String> sigma = new ArrayList<>();  
    @Override
    public void toAFND(String[] regular,String[] chain){
        
        String[] aux;
        aux = regular.clone();
        Funciones funciones = new Funciones(regular, toSigma(aux));
        int i = 0;                
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
            i++;            
        }
        
        
        
        for(int k=0; k < group.size() ;k=k+2)
        {
            funciones.desarmador(group.get(k), group.get(k+1));
        }
        int total=funciones.totalNodos();
        
        System.out.print("K={");
        for (int j=0; j <= total; j++)
        {
            if (j==total)
                System.out.print("q"+j+"}");
            else
                System.out.print("q"+j+",");
        }
        System.out.println("");
        toSigma(aux);
        printSigma();
        funciones.completeStart();
        printEdges(funciones);
        printStartFinish(funciones.getFinishEnd());
        
        
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
    
    public void getSigma(String[] regular)
    {
        for(int i=0; regular.length >i ;i++)
        {
            
        }
    }
    
    public void printEdges(Funciones funciones)
    {
        System.out.println("");
        System.out.println("Delta:");
        ArrayList<Edge> edges = funciones.getEdges();
        for(int i=0; i<edges.size(); i++)
        {
            System.out.println("(q"+edges.get(i).getFather()+","+edges.get(i).getValue()+",q"+edges.get(i).getSon()+")");
        }
    }
    
    public void printStartFinish(Edge edge)
    {
        System.out.println("s=q"+edge.getFather());
        System.out.println("F={q"+edge.getSon()+"}");
    }
    
    @Override
    public ArrayList<String> toSigma(String[] array){    
        String aux = Arrays.toString(array);
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(aux);
        while (matcher.find()) {
            if(!sigma.contains(matcher.group())) 
                sigma.add(matcher.group());   
        }
        
       
      //  System.out.println("");
      //  System.out.print("Sigma =" + temp.toString() + " ");
      //  System.out.println("");
        return sigma;
    }
    public void printSigma()
    {
        System.out.print("Sigma={");
        for(int i=0; i<sigma.size()-1;i++)
        {
            System.out.print(sigma.get(i)+",");
        }
        System.out.print(sigma.get(sigma.size()-1)+"}");
    }
}
