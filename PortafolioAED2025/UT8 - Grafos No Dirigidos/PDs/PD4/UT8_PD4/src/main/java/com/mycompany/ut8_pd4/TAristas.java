package com.mycompany.ut8_pd4;

import java.util.Collection;

import java.util.LinkedList;

public class TAristas extends LinkedList<TArista> {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    //private Collection<TArista> aristas  = new LinkedList<TArista>();

    /**
     * Busca dentro de la lista de aristas una arista que conecte a etOrigen con
     * etDestino
     *
     * @param etOrigen
     * @param etDestino
     * @return
     */
    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        for (TArista a : this) {
            if (a.getEtiquetaOrigen().equals(etOrigen) && a.getEtiquetaDestino().equals(etDestino)){
                return a;
            }
        }
        return null;
    }

    /**
     * Busca la arista de menor costo que conecte a cualquier nodo de VerticesU
     * con cualquier otro de VerticesV y cuyo costo sea el minimo
     *
     * @param VerticesU - Lista de vertices U
     * @param VerticesV - Lista de vertices V
     * @return
     */
    public TArista buscarMin(Collection<TVertice> VerticesU, Collection<TVertice> VerticesV) {
        TArista minA = null;
        double minC = Double.MAX_VALUE;
        
        for (TVertice u : VerticesU) {
            for (TVertice v : VerticesV) {
                TArista tempA = this.buscar(u.getEtiqueta(), v.getEtiqueta());
                if (tempA != null){
                    if (tempA.costo < minC){
                        minA = tempA;
                        minC = tempA.costo;
                    }
                }
            }
        }
        return minA;
    }

    public String imprimirEtiquetas() {
        if (this.isEmpty()) {
            return null;
        }
        StringBuilder salida = new StringBuilder();
        //TODO: Completar codigo que imprime todas las aristas de la lista en el siguiente formato:
        //ORIGEN - DESTINO - COSTO
        return salida.toString();
    }

    void insertarAmbosSentidos(Collection<TArista> aristas) {
        if (aristas == null) {
            return;
        }
        TArista tempArista;
        for (TArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }

}
