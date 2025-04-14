package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("UT 1 - PD1 ");
        System.out.println("EJERCICIO 3");
        multsuma multsuma = new multsuma(1.0, 2.0, 3.0);
        multsuma.Multsuma();

        System.out.println("EJERCICIO 4 ");
        Alumno alumno = new Alumno("juan");
        System.out.println(alumno.getNombreAdmiracion());

        alumno.recorrer("Algoritmos");
        System.out.println(alumno.recorrer("Algortimos"));

        alumno.getValor();
        System.out.println(alumno.getValor());

        alumno.getPrimerCaracter("Universidad");
        System.out.println(alumno.getPrimerCaracter("Universidad"));

        alumno.paraAString(12);
        System.out.println(alumno.paraAString(12));

        System.out.println("EJERCICIO 5");
        Contador contador = new Contador();
        contador.mostrarContadorWHILE();
        contador.mostrarContadorDOWHILE();
        contador.mostrarContadorFOR();
    }
}
