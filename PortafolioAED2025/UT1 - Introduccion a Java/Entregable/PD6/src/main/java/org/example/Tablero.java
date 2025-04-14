package org.example;

public class Tablero {
    public int alto;
    public int ancho;


//#
    public void Imprimirtablero(int alto, int ancho) {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
