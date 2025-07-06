package Alfo;

import java.util.Arrays;
import java.util.LinkedList;

public class UT5_PD7 {

    public static void main(String[] args) {
        TArbolTrieTelefonos trie = new TArbolTrieTelefonos();

        String[] abonadosArchivo = ManejadorArchivosGenerico.leerArchivo(
                "C:\\Users\\alfon\\Desktop\\UT5\\Ejercicios\\UT5_PD7\\src\\main\\java\\Alfo\\abonados.txt");
        for (String str : abonadosArchivo) {
            String[] elementos = str.split(",");
            String telefono = elementos[0];
            String nombre = elementos[1];
            TAbonado abonado = new TAbonado(nombre, telefono);
            trie.insertar(abonado);
            
        }
        
        String codigoPais = "054" ;
        String codigoArea = "90" ;
        LinkedList<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        
        // guardar abonados en salida.txt, correspondientes al pais y area 
        String[] lista = new String[ab.size()];
        int indice = 0;
        
        for (TAbonado a : ab) {
            String nombre = a.getNombre();
            String telefono = a.getTelefono();
            String abonado = nombre + ", " + telefono;
            lista[indice] = abonado;
            indice++;
        }
        
        Arrays.sort(lista);

        ManejadorArchivosGenerico.escribirArchivo("C:\\Users\\alfon\\Desktop\\UT5\\Ejercicios\\UT5_PD7\\src\\main\\java\\Alfo\\salida.txt", lista);
    }
}
