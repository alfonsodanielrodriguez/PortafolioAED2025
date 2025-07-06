package uy.edu.ucu.aed.parcial;

import uy.edu.ucu.aed.modelo.*;
import java.util.List;

/**
 * Clase principal que demuestra el uso del sistema de transporte implementado.
 * Carga datos de ejemplo y muestra el cálculo de rutas óptimas.
 */
public class Main 
{
    public static void main(String[] args)
    {
        System.out.println("=== SISTEMA DE GESTIÓN DE TRANSPORTE ===\n");
        
        // TODO: Instanciar el sistema de transporte según la clase que implementa ISistemaTransporte

        // Por ejemplo, si tienes una clase llamada SistemaTransporteImpl que implementa ISistemaTransporte:
        // ISistemaTransporte sistema = new SistemaTransporteImpl();
        // Aquí debes reemplazar con la implementación real de tu sistema de transporte.
        // Puede llegar a ser necesario cambiar el tipo de la variable sistema si es necesario utilizar métodos específicos de una implementación concreta.
        ISistemaTransporte sistema = null;

        String rutaArchivoCiudades = "uy/edu/ucu/aed/parcial/ciudades.txt";
        String rutaArchivoCarreteras = "uy/edu/ucu/aed/parcial/carreteras.txt";
        String rutaArchivoCamiones = "uy/edu/ucu/aed/parcial/camiones.txt";
        
        // TODO: Cargar datos de ejemplo

        
        // TODO: Mostrar ejemplos de consultas de rutas
        // Las consultas se realizan con ciudades del nuevo grafo
        System.out.println("\n--- Consultas de rutas óptimas ---");
        String[][] consultas = {
            {"Montevideo", "Salto"},
            {"Punta del Este", "Rivera"},
            {"Colonia del Sacramento", "Tacuarembó"},
            {"Maldonado", "Paysandú"}
        };
        
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}
