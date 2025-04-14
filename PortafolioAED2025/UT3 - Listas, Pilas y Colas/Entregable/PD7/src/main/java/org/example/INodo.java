package org.example;

public interface INodo<T> {

    public T getDato();

    public Nodo<T> getSiguiente();

    public void setSiguiente(Nodo<T> nodo);

    public void imprimir();

    public void imprimirEtiqueta();

    public Comparable getEtiqueta();

    public int compareTo(Comparable etiqueta);

}