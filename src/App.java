public class App {
    /**
     * <h2>Algunas cosas importante a tener en cuenta:</h2>
     * <p>Los métodos que fueron solicitados en para la implementación del grafo son los siguientes:</p>
     *
     * <ul>
     *     <li>Creación de un grafo vacío</li>
     *     <li>Inicializar grafo</li>
     *     <li>Insertar aristas</li>
     *     <li>Insertar vértices</li>
     *     <li>Eliminar vértices</li>
     *     <li>Eliminar aristas</li>
     *     <li>Comprobar sí el grafo esta vacío</li>
     *     <li>Comprobar adyacencia</li>
     *     <li>Imprimir grafo</li>
     * </ul>
     *
     * <p>Por motivos de la naturaleza del compilador de Java, el método "creación de un grafo vacío" e
     * "Inicializar un grafo vacío" fueron mezclados e implementados como el constructor de la propia clase,
     * ya que como tal no es posible crear una matriz vacía en Java, porque el compilador siempre las inicializa
     * con valores por defecto, en este caso, la matriz de adyacencia, se trabajó con enteros, por lo que, al
     * momento de crearla, es inicializada con valores de cero.</p>
     * */
    public static void main(String[] args) throws Exception {

        // Se crea la matiz de adyacencia y los nodos
        // en este caso será un grafo no dirigido
        Grafo<String> grafo = new Grafo<>(4, false);

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
    
    }
}
