package org.example;

public class Factorial {
    public int N;

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("No exiten numeros factoriales negativos");
        }
        int aux = 1;
        for (int i = 1; i <= n; i++) {
            aux *= i;
        }
        return aux;
    }
}
