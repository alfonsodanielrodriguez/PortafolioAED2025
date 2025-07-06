package com.mycompany.ut8_pd4;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

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
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> lista) {
        this.visitado = true;
        lista.add(this);

        for (TAdyacencia ady : this.adyacentes) {
            TVertice v = ady.getDestino();
            if (!v.getVisitado()) {
                v.bpf(lista);
            }
        }
    }
    
    public boolean conectado(TVertice d){
        if (etiqueta.equals(d.getEtiqueta())){
            return true;
        }
        visitado = true;
        for (TAdyacencia ady : this.adyacentes) {
            TVertice v = ady.getDestino();
            if (!v.getVisitado()) {
                v.conectado(d);
            }
        }
        return false;
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
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                    //COMPLETAR LLAMADA RECURSIVA
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        Queue<TVertice> cola = new LinkedList<>();
        this.visitado = true;
        cola.add(this);
        visitados.add(this);
        while (!cola.isEmpty()) {
            TVertice vX = cola.poll();
            for (Object adyacencia : vX.adyacentes) {
                TAdyacencia ady = (TAdyacencia) adyacencia;
                TVertice vY = ady.getDestino();
                if (!vY.getVisitado()) {
                    vY.visitado = true;
                    cola.add(vY);
                    visitados.add(vY);
                }
            }
        }
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
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        this.visitado = true;
        camino.add(this.getEtiqueta());
        for (TAdyacencia ady : this.adyacentes) {
            TVertice v = ady.getDestino();
            if (!v.getVisitado()) {
                return v.tieneCiclo();
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean tieneCiclo() {
        this.visitado = true;
        for (TAdyacencia ady : this.adyacentes) {
            TVertice v = ady.getDestino();
            if (!v.getVisitado()) {
                return v.tieneCiclo();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean conectadoCon(TVertice destino) {
        TAdyacencia ady = this.buscarAdyacencia(destino);
        if (ady != null) {
            return true;
        }
        return false;
    }

    public void clasificacionTopologica(List<Comparable> lista) {
        this.setVisitado(true);
        for (TAdyacencia w : adyacentes) {
            TVertice v = w.getDestino();
            if (!v.getVisitado()) {
                v.clasificacionTopologica(lista);
            }
        }
        lista.add(this.getEtiqueta());
    }

    public int puntosArticulacion(int[] numeracionSrc, List<Comparable> lista, Map<Comparable, Integer> numeraciones, TVertice padre) {
        visitado = true;

        numeracionSrc[0]++;
        int numeracion = numeracionSrc[0];
        numeraciones.put(getEtiqueta(), numeracion);

        // Almacena solamente el máximo de los bajos de sus hijos para compararlo con su numeración.
        int bajoDeHijoMaximo = -1;

        // Almacenar número de hijos para confirmar caso del vértice.
        int numHijos = 0;

        int bajo = numeracion;
        for (TAdyacencia adyacencia : getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();

            if (!destino.visitado) {
                numHijos++;

                // Calcular en post-orden el bajo del hijo (y revisar si es punto de articulación)
                int bajoDelHijo = destino.puntosArticulacion(numeracionSrc, lista, numeraciones, this);

                // Calcular mínimo para el bajo
                if (bajoDelHijo < bajo) {
                    bajo = bajoDelHijo;
                }

                // Calcular máximo de los bajos de los hijos
                if (bajoDelHijo > bajoDeHijoMaximo) {
                    bajoDeHijoMaximo = bajoDelHijo;
                }

            } else if (destino != padre) {

                int numDestino = numeraciones.get(destino.getEtiqueta());

                // Calcular mínimo para el hijo
                if (numDestino < bajo) {
                    bajo = numDestino;
                }

            }
        }
        if (padre != null) {
            if (bajoDeHijoMaximo >= numeracion) {
                lista.add(getEtiqueta());
            }
        } else {
            if (numHijos >= 2) {
                lista.add(getEtiqueta());
            }
        }

        return bajo;
    }
}
