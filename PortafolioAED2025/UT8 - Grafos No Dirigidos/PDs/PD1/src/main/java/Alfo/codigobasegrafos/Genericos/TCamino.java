
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import jumpert.codigobasegrafos.Interfaces.ICamino;

/**
 *
 * @author diego
 */
public class TCamino implements ICamino {

    private final TVertice origen;
    private Collection<Comparable> otrosVertices;
// es una lista de etiquetas de los vertices
// ATENCIÓN: PONER LA CLASE CONCRETA QUE									     	     
// SEA MÁS APROPIADA
    private Double costoTotal = 0.0d;

    @Override
    public void imprimirEtiquetasConsola() {
        System.out.println(imprimirEtiquetas());
    }

    @Override
    public String imprimirEtiquetas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Origen: " + getOrigen().getEtiqueta());
        for (Comparable adyacente : getOtrosVertices()) {
            sb.append(" -> " + adyacente);
        }
        return sb.toString();
    }

    public TCamino(TVertice v) {
        this.costoTotal = 0.0d;
        this.origen = v;
        this.otrosVertices = new LinkedList();
    }

    @Override
    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            costoTotal += adyacenciaActual.getCosto();
            return getOtrosVertices().add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual) {
        if (getOtrosVertices().contains(adyacenciaActual.getDestino().getEtiqueta())) {
            setCostoTotal((Double) getCostoTotal() - ((Number) adyacenciaActual.getCosto()).doubleValue());
            return getOtrosVertices().remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    @Override
    public TVertice getOrigen() {
        return origen;
    }

    @Override
    public Collection<Comparable> getOtrosVertices() {
        return otrosVertices;
    }

    @Override
    public void setOtrosVertices(Collection<Comparable> otrosVertices) {
        this.otrosVertices = otrosVertices;
    }

    @Override
    public Double getCostoTotal() {
        return costoTotal;
    }

    @Override
    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public TCamino copiar() {
        TVertice origen = new TVertice(this.getOrigen().getEtiqueta());
        TCamino copia = new TCamino(origen);
        origen.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.setCostoTotal(this.costoTotal);

        return copia;
    }

    @Override
    public String imprimirDesdeClave(Comparable clave) {
        StringBuilder sb = new StringBuilder();
        boolean start = false;
        Collection<Comparable> listaDefinitiva = new LinkedList<Comparable>();
        listaDefinitiva.add(this.getOrigen().getEtiqueta());
        listaDefinitiva.addAll(this.getOtrosVertices());

        for (Iterator<Comparable> iterator = listaDefinitiva.iterator(); iterator.hasNext();) {
            Comparable next = iterator.next();
            if (next.compareTo(clave) == 0) {
                start = true;
            }
            if (start) {
                sb.append(" " + next + " ");
            }
        }
        return sb.toString();
    }

}
