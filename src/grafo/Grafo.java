package grafo;
public class Grafo<T>{
    /**
     * <h1>Implementación de grafo en Java</h1>
     * <p>Autor: Rafael García Mendoza</p>
     * <p>Último commit: 13/06/21</p><br>
     *
     * <h1>¿Cómo funciona este grafo?</h1>
     * 
     * <h2>Creación del grafo y la matriz:</h2>
     * 
     * <p>Debemos entender, que como tal, el nodo va estar construido en base a dos
     * estructuras de datos estáticas, la primera será un arreglo bidimensional, que va
     * a representar las adyacencias de los nodos (o vértices, estos términos serán usados
     * como sinónimos). El segundo será un arreglo de la información que contengan los
     * nodos, y puede ser de cualquier tipo de dato que este disponible.</p>
     * 
     * <p>Los nodos del grafo, son creados al momento de darle un valor al
     * parámetro <var>maxNodes</var> en el constructor, ¿por qué se hace esta afirmación? Bueno, como
     * ya es bien sabido, al momento de crear un vector o una matriz en Java&trade;, el compilador
     * por sí mismo inicializa todos los valores de las celdas con un valor predeterminado
     * según el tipo de dato que se este manejando, aquí una lista de como se inicializan 
     * por defecto las variable dependiendo del tipo de dato al que pertenezcan:</p><br>
     * 
     *  <p>-Para <var>String</var> será el valor <var>null</var>.</p>
     *  <p>-Para <var>int</var> será el valor de <var>0</var>.</p>
     *  <p>-Para <var>double</var> será el valor de <var>0.0</var>.</p>
     *  <p>-Para <var>float</var> será el valor <var>0.0f</var>.</p>
     *  <p>-Para <var>boolean</var> será <var>false</var>.</p>
     *  <p>-Para <var>Object</var> será <var>null</var>.</p>
     *  
     * <p>Por lo que, se puede interpretar que los nodos ya están
     * creados, solo que no contienen adyacencia ni información, sin embargo, al final de
     * cuentas, estos existen.</p><br>
     * 
     * 
     * <h3>Atributos de la clase.</h3>
     * 
     *  <p>-<var>adjMat[][]</var>. Es la matriz de adyacencia del grafo, y representa que nodos
     *  del gafo son adyacentes entre sí.</p>
     *  <p>-<var>vertInfo[]</var>. Es un arreglo asociativo del grafo, sirve para representar el
     *  contenido de los nodos, puede ser del tipo de dato que el usuario ingrese al 
     *  momento de indicarlo en la notación diamante.</p><br>
     *  <p>-<var>maxNodes</var>: sirve para delimitar el tamaño máximo de nodos que va
     *  tener el tamaño de la matriz de adyacencia y del grafo asociativo.</p><br>
     *  <p>-<var>verQuant</var>: variable auxiliar, es utilizada para ir marcando la cantidad de
     *  vértices (nodos) del grafo que guardan un contenido, sin importar si
     *  tiene o no adyacencia. La variable se utiliza es esencial para los siguientes
     *  métodos: <var>addVert()</var> y <var>deleteVert()</var>.</p><br>
     * <p>-<var>isDirected</var>: booleano que determina sí el grafo es dirigido o no.</p><br>
     * 
     * 
     */

    public int maxNodes;
    public int verQuant;
    public boolean isDirected;
    public int[][] adjMat;
    public Object[] vertInfo;




    /**
     * <h3>Constructor, sin inicializar la matriz.</h3>
     *<p>Con este constructor, simplemente se va a determinar sí el grafo es dirigido o no.</p>
     * */
    public Grafo(boolean isDirected){
        this.isDirected = isDirected;
        maxNodes = verQuant = 0;
    }

    /**
     * <h3>Constructor con parámetros.</h3>
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
     * <h3>Método para la inserción de un vértice</h3>
     *
     * <p>Al momento de añadir un vértice, lo que se esta haciendo en realidad es
     * asignar la información que este contenga, pues, como hemos de recordar
     * todos los vértices ya fueron creados en la matriz de adyacencia al 
     * momento de inicializarla en el constructor.</p>
     *
     * 
     * <p>En caso de que la variable <var>vertQuant</var> sea igual a <var>maxNodes</var> (número de nodos
     * existentes en el grafo), simplemente no se añadirá ningún valor a <var>vertInfo[]</var>
     * y se imprimirá un mensaje de alerta.</p>
     *
     *@param data Es un parámetro de tipo genérico, que se guarda directamente
     *en el arreglo <var>vertInfo[]</var> en una posición determinada por la variable
     *<var>vertQuant</var>.
    */

