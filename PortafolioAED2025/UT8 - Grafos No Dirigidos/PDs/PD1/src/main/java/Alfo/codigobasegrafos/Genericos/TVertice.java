

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import jumpert.codigobasegrafos.Interfaces.IVertice;
import jumpert.codigobasegrafos.Interfaces.IVerticeKevinBacon;

public class TVertice<T> implements IVertice, IVerticeKevinBacon {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;
    private int numBacon = -1;
    private int numBp;
    private int numBajo;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    
    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }
 
    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }
    
      @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia(adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest,caminoPrevio,todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        TVertice x;
        Queue<TVertice> cola = new LinkedList<TVertice>();
        cola.add(this); //faltaba esto
        while (!cola.isEmpty()) {
            x = cola.remove();
            LinkedList<TAdyacencia> adyacencias = x.getAdyacentes();
            for (TAdyacencia tAdyacencia : adyacencias) {
                TVertice y = tAdyacencia.getDestino();
                if (!y.visitado){
                    y.setVisitado(true);
                    cola.add(y);
                    visitados.add(y);
                }
            }
        }     
    }

    @Override
    public boolean tieneCiclo(LinkedList<Comparable> verticesVisitados) {
        boolean result = false;
        this.setVisitado(true);
        verticesVisitados.add(this.getEtiqueta());
        for (TAdyacencia ady : this.adyacentes) {
            if (!ady.getDestino().getVisitado()) {
                result = ady.getDestino().tieneCiclo(verticesVisitados);
            } else {
                result = verticesVisitados.contains(ady.getEtiqueta());            
            }
            if (result) {
                break;
            }
            verticesVisitados.remove(this.getEtiqueta());
        }
        return result;
    }

    public void ordenTopologico(LinkedList<TVertice> ordenTopologico) {
        this.setVisitado(true);
        for (TAdyacencia adyacente : this.getAdyacentes()) {
            if (!adyacente.getDestino().visitado) {
                adyacente.getDestino().ordenTopologico(ordenTopologico);
            }
        }
        ordenTopologico.add(this);
    } 

    @Override
    // Este metodo tiene como precondicion que todos los vertices del grafo se encuentren con getVisitado en false.
    public boolean conectadoCon(TVertice destino) {
        setVisitado(true);
        boolean encontrado = false;
        if (this.getEtiqueta().equals(destino.getEtiqueta())) {
            return true;
        }
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                encontrado = vertAdy.conectadoCon(destino);
            }
        }
        return encontrado;
    }

	@Override
	public int getBacon() {
		return this.numBacon;
	}

	@Override
	public void setBacon(int newBacon) {
		this.numBacon = newBacon;
	}

    public int numBacon(Comparable actor){
        this.setBacon(0);
        this.setVisitado(true);
        TVertice x;
        Queue<TVertice> cola = new LinkedList<TVertice>();
        cola.add(this);
        while (!cola.isEmpty()) {
            x = cola.remove();
            LinkedList<TAdyacencia> adyacencias = x.getAdyacentes();
            for (TAdyacencia tAdyacencia : adyacencias) {
                TVertice y = tAdyacencia.getDestino();
                if (!y.getVisitado()){
                    y.setBacon(x.getBacon() + 1);
                    y.setVisitado(true);
                    if (y.getEtiqueta().compareTo(actor) == 0){
                        return y.getBacon();
                    }
                    cola.add(y);
                
                }
            }
        } 
        return Integer.MAX_VALUE;
    }

    public void puntosArt(Collection<TVertice> puntos, int[] cont) {
        setVisitado(true);
        cont[0]++;
        this.numBp = cont[0];
        this.numBajo = cont[0];
        LinkedList<TVertice> hijos = new LinkedList<>();
        for (TAdyacencia ady : this.getAdyacentes()) {
            TVertice adyacente = ady.getDestino();
            if (!adyacente.getVisitado()){
                adyacente.puntosArt(puntos, cont);
                hijos.add(adyacente);
                this.numBajo = Math.min(this.numBajo, adyacente.numBajo);
            }else {
                this.numBajo = Math.min(this.numBajo,adyacente.numBp);
            }
        }

        if (this.numBp > 1){
            for (TVertice hijo : hijos) {
                if (hijo.numBajo >= this.numBp) // Si para más de un hijo se cumple esto, se va a agregar más de 1 vez a "puntos"
                    puntos.add(this);           //Esto se podría mejorar con otra Collection, un Set por ej.
            }
        }else {
            if (hijos.size() > 1){
                puntos.add(this);
            }
        }
    }

}
