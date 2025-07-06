/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Alfo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TClasificadorTest {
    
    public TClasificadorTest() {
    }

    /**
     * Test of clasificar method, of class TClasificador.
     */
    @Test
    public void testClasificar() {
        System.out.println("clasificar");
        int[] datosParaClasificar = null;
        int metodoClasificacion = 0;
        TClasificador instance = new TClasificador();
        int[] expResult = null;
        int[] result = instance.clasificar(datosParaClasificar, metodoClasificacion);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenarPorInsercion method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorInsercion() {
        System.out.println("ordenarPorInsercion");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        int[] expResult = null;
        int[] result = instance.ordenarPorInsercion(datosParaClasificar);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenarPorQuickSort method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorQuickSort() {
        System.out.println("ordenarPorQuickSort");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        int[] expResult = null;
        int[] result = instance.ordenarPorQuickSort(datosParaClasificar);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenarPorHeapSort method, of class TClasificador.
     */
    @Test
    public void testOrdenarPorHeapSort() {
        System.out.println("ordenarPorHeapSort");
        int[] datosParaClasificar = null;
        TClasificador instance = new TClasificador();
        int[] expResult = null;
        int[] result = instance.ordenarPorHeapSort(datosParaClasificar);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estaOrdenado method, of class TClasificador.
     */
    @Test
    public void testEstaOrdenado() {
        System.out.println("estaOrdenado");
        int[] arr = null;
        TClasificador instance = new TClasificador();
        boolean expResult = false;
        boolean result = instance.estaOrdenado(arr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
