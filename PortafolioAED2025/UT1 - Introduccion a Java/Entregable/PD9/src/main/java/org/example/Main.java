package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("UT1 -- PD9 ");
        System.out.println("Ejercico 1 ");
        Factorial NumeroFactorial = new Factorial();
        System.out.println(NumeroFactorial.factorial(6));


        System.out.println("Ejercicio 2 ");
        IsPrimo isPrime = new IsPrimo();
        int valor = 7;
        System.out.println(isPrime.isprimo(valor));
        if (isPrime.isprimo(7) == true) {
            System.out.println(isPrime.sumaNumImpares(valor));
        } else {
            System.out.println(isPrime.sumaTodosNum(valor));
        }
    }
}