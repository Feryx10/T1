/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinasabstractas;

import java.util.ArrayList;

/**
 *
 * @author lucia
 */
public class Funciones {
    ArrayList<Edge> edges = new ArrayList<Edge>();
    ArrayList<Edge> dones = new ArrayList<Edge>();
    private String[] expression;
    
    
    
    public void desarmador(int inicio, int fin)
    {
        while(fin<inicio)
        {
            contieneSimbolo(fin);
            fin--;
        }
    }
    
    
    private void contieneSimbolo(int fin) 
    {
        switch(expression[fin]){
                    case ".":
                        concatenacion(fin);    
                    case "*":
                        estrella(fin);
                    case "|":
                        union(fin);
                        
}
    }

    private void concatenacion(int fin) 
    {
        if(expression[fin+1].length()>1)
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
            edges.add(new Edge(ultimoNodo(), ))
        }
    }

    private void estrella(int fin) {
    
    }

    private void union(int fin) {

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

    private int getDone(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
