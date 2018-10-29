/**
 * Maquinas Abstractas. 2018-2
 * Tarea 1 
 * @author 
 * Luciano Garcia 
 * Fernando Pino 
 */

public interface APISearch {

    /**
     * Método que recibe un arreglo de elementos y un caracter
     * para realizar una búsqueda en el arreglo de tal caracter.
     *
     * @param array es el arreglo en cual realizará la búsqueda
     * @param key es el elemento a buscar
     * @return Los índices del caracter búscado. null si es que no se encuentra
     */
    public int[] positions(String[] array, String key);

}
