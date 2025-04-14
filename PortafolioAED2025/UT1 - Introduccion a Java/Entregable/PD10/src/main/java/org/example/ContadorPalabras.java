package org.example;

import java.util.ArrayList;
import java.util.List;

public class ContadorPalabras {
    public static List<String> arResultado = new ArrayList<String>();
    public static void contarPalabras(String[] array1, String[] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i].equals(array2[j])) {
                    arResultado.add(array1[i]);
                }
            }
        }
        System.out.println("Las palabras repetidas son: " + arResultado);
    }
}