    public void addVert(T data) throws Exception{
        if(verQuant == maxNodes){
            throw new Exception("El grafo ya no puede contener más vértices");
        }else{
            vertInfo[verQuant] = data;
            verQuant++;
        }
    }

    /**
     * <h3>Método de eliminación de un vértice en un grafo.</h3>
     * 
     * <p>El concepto del método es sencillo, sí el vértice existe,
     * eliminarán todas sus adyacencias.</p>
     *
     * <p>Para lograr esto, se consigue el valor el index del nodo en el array <var>verInfo</var>, para esto
     * se usa el método <var>getIndOfNode().</var></p>
     *
     * <p>Se procederá a igualar todos los valores de las columnas y las filas en la matriz correspondientes al
     * index del vértice a 0.</p>
     *
     * <p>Al final, simplemente se igualará el valor guardado en el arreglo <var>vertInfo</var> a nulo y se
     * decrementará el valor de la variable <var>vertQuant.</var></p>
     *
     * <p>En caso de que el método <var>getIndOfNode()</var> retorne un -1, entonces se propagará une excepción.</p>
     * 
     * @param data Se usa para buscar el index correspondiente a el valor que se
     * desea eliminar en el arreglo de vertInfo, y también en la adjMat en caso
     * de que exista adyacencia.
     */

    public void deleteVert(T data) throws Exception{
    
        int vertPosition = getIndOfNode(data);

        if (vertPosition == -1) throw new Exception("Vértice no existente");

        for (int i = 0; i < adjMat.length; i++) {
            adjMat[vertPosition][i] = 0;
        }

        for (int i = 0; i < adjMat.length; i++) {
            adjMat[i][vertPosition] = 0;
        }

        vertInfo[vertPosition] = null;

        verQuant--;

    }


    /**
     * <h3>Método para añadir una arista entre dos vértices que contengan información que no
     * sea nula.</h3>
     * 
     * <p>Primero obtiene la posición de los nodos a los que se desea añadir un vértice
     * para conectarlos entre sí.</p>
     *
     * <p>Para obtener la posición de cada uno de los índices de los vértices en el <var>vertInfo</var> y
     * <var>adjMat</var>, se llama al método <strong>getIndOfNode()</strong>, cuya explicación de funcionamiento y propósito
     * se indica en el comentario que esta sobre la definición del método anteriormente mencionado.</p><br>
     * 
     * <p>Después, se hace la verificación sí el nodo es dirigido o no, en caso de ser dirigido,
     * simplemente se verifica si ya no hay alguna arista existente entre los nodos, en caso de
     * ser así, no se añade nada y se imprime un mensaje de alerta.</p><br>
     * 
     * <p>En caso de no ser dirigido y sí no existe una arista (es decir, que la posición <var>adjMat[row][col]</var>
     * contenga un cero), entonces, se añade el valor de uno de vértice 'a' a vértice 'b' y viceversa, ya
     * que no es dirigido.</p>
     *
     * @param a Etiqueta del primer nodo.<br>
     * @param b Etiqueta del segundo nodo.<br>
     * 
     */
    public void addEdge(T a, T b){

        int row = getIndOfNode(a);
        int col = getIndOfNode(b);

        if(isDirected){
            if(adjMat[row][col] != 1){
                adjMat[row][col] = 1;
            }else{
                System.out.println("Arista ya existente");
            }
        }else{
            if(adjMat[row][col] != 1 ){
                adjMat[row][col] = 1;
                adjMat[col][row] = 1;
            }else{
                System.out.println("Arista ya existente");
            }
        }
        
    }


    /**
     * <h3>Método para la eliminación de una arista</h3>
     * 
     * Hace casi exactamente el mismo proceso que el método <var>addEdge()</var>, sin embargo, en lugar de verificar
     * sí la arista no existe, en caso de no existir, no va borrar nada (porque no hay nada que borrar) y simplemente
     * se imprimirá un mensaje de alerta.
     * 
     * 
      */

    public void deleteEdge(T a, T b){
        int row = getIndOfNode(a);
        int col = getIndOfNode(b);

        if(isDirected){
            if(adjMat[row][col] != 0){
                adjMat[row][col] = 0;
            }else{
                System.out.println("La arista entre los nodos ingresados no existe");
            }
        }else{
            if(adjMat[row][col] != 0 ){
                adjMat[row][col] = 0;
                adjMat[col][row] = 0;
            }else{
                System.out.println("La arista entre los nodos ingresados no existe");
            }
        }
    }


    // Métodos de utilidad

