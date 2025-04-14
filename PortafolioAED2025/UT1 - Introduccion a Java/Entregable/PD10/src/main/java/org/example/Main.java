package org.example;


public class Main {
    public static void main (String args[]) {
        System.out.println("UT1 - PD10");
        String[] Ar1 = {"Hola", "mundo", "de", "los", "algoritmos"};
        String[] Ar2 = {"Hola", "mundo", "de", "la", "informática"};

        ContadorPalabras contar = new ContadorPalabras();
        contar.contarPalabras(Ar1, Ar2);
    }
}