package Alfo.codigobasegrafos.Mains;

import java.util.LinkedList;

import Alfo.codigobasegrafos.Genericos.TGrafoNoDirigido;
import Alfo.codigobasegrafos.Genericos.UtilGrafos;

public class MainBacon {
    public static void main(String[] args) {
        // cargar grafo con actores y relaciones
        TGrafoNoDirigido grafoBacon = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("src/actores.csv", "src/en_pelicula.csv",
        false, TGrafoNoDirigido.class);
        
        // invocar a numBacon como indica la letra y mostrar en consola el resultado
        String[] actoresPrueba = new String[] {"John_Goodman", "Tom_Cruise", "Jason_Statham", "Lukas_Haas", "Djimon_Hounsou"};
        for (String actor : actoresPrueba) {
            System.out.println("Numero de Bacon de " + actor + ": " + grafoBacon.numBacon(actor));
        }
    }
}