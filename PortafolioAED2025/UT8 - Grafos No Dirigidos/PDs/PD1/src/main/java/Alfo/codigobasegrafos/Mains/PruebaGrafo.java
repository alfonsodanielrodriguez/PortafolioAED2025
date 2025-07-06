package Alfo.codigobasegrafos.Mains;
import java.util.LinkedList;

import Alfo.codigobasegrafos.Genericos.TGrafoDirigido;
import Alfo.codigobasegrafos.Genericos.TVertice;
import Alfo.codigobasegrafos.Genericos.UtilGrafos;

import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {

        // EJERCICIO 1
        /**
         * ***********************
         * PROBAR FLOYD, EXCENTRICIDAD Y CENTRO DEL GRAFO
        ************************
         */
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/main/java/uy/edu/ucu/aed2/aeropuertos.txt", "./src/main/java/uy/edu/ucu/aed2/conexiones.txt",
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

        /**
         * ***********************
         * PROBAR WARSHALL **************************
         **/
        boolean[][] warshall = gd.warshall();
        Comparable[][] warshall2 = UtilGrafos.convertirWarshall(warshall);

        UtilGrafos.imprimirMatrizMejorado(warshall2, gd.getVertices(), "Matriz de Warshall");
        
        /**
         **************************
         */
        // EJERCICIO 2
        /**
         * ***********************
         * PROBAR BPF DEL GRAFO, CON DISTINTOS GRAFOS
        **************************
         */
        // hacer lo siguiente para distintos grafos (ver los archivos de datos disponibles)
        Collection<TVertice> recorrido = gd.bpf();
        // imprimir etiquetas del bpf de todo el grafo....
        System.out.println("bpf del grafo:");
        UtilGrafos.imprimirBpf(recorrido);

        /**
         * *************************************************
         * PROBAR BPF DEL GRAFO, a partir de un sólo vértice
        **************************************************
         */
        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion"); 
        // imprimir etiquetas del bpf desde Asunción....
        System.out.println("\nbpf desde Asuncion:"); 
        UtilGrafos.imprimirBpf(recorrido_Asuncion);
        // probar con distintos GRAFOS y vértices de origen 

        // EJERCICIO 3
        /**
         * ***********************
         * todos los caminos
        **************************
         */
        TGrafoDirigido gdcaminos = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/main/java/uy/edu/ucu/aed2/aeropuertosPROYECTO.txt", "./src/main/java/uy/edu/ucu/aed2/conexionesPROYECTO.txt",
                false, TGrafoDirigido.class);
        //TCaminos caminos = gdcaminos.todosLosCaminos("ATL", "JAX");
        //caminos.imprimirCaminosConsola();
        //System.out.println("cantidad de caminos: " + caminos.getCaminos().size());
         
         /***********************
         * camino crítico
        **************************/
        /*
         ver la letra del ejercicio 3, elegir dos aeropuertos del grafo aeropuertosPROYECTO1 y buscar el camino crítico entre los mismos. 
         SUGERENCIA: probar primero con un grafo pequeño, dibujado. 
         */
        //gdcaminos.caminoCritico("ATL", "JAX");
         
        /***********************
         * ciclos
        **************************/
       // Dados los archivos “conexiones_2.txt” y “aeropuertos_2.txt”, ejecutar el programa e indicar si el grafo resultante contiene ciclos o no. 
        TGrafoDirigido gdCiclos = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/main/java/uy/edu/ucu/aed2/aeropuertos_2.txt", "./src/main/java/uy/edu/ucu/aed2/conexiones_2.txt",
        false, TGrafoDirigido.class);
        System.out.println(gdCiclos.tieneCiclo());
        /***********************
         * unOrdenTopologico
        **************************/
        
        // implementar los métodos para, dado un grafo y un vértice del mismo, obtener una ordenación topológica
        
        TGrafoDirigido grafoTopologico = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/main/java/uy/edu/ucu/aed2/topologico.txt", "./src/main/java/uy/edu/ucu/aed2/topologicoConexiones.txt",
                false, TGrafoDirigido.class);
        LinkedList<TVertice> orden = grafoTopologico.unOrdenTopologico(new TVertice<>("C5"));
        UtilGrafos.imprimirBpf(orden);
    }
}
