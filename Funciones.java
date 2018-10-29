/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */
import java.util.ArrayList;

public class Funciones {
    ArrayList<Edge> edges = new ArrayList<Edge>();
    ArrayList<Edge> dones = new ArrayList<Edge>();
    private String[] expression;
    int finReal;
    int inicioReal;

    public Funciones(String[] expression) {
        this.expression = expression;
    }
    
    
    
    public void desarmador(int inicio, int fin)
    {
        finReal=fin;
        inicioReal=inicio;
        while(fin>inicio)
        {
            if(expression[fin].length()==1)
            {
                contieneSimbolo(fin);
            }
           // System.out.println(expression[fin]);
            fin--;
        }
       // imprimir();
         
        imprimir();
        
    }
    
   
    
    private void contieneSimbolo(int fin) 
    {
        switch(expression[fin]){
                    case "*":
                        estrella(fin);
                    case ".":
                        concatenacion(fin);   
                    case "|":
                        union(fin);
                        
}
    }

    private void concatenacion(int fin) 
    {
        //System.out.println(expression[fin-1]+" "+expression[fin+1]);
      // System.out.println(expression[fin-1].length()+" "+expression[fin+1].length()+" "+fin);
        int tempFin=finReal;
        if(!(expression[fin].length()>1))
        {
            if (expression[fin-1].equals("*"))
                estrella(fin-1);
            if (expression[fin-1].length()>1 && expression[fin+1].length()>1)
            {  
                int doneUno = getDone(expression[fin-1]);
                int doneDos = getDone(expression[fin+1]);
                edges.add(new Edge(dones.get(doneUno).getSon(), "_", dones.get(doneDos).getFather()));
                dones.add(new Edge(dones.get(doneUno).getFather(), "done", dones.get(doneDos).getSon()));
            }
            else if(expression[fin+1].length()>1)
            {
                int done = getDone(expression[fin+1]);
                edges.add(new Edge(ultimoNodo(), expression[fin-1], dones.get(done).getFather()));
                dones.add(new Edge(ultimoNodo()-1, "done", dones.get(done).getSon()));
            }
            else if (expression[fin-1].length()>1)
            {
                int done = getDone(expression[fin-1]);
                edges.add(new Edge(dones.get(done).getSon(), expression[fin+1], ultimoNodo()));
                dones.add(new Edge(dones.get(done).getFather(), "done",ultimoNodo()-1 ));
            }

            else
            {
                edges.add(new Edge(ultimoNodo(),expression[fin-1],ultimoNodo()+1));
                edges.add(new Edge(ultimoNodo()-1,expression[fin+1],ultimoNodo()));
                dones.add(new Edge(ultimoNodo()-3, "done", ultimoNodo()-1));
            }
        }
        expression[fin]=("done"+String.valueOf(dones.size()-1));
        boolean punto = false;
        while(!punto)
        {
            expression[tempFin]=("done"+String.valueOf(dones.size()-1));
            tempFin--;
            if(tempFin<inicioReal || expression[tempFin].equals(".") || expression[tempFin].equals("_") || expression[tempFin].equals("*"))
                punto=true;
        }
        
       
        
    }

    private void estrella(int fin)
    {
        System.out.println("estrella");
        int tempFin=fin;
        int nodo = ultimoNodo();
        edges.add(new Edge(nodo, "_", nodo+1));
        if (expression[fin-1].length()>1)
        {
            edges.add(new Edge(nodo, "_", dones.get(getDone(expression[fin-1])).getFather()));
            edges.add(new Edge(dones.get(getDone(expression[fin-1])).getSon(), "_", nodo+1 ));
            edges.add(new Edge(dones.get(getDone(expression[fin-1])).getSon(), "_", dones.get(getDone(expression[fin-1])).getFather()));
            dones.add(new Edge(nodo,"_",nodo+1));
        }
        else
        {
            edges.add(new Edge(nodo,"_",nodo+2));
            edges.add(new Edge(nodo+2,expression[fin-1],nodo+3));
            edges.add(new Edge(nodo+3,"_", nodo+2));
            edges.add(new Edge(nodo+3,"_", nodo+1));
            dones.add(new Edge(nodo,"_",nodo+1));
            
        }
        expression[fin]=("done"+String.valueOf(dones.size()-1));
        boolean punto = false;
        while(!punto)
        {
            expression[tempFin]=("done"+String.valueOf(dones.size()-1));
            tempFin--;
            if(tempFin<inicioReal || expression[tempFin].equals(".") || expression[tempFin].equals("_") || expression[tempFin].equals("*"))
                punto=true;
        }
        
    }

