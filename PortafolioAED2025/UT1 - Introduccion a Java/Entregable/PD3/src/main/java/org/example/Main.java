package org.example;


public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato("Carmela");
        Perro unPerro = new Perro("Dunkel");
        System.out.println("El gato responde a Pocho? : " + gato.respondeA("Pocho"));
        System.out.println("Responde a Juan " + unPerro.respondeA("Juan"));
        System.out.println("Responde a Dunkel " + unPerro.respondeA("Dunkel"));

        //MaquinaA
        unPerro.caminar();
        unPerro.saltar();

        //MaquinaB
        gato.maullar();
        gato.correr();
        
    }
}