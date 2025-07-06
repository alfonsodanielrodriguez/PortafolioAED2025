
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import jumpert.codigobasegrafos.Interfaces.IGrafoKevinBacon;
import jumpert.codigobasegrafos.Interfaces.IGrafoNoDirigido;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {

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
        TArista aristaMin;
        Collection<Comparable> VerticesU = new LinkedList<>();
        Comparable u, v;
        TAristas T = new TAristas();
        LinkedList<Comparable> VerticesV = copiarEtisVertices();
        u = VerticesV.getFirst();
        VerticesU.add(u);
        VerticesV.remove(u);
        while ( !VerticesV.isEmpty()) {
            aristaMin = this.lasAristas.buscarMin(VerticesU, VerticesV);
            v = aristaMin.getEtiquetaDestino();
            VerticesU.add(v);
            VerticesV.remove(v);
            T.add(aristaMin);
        }
        LinkedList<TVertice> vertices = new LinkedList<>();
        for (Comparable eti : VerticesU) {
            vertices.add(new TVertice<>(eti));
        }
        return new TGrafoNoDirigido(vertices, T);    
    }

    private  LinkedList<Comparable> copiarEtisVertices() {
        Collection<TVertice> col = super.getVertices().values();
        LinkedList<Comparable> copiaV = new LinkedList<>();
        for (TVertice tVertice : col) {
            copiaV.add(tVertice.getEtiqueta());
        }
        return copiaV;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        TGrafoNoDirigido arbolCostoMinimo = new TGrafoNoDirigido(vertices.values(),new TAristas());
        TAristas aristasOrdenadas = lasAristas.copiarTAristasOrdenado();
        int aristasAgregadas = 0;
    
        while (aristasAgregadas != getVertices().size() - 1){
            TArista aristaMin = aristasOrdenadas.removeFirst();
            TVertice verticeOrigen = arbolCostoMinimo.buscarVertice(aristaMin.getEtiquetaOrigen());
            TVertice verticeDestino = arbolCostoMinimo.buscarVertice(aristaMin.getEtiquetaDestino());
            if (!arbolCostoMinimo.conectados(verticeOrigen, verticeDestino)){
                arbolCostoMinimo.insertarArista(aristaMin);
                arbolCostoMinimo.getLasAristas().add(aristaMin);
                arbolCostoMinimo.getLasAristas().add(aristaMin.aristaInversa());
                aristasAgregadas++;
            }
        }
        return arbolCostoMinimo;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        desvisitarVertices();
        LinkedList<TVertice> col = new LinkedList<>();
        getVertices().get(etiquetaOrigen).bea(col);
        return col;
    }
	
	@Override
    //Precondicion: El grafo tiene que ser conexo.
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        if (esConexo()){
            desvisitarVertices();
            int[] cont = {0};
            LinkedList<TVertice> puntos = new LinkedList<>();
            TVertice vert = this.buscarVertice(etOrigen);
            if (vert != null){
                vert.puntosArt(puntos, cont);
            }
            return puntos;
        }
        return null;
    }
    
	@Override
	public boolean esConexo(){
        Collection<TVertice> vertices = this.getVertices().values();
        Collection<TVertice> visitados = this.bpf(vertices.iterator().next());
        return vertices.size() == visitados.size();
    }

    @Override
    public int numBacon(Comparable actor) {
        desvisitarVertices();
        int numBacon;
        TVertice kBacon = getVertices().get("Kevin_Bacon");
        TVertice vActor = getVertices().get(actor);
        if (vActor != null) {
            //Si ya tiene un numero de bacon (ya se corrio el algoritmo una vez).
            if (vActor.getBacon() > -1) {
                numBacon =  vActor.getBacon();
            }
            else {
                numBacon = kBacon.numBacon(actor);
                if (numBacon == Integer.MAX_VALUE)
                    vActor.setBacon(numBacon);
            }
        }
        else {
            numBacon = -1;
        }
        return numBacon;
    }

    @Override
    public boolean conectados(TVertice u, TVertice v) {
        this.desvisitarVertices();
        if (this.existeVertice(u.getEtiqueta()) && this.existeVertice(v.getEtiqueta())) {
            return this.buscarVertice(u.getEtiqueta()).conectadoCon(v);
        }
        return false;
    }


    public double getCostoTotal(){
        double costo = 0;
        for (TArista tArista : lasAristas) {
            costo += tArista.getCosto();
        }
        return costo/2;
    }

}
