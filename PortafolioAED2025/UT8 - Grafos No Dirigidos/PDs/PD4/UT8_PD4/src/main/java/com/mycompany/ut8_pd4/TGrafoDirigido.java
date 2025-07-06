package com.mycompany.ut8_pd4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-

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
    private TVertice buscarVertice(Comparable unaEtiqueta) {
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
                //getLasAristas().add(arista);
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

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
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
        LinkedList visitados = new LinkedList();
        vertice.bpf(visitados);
        visitados.addAll(this.bpf());
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf() {
        LinkedList visitados = new LinkedList();
        for (TVertice vertice : this.vertices.values()) {
            if (!vertice.getVisitado()) {
                vertice.bpf(visitados);
            }
        }
        this.desvisitarVertices();
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        LinkedList visitados = new LinkedList();
        TVertice vOrigen = this.buscarVertice(etiquetaOrigen);
        if (vOrigen != null) {
            vOrigen.bpf(visitados);
        }
        visitados.addAll(this.bpf());
        return visitados;
    }

    @Override
    public Comparable centroDelGrafo() {
        Map<Comparable, Double> excentricidades = this.obtenerExcentricidades();

        double min = Double.MAX_VALUE;
        Comparable result = null;

        for (Map.Entry<Comparable, Double> entry : excentricidades.entrySet()) {
            Comparable etiqueta = entry.getKey();
            double excentricidad = entry.getValue();

            if (min > excentricidad && excentricidad >= 0) {
                min = excentricidad;
                result = etiqueta;
            }
        }
        return result;
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizFloyd = UtilGrafos.obtenerMatrizCostos(this.vertices);
        Double[][] matrizPredecesores = new Double[matrizFloyd.length][matrizFloyd.length];
        int n = this.vertices.size();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (matrizFloyd[i][k] == Double.MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (matrizFloyd[i][k] + matrizFloyd[k][j] < matrizFloyd[i][j]) {
                        matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                        matrizPredecesores[i][j] = (double) k;
                    }
                }
            }
        }
        return matrizFloyd;
    }

    private Map<Comparable, Double> obtenerExcentricidades() {
        Double[][] matrizFloyd = this.floyd();
        int tam = this.vertices.size();

        Comparable[] etiquetas = new Comparable[tam];
        int i = 0;
        for (Comparable eti : this.vertices.keySet()) {
            etiquetas[i++] = eti;
        }

        Map<Comparable, Double> result = new HashMap<>(tam * 4 / 3);

        for (int j = 0; j < tam; j++) {
            double max = 0;
            for (int k = 0; k < tam; k++) {
                if (max < matrizFloyd[k][j]) {
                    max = matrizFloyd[k][j];
                }
            }
            if (max == Double.MAX_VALUE) {
                max = -1;
            }
            result.put(etiquetas[j], max);
        }
        return result;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        return this.obtenerExcentricidades().get(etiquetaVertice);
    }

    @Override
    public boolean[][] warshall() {
        Double[][] C = UtilGrafos.obtenerMatrizCostos(this.getVertices());
        boolean[][] A = new boolean[C.length][C.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (C[i][j] != Double.MAX_VALUE) {
                    A[i][j] = true;
                }
            }
        }

        for (int k = 0; k < A.length; k++) {
            for (int i = 0; i < A.length; i++) {
                if (!A[i][k]) {
                    continue;
                }
                for (int j = 0; j < A.length; j++) {
                    A[i][j] |= A[i][k] && A[k][j];
                }
            }
        }

        return A;
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        this.desvisitarVertices();
        TVertice origen = this.buscarVertice(etiquetaOrigen);
        if (origen == null || this.buscarVertice(etiquetaDestino) == null) {
            return null;
        }

        TCaminos caminos = origen.todosLosCaminos(etiquetaDestino, new TCamino(origen), new TCaminos());

        return caminos;
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        TVertice origen = buscarVertice(etiquetaOrigen);
        if(origen.tieneCiclo()){
            this.desvisitarVertices();
            return true;
        }
        this.desvisitarVertices();

        return false;
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        Collection<Comparable> res = new LinkedList();
        res.add(camino.getOrigen().getEtiqueta());
        Collection<Comparable> otrosVertices = camino.getOtrosVertices();
        for (Comparable actual : otrosVertices) {
            if (res.contains(actual)) {
                return true;
            }
            res.add(actual);
        }
        return false;
    }

    @Override
    public boolean tieneCiclo() {
        for (TVertice vertice : this.getVertices().values()) {
            if (vertice.tieneCiclo()) {
                return true;
            }
            this.desvisitarVertices();
        }

        return false;
    }

    @Override
    public Collection<TVertice> bea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double obtenerCostoAdyacencia(Comparable verticeO, Comparable verticeD) {
        Double[][] matrizFloyd = this.floyd();

        int indiceVerticeO = -1;
        int indiceVerticeD = -1;
        int i = 0;

        for (Comparable eti : this.vertices.keySet()) {
            if (eti.equals(verticeO)) {
                indiceVerticeO = i;
            }
            if (eti.equals(verticeD)) {
                indiceVerticeD = i;
            }
            i++;
        }

        double costoViaje = -1;
        if (indiceVerticeO != -1 && indiceVerticeD != -1) {
            costoViaje = matrizFloyd[indiceVerticeO][indiceVerticeD];
        }
        return costoViaje;
    }

    public boolean obtenerConectividadAeropuertos(Comparable ciudadO, Comparable ciudadD) {
        boolean[][] matrizWarshall = this.warshall();

        int indiceVerticeO = -1;
        int indiceVerticeD = -1;
        int i = 0;

        for (Comparable eti : this.vertices.keySet()) {
            if (eti.equals(ciudadO)) {
                indiceVerticeO = i;
            }
            if (eti.equals(ciudadD)) {
                indiceVerticeD = i;
            }
            i++;
        }
        if (indiceVerticeD < 0 || indiceVerticeO < 0) {
            return false;
        }
        return matrizWarshall[indiceVerticeO][indiceVerticeD];
    }

    public List<Comparable> clasificacionTopologica(Comparable destino) {
        TVertice vertice = this.buscarVertice(destino);
        if (vertice == null) {
            return null;
        }

        List<Comparable> res = new LinkedList<>();
        vertice.clasificacionTopologica(res);
        return res;
    }

    public TAristas getAristas() {
        TAristas res = new TAristas();

        for (Map.Entry<Comparable, TVertice> entrada : this.getVertices().entrySet()) {
            Comparable origenEti = entrada.getKey();
            TVertice origen = entrada.getValue();

            for (Object ob : origen.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) ob;
                res.add(new TArista(origenEti, ady.getEtiqueta(), ady.getCosto()));
            }
        }

        return res;
    }
}
