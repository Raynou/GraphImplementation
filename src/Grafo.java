
public class Grafo<T>{
    /** 
     * ¿Cómo funciona este grafo?
     * 
     * La  clase, principalmente, esta compuesta de dos arreglos importantes:
     * 
     *  @array adjMat[][]. Es la matriz de adyacencia del grafo, y representa que nodos
     *  del gafo son adyacentes entre sí.
     *  @array vertInfo[]. Es un arreglo asociativo del grafo, sirve para representar el
     *  contenido de los nodos, puede ser del tipo de dato que el usuario ingrese al 
     *  momento de indicarlo en la notación diamante.
     * 
     * 
     * Atributos de la clase:
     *  @var maxNodes: sirve para delimitar el tamaño máximo de nodos que va
     *  tener el tamaño de la matriz de adyacencia y del grafo asociativo.
     * 
     *  @var verQuant: variable auxiliar, es utilizada para ir marcando la cantidad de
     *  vértices (nodos) del grafo que tienen guardan un contenido, sin importar si
     *  tiene o no adyacencia. La variable se utiliza es esencial para los siguientes
     *  métodos:
     * 
     *      @met addVert()
     *      @met deleteVer()
     * 
     *  @var isDirected: booleano que determina sí el grafo es dirigo o no.
     * 
     * 
     */
    public int maxNodes;
    public int verQuant;
    public boolean isDirected;
    public int adjMat[][];
    public Object vertInfo[];


    public Grafo(int maxNodes, boolean isDirected){
        this.maxNodes = maxNodes;
        this.verQuant = 0;
        this.isDirected = isDirected;
        this.adjMat = new int[this.maxNodes][this.maxNodes];    
        this.vertInfo = new Object[this.maxNodes];    
    }



    // Insertion and deletion methods

    /**
     * Al momento de añadir un vértice, lo que se esta haciendo en realidad es
     * asignar la información que este contenga, pues, como hemos de recordar
     * todos los vértices ya fueron creados en la matriz de adyacencia al 
     * momento de inicializarla en el cosntructor.
     * 
     * @param data. Es un parámetro de tipo genérico, que se guarda directamente
     * en el arreglo vertInfo[] en una posición determinada por la variable
     * vertQuant.
     * 
     * En caso de que la variable vertQuant sea igual a maxNodes (número de nodos
     * existentes en el grafo), simplemente no se añadirá ningún valor a vertInfo[]
     * y se imprimirá un mensaje de alerta.
    */
    public void addVert(T data){
        if(verQuant == maxNodes){
            System.out.println("El grafo ya no contiene más vértices");
        }else{
            vertInfo[verQuant] = data;
            verQuant++;
        }
    }

    /**
     * Método de eliminación de un vértice en un grafo.
     * 
     * El concepto del método es sencillo, sí el vértice existe,
     * entonces primeramente se evaluará si este tiene o no adyacencia.
     * 
     * En caso de que el vértice no tenga ninguna adyacencia, simplemente
     * el valor que guarda este se igualará a nulo y no se decrementará el
     * valor de la variable vertQuant.
     * 
     * En casi de que el vértice sí tenga una adyacencia, se procederá a igualar
     * todos los valores de las columnas y las filas correspondientes al 
     * index del vértice a 0.
     * 
     * @param data. Se usa para buscar el index correspondiente a el valor que se
     * desea eliminar en el arreglo de vertInfo, y también en la adjMat en caso
     * de que exista adyacencia.
     */

    public void deleteVert(T data){
    
        int vertPosition = getIndOfNode(data);

        /* Se debe añadir un condicional que verifique
        sí "data" tiene adyacencia entre "Inicio" y  "Fin" */
        // Inicio
        for (int i = 0; i < adjMat.length; i++) {
            adjMat[vertPosition][i] = 0;
        }

        for (int i = 0; i < adjMat.length; i++) {
            adjMat[i][vertPosition] = 0;
        }
        // Fin

        vertInfo[vertPosition] = null;

        verQuant--;

    }

    @Deprecated void addEdge(int row, int col){
        if(adjMat[row][col] != 1)
            adjMat[row][col] = 1;
        else System.out.println("Arista ya existente");
    }


    /**
     * Método para añadir una arista entre dos vértices que contengan información que no
     * sea nula.
     * 
     * 
     */
    public void addEdge(T a, T b){

        int row = getIndOfNode(a);
        int col = getIndOfNode(b);

        if(adjMat[row][col] != 1){
            if(!isDirected){
                adjMat[row][col] = 1;
                adjMat[col][row] = 1;
            }else{
                adjMat[row][col] = 1;
            }
        }else{
                System.out.println("Arista ya existente");
        }
            
        
    }

    public void deleteEdge(T a, T b){
        int row = getIndOfNode(a);
        int col = getIndOfNode(b);

        if(adjMat[row][col] != 0){
            if(!isDirected){
                adjMat[row][col] = 0;
                adjMat[col][row] = 0;
            }else{
                adjMat[row][col] = 0;
            }
        }else{
            System.out.println("La arista no existe");
        }
    }


    // Uility methods

    private int getIndOfNode(T a){
        for (int i = 0; i < vertInfo.length; i++) {
            if(vertInfo[i] == a){
                return i;
            }
        }
        return -1;
    }

    // Query methods

    public boolean isAdjacent(T a, T b){
        return true;
    }


    public void printMatrix(){
        for (int i = 0; i < 6; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < vertInfo.length; i++) {
            System.out.print(vertInfo[i] + "     ");
        }
        System.out.println();
        for(int i=0; i< maxNodes; i++){
            System.out.println("");
            System.out.print(vertInfo[i]+"    ");
            for(int j=0; j< maxNodes; j++){
                System.out.print(adjMat[i][j] + "       " );        
            }
            System.out.println();
            System.out.println();
        }
    }
}

