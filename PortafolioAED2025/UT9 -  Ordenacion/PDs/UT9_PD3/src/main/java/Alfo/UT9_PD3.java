/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Alfo;

public class UT9_PD3 {

    public static void main(String[] args) {
        TClasificador cla = new TClasificador();
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        
        int[] a = {44,55,12,42,94,18,6,67,1};
        int[] b = gen.generarDatosAleatorios(10);
        
        System.out.println("Ejercicio clase");
        System.out.println(cla.estaOrdenado(b));
        int[] in = cla.clasificar(b, 2);
        System.out.println(cla.estaOrdenado(b));
        
        for (int i : b){
            System.out.println(i);
        }
        
        /* 
        TClasificador cla = new TClasificador();
        GeneradorDatosGenericos gen = new GeneradorDatosGenericos();
        
        int[] a = {256,458,365,298,43,648};
        
        System.out.println("Ejercicio clase");
        int[] in = cla.clasificar(a, 4);
        
        System.out.println("Heap");
        for (int i : in){
            System.out.println(i);
        }
        System.out.println("");
        
        int[] aleatorios300 = gen.generarDatosAleatorios(10000);
        //int[] aleatorios300 = gen.generarDatosAscendentes(10000);
        int[] ale300 = cla.clasificar(aleatorios300, 4);
        
        System.out.println("Heap");
        for (int i : ale300){
            System.out.println(i);
        }
        */
    }
}
