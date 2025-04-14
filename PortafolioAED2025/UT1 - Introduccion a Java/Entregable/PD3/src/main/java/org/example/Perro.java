package org.example;

public class Perro {
    private String nombre;

    public Perro(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void ladrar() {
        System.out.println("wof");
    }
    public boolean respondeA(String unNombre){
        return nombre.equals(unNombre);
    }

    public void caminar() {
        System.out.println(nombre + " esta caminando");
    }
    public void saltar() {
        System.out.println(nombre + " saltando");
    }
}
