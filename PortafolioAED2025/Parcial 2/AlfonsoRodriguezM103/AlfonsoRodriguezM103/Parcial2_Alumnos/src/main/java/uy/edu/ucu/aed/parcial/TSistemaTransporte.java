package uy.edu.ucu.aed.parcial;

import uy.edu.ucu.aed.modelo.Recorrido;
import uy.edu.ucu.aed.modelo.Ciudad;
import java.util.List;
import java.util.ArrayList;

public class TSistemaTransporte implements ISistemaTransporte{

    // Suponiendo que tienes acceso a un grafo de ciudades y carreteras, y a los camiones.
    // Aquí solo se simula la lógica, deberías adaptar a tu estructura real.

    @Override
    public List<Recorrido> ruta(String ciudadOrigen, String ciudadDestino) {
        // Buscar los caminos más cortos entre ciudadOrigen y ciudadDestino y devolverlos como objetos Recorrido.
        List<Recorrido> resultados = new ArrayList<>();
        // Se usaria el algoritmo de dijkstra para buscar el recorrido deseado
        // Luego para cada camino encontrado, se crea un Recorrido con el camión más adecuado
        return resultados;
    }

    @Override
    public List<Recorrido> rutaExtendida(String ciudadOrigen, String ciudadDestino) {
        // Lógica seria buscar todos los caminos posibles entre ciudadOrigen y ciudadDestino, no solo el más corto, y devolverlos como objetos Recorrido.
        List<Recorrido> resultados = new ArrayList<>();
        // Usaria el algoritmo de DFS para encontrar todos los caminos simples y luego para cada camino se crea un Recorrido con el camión más adecuado.
        return resultados;
    }
}
