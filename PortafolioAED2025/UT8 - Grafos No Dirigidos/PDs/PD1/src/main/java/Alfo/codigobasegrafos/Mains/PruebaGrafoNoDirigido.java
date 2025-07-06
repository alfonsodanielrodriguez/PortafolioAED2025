package Alfo.codigobasegrafos.Mains;

import java.util.LinkedList;

import Alfo.codigobasegrafos.Genericos.TGrafoNoDirigido;
import Alfo.codigobasegrafos.Genericos.UtilGrafos;

public class PruebaGrafoNoDirigido {
    public static void main(String[] args) {/*
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("src/main/verticesBEA.txt", "src/main/aristasBEA.txt",
        false, TGrafoNoDirigido.class);

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gnd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gnd.getVertices(), "Matriz");
        
        TGrafoNoDirigido grafoPrim = gnd.Prim();

        matriz = UtilGrafos.obtenerMatrizCostos(grafoPrim.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafoPrim.getVertices(), "Matriz");
        

        for (TVertice v :   gnd.bea("d")) {
        //  System.out.println(v.getEtiqueta());
        }

        //System.out.println("==========");


        for (TVertice v :   gnd.bpf("a")) {
        //    System.out.println(v.getEtiqueta());
        }

        //Puntos de articulación
        TGrafoNoDirigido gndArticulacion = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("src/main/verticesPuntosArt.txt", "src/main/conexionesPuntosArt.txt",
        false, TGrafoNoDirigido.class);
        System.out.println("Puntos de articulacion: ");
        LinkedList<TVertice> puntos = gndArticulacion.puntosArticulacion("Gar");
        for (TVertice punto : puntos) {
            System.out.println(punto.getEtiqueta());
        }
        */

        TGrafoNoDirigido grafoND = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("src/main/java/uy/edu/ucu/aed2/verticesAAM.txt","src/main/java/uy/edu/ucu/aed2/conexionesAAM.txt",
        false, TGrafoNoDirigido.class);

        TGrafoNoDirigido grafoPrim2 = grafoND.Prim();
        System.out.println("AAM a partir de Prim: " + grafoPrim2.getCostoTotal());
        grafoND.desvisitarVertices();
        TGrafoNoDirigido grafoKruskal = grafoND.Kruskal();
        System.out.println("AAM a partir de Kruskal: " + grafoKruskal.getCostoTotal());
    }
  
}
