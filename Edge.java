package tarea1;

/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */

public class Edge {   

    private final int father;
    private final String value;
    private final int son;
    
    public Edge(int father,String value,int son){
        this.father = father;
        this.value  = value;
        this.son    = son;
        
    }

    public int getFather() {
        return father;
    }

    public String getValue() {
        return value;
    }

    public int getSon() {
        return son;
    }
    
    
}
