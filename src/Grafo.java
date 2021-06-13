
public class Grafo<T>{
    /** 
     * ¿Cómo funciona este grafo?
     * 
     * Creación del grafo y la matriz:
     * 
     * Debemos entender, que como tal, el nodo va estar construido en base a dos
     * estructura de datos estáticas, la primera será un areglo bidimensional, que va
     * a representar las adyacencias de los nodos (o vértices, estos términos serán usados
     * como sinónimos). El segundo será un arreglo de la información que contengan los
     * nodos, y puede ser de cualquier tipo de dato primitivo que este disponible.
     * 
     * Los nodos del grafo, son creados al momento de darle un valor al
     * @param maxNodes en el constructor, ¿por qué se hace esta afirmación? Bueno, como
     * ya es bien sabido, al momento de crear un vector o una matriz en Java, el compilador
     * por sí mismo inicializa todos los valores de las celdas con un valor predeterminado
     * según el tipo de dato que se este manejando, aquí una lista de como se inicializan 
     * por defecto las variable dependiendo del tipo de dato al que pertenezcan:
     * 
     *  @String será el valor "".
     *  @int será el valor de 0.
     *  @double será el valor de 0.0.
     *  @float será el valor 0.0f.
     *  @boolean será false.
     *  @Object será null.
     * 
     * Por lo tanto, creemos la matriz (que es de enteros) en el constructor, esta se verá 
     * de la siguiente manera:
     * 
     * @see adjMatExample.jpg
     * 
     * Por lo que, al ver esta ilustración, se puede interpretar como que los nodos ya están
     * creados, solo que no contienen adyacencia ni información, no obstante, al fianl de
     * cuentas, estos existen.
     * 
     * 
     * Atributos de la clase.
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
    public int[][] adjMat;
    public Object[] vertInfo;





    /** Constructor.
     * 
     * Cómo ya se explicó con anterioridad, no es necesario cargar los valores en la matriz y el vector en
     * ceros, pues esto ya lo hace el compilador de Java por defecto.
     * 
      */
    public Grafo(int maxNodes, boolean isDirected){
        this.maxNodes = maxNodes;
        this.verQuant = 0;
        this.isDirected = isDirected;
        this.adjMat = new int[this.maxNodes][this.maxNodes];    
        this.vertInfo = new Object[this.maxNodes];    
    }



    // Métodos de inserción y eliminación.

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
     * el valor que guarda este en el arreglo vertInfo se igualará a nulo 
     * y se decrementará el valor de la variable vertQuant.
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



    // TODO: Documentación aún no añadida para los siguientes métodos.

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

    /** Método para obtener el index de un nodo.
     * 
     * @param a. Recibe la información que el nodo guarde
     * en el arreglo vertInfo.
     * 
     * La idea es hacer una búsqueda lineal de la etiqueta (información)
     * del nodo en el arreglo vertInfo, una vez obtenida, se retorna el valor
     * del index.
     * 
     * Este método no esta pensado para ser usado por el usuario, más bien, es
     * un método de utilidad que se utiliza en una variedad de métodos, en donde
     * se requiera obtener la posición del index de cierto nodo, por ejemplo, 
     * cuando se requiere verificar la adyacencia de dos nodos, pues no debemos
     * olvidar, que los índices de vertInfo son los mismos para las  filas y las
     * columnas de la matriz de adyacencia. Es decir, sí un nodo con la etiqueta
     * "COL" se tiene en el index 0 del vector, entonces, este índice del vector,
     * va a representar la posición 0 de la columnas y 0 de las filas en la matriz.
     * 
     * En caso de que no encuentre ningún vector con la etiqueta ingresada, se
     * retornará un -1.
      */

    private int getIndOfNode(T a){
        for (int i = 0; i < vertInfo.length; i++) {
            if(vertInfo[i] == a){
                return i;
            }
        }
        return -1;
    }

    // Query methods

    /** Comprobación de adyacencia.
     * 
     * Comprueba sí dos nodos tienen una adyacencia entre sí.
     * 
     * @param a. Representa la información de un nodo dentro del vector
     * vertInfo.
     * @param b. Tiene el mismo propósito que el parámetro a.
     * 
     * La idea es tomar la posición del primer y segundo nodo en el arreglo 
     * vertInfo, después, estos index se guardan en las variables row y col.
     * 
     * Una vez se tienen las posiciones de los index de cada uno de los nodos, se
     * pasan a comparar esas mismas posiciones en la matriz de adyacencia.
     * 
     * En caso de que el grafo sea dirigido, entonces se deberá evaluar que
     * las posiciones row, col ó col, row en la matriz, sean diferentes a 0,
     * representando que hay adyacencia.
     * 
     * En caso de que no sea dirigido, las dos condiciones anteriormente mencionadas
     * se tendrán que cumplir para que se retorne un true.
      */
    public boolean isAdjacent(T a, T b){
        int row = getIndOfNode(a);
        int col = getIndOfNode(b);

        if(isDirected){
            try {
                if(adjMat[row][col] != 0 || adjMat[col][row] != 0){
                    return true;
                }
            } catch (Exception e) {
                System.out.println("El nodo o la arista no existe");
            }
        }else{
            try {
                if(adjMat[row][col] != 0 && adjMat[col][row] != 0){
                    return true;
                }
            } catch (Exception e) {
                System.out.println("El nodo o la arista no existe");
            }
        }
        return false;
    }


    public void printMatrix(){
        for (int i = 0; i < 6; i++) {
            System.out.print(" ");
        }
        for (Object o : vertInfo) {
            System.out.print(o + "     ");
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

