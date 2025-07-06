/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Alfo;

import java.util.Arrays;


public class UT9_PD2 {

    public static void main(String[] args) {
        TClasificador cla = new TClasificador();
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        
        int[] a = {256,458,655,298,43,648,778,621,655,19,124,847};
        
        System.out.println("Ejercicio clase");
        int[] shell1 = cla.clasificar(a, 5);
        int[] shell2 = cla.clasificar(a, 6);
        int[] shell3 = cla.clasificar(a, 7);
        
        System.out.println("Secuencia de Marcin Ciura: 1, 4, 10, 23, 57, 132, 301");
        System.out.println(Arrays.toString(shell1) + "\n");
        
        System.out.println("Secuencia de Donald Knuth: 1, 4, 13, 40, 121");
        System.out.println(Arrays.toString(shell2) + "\n");
        
        System.out.println("Secuencia de Robert Sedgewick: 1, 3, 7, 21, 48, 112");
        System.out.println(Arrays.toString(shell3) + "\n");
        
        
        
    }
}
