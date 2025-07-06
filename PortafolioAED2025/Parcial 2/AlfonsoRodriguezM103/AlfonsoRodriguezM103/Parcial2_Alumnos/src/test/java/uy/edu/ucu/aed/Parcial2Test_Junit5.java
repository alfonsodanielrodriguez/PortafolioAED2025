package uy.edu.ucu.aed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uy.edu.ucu.aed.modelo.*;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;
import uy.edu.ucu.aed.parcial.TSistemaTransporte;
import uy.edu.ucu.aed.parcial.ISistemaTransporte;
import uy.edu.ucu.aed.modelo.Recorrido;

import java.util.List;

/**
 * Tests completos para el sistema de transporte.
 * Valida la funcionalidad de ciudades, carreteras, camiones y cálculo de rutas.
 */
public class Parcial2Test_Junit5
{
    ISistemaTransporte sistema = new TSistemaTransporte();


    @BeforeEach
    public void setUp() {
        System.out.println("Here you can use this method to initialize the system before each test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Here you can ue this method to clean up after each test");
    }

    @Test
    public void testLeerArchivo() {
        String archivo = "testlineaporlinea.txt";
        String[] esperado = {"hola", "chau"};
        String[] resultado = ManejadorArchivosGenerico.leerArchivo(archivo);
        assertArrayEquals(esperado, resultado, "El archivo no se leyó correctamente");
    }

    @Test
    public void testRutaVacia() {
        ISistemaTransporte sistema = new TSistemaTransporte();
        assertTrue(sistema.ruta("Montevideo", "Salto").isEmpty(), "Debe retornar lista vacía si no hay rutas");
    }

    @Test
    public void testRutaExtendidaVacia() {
        assertTrue(sistema.rutaExtendida("Montevideo", "Salto").isEmpty(), "Debe retornar lista vacía si no hay rutas extendidas");
    }

    @Test
    public void testRutaMinima(){
        String camino = "Camino minimo es ..";
        assertEquals(sistema.ruta("Rivera", "Salto"), camino);
    }

    @Test
    public void testCaminominimoentredos(){
        String salida ;
    }
}
