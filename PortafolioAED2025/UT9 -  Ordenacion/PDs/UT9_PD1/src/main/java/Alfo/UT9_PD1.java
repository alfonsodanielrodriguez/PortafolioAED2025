/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Alfo;

public class UT9_PD1 {

    public static void main(String[] args) {
        TClasificador cla = new TClasificador();
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        
        // Ejercicio 2
        System.out.println("Ejercicio 2");
        System.out.println("-".repeat(11));
        
        int[] a = gen.generarDatosAleatorios(300);
        int[] b = gen.generarDatosDescendentes(300);
        int[] c = gen.generarDatosAscendentes(300);
        
        System.out.println("Esta ordenado: " + cla.estaOrdenado(a));
        int[] ins = cla.clasificar(a, 1);
        System.out.println("Esta ordenado: " + cla.estaOrdenado(ins));
        
        System.out.println("Parte 8");
        
        System.out.println("\nSHELLSORT");
        int[] shell1 = cla.clasificar(a, 2);
        int[] shell2 = cla.clasificar(b, 2);
        int[] shell3 = cla.clasificar(c, 2);
        System.out.println("shell Aleatorio --> Esta ordenado: " + cla.estaOrdenado(shell1));
        System.out.println("shell Descendiente --> Esta ordenado: " + cla.estaOrdenado(shell2));
        System.out.println("shell Ascendente --> Esta ordenado: " + cla.estaOrdenado(shell3));
        System.out.println("\nBURBUJA");
        int[] burb1 = cla.clasificar(a, 3);
        int[] burb2 = cla.clasificar(b, 3);
        int[] burb3 = cla.clasificar(c, 3);
        System.out.println("Burbuja Aleatorio --> Esta ordenado: " + cla.estaOrdenado(burb1));
        System.out.println("Burbuja Descendiente --> Esta ordenado: " + cla.estaOrdenado(burb2));
        System.out.println("Burbuja Ascendente --> Esta ordenado: " + cla.estaOrdenado(burb3));
        
        
        
    }
}
