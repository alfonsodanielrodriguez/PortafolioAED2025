/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut9_ta4;

public class MedicionTiempo {

    public static final int ALEATORIO = 1;
    public static final int ASCENDENTE = 2;
    public static final int DESCENDENTE = 3;
    public static final int TIEMPO_RESOLUCION = 1000000000;

    private GeneradorDatosGenericos generador;
    private TClasificador clasificador;

    public MedicionTiempo(int tamanioVectores) {
        generador = new GeneradorDatosGenericos(tamanioVectores);
        clasificador = new TClasificador();
    }

    public long medicionTiempo(int algoritmo, int tipoOrden) {
        int[] vectorOriginal = generarVector(tipoOrden);

        long t1 = System.nanoTime();
        long total = 0;
        int cantLlamadas = 0;

        while (total < TIEMPO_RESOLUCION) {
            // cuidado con las unidades que retornan las funciones
            cantLlamadas++;
            // tenemos que trabajar siempre con los mismos datos.
            int[] datosCopia = vectorOriginal.clone();
            clasificador.clasificar(datosCopia, algoritmo, false);
            long t2 = System.nanoTime();
            total = t2 - t1;
        }
        // lo que lleva ejecutar 1 vez el algoritmo, para ese conjunto de datos
        long tiempoMedioAlgoritmoBase = total / cantLlamadas;
        
        // ahora tenemos que calcular cuánto se fue en las cáscaras y restarlo.
        vectorOriginal = generarVector(tipoOrden);
        
        t1 = System.nanoTime();
        total = 0;
        cantLlamadas = 0;
        
        while (total < TIEMPO_RESOLUCION) {
            cantLlamadas++;
            int[] datosCopia = vectorOriginal.clone();
            clasificador.clasificar(datosCopia, algoritmo, true);
            long t2 = System.nanoTime();
            total = t2 - t1;
        }

        // lo que lleva ejecutar 1 vez la infraestructura del algoritmo, para ese conjunto de datos.    
        long tiempoMedioCascara = total / cantLlamadas;
        
        long tiempoMedioAlgoritmo = tiempoMedioAlgoritmoBase - tiempoMedioCascara;
        
        return tiempoMedioAlgoritmo;
    }

    public int[] generarVector(int tipoOrden) {
        return switch (tipoOrden) {
            case ALEATORIO ->
                generador.generarDatosAleatorios();
            case ASCENDENTE ->
                generador.generarDatosAscendentes();
            case DESCENDENTE ->
                generador.generarDatosDescendentes();
            default ->
                null;
        };
    }

}
