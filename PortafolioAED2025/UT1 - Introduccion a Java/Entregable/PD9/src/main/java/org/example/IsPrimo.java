package org.example;

public class IsPrimo {
    public static boolean isprimo(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        boolean primo = true;
        int i = 3;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                primo = false;
                break;
            }
            i += 2;
        }
        return primo;
    }

    public static int sumaTodosNum(int n) {
        int sum = 0;
        int i = 0;
        while (i <= n) {
            if (i % 2 == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }

    public static int sumaNumImpares(int n) {
        int sum = 0;
        int i = 0;
        while (i <= n) {
            if (i % 2 != 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }
}
