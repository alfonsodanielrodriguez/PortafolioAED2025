/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Alfo;

public class UT4_PD2_ej2 {
    
    public static void main(String[] args) {
        /*
        Ejercicio 2-
        Leer ClavesPrueba y salvar ordenes
        */
        String[] claves = ManejadorArchivosGenerico.leerArchivo(".\\src\\main\\java\\jumpert\\ut4_pd2_ej2\\clavesPrueba.txt");
        ArbolBB arbol = new ArbolBB();
        for (String clave : claves){
            arbol.insertar(new ElementoAB(Integer.parseInt(clave),clave));
        }
        
        System.out.println(arbol.inOrden());
        System.out.println(arbol.preOrden());
        System.out.println(arbol.postOrden());
        String ruta = ".\\src\\main\\java\\jumpert\\ut4_pd2_ej2\\salvarOrder.txt";
        arbol.guardarOrdenes(ruta, arbol.inOrden());
        arbol.guardarOrdenes(ruta, arbol.preOrden());
        arbol.guardarOrdenes(ruta, arbol.postOrden());
        
        /*
        Ejercicio 3
        Leer archivo claves, insertar en arbol y buscar claves.
        */
        ArbolBB arbol1 = new ArbolBB();
        String ruta1 = ".\\src\\main\\java\\jumpert\\ut4_pd2_ej2\\claves1.txt";
        String[] claves1 = ManejadorArchivosGenerico.leerArchivo(ruta1);
        for (String clave : claves1){
            arbol1.insertar(new ElementoAB(Integer.parseInt(clave),clave));
        }
        // Parte C
        ElementoAB[] elem = new ElementoAB[4];
        elem[0]= arbol1.buscar(10635);
        elem[1]= arbol1.buscar(4567);
        elem[2]= arbol1.buscar(12);
        elem[3]= arbol1.buscar(8978);
        for (ElementoAB elemento : elem){
            if (elemento != null){
                System.out.println("Valor encontrador: " + elemento.getEtiqueta().toString());
            }else{
                System.out.println("Valor " + elemento + " no encontrado");
            }
        }
        // Parte D
        System.out.println(arbol1.preOrden());
        System.out.println("La 10ma clave es: 797. Respuesta C");
    }
}
