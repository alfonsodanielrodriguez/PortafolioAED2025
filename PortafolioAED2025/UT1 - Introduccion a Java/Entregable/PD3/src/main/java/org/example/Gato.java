package org.example;

public class Gato {
    private String nombre;

    public Gato(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void maullar() {
        System.out.println("miau");
    }
    public boolean respondeA(String unNombre){
        return false;
    }
    public void correr() {
        System.out.println("Se va corriendo");
    }
}
