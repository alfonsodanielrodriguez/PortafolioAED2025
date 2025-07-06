
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

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
        if (!this.esConexo()) {
            return null;
        }
        LinkedList<TVertice> verticesU = new LinkedList();
        LinkedList<TVertice> verticesV = new LinkedList();
        verticesV.addAll(this.getVertices().values());
        LinkedList<TArista> aristasT = new LinkedList<>();
        double costo = 0;

        verticesU.add(verticesV.pollFirst());
        while (!verticesV.isEmpty()) {
            TArista tempA = lasAristas.buscarMin(verticesU, verticesV);
            if (tempA != null) {
                TVertice vDest = this.getVertices().get(tempA.getEtiquetaDestino());
                aristasT.add(tempA);
                verticesV.remove(vDest);
                verticesU.add(vDest);
                costo += tempA.getCosto();
            }
        }
        //System.out.println("Costo total de Prim: " + costo);
        return new TGrafoNoDirigido(verticesU, aristasT);
    }

    public TAristas PrimAristas() {
        if (!this.esConexo()) {
            return null;
        }
        LinkedList<TVertice> verticesU = new LinkedList();
        LinkedList<TVertice> verticesV = new LinkedList();
        verticesV.addAll(this.getVertices().values());
        TAristas aristasT = new TAristas();
        double costo = 0;

        verticesU.add(verticesV.pollFirst());
        while (!verticesV.isEmpty()) {
            TArista tempA = lasAristas.buscarMin(verticesU, verticesV);
            if (tempA != null) {
                TVertice vDest = this.getVertices().get(tempA.getEtiquetaDestino());
                aristasT.add(tempA);
                verticesV.remove(vDest);
                verticesU.add(vDest);
                costo += tempA.getCosto();
            }
        }
        //System.out.println("Costo total de Prim: " + costo);
        return aristasT;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        if (esConexo()) {
            TAristas F = new TAristas();
            double costoTotal = 0;
            int numVertices = this.getVertices().size();
            Map<Comparable, Integer> componentes = new HashMap<>();
            int i = 0;
            for (Comparable vertice : this.getVertices().keySet()) {
                componentes.put(vertice, i);
                i++;
            }
            int contador = numVertices - 1;

            TAristas aristasOrdenadas = this.lasAristas;
            aristasOrdenadas.sort((a1, a2) -> Double.compare(a1.costo, a2.costo));

            Iterator<TArista> iter = aristasOrdenadas.iterator();
            while (contador > 0 && iter.hasNext()) {
                TArista arista = iter.next();
                Integer comp1 = componentes.get(arista.etiquetaOrigen);
                Integer comp2 = componentes.get(arista.etiquetaDestino);
                if (comp1 != null && comp2 != null) {
                    if (!comp1.equals(comp2)) {
                        F.add(arista);
                        costoTotal += arista.getCosto();
                        for (Comparable vertice : this.getVertices().keySet()) {
                            if (componentes.get(vertice).equals(comp1)) {
                                componentes.put(vertice, comp2);
                            }
                        }
                        contador--;
                    }
                }
            }
            if (contador > 0) {
                return null;
            }
            TGrafoNoDirigido kruskal = new TGrafoNoDirigido(this.getVertices().values(), F);
            //System.out.println("Costo de Kruskal: " + costoTotal);
            return kruskal;

        }
        return null;
    }

    public TAristas KruskalAristas() {
        if (esConexo()) {
            TAristas F = new TAristas();
            double costoTotal = 0;
            int numVertices = this.getVertices().size();
            Map<Comparable, Integer> componentes = new HashMap<>();
            int i = 0;
            for (Comparable vertice : this.getVertices().keySet()) {
                componentes.put(vertice, i);
                i++;
            }
            int contador = numVertices - 1;

            TAristas aristasOrdenadas = this.lasAristas;
            aristasOrdenadas.sort((a1, a2) -> Double.compare(a1.costo, a2.costo));

            Iterator<TArista> iter = aristasOrdenadas.iterator();
            while (contador > 0 && iter.hasNext()) {
                TArista arista = iter.next();
                Integer comp1 = componentes.get(arista.etiquetaOrigen);
                Integer comp2 = componentes.get(arista.etiquetaDestino);
                if (comp1 != null && comp2 != null) {
                    if (!comp1.equals(comp2)) {
                        F.add(arista);
                        costoTotal += arista.getCosto();
                        for (Comparable vertice : this.getVertices().keySet()) {
                            if (componentes.get(vertice).equals(comp1)) {
                                componentes.put(vertice, comp2);
                            }
                        }
                        contador--;
                    }
                }
            }
            if (contador > 0) {
                return null;
            }
            return F;

        }
        return null;
    }

    public boolean esConexo() {
        Collection<TVertice> vertices = this.getVertices().values();
        if (!vertices.isEmpty()) {
            TVertice origen = vertices.iterator().next();
            LinkedList<TVertice> visitados = new LinkedList();
            origen.bea(visitados);
            for (TVertice vertice : vertices) {
                if (!vertice.getVisitado()) {
                    this.desvisitarVertices();
                    return false;
                }
            }
            this.desvisitarVertices();
            return true;
        }
        return false;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        LinkedList<TVertice> visitados = new LinkedList();
        for (TVertice vertice : this.getVertices().values()) {
            if (!vertice.getVisitado()) {
                vertice.bea(visitados);
            }
        }
        this.desvisitarVertices();
        return visitados;
    }
}
