import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

public class TAristas extends LinkedList<TArista> {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    /**
     * Busca dentro de la lista de aristas una arista que conecte a etOrigen con
     * etDestino
     *
     * @param etOrigen
     * @param etDestino
     * @return
     */
    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        for (TArista arista : this) {
            if (arista.getEtiquetaOrigen().compareTo(etOrigen) == 0 && arista.getEtiquetaDestino().compareTo(etDestino) == 0) {
                return arista;
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
    
    public TArista buscarMin(Collection<Comparable> VerticesU, Collection<Comparable> VerticesV) {
    
        double menorCosto = Double.MAX_VALUE;
        TArista menorArista = getFirst();
        for (TArista arista : this) {
            if (
                arista.getCosto() < menorCosto && 
                VerticesU.contains(arista.getEtiquetaOrigen()) && 
                VerticesV.contains(arista.getEtiquetaDestino()) 
            )  {
                menorCosto = arista.getCosto();
                menorArista = arista;
            }
        }
        return menorArista;
        //---------COMPLETAR ALGORITMO-------- 
        // para todo u en Vertices U
        //      para todo v en Vertices V
        //          tA =buscar (u, v)
        // si tA <> null y tA.costo < costoMin entonces
        // tAMin = tA y costoMin = tA.costo
        // fin para todo v
        // fin para todo u
        // devolver tAMin
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
        if (aristas == null) return;
        for (TArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }

    public TAristas copiarTAristasOrdenado() {
        Comparator comp = new Comparator<TArista>() {
            public int compare(TArista ar1, TArista ar2){
                return (int) (ar1.getCosto() - ar2.getCosto());  
            } 
        };
        
        sort(comp);
        TAristas aristasNuevas = new TAristas();
        for (TArista ar : this) {
            aristasNuevas.add(ar);
        }
        return aristasNuevas;
    }

}
