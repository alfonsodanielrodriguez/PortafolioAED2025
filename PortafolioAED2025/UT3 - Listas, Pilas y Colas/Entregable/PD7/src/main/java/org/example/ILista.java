package org.example;

public interface ILista<T> {

    public void insertar(Nodo<T> nodo);

    public Nodo<T> buscar(Comparable clave);

    public boolean eliminar(Comparable clave);

    public String imprimir();

    public String imprimir(String separador);

    public int cantElementos();

    public boolean esVacia();

    public void setPrimero( Nodo<T> unNodo);

}