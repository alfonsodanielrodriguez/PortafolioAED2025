package uy.edu.ucu.aed.modelo;

import java.util.List;

/**
 * Clase que representa el resultado de un recorrido de un camión entre dos ciudades.
 * Contiene el ID del camión, el tiempo total del recorrido y la ruta seguida.
 */
public class Recorrido {
    private String camionID;
    private float tiempo; // en horas
    private List<Ciudad> rutaRecorrida;
    
    /**
     * Constructor de la clase Recorrido.
     * @param camionID El ID del camión que realiza el recorrido.
     * @param tiempo El tiempo total del recorrido en horas.
     * @param rutaRecorrida La lista ordenada de ciudades recorridas desde origen a destino.
     */
    public Recorrido(String camionID, float tiempo, List<Ciudad> rutaRecorrida) {
        this.camionID = camionID;
        this.tiempo = tiempo;
        this.rutaRecorrida = rutaRecorrida;
    }
    
    /**
     * Obtiene el ID del camión.
     * @return El ID del camión.
     */
    public String getCamionID() {
        return camionID;
    }
    
    /**
     * Establece el ID del camión.
     * @param camionID El nuevo ID del camión.
     */
    public void setCamionID(String camionID) {
        this.camionID = camionID;
    }
    
    /**
     * Obtiene el tiempo total del recorrido.
     * @return El tiempo total en horas.
     */
    public float getTiempo() {
        return tiempo;
    }
    
    /**
     * Establece el tiempo total del recorrido.
     * @param tiempo El nuevo tiempo total en horas.
     */
    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
    
    /**
     * Obtiene la ruta recorrida.
     * @return La lista de ciudades recorridas.
     */
    public List<Ciudad> getRutaRecorrida() {
        return rutaRecorrida;
    }
    
    /**
     * Establece la ruta recorrida.
     * @param rutaRecorrida La nueva lista de ciudades recorridas.
     */
    public void setRutaRecorrida(List<Ciudad> rutaRecorrida) {
        this.rutaRecorrida = rutaRecorrida;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recorrido{");
        sb.append("camionID='").append(camionID).append('\'');
        sb.append(", tiempo=").append(tiempo).append(" horas");
        sb.append(", ruta=");
        
        if (rutaRecorrida != null && !rutaRecorrida.isEmpty()) {
            for (int i = 0; i < rutaRecorrida.size(); i++) {
                if (i > 0) sb.append(" -> ");
                sb.append(rutaRecorrida.get(i).getNombre());
            }
        }
        
        sb.append('}');
        return sb.toString();
    }
}
