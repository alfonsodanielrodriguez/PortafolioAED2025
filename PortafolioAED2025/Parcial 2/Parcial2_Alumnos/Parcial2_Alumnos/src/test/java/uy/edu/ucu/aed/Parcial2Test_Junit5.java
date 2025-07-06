package uy.edu.ucu.aed;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import uy.edu.ucu.aed.modelo.*;
import java.util.List;

/**
 * Tests completos para el sistema de transporte.
 * Valida la funcionalidad de ciudades, carreteras, camiones y cálculo de rutas.
 */
public class Parcial2Test_Junit5
{
    @BeforeEach
    public void setUp() {
        System.out.println("Here you can use this method to initialize the system before each test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Here you can ue this method to clean up after each test");
    }

    @Test
    public void test_Sample() {
        // Given
        System.out.println("You should setup the specific test case here");
        
        // When
        System.out.println("You should execute the specific method under test here");
        
        // Then
        System.out.println("You should assert the expected results here");
        fail("This test is not implemented yet");
    }
}
