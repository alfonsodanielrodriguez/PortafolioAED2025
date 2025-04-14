package org.example;


public class Contador {
    public final int MAX_CONT = 50;
    public int incremento = 1;
    public int contador = 1;

    public void mostrarContadorWHILE(){
        while (contador <= MAX_CONT){
            System.out.println("Contador " + contador);
            contador += incremento;
        }
    }
    public void mostrarContadorDOWHILE(){
        do {
            System.out.println("Contador " + contador);
            contador += incremento;
        } while (contador <= MAX_CONT);
    }

    public void mostrarContadorFOR(){
        for (int contador = 0; contador <= MAX_CONT; contador += incremento) {
            System.out.println("Contador " + contador);
        }
    }
}
