package uy.edu.ucu.aed.modelo;

/**
 * Clase que representa un camión en el sistema de transporte.
 * Cada camión tiene un ID único, una velocidad específica y una autonomía.
 */
public class Camion {
    private String camionID;
    private double velocidad; // en km/h
    private int autonomia; // en km
    private String ciudadActual; // ciudad donde se encuentra inicialmente el camión
    
    /**
     * Constructor de la clase Camion con autonomía y ciudad inicial.
     * @param camionID El identificador único del camión.
     * @param velocidad La velocidad del camión en km/h.
     * @param autonomia La autonomía del camión en km.
     * @param ciudadActual La ciudad donde se encuentra inicialmente el camión.
     */
    public Camion(String camionID, double velocidad, int autonomia, String ciudadActual) {
        this.camionID = camionID;
        this.velocidad = velocidad;
        this.autonomia = autonomia;
        this.ciudadActual = ciudadActual;
    }
    
    /**
     * Constructor de la clase Camion con autonomía (sin ciudad inicial).
     * @param camionID El identificador único del camión.
     * @param velocidad La velocidad del camión en km/h.
     * @param autonomia La autonomía del camión en km.
     */
    public Camion(String camionID, double velocidad, int autonomia) {
        this(camionID, velocidad, autonomia, null);
    }
    
    /**
     * Constructor de la clase Camion solo con velocidad (para compatibilidad).
     * @param camionID El identificador único del camión.
     * @param velocidad La velocidad del camión en km/h.
     */
    public Camion(String camionID, double velocidad) {
        this(camionID, velocidad, 0, null);
    }
    
    /**
     * Obtiene el ID del camión.
     * @return El ID del camión.
     */
    public String getCamionID() {
        return camionID;
    }
    
    /**
     * Obtiene la velocidad del camión.
     * @return La velocidad del camión en km/h.
     */
    public double getVelocidad() {
        return velocidad;
    }

    /**
     * Obtiene la autonomía del camión.
     * @return La autonomía del camión en km.
     */
    public int getAutonomia() {
        return autonomia;
    }
    
    /**
     * Obtiene la ciudad actual del camión.
     * @return La ciudad donde se encuentra inicialmente el camión.
     */
    public String getCiudadActual() {
        return ciudadActual;
    }
    
    /**
     * Establece la ciudad actual del camión.
     * @param ciudadActual La nueva ciudad donde se encuentra el camión.
     */
    public void setCiudadActual(String ciudadActual) {
        this.ciudadActual = ciudadActual;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Camion camion = (Camion) obj;
        return camionID.equals(camion.camionID);
    }
    
    @Override
    public int hashCode() {
        return camionID.hashCode();
    }
    
    @Override
    public String toString() {
        return "Camion{ID='" + camionID + "', velocidad=" + velocidad + " km/h, autonomia=" + autonomia + " km, ciudadActual='" + ciudadActual + "'}";
    }
}