    /**
     *<h3>Método para obtener el index de un nodo.</h3>
     * 
     * <p>La idea es hacer una búsqueda lineal de la etiqueta (información)
     * del nodo en el arreglo <var>vertInfo</var>, una vez obtenida, se retorna el valor
     * del index.</p>
     * 
     * <p>Este método no esta pensado para ser usado por el usuario, más bien, es
     * un método de utilidad que se utiliza en una variedad de métodos de la clase,
     * en donde se requiera obtener la posición del index de cierto nodo, por ejemplo,
     * cuando se requiere verificar la adyacencia de dos nodos, pues no debemos
     * olvidar, que los índices de <var>vertInfo</var> son los mismos para las  filas y las
     * columnas de la matriz de adyacencia. Es decir, sí un nodo con la etiqueta
     * "COL" se tiene en el index 0 del vector, entonces, este índice del vector,
     * va a representar la posición 0 de la columnas y 0 de las filas en la matriz.</p>
     * 
     * <p>En caso de que no encuentre ningún vector con la etiqueta ingresada, se
     * retornará un -1.</p>
     *
     *@param a Recibe la información que el nodo guarde
     *en el arreglo <var>vertInfo</var>.<br>
      */

    private int getIndOfNode(T a){
        for (int i = 0; i < vertInfo.length; i++) {
            if(vertInfo[i] == a){
                return i;
            }
        }
        return -1;
    }

    // Métodos de consulta

    /**
     * <h3>Comprobación de adyacencia.</h3>
     * 
     * Comprueba sí dos nodos tienen una adyacencia entre sí.
     *
     * 
     * <p>La idea es tomar la posición del primer y segundo nodo en el arreglo
     * <var>vertInfo</var>, después, estos index se guardan en las variables <var>aIndex</var> y <var>bIndex</var>.</p>
     * 
     * <p>Una vez se tienen las posiciones de los index de cada uno de los nodos, se
     * pasan a comparar esas mismas posiciones en la matriz de adyacencia.</p>
     * 
     * <p>En caso de que el grafo sea dirigido, entonces se deberá evaluar que
     * las posiciones <var>bIndex</var>, <var>aIndex</var> ó <var>aIndex</var>, <var>bIndex</var> en la matriz,
     * sean diferentes a 0, representando que hay adyacencia.</p>
     * 
     * <p>En caso de que no sea dirigido, las dos condiciones anteriormente mencionadas
     * se tendrán que cumplir para que se retorne un true.</p>
     *
     * @param a Representa la etiqueta de un nodo dentro del vector
     * <var>vertInfo</var>.
     * @param b Representa la etiqueta de un nodo dentro del vector <var>vertInfo</var>. <br><br>
     *
     *          <p>Básicamente, la idea es comprobar adyacencia entre un vértice <var>a</var> y  un
     *          vértice <var>b</var>.</p>
     *
     *
      */
    public boolean isAdjacent(T a, T b){

        //aIndex representa el índice del nodo 'a' dentro del arreglo vertInfo[],
        //mientras que bIndex hace lo mismo, pero con el nodo 'b'.
        int aIndex = getIndOfNode(a);
        int bIndex = getIndOfNode(b);

        if(isDirected){
            try {
                if(adjMat[aIndex][bIndex] != 0 || adjMat[bIndex][aIndex] != 0){
                    return true;
                }
            } catch (Exception e) {
                System.out.println("El nodo o la arista no existe");
            }
        }else{
            try {
                if(adjMat[bIndex][aIndex] != 0 && adjMat[aIndex][bIndex] != 0){
                    return true;
                }
            } catch (Exception e) {
                System.out.println("El nodo o la arista no existe");
            }
        }
        return false;
    }

    /**
     * <h3>Método de consulta: grafo vacío</h3>
     *
     * <p>Su funcionamiento es bastante sencillo, sí no existen vértices con información diferente a nula,
     * es decir, que el arreglo <var>vertInfo[]</var> esta lleno de puros valores nulos, entonces eso significa que
     * la variable <var>verQuant</var> es igual a 0, y sí ese es el caso, entonces este método retorna true.</p>
     * */

    public boolean isEmpty(){
        return verQuant == 0;
    }


    /**
     * <h3>Simple método para imprimir la matriz de adyacencia</h3>
     * 
     * El método es sencillo, solo es un clásico proceso de imprimir un
     * arreglo bidimensional, sin embargo, se añade  un poco de formato.
      */
    public void printMatrix(){
        for (int i = 0; i < 6; i++) {
            System.out.print(" ");
        }
        for (Object o : vertInfo) {
            if (o != null)System.out.print(o + "     ");
        }
        System.out.println();
        for(int i=0; i< maxNodes; i++){
            System.out.println();
            if (vertInfo[i] != null)System.out.print(vertInfo[i]+"    ");
            for(int j=0; j< maxNodes; j++){
                if (vertInfo[i] != null && vertInfo[j] != null){
                    System.out.print(adjMat[i][j] + "       " );
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}

