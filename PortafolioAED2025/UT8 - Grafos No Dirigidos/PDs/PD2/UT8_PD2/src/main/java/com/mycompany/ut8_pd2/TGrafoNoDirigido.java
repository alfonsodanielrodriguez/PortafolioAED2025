package com.mycompany.ut8_pd2;

import java.util.Collection;
import java.util.Collections;
import java.util.*;
import java.util.LinkedList;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        if (!esConexo()) {
            return null;
        }
        LinkedList<TArista> tResultado = new LinkedList<>();
        LinkedList<TVertice> uVertices = new LinkedList<>();
        LinkedList<TVertice> vertices = new LinkedList<>();
        vertices.addAll(getVertices().values());
        uVertices.add(vertices.pollFirst());
        double costoPrim = 0;
        while (!vertices.isEmpty()) {
            TArista tempArista = lasAristas.buscarMin(uVertices, vertices);
            if (tempArista != null) {
                tResultado.add(tempArista);
                TVertice vert = getVertices().get(tempArista.etiquetaDestino);
                vertices.remove(vert);
                uVertices.add(vert);
                costoPrim += tempArista.costo;
            }
            
        }
        return new TGrafoNoDirigido(uVertices, tResultado);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        if (!esConexo()) {
            return null;
        }
        int numVertices = this.getVertices().size();
        Map<Comparable, Comparable> componentes = new HashMap<>();
        for (Comparable vertice : this.getVertices().keySet()) {
            componentes.put(vertice, vertice);
        }
        
        TAristas aristas = lasAristas;
        aristas.sort((a1, a2) -> Double.compare(a1.costo, a2.costo));
        
        TAristas res = new TAristas();
        
        int contador = numVertices - 1;
        
        Iterator<TArista> iter = aristas.iterator();
        while (contador > 0 && iter.hasNext()) {
            TArista arista = iter.next();
            Comparable comp1 = raizDe(arista.etiquetaOrigen, componentes);
            Comparable comp2 = raizDe(arista.etiquetaDestino, componentes);
            if (!comp1.equals(comp2)) {
                res.add(arista);
                componentes.put(comp1, comp2);
                contador--;
            }
        }
        
        if (contador > 0) {
            return null;
        }
        
        return new TGrafoNoDirigido(this.getVertices().values(), res);
    }
    
    private static Comparable raizDe(Comparable inicio, Map<Comparable, Comparable> componentes) {
        if (inicio == null) {
            return null;
        }
        Comparable aux = componentes.get(inicio);
        while (aux != null && !inicio.equals(aux)) {
            inicio = aux;
            aux = componentes.get(inicio);
        }
        
        return inicio;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        Collection<TVertice> visitados = new LinkedList<>();
        TVertice vertice = getVertices().get(etiquetaOrigen);
        if (vertice != null) {
            vertice.bea(visitados);
        }
        visitados.addAll(bea());
        return visitados;
    }
    
    public Collection<TVertice> bea() {
        Collection<TVertice> visitados = new LinkedList<>();
        getVertices().forEach((etiqueta, vertice) -> {
            if (!vertice.getVisitado()) {
                vertice.bea(visitados);
            }
        });
        desvisitarVertices();
        return visitados;
    }

    @Override
    public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        if (this.getVertices().isEmpty()) {
            return null;
        }
        TVertice origen = this.getVertices().values().iterator().next();
        LinkedList<TVertice> res = new LinkedList<>();
        origen.puntosArticulacion(new int[1], res, new HashMap<>(), null);
        desvisitarVertices();
        return res;
    }

    @Override
    public boolean esConexo() {
        Collection<TVertice> vertices = getVertices().values();
        if (!vertices.isEmpty()) {
            TVertice unVertice = vertices.iterator().next();
            LinkedList<TVertice> visitados = new LinkedList<>();
            unVertice.bpf(visitados);
            for (TVertice vertice : vertices) {
                if (!vertice.getVisitado()) {
                    desvisitarVertices();
                    return false;
                }
            }
            desvisitarVertices();
            return true;
        }
        desvisitarVertices();
        return false;
    }
}
