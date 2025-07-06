/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Alfo;

public class UT6_PD1 {

    public static void main(String[] args) {
        

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\alfon\\Desktop\\UT 6 - PD\\UT6_PD1\\src\\main\\java\\Alfo\\prueba.txt");

        for (String p : palabrasclave) {
                System.out.println(p);
        }
        
        //System.out.println(trie.predecir("bo"));
    }
}
