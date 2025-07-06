package uy.edu.ucu.aed.parcial;

import uy.edu.ucu.aed.modelo.*;
import uy.edu.ucu.aed.tdas.TArista;
import uy.edu.ucu.aed.tdas.TGrafoDirigido;
import uy.edu.ucu.aed.tdas.TGrafoNoDirigido;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.utils.TCamino;
import uy.edu.ucu.aed.utils.TCaminos;

import java.util.ArrayList;
import java.util.Collection;
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
        ISistemaTransporte sistema = new TSistemaTransporte();

        String rutaArchivoCiudades = "C:\\Users\\alfon\\Downloads\\Parcial2_Alumnos\\Parcial2_Alumnos\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial\\ciudades.txt";
        String rutaArchivoCarreteras = "C:\\Users\\alfon\\Downloads\\Parcial2_Alumnos\\Parcial2_Alumnos\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial\\carreteras.txt";
        String rutaArchivoCamiones = "C:\\Users\\alfon\\Downloads\\Parcial2_Alumnos\\Parcial2_Alumnos\\src\\main\\java\\uy\\edu\\ucu\\aed\\parcial\\camiones.txt";
        Collection<Camion> camions = new ArrayList<>();
        Collection<Ciudad> city = new ArrayList<>();
        Collection<Recorrido> recorridos = new ArrayList<>();

        // TODO: Cargar datos de ejemplo
        //String camionID, double velocidad, int autonomia, String ciudadActual
        String[] lineasSplit1 = ManejadorArchivosGenerico.leerArchivo(rutaArchivoCamiones);
        String[] lineasSplit2 = ManejadorArchivosGenerico.leerArchivo(rutaArchivoCiudades);
        String[] lineasSplit3 = ManejadorArchivosGenerico.leerArchivo(rutaArchivoCarreteras);

        for (String linea : lineasSplit1) { //CAM001,85,900,Montevideo
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String nombre = partes[0];
                double velocidad = Double.parseDouble(partes[1]);
                int autonomia = Integer.parseInt(partes[2]);
                String ciudadActual = partes[3];
                int id = Integer.parseInt(partes[0]);
                camions.add(new Camion(nombre, velocidad, autonomia, ciudadActual));
            }
        }
        Collection<TArista> aristas = new ArrayList<>();
        //String camionID, float tiempo, List<Ciudad> rutaRecorrida
        for (String linea : lineasSplit3) { //Montevideo,Colonia del Sacramento,177
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String origen = partes[0];
                String destino = partes[1];
                double tiempo = Double.parseDouble(partes[2]);
                aristas.add(new TArista(origen, destino, tiempo));
            }
        }

        //Rivera
        for (String linea : lineasSplit2) { //Ciudades
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String ciudad = partes[0];
                city.add(new Ciudad(ciudad));
            }
        }
        TGrafoDirigido dirigido = new TGrafoNoDirigido(city,aristas);
        TCaminos camino = dirigido.todosLosCaminos("Rivera", "Tacuarembo");

        // TODO: Mostrar ejemplos de consultas de rutas
        // Las consultas se realizan con ciudades del nuevo grafo

        System.out.println("\n--- Consultas de rutas óptimas ---");
        String[][] consultas = {
            {"Montevideo", "Salto"},
            {"Punta del Este", "Rivera"},
            {"Colonia del Sacramento", "Tacuarembó"},
            {"Maldonado", "Paysandú"}
        };

        for (String[] consulta : consultas) {
            String origen = consulta[0];
            String destino = consulta[1];
            System.out.println("Ruta de " + origen + " a " + destino + ":");
            List<Recorrido> rutas = sistema.ruta(origen, destino);
            if (rutas.isEmpty()) {
                System.out.println("No se encontraron rutas.");
            } else {
                for (Recorrido r : rutas) {
                    System.out.println(r);
                }
            }
            System.out.println("Ruta extendida de " + origen + " a " + destino + ":");
            List<Recorrido> rutasExt = sistema.rutaExtendida(origen, destino);
            if (rutasExt.isEmpty()) {
                System.out.println("No se encontraron rutas extendidas.");
            } else {
                for (Recorrido r : rutasExt) {
                    System.out.println(r);
                }
            }
            System.out.println();
        }
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}
