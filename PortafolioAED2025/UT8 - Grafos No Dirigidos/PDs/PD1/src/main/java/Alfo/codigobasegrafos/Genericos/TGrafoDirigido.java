
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import jumpert.codigobasegrafos.Interfaces.IGrafoDirigido;

public class TGrafoDirigido implements IGrafoDirigido {

    protected final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-

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
     * etiquetas sean inv�lidas, retorna falso.
     *
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
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
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            Collection<TVertice> vertices = getVertices().values();
            for (TVertice vertice : vertices) {
                vertice.eliminarAdyacencia(nombreVertice);
            }
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }
    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
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
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    protected TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    @Override
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
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        desvisitarVertices();
        Collection<TVertice> visitados = new LinkedList<>();
        if (vertice != null){
            vertice.bpf(visitados);
        }
        return visitados;
    }

    /**
     *
     * @return
     */
    @Override
    /**
     * BPF del grafo, a partir del primer vértice, para todos los vertices
     */

    public Collection<TVertice> bpf() {
        desvisitarVertices(); //agregué este bpf porque no usamos el bpf con vertice al final
        Collection<TVertice> visitados = new LinkedList<>();
        Collection<TVertice> vertices = this.vertices.values();
        for (TVertice v : vertices) {
            if (! v.getVisitado()){
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
    /**
     *
     */
    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }


    @Override
    public Comparable centroDelGrafo() {
        Object[] etiquetasarray = this.getEtiquetasOrdenado();
        Comparable[] excentricidad = new Comparable[]{Double.MAX_VALUE, null};
        for (int i = 0; i < etiquetasarray.length; i++) {
            Comparable excentricidadVertice = this.obtenerExcentricidad((Comparable) etiquetasarray[i]);
            if ((excentricidadVertice.compareTo(-1d) > 0) && excentricidadVertice.compareTo(excentricidad[0]) < 0) {
                excentricidad[0] = excentricidadVertice;
                excentricidad[1] = i;
            }
        }
        return (Comparable)etiquetasarray[(int)excentricidad[1]];
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizADevolver = UtilGrafos.obtenerMatrizCostos(this.vertices);

		for (int k = 0; k < matrizADevolver.length; k++) {
			for (int i = 0; i < matrizADevolver.length; i++) {
				for (int j = 0; j < matrizADevolver.length; j++) {
					if ((i != j) && matrizADevolver[i][k] != Double.MAX_VALUE && matrizADevolver[k][j] != Double.MAX_VALUE) {
						if (((matrizADevolver[i][k] + matrizADevolver[k][j]) < matrizADevolver[i][j])) {
							matrizADevolver[i][j] = matrizADevolver[i][k] + matrizADevolver[k][j];
						}
					}
				}
			}
		}
		return matrizADevolver;
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
        Double[][] matrizADevolver = UtilGrafos.obtenerMatrizCostos(this.vertices);
        boolean[][] matrizADevolverWarshall = new boolean[matrizADevolver.length][matrizADevolver.length];

		for (int k = 0; k < matrizADevolverWarshall.length; k++) {
			for (int i = 0; i < matrizADevolverWarshall.length; i++) {
				for (int j = 0; j < matrizADevolverWarshall.length; j++) {
                    //Inicializo las conexiones directas con true (deberia funcar igual que hacerlo antes arriba)
                    if ((i != j) && (matrizADevolver[i][j] != Double.MAX_VALUE)) {
                        matrizADevolverWarshall[i][j] = true;
                    }

					if ((i != j) && (matrizADevolverWarshall[i][j] == false)) {
						matrizADevolverWarshall[i][j] = matrizADevolverWarshall[i][k] && matrizADevolverWarshall[k][j];
					}
				}
			}
		}
		return matrizADevolverWarshall;
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        desvisitarVertices();
        TCaminos todosLosCaminos = new TCaminos();
        TVertice v = buscarVertice(etiquetaOrigen);
        if(v != null){
            TCamino caminoPrevio = new TCamino(v);
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
            return todosLosCaminos;
        }
        return null;
    }

    @Override
    public boolean tieneCiclo() {
        Boolean result = false;
        this.desvisitarVertices();
        Collection<TVertice> vertices = this.vertices.values();
        for (TVertice v : vertices) {
            LinkedList<Comparable> unCamino = new LinkedList<Comparable>();
            if (!v.getVisitado()) {
                result = v.tieneCiclo(unCamino);
            }
            if (result) {
                return result;
            }
        }
        return result;
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void caminoCritico(Comparable etiquetaOrigen, Comparable etiquetaDestino){
        if (!tieneCiclo()) {
            TCaminos todosLosCaminos = this.todosLosCaminos(etiquetaOrigen, etiquetaDestino);
            Collection<TCamino> caminos = todosLosCaminos.getCaminos();
            TCamino caminoCritico = todosLosCaminos.getCaminoMayorCosto(); 

            System.out.println("Camino Critico:");
            System.out.println(caminoCritico.imprimirEtiquetas());
            caminos.remove(caminoCritico);
            
            System.out.println("\nOtros Caminos:");
            for (TCamino elemen : caminos) {
                System.out.print(elemen.imprimirEtiquetas());
                System.out.println(" - Holgura: "+ (caminoCritico.getCostoTotal() - elemen.getCostoTotal()));
            }
        } else {
            System.out.println("Tiene ciclos");
        }
    }

    @Override
    public LinkedList<TVertice> unOrdenTopologico(TVertice w) {
        this.desvisitarVertices();
        if (this.existeVertice(w.getEtiqueta()) && !this.tieneCiclo()) {
            TGrafoDirigido nuevoGrafo = this.getGrafoInvertido();
            LinkedList<TVertice> ordenTopologico = new LinkedList<TVertice>();
            nuevoGrafo.getVertices().get(w.getEtiqueta()).ordenTopologico(ordenTopologico);
            return ordenTopologico;
        } else {
            System.out.println("Tiene ciclos, orden topológico no disponible");
            return null;
        }
    }

    private TGrafoDirigido getGrafoInvertido() {
        LinkedList<TArista> aristas = new LinkedList<TArista>();
        LinkedList<TVertice> vertices = new LinkedList<TVertice>();
        Collection<TVertice> verticesGrafo = this.getVertices().values();
        for (TVertice vertice : verticesGrafo) {      
            LinkedList<TAdyacencia> adyacentes = vertice.getAdyacentes();
            vertices.add(new TVertice<>(vertice.getEtiqueta()));
            for (TAdyacencia adyacencia : adyacentes) {
                aristas.add(new TArista(adyacencia.getDestino().getEtiqueta(), vertice.getEtiqueta(), adyacencia.getCosto()));
            }

        }    
        return new TGrafoDirigido(vertices, aristas);
    }

    @Override
    public Collection<TVertice> bea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
