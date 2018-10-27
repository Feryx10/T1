/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */

public interface APIConvert {
    /**
     * Método que recibe dos arreglos de elementos para
     * realizar el AFND y el AFD e imprimir en pantalla.
     *
     * @param regular es la expresion regular.
     * @param chain es la cadena a consumir.
     * 
     */
    public void toAFND(String[] regular,String[] chain);
    
    public void toAFD (String[] regular,String[] chain);
    
    
}
