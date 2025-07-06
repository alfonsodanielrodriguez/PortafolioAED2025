/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ut8_pd4;

import java.util.LinkedList;

/**
 *
 * @author juan-
 */
public class UT8_PD4 {

    public static void main(String[] args) {
        
        TVertice CC1 = new TVertice("CC1");
        TVertice CC2 = new TVertice("CC2");
        TVertice CC3 = new TVertice("CC3");
        TVertice CC4 = new TVertice("CC4");
        TVertice CC5 = new TVertice("CC5");
        TVertice CC6 = new TVertice("CC6");

        LinkedList<TVertice> vertices = new LinkedList();
        vertices.add(CC1);
        vertices.add(CC2);
        vertices.add(CC3);
        vertices.add(CC4);
        vertices.add(CC5);
        vertices.add(CC6);

        TArista a1 = new TArista("CC1", "CC2", 5);
        TArista a2 = new TArista("CC1", "CC3", 7);
        TArista a3 = new TArista("CC1", "CC4", 3);
        TArista a4 = new TArista("CC1", "CC5", 9);
        TArista a5 = new TArista("CC1", "CC6", 4);
        TArista a6 = new TArista("CC2", "CC3", 3);
        TArista a7 = new TArista("CC2", "CC4", 5);
        TArista a8 = new TArista("CC2", "CC5", 7);
        TArista a9 = new TArista("CC2", "CC6", 8);
        TArista a10 = new TArista("CC3", "CC4", 4);
        TArista a11 = new TArista("CC3", "CC5", 5);
        TArista a12 = new TArista("CC3", "CC6", 7);
        TArista a13 = new TArista("CC4", "CC5", 9);
        TArista a14 = new TArista("CC4", "CC6", 3);
        TArista a15 = new TArista("CC5", "CC6", 6);

        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(a1);
        aristas.add(a2);
        aristas.add(a3);
        aristas.add(a4);
        aristas.add(a5);
        aristas.add(a6);
        aristas.add(a7);
        aristas.add(a8);
        aristas.add(a9);
        aristas.add(a10);
        aristas.add(a11);
        aristas.add(a12);
        aristas.add(a13);
        aristas.add(a14);
        aristas.add(a15);
        
        //Ejercicio 1

        TGrafoNoDirigido UcuRedes = new TGrafoNoDirigido(vertices, aristas);
        
        LinkedList<TArista> UcuRedesPrim = UcuRedes.PrimAristas();
        
        String[] enlacesFibra = new String[UcuRedesPrim.size() + 1];
        int i = 0;
        double costoTotal = 0;
        for (TArista arista : UcuRedesPrim) {
            enlacesFibra[i] = arista.getEtiquetaOrigen() + " --> " + arista.getEtiquetaDestino() + ". Costo: " + arista.getCosto();
            i++;
            costoTotal += arista.getCosto();
        }
        enlacesFibra[i] = "El costo total de unir todos los Centros de Comunicaciones mediante fibre óptica es: " + costoTotal;
        
        ManejadorArchivosGenerico.escribirArchivo("C:\\Users\\alfon\\Desktop\\portafolio-alfonsodanielrodriguez\\Unidad Tematica 8\\PDs\\PD4\\UT8_PD4\\src\\enlaceFibraOptica.txt", enlacesFibra);
        
        
        //Ejercicio 2
        
        System.out.println("El CC1 y el CC5 estan conectados? " + UcuRedes.conectados(CC6, CC6));
    }
}
