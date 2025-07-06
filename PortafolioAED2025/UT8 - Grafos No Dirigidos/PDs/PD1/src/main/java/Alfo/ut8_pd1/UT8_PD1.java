/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Alfo.ut8_pd1;

import java.util.LinkedList;
import Alfo.codigobasegrafos.Genericos.TGrafoNoDirigido;
import Alfo.codigobasegrafos.Genericos.TVertice;
import Alfo.codigobasegrafos.Genericos.UtilGrafos;

/**
 *
 * @author jpere
 */
public class UT8_PD1 {

    public static void main(String[] args) {
       
        // UT8 PD1 Ejercicio 2
        System.out.println("Ejercicio 2");
        TGrafoNoDirigido grafoND = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(".\\src\\main\\java\\Alfo\\codigobasegrafos\\txt\\verticesAAM.txt",".\\src\\main\\java\\Alfo\\codigobasegrafos\\txt\\conexionesAAM.txt",
        false, TGrafoNoDirigido.class);

        TGrafoNoDirigido grafoPrim2 = grafoND.Prim();
        System.out.println("AAM a partir de Prim: " + grafoPrim2.getCostoTotal());
        grafoND.desvisitarVertices();
        TGrafoNoDirigido grafoKruskal = grafoND.Kruskal();
        System.out.println("AAM a partir de Kruskal: " + grafoKruskal.getCostoTotal());
        
        System.out.println("\n==========");
        
        // UT8 PD1 Ejercicio 3
        System.out.println("Ejercicio 3");
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo(".\\src\\main\\java\\Alfo\\codigobasegrafos\\txt\\verticesBEA_1.txt", ".\\src\\main\\java\\Alfo\\codigobasegrafos\\txt\\aristasBEA_1.txt",
        false, TGrafoNoDirigido.class);

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gnd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gnd.getVertices(), "Matriz");
        
        TGrafoNoDirigido grafoPrim = gnd.Prim();

        matriz = UtilGrafos.obtenerMatrizCostos(grafoPrim.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, grafoPrim.getVertices(), "Matriz con Prim");
        
        for (TVertice v :   gnd.bea("a")) {
          System.out.print (v.getEtiqueta() + " ");
        }
    }
}