    private void union(int fin)
    {
        int tempFin=finReal;
        if(!(expression[fin].length()>1))
        {
            if (expression[fin-1].equals("*"))
                estrella(fin-1);
            if (expression[fin-1].length()>1 && expression[fin+1].length()>1)
            {  
                int nodo = ultimoNodo();
                int doneUno = getDone(expression[fin-1]);
                int doneDos = getDone(expression[fin+1]);
                edges.add(new Edge(nodo,"_",  dones.get(doneUno).getSon()));
                edges.add(new Edge(nodo,"_",  dones.get(doneDos).getSon()));
                edges.add(new Edge(dones.get(doneUno).getFather() ,"_", nodo+1));
                edges.add(new Edge(dones.get(doneDos).getFather() ,"_", nodo+1));
                dones.add(new Edge(doneUno, "done", doneDos));
            }
            else if(expression[fin+1].length()>1)
            {
                int nodo = ultimoNodo();
                int done = getDone(expression[fin+1]);
                edges.add(new Edge(nodo,"_",  dones.get(done).getSon()));
                edges.add(new Edge(dones.get(done).getFather() ,"_", nodo+1));
                edges.add(new Edge(nodo,"_",nodo+2));
                edges.add(new Edge(nodo+2,expression[fin-1],nodo+3));
                edges.add(new Edge(nodo+3, "_", nodo+1));
                dones.add(new Edge(nodo, "_", nodo+1));
            }
            else if (expression[fin-1].length()>1)
            {
                int nodo = ultimoNodo();
                int done = getDone(expression[fin-1]);
                edges.add(new Edge(nodo,"_",  dones.get(done).getSon()));
                edges.add(new Edge(dones.get(done).getFather() ,"_", nodo+1));
                edges.add(new Edge(nodo,"_",nodo+2));
                edges.add(new Edge(nodo+2,expression[fin+1],nodo+3));
                edges.add(new Edge(nodo+3, "_", nodo+1));
                dones.add(new Edge(nodo, "_", nodo+1));
            }

            else
            {
                int nodo = ultimoNodo();
                edges.add(new Edge(nodo,"_",nodo+1));
                edges.add(new Edge(nodo,"_",nodo+2));
                edges.add(new Edge(nodo+1,expression[fin+1],nodo+4));
                edges.add(new Edge(nodo+2,expression[fin-1],nodo+3));
                edges.add(new Edge(nodo+4,"_",nodo+5));
                edges.add(new Edge(nodo+3,"_",nodo+5));
                dones.add(new Edge(nodo, "done", nodo+5));
            }
            expression[fin]=("done"+String.valueOf(dones.size()-1));
            boolean punto = false;
            while(!punto)
            {
                expression[tempFin]=("done"+String.valueOf(dones.size()-1));
                tempFin--;
                if(tempFin<inicioReal || expression[tempFin].equals(".") || expression[tempFin].equals("_") || expression[tempFin].equals("*"))
                    punto=true;
        }
        }
    }
    
    public int ultimoNodo()
    {
        int mayor=-1;
        for(int i=0; i<edges.size();i++)
        {
            if(mayor<edges.get(i).getFather())
                mayor=edges.get(i).getFather();
            if(mayor<edges.get(i).getSon())
                mayor=edges.get(i).getSon();
        }
        return mayor+1;
    }

    private int getDone(String string) 
    {
        String temp[] = string.split("");
        return Integer.parseInt(temp[temp.length-1]);
    }
    public void imprimir()
    {
        for(int i=0; edges.size()>i; i++)
        {
            System.out.println(edges.get(i).getFather()+","+edges.get(i).getValue()+","+edges.get(i).getSon());
        }
        System.out.println("------------");
        for(int i=0; i<expression.length;i++)
        {
            System.out.print(expression[i]);
        }
    }
}
