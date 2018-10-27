/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */

public class Edge {   

    private final String father;
    private final String value;
    private final String son;
    
    public Edge(String father,String value,String son){
        this.father = father;
        this.value  = value;
        this.son    = son;
        
    }

    public String getFather() {
        return father;
    }

    public String getValue() {
        return value;
    }

    public String getSon() {
        return son;
    }
    
    
}
