package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("UT 3 - PD 14 ");
        CircularQueue queue = new CircularQueue(5);

        queue.agregarElemento(10);
        queue.agregarElemento(20);
        queue.agregarElemento(30);
        queue.agregarElemento(40);
        queue.agregarElemento(50);

        queue.verLista();
        System.out.println(" ");

        System.out.println("Elemento quitado: " + queue.quitarElemento());
        System.out.println("Elemento quitado: " + queue.quitarElemento());

        queue.agregarElemento(60);
        queue.agregarElemento(70);

        queue.estaVacia();
        queue.verLista();

    }
}