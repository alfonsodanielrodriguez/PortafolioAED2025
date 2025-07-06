/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Alfo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TNodoGenericoTest {
    
    /**
     * Test of buscar method, of class TNodoGenerico.
     */
    @Test
    public void testBuscarNulo() {
        System.out.println("BUSCAR NULO:");
        TNodoGenerico instance = new TNodoGenerico("","");
        Comparable expResult = "";
        TNodoGenerico result = instance.buscar("");
        assertEquals(expResult, result.getEtiqueta());
    }
    /**
     * Test of buscar method, of class TNodoGenerico.
     */
    @Test
    public void testBuscarPrimerHijo() {
        System.out.println("BUSCAR PRIMER HIJO:");
        TNodoGenerico instance = new TNodoGenerico("","");
        instance.insertar("primer hijo", "");
        
        Comparable expResult = "primer hijo";
        TNodoGenerico result = instance.buscar("primer hijo");
        assertEquals(expResult, result.getEtiqueta());
    }
    /**
     * Test of buscar method, of class TNodoGenerico.
     */
    @Test
    public void testBuscarSiguienteHermano() {
        System.out.println("BUSCAR SIGUIENTE HERMANO:");
        TNodoGenerico instance = new TNodoGenerico("","");
        instance.insertar("primer hijo", "");
        instance.insertar("siguienteHermano", "");
        
        Comparable expResult = "siguienteHermano";
        TNodoGenerico result = instance.buscar("siguienteHermano");
        assertEquals(expResult, result.getEtiqueta());
    }

    /**
     * Test of insertar method, of class TNodoGenerico.
     */
    @Test
    public void testInsertarRaiz() {
        System.out.println("INSERTAR RAIZ:");
        TArbolGenerico instance = new TArbolGenerico();
        Comparable raizEtiqueta = "Raiz";
        Comparable etiquetaPadre = "";
        boolean result = instance.insertar(raizEtiqueta, etiquetaPadre);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertar method, of class TNodoGenerico.
     */
    @Test
    public void testInsertarPrimerHijo() {
        System.out.println("INSERTAR PRIMER HIJO:");
        TArbolGenerico instance = new TArbolGenerico();
        instance.insertar("Raiz", "");
        Comparable raizEtiqueta = "Primer hijo";
        Comparable etiquetaPadre = "Raiz";
        boolean result = instance.insertar(raizEtiqueta, etiquetaPadre);
        boolean expResult = true;
        assertEquals(expResult, result);
    }
    /**
     * Test of insertar method, of class TNodoGenerico.
     */
    @Test
    public void testInsertarSiguienteHermano() {
        System.out.println("INSERTAR SIGUIENTE HERMANO:");
        TArbolGenerico instance = new TArbolGenerico();
        instance.insertar("Raiz", "");
        instance.insertar("Primer hijo", "Raiz");
        
        Comparable raizEtiqueta = "Siguiente Hermano";
        Comparable etiquetaPadre = "Raiz";
        boolean result = instance.insertar(raizEtiqueta, etiquetaPadre);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    /**
     * Test of listarIndentado method, of class TNodoGenerico.
     */
    @Test
    public void testListarIndentadoRaiz() {
        System.out.println("listarIndentado raiz");
        int valor = 0;
        TNodoGenerico instance = new TNodoGenerico("raiz", "");
        String expResult = "raiz\n";
        String result = instance.listarIndentado(valor);
        assertEquals(expResult, result);
    }
    /**
     * Test of listarIndentado method, of class TNodoGenerico.
     */
    @Test
    public void testListarIndentadoPrimerHijo() {
        System.out.println("listarIndentado primer hijo");
        int valor = 0;
        TNodoGenerico instance = new TNodoGenerico("raiz", "");
        instance.insertar("Primer hijo", "raiz");
        String expResult = "raiz\n\tPrimer hijo\n";
        String result = instance.listarIndentado(valor);
        assertEquals(expResult, result);
    }
    /**
     * Test of listarIndentado method, of class TNodoGenerico.
     */
    @Test
    public void testListarIndentadoSiguienteHermano() {
        System.out.println("listarIndentado siguiente hijo");
        int valor = 0;
        TNodoGenerico instance = new TNodoGenerico("raiz", "");
        instance.insertar("Primer hijo", "raiz");
        instance.insertar("Siguiente hermano", "raiz");
        String expResult = "raiz\n\tPrimer hijo\n\tSiguiente hermano\n";
        String result = instance.listarIndentado(valor);
        assertEquals(expResult, result);
    }
}
