
import java.util.Collection;
import java.util.LinkedList;
import Alfo.codigobasegrafos.Genericos.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ernesto
 */
public interface IVertice {

    TAdyacencia buscarAdyacencia(TVertice verticeDestino);

    TAdyacencia buscarAdyacencia(Comparable etiquetaDestino);

    boolean eliminarAdyacencia(Comparable nomVerticeDestino);

    LinkedList<TAdyacencia> getAdyacentes();

    boolean insertarAdyacencia(Double costo, TVertice verticeDestino);

    Double obtenerCostoAdyacencia(TVertice verticeDestino);

    TVertice primerAdyacente();

    TVertice siguienteAdyacente(TVertice w);

    public void bpf(Collection<TVertice> visitados);

    public boolean conectadoCon(TVertice destino);

    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos);

    public boolean tieneCiclo(LinkedList<Comparable> camino);

    public void bea(Collection<TVertice> visitados);

    public void puntosArt(Collection<TVertice> puntos, int[] cont);

}
