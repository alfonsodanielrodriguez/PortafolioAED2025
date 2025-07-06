/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ucu.aed;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"
        IHash tabla = new TTablaHash(1000);
        ManejadorArchivos archivos = new ManejadorArchivos();
        String[] claves = archivos.leerArchivo("C:\\Users\\alfon\\Desktop\\Unidad Temática 6\\Adicional\\Hashes\\src\\main\\java\\uy\\edu\\ucu\\aed\\claves_insertar.txt");
        for (String clave : claves) {
            tabla.insertar(Integer.parseInt(clave));
        }

        
        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
        String[] clavesBuscar = archivos.leerArchivo("C:\\Users\\alfon\\Desktop\\Unidad Temática 6\\Adicional\\Hashes\\src\\main\\java\\uy\\edu\\ucu\\aed\\claves_buscar.txt");
        for (String clave : clavesBuscar) {
            int pos = tabla.buscar(Integer.parseInt(clave));
            if (pos != -1) {
                System.out.println("La clave " + clave + " se encuentra en la posición " + pos);
            } else {
                System.out.println("La clave " + clave + " no se encuentra en la tabla");
            }
        }


    }
    
}
