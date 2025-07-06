package uy.edu.ucu.aed.parcial;

import java.util.List;

import uy.edu.ucu.aed.modelo.Recorrido;

public interface ISistemaTransporte {
    /**
     * Calcula las rutas más rápidas para todos los camiones entre dos ciudades.
     * Para cada camión registrado en el sistema, calcula la ruta de menor tiempo
     * entre la ciudad de origen y la de destino, considerando la velocidad individual de cada camión.
     * 
     * Precondiciones:
     * - Las ciudades de origen y destino deben existir en el sistema
     * - Debe haber al menos un camino posible entre las ciudades
     * - Los camiones deben estar registrados en el sistema
     * - Las velocidades de los camiones deben ser mayores a 0
     * 
     * Postcondiciones:
     * - Retorna una lista de recorridos, uno por cada camión que puede realizar el viaje
     * - Cada recorrido contiene el camión, tiempo total y ruta óptima
     * - Los recorridos están ordenados por tiempo (menor a mayor)
     * - Si no hay ruta posible para un camión, se omite del resultado
     * 
     * @param ciudadOrigen El nombre de la ciudad de origen.
     * @param ciudadDestino El nombre de la ciudad de destino.
     * @return Lista de recorridos óptimos para cada camión, ordenados por tiempo.
     */
    public List<Recorrido> ruta(String ciudadOrigen, String ciudadDestino);

    /**
     * Calcula las rutas más rápidas para todos los camiones entre dos ciudades,
     * considerando su posición inicial y autonomía máxima.
     * 
     * Este método considera los siguientes aspectos adicionales:
     * - Posición inicial propia: Cada camión puede encontrarse en una ciudad distinta al origen
     * - Autonomía máxima: Cada camión tiene una autonomía limitada que restringe la distancia total
     * 
     * Para cada camión, calcula la ruta desde su ciudad actual hasta la ciudad de origen,
     * y luego desde allí hasta la ciudad de destino. Si el camión ya está en el origen,
     * comienza directamente la ruta hacia el destino.
     * 
     * @param ciudadOrigen El nombre de la ciudad de origen solicitada.
     * @param ciudadDestino El nombre de la ciudad de destino.
     * @return Lista de recorridos para camiones que pueden completar el viaje dentro de su autonomía.
     */
    public List<Recorrido> rutaExtendida(String ciudadOrigen, String ciudadDestino);
}
