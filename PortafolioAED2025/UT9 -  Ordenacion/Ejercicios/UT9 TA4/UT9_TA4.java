/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut9_ta4;
import java.util.Arrays;
import static ut9_ta4.TClasificador.METODO_CLASIFICACION_INSERCION;
import static ut9_ta4.TClasificador.METODO_CLASIFICACION_SHELL;
import static ut9_ta4.TClasificador.METODO_CLASIFICACION_BURBUJA;
import static ut9_ta4.TClasificador.METODO_CLASIFICACION_QUICKSORT;
import static ut9_ta4.TClasificador.METODO_CLASIFICACION_HEAPSORT;
import static ut9_ta4.TClasificador.METODO_CLASIFICACION_SELECCION;

import static ut9_ta4.MedicionTiempo.ALEATORIO;
import static ut9_ta4.MedicionTiempo.ASCENDENTE;
import static ut9_ta4.MedicionTiempo.DESCENDENTE;


public class UT9_TA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TClasificador clasificador = new TClasificador();
        GeneradorDatosGenericos generador = new GeneradorDatosGenericos(300);
        
        // MEDICION DE TIEMPOS
        System.out.println("\nMEDICION DE TIEMPOS CON 300 ELEMENTOS:");
        
        MedicionTiempo medicion = new MedicionTiempo(300);
        
        // SHELLSORT
        System.out.println("\nShellSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, ALEATORIO) + "ns");
        System.out.println("ShellSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, ASCENDENTE) + "ns");
        System.out.println("ShellSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, DESCENDENTE) + "ns");
        
        // INSERCION
        System.out.println("\nInsercion, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, ALEATORIO) + "ns");
        System.out.println("Insercion, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, ASCENDENTE) + "ns");
        System.out.println("Insercion, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, DESCENDENTE) + "ns");
        
        // BURBUJA
        System.out.println("\nBurbuja, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, ALEATORIO) + "ns");
        System.out.println("Burbuja, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, ASCENDENTE) + "ns");
        System.out.println("Burbuja, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, DESCENDENTE) + "ns");
        
        // QuickSort
        System.out.println("\nQuickSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, ALEATORIO) + "ns");
        System.out.println("QuickSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, ASCENDENTE) + "ns");
        System.out.println("QuickSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, DESCENDENTE) + "ns");
        
        // HEAPSORT
        System.out.println("\nHeapSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, ALEATORIO) + "ns");
        System.out.println("HeapSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, ASCENDENTE) + "ns");
        System.out.println("HeapSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, DESCENDENTE) + "ns");
        
        // SELECCION
        System.out.println("\nSeleccion, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, ALEATORIO) + "ns");
        System.out.println("Seleccion, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, ASCENDENTE) + "ns");
        System.out.println("Seleccion, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, DESCENDENTE) + "ns");
        
        System.out.println("\n-----------------------------------------------------");
        System.out.println("\nMEDICION DE TIEMPOS CON 3000 ELEMENTOS:");
        
        medicion = new MedicionTiempo(3000);
        
        // SHELLSORT
        System.out.println("\nShellSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, ALEATORIO) + "ns");
        System.out.println("ShellSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, ASCENDENTE) + "ns");
        System.out.println("ShellSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, DESCENDENTE) + "ns");
        
        // INSERCION
        System.out.println("\nInsercion, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, ALEATORIO) + "ns");
        System.out.println("Insercion, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, ASCENDENTE) + "ns");
        System.out.println("Insercion, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, DESCENDENTE) + "ns");
        
        // BURBUJA
        System.out.println("\nBurbuja, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, ALEATORIO) + "ns");
        System.out.println("Burbuja, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, ASCENDENTE) + "ns");
        System.out.println("Burbuja, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, DESCENDENTE) + "ns");
        
        // QuickSort
        System.out.println("\nQuickSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, ALEATORIO) + "ns");
        System.out.println("QuickSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, ASCENDENTE) + "ns");
        System.out.println("QuickSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, DESCENDENTE) + "ns");
        
        // HEAPSORT
        System.out.println("\nHeapSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, ALEATORIO) + "ns");
        System.out.println("HeapSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, ASCENDENTE) + "ns");
        System.out.println("HeapSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, DESCENDENTE) + "ns");
        
        // SELECCION
        System.out.println("\nSeleccion, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, ALEATORIO) + "ns");
        System.out.println("Seleccion, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, ASCENDENTE) + "ns");
        System.out.println("Seleccion, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, DESCENDENTE) + "ns"); 
        
        System.out.println("\n-----------------------------------------------------");
        System.out.println("\nMEDICION DE TIEMPOS CON 30000 ELEMENTOS:");
        
        medicion = new MedicionTiempo(30000);
        
        // SHELLSORT
        System.out.println("\nShellSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, ALEATORIO) + "ns");
        System.out.println("ShellSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, ASCENDENTE) + "ns");
        System.out.println("ShellSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SHELL, DESCENDENTE) + "ns");
        
        // INSERCION
        System.out.println("\nInsercion, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, ALEATORIO) + "ns");
        System.out.println("Insercion, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, ASCENDENTE) + "ns");
        System.out.println("Insercion, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_INSERCION, DESCENDENTE) + "ns");
        
        // BURBUJA
        System.out.println("\nBurbuja, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, ALEATORIO) + "ns");
        System.out.println("Burbuja, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, ASCENDENTE) + "ns");
        System.out.println("Burbuja, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_BURBUJA, DESCENDENTE) + "ns");
        
        // QuickSort
        System.out.println("\nQuickSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, ALEATORIO) + "ns");
        System.out.println("QuickSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, ASCENDENTE) + "ns");
        System.out.println("QuickSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_QUICKSORT, DESCENDENTE) + "ns");
        
        // HEAPSORT
        System.out.println("\nHeapSort, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, ALEATORIO) + "ns");
        System.out.println("HeapSort, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, ASCENDENTE) + "ns");
        System.out.println("HeapSort, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_HEAPSORT, DESCENDENTE) + "ns");
        
        // SELECCION
        System.out.println("\nSeleccion, Vector Aleatorio. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, ALEATORIO) + "ns");
        System.out.println("Seleccion, Vector Ascendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, ASCENDENTE) + "ns");
        System.out.println("Seleccion, Vector Descendente. Tiempo: " + medicion.medicionTiempo(METODO_CLASIFICACION_SELECCION, DESCENDENTE) + "ns"); 
        
        int[] vectorAscendente = generador.generarDatosAscendentes();
        int[] vectorDescendente = generador.generarDatosDescendentes();
        int[] vectorAleatorio = generador.generarDatosAleatorios();
        
        int alturaVectorAscendente = clasificador.ordenarPorQuickSortAltura(vectorAscendente);
        int alturaVectorDescendente = clasificador.ordenarPorQuickSortAltura(vectorDescendente);
        int alturaVectorAleatorio = clasificador.ordenarPorQuickSortAltura(vectorAleatorio);
        
        System.out.println("\n300 elementos:");
        System.out.println("\nVector ascendente ordenado? " + clasificador.estaOrdenado(vectorAscendente));
        System.out.println("Vector descendente ordenado? " + clasificador.estaOrdenado(vectorDescendente));
        System.out.println("Vector aleatorio ordenado? " + clasificador.estaOrdenado(vectorAleatorio));
        
        System.out.println("\nAltura vector Ascendente: " + alturaVectorAscendente);
        System.out.println("Altura vector Descendente: " + alturaVectorDescendente);
        System.out.println("Altura vector Aleatorio: " + alturaVectorAleatorio);
        
        generador = new GeneradorDatosGenericos(10000);
        
        System.out.println("\n10000 elementos:");
        vectorAscendente = generador.generarDatosAscendentes();
        vectorDescendente = generador.generarDatosDescendentes();
        vectorAleatorio = generador.generarDatosAleatorios();
        
        
        alturaVectorAscendente = clasificador.ordenarPorQuickSortAltura(vectorAscendente);
        alturaVectorDescendente = clasificador.ordenarPorQuickSortAltura(vectorDescendente);
        alturaVectorAleatorio = clasificador.ordenarPorQuickSortAltura(vectorAleatorio);
        
        System.out.println("\nVector ascendente ordenado? " + clasificador.estaOrdenado(vectorAscendente));
        System.out.println("Vector descendente ordenado? " + clasificador.estaOrdenado(vectorDescendente));
        System.out.println("Vector aleatorio ordenado? " + clasificador.estaOrdenado(vectorAleatorio));
        
        System.out.println("\nAltura vector Ascendente: " + alturaVectorAscendente);
        System.out.println("Altura vector Descendente: " + alturaVectorDescendente);
        System.out.println("Altura vector Aleatorio: " + alturaVectorAleatorio);
        
    }
    
}
