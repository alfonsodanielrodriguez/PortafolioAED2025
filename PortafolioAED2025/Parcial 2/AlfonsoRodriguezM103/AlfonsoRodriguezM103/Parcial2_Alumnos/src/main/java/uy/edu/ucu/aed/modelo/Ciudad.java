package uy.edu.ucu.aed.modelo;

/**
 * Clase que representa una ciudad en el sistema de transporte.
 * Cada ciudad tiene un nombre único que la identifica.
 */
public class Ciudad {
    private String nombre;
    
    /**
     * Constructor de la clase Ciudad.
     * @param nombre El nombre de la ciudad.
     */
    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el nombre de la ciudad.
     * @return El nombre de la ciudad.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre de la ciudad.
     * @param nombre El nuevo nombre de la ciudad.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ciudad ciudad = (Ciudad) obj;
        return nombre.equals(ciudad.nombre);
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
