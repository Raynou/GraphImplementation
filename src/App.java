public class App {
    public static void main(String[] args) throws Exception {
        Grafo<String> grafo = new Grafo<>(4, false);

        grafo.addVert("COL");
        grafo.addVert("MEX");
        grafo.addVert("BRA");
        grafo.addEdge("COL", "MEX");
        grafo.addEdge("BRA", "MEX");
        grafo.printMatrix();


        System.out.println("Al borrar un vértice");
        System.out.println();
        grafo.deleteVert("BRA");

        grafo.printMatrix();

        System.out.println(grafo.isAdjacent("BRA", "MEX"));
    }


}
