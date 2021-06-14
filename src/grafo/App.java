package grafo;
public class App {
    /**
     * <h2>Algunas cosas importante a tener en cuenta:</h2>
     * <p>Los métodos que fueron solicitados en para la implementación del grafo son los siguientes:</p>
     *
     * <ol>
     *     <li>Creación de un grafo vacío</li>
     *     <li>Inicializar grafo</li>
     *     <li>Insertar aristas</li>
     *     <li>Insertar vértices</li>
     *     <li>Eliminar vértices</li>
     *     <li>Eliminar aristas</li>
     *     <li>Comprobar sí el grafo esta vacío</li>
     *     <li>Comprobar adyacencia</li>
     *     <li>Imprimir grafo</li>
     * </ol>
     *
     * <p>Tales métodos fueron implementados con los siguientes nombres: </p>
     *
     * <ol>
     *     <li>Grafo()</li>
     *     <li>Grafo()</li>
     *     <li>addEdge()</li>
     *     <li>addVert()</li>
     *     <li>deleteVert()</li>
     *     <li>deleteEdge</li>
     *     <li>isEmpty()</li>
     *     <li>isAdjacent()</li>
     *     <li>printMatrix()</li>
     * </ol>
     * */
    public static void main(String[] args) throws Exception {

        // Se crea la matiz de adyacencia y los nodos
        // en este caso será un grafo no dirigido
        Grafo<String> grafo = new Grafo<>(4, false);

        // Se verifica que sí el grafo esta vacío, en este caso no lo está, por lo que deberá imprimir "true"
        System.out.println(grafo.isEmpty() ? "El grafo esta vacío.":"El grafo no esta vacío.");

        grafo.addVert("MEX");
        grafo.addVert("COL");
        grafo.addVert("USA");
        grafo.addVert("BRA");

        // Se crea un lazo
        grafo.addEdge("MEX", "MEX");
        
        // Se crea una arista entre MEX y USA
        grafo.addEdge("MEX", "USA");

        // Se crea una matriz entre COL y USA
        grafo.addEdge("COL", "USA");

        // Se crea una arista entre COL y BRA
        grafo.addEdge("COL", "BRA");
        
        // Se imprime la matriz de adyacencia.
        grafo.printMatrix();

        // Se verifica la adyacencia de dos vértices, en este caso el resultado esperado es "true".
        System.out.println(grafo.isAdjacent("USA", "COL") ? "Hay adyacencia entre COL y USA":"No hay adyacencia"
                + "entre COL y USA");

        // Ahora que se han añadido valores, el resultado esperado es "false".
        System.out.println(grafo.isEmpty() ? "El grafo esta vacío.":"El grafo no esta vacío.");

        // Eliminación de la arista entre USA y COL.
        grafo.deleteEdge("USA", "COL");

        grafo.printMatrix();

        System.out.println(grafo.isAdjacent("USA", "COL") ? "Hay adyacencia entre COL y USA":"No hay adyacencia"
                + "entre COL y USA");

        //Eliminación de BRA.

        grafo.deleteVert("BRA");
        grafo.printMatrix();
    
    }
}
