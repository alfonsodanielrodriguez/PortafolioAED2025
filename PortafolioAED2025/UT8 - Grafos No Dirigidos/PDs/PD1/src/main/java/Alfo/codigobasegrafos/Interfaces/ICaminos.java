

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface ICaminos extends ICamino {

    boolean agregarAdyacencia(TAdyacencia adyacenciaActual);

    TCamino copiar();

    boolean eliminarAdyacencia(TAdyacencia adyacenciaActual);

    Double getCostoTotal();

    TVertice getOrigen();

    Collection<Comparable> getOtrosVertices();

    String imprimirDesdeClave(Comparable clave);

    String imprimirEtiquetas();

    void imprimirEtiquetasConsola();

    void setCostoTotal(Double costoTotal);

    void setOtrosVertices(Collection<Comparable> otrosVertices);
    TCamino caminoMenorCosto();
    TCamino caminoMayorCosto();
    
}
