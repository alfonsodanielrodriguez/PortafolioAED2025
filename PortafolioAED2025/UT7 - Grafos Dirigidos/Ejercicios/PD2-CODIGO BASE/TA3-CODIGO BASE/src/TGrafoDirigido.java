
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Map<Comparable, TVertice> vertices = getVertices();
        LinkedList<Comparable> listaVertices = new LinkedList<Comparable>();
        LinkedList<Comparable> excentricidades = new LinkedList<Comparable>();

        for (Map.Entry<Comparable, TVertice> entry : vertices.entrySet()) {
            listaVertices.add(entry.getKey());
            excentricidades.add(obtenerExcentricidad(entry.getKey()));
        }
        LinkedList<Comparable> excentricidadesAux = (LinkedList<Comparable>) excentricidades.clone();
        Double menosUno = -1.d;
        while (excentricidadesAux.contains(menosUno)) {
            excentricidadesAux.remove(menosUno);
        }
        Comparable centro = excentricidadesAux.getFirst();
        for (Comparable excentricidad : excentricidadesAux) {
            if (centro.compareTo(excentricidad) > 0) {
                centro = excentricidad;
                System.out.println(centro.toString());
            }
        }
        int indice = excentricidades.indexOf(centro);
        centro = listaVertices.get(indice);
        return centro;
        
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizFloyd = UtilGrafos.obtenerMatrizCostos(vertices);
        Double[][] matrizPredecesores = new Double[matrizFloyd.length][matrizFloyd.length];
        int tamanio = matrizFloyd.length;

        for (int i = 0; i < tamanio; i++) {
            matrizFloyd[i][i] = 0d;
        }
        for (int k = 0; k < tamanio; k++) {
            for (int i = 0; i < tamanio; i++) {
                for (int j = 0; j < tamanio; j++) {
                    if (i != k && i != j && k != j) {
                        if (matrizFloyd[i][k] + matrizFloyd[k][j] < matrizFloyd[i][j]) {
                            matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                            matrizPredecesores[i][j] = (double) k;

                        }
                    }
                }
            }
        }
        return matrizFloyd;

    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] floyd = this.floyd();
        Map<Comparable, TVertice> vertices = this.getVertices();
        Object[] etiquetas = vertices.keySet().toArray();
        Integer indiceEtiqueta = null;
        for (int i = 0; i < etiquetas.length; i++) {
            if (etiquetas[i].equals(etiquetaVertice)) {
                indiceEtiqueta = i;
                break;
            }
        }
        Double excentricidad = -1d;
        for (int i = 0; i < floyd.length; i++) {
            if ((floyd[i][indiceEtiqueta] != Double.MAX_VALUE) && i != indiceEtiqueta && floyd[i][indiceEtiqueta] > excentricidad) {
                excentricidad = floyd[i][indiceEtiqueta];
            }
        }
        return excentricidad;

    }
    
    
    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        desvisitarVertices();
        Collection<TVertice> visitados = new LinkedList<>();
        if (vertice != null) {
            vertice.bpf(visitados);
        }
        return visitados;
    
    }
    

    @Override
    public Collection<TVertice> bpf() {
       desvisitarVertices(); //agregué este bpf porque no usamos el bpf con vertice al final
        Collection<TVertice> visitados = new LinkedList<>();
        Collection<TVertice> vertices = this.vertices.values();
        for (TVertice v : vertices) {
            if (!v.getVisitado()) {
                v.bpf(visitados);
            }
        }
        return visitados;
    }
    
     @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        TVertice aux = vertices.get(etiquetaOrigen);
        return this.bpf(aux);
    }
    
    
    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }
    
    
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        desvisitarVertices();
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if (v != null) {
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }
    
     public boolean tieneCiclo(Comparable etiquetaOrigen) {
        TVertice vertV = vertices.get(etiquetaOrigen);
        if (vertV != null) {
            desvisitarVertices();
            TCamino camino = new TCamino(vertV);
            return vertV.tieneCiclo(camino);
        }
        return false;
    }

    public boolean tieneCiclo() {
        boolean result = false;
        if (vertices.isEmpty()) {
            System.out.println(" el grafo está vacio");
            return result;
        }
        desvisitarVertices();

        for (TVertice vertV : this.vertices.values()) {
            if (result) {
                break;
            }
            if (!vertV.getVisitado()) {
                TCamino camino = new TCamino(vertV);
                result = vertV.tieneCiclo(camino);
                if (result) {
                    camino.imprimirEtiquetasConsola();
                }
            }
        }
        if (!result) {
            System.out.println("no hay ciclos");
        }
        return result;
    }
    

}
