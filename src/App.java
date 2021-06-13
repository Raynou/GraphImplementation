public class App {
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
