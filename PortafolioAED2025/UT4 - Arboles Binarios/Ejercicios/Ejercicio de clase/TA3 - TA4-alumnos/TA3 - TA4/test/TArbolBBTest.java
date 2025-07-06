/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author belu_
 */
public class TArbolBBTest {
    
    public TArbolBBTest() {
    }
    
    /**
     * Test of obtenerTamanio method, of class TArbolBB. For 0
     */
    @Test
    public void testObtenerTamanio0() {
        System.out.println("obtenerTamanio 0");
        TArbolBB instance = new TArbolBB();
        int expResult = 0;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);

    }
    
        /**
     * Test of obtenerTamanio method, of class TArbolBB. For 1
     */
    @Test
    public void testObtenerTamanio1() {
        System.out.println("obtenerTamanio 1");
        TArbolBB instance = new TArbolBB();
        instance.insertar(new TElementoAB(1,1));
        int expResult = 1;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);
    }
    
        /**
     * Test of obtenerTamanio method, of class TArbolBB. For 2
     */
    @Test
    public void testObtenerTamanio2() {
        System.out.println("obtenerTamanio 2");
        TArbolBB instance = new TArbolBB();
        instance.insertar(new TElementoAB(1,1));
        instance.insertar(new TElementoAB(2,2));
        int expResult = 2;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);
    }
    
        /**
     * Test of obtenerTamanio method, of class TArbolBB. For 3.
     */
    @Test
    public void testObtenerTamanio3() {
        System.out.println("obtenerTamanio");
        TArbolBB instance = new TArbolBB();
        instance.insertar(new TElementoAB(1,1));
        instance.insertar(new TElementoAB(2,2));
        instance.insertar(new TElementoAB(3,3));
        int expResult = 3;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);

    }
/**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void AlturaVacioTest() {
        System.out.println("obtenerAltura - VacioTest");
        TArbolBB instance = new TArbolBB();
        int expResult = -1;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void AlturaUnElementoTest() {
        System.out.println("obtenerAltura - VacioTest");
        TArbolBB instance = new TArbolBB();
        TElementoAB uno = new TElementoAB(1,1);
        instance.insertar(uno);
        int expResult = 0;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void AlturaDosElementosTest() {
        System.out.println("obtenerAltura - VacioTest");
        TArbolBB instance = new TArbolBB();
        TElementoAB uno = new TElementoAB(1,1);
        instance.insertar(uno);
        TElementoAB dos = new TElementoAB(2,2);
        instance.insertar(dos);
        int expResult = 1;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void AlturaDosHermanosTest() {
        System.out.println("obtenerAltura - VacioTest");
        TArbolBB instance = new TArbolBB();
        TElementoAB dos = new TElementoAB(2,2);
        instance.insertar(dos);
        TElementoAB uno = new TElementoAB(1,1);
        instance.insertar(uno);
        TElementoAB tres = new TElementoAB(3,3);
        instance.insertar(tres);
        int expResult = 1;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of obtenerAltura method, of class TArbolBB.
     */
    @Test
    public void AlturaEnLineaTest() {
        System.out.println("obtenerAltura - VacioTest");
        TArbolBB instance = new TArbolBB();
        TElementoAB uno = new TElementoAB(1,1);
        instance.insertar(uno);
        TElementoAB dos = new TElementoAB(2,2);
        instance.insertar(dos);
        TElementoAB tres = new TElementoAB(3,3);
        instance.insertar(tres);
        int expResult = 2;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
    }
}