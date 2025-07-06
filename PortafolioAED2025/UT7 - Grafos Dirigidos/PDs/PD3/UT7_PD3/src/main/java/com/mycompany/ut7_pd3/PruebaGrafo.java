package com.mycompany.ut7_pd3;


import static java.lang.System.in;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        // EJERCICIO 1:
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos.txt", "./src/conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());

        // EJERCICIO 2:
        Comparable ciudadOrigen = "Montevideo";
        Comparable ciudadDestino = "Curitiba";
        boolean existeConexion = gd.obtenerConectividad(ciudadOrigen, ciudadDestino);
        String respuesta = existeConexion ? "Si" : "No";
        System.out.println("\n¿Existe conexion entre " + ciudadOrigen + " y " + ciudadDestino + "?: " + respuesta);

        ciudadOrigen = "Porto_Alegre";
        ciudadDestino = "Santos";
        existeConexion = gd.obtenerConectividad(ciudadOrigen, ciudadDestino);
        respuesta = existeConexion ? "Si" : "No";
        System.out.println("¿Existe conexion entre " + ciudadOrigen + " y " + ciudadDestino + "?: " + respuesta);
        
        ciudadOrigen = "Porto_Alegre";
        ciudadDestino = "Peru";
        existeConexion = gd.obtenerConectividad(ciudadOrigen, ciudadDestino);
        respuesta = existeConexion ? "Si" : "No";
        System.out.println("¿Existe conexion entre " + ciudadOrigen + " y " + ciudadDestino + "?: " + respuesta);

        
        // EJERCICIO 3:
        Collection<TVertice> recorridoDesdeMontevideo = gd.bpf("Montevideo");
        System.out.println("Camino desde Montevideo:");
        recorridoDesdeMontevideo.forEach((vertice) -> {
            System.out.println("\t" + vertice.getEtiqueta() + ","); 
        });
        
        System.out.println("\nCaminos desde Montevideo a Rio de janeiro:");
        TCaminos caminos = gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        caminos.imprimirCaminosConsola();
    }
}
