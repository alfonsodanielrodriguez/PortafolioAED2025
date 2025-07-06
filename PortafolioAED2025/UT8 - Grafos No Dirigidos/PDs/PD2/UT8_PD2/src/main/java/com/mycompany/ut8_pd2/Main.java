/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ut8_pd2;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        
        // Ejercicio 1

        TVertice v1 = new TVertice("V1");
        TVertice v2 = new TVertice("V2");
        TVertice v3 = new TVertice("V3");
        TVertice v4 = new TVertice("V4");

        LinkedList<TVertice> vertices = new LinkedList();
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);

        TArista a1 = new TArista("V1", "V2", 5);
        TArista a2 = new TArista("V4", "V3", 8);
        TArista a3 = new TArista("V1", "V3", 3);
        TArista a4 = new TArista("V2", "V3", 1);

        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);

        TGrafoNoDirigido gf = new TGrafoNoDirigido(vertices, aristas);

        Double[][] matrizCostos = UtilGrafos.obtenerMatrizCostos(gf.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizCostos, gf.getVertices(), "Matriz de costo");


        TGrafoNoDirigido gfPrim = gf.Prim();

        Double[][] matrizCostosPrim = UtilGrafos.obtenerMatrizCostos(gfPrim.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizCostosPrim, gfPrim.getVertices(), "Matriz de costos Prim");
        
        TGrafoNoDirigido gfKruskal = gf.Kruskal();
        Double[][] matrizCostosKruskal = UtilGrafos.obtenerMatrizCostos(gfKruskal.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizCostosKruskal, gfKruskal.getVertices(), "Matriz de cosos Kruskal");
        
    }
}
