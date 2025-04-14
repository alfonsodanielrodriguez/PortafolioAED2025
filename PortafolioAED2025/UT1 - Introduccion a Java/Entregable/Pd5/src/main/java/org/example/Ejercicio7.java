package org.example;

public class Ejercicio7 {
    public void Ejercicio7(){
        System.out.println("Ejemplo de Constructores:");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("Hello");
        StringBuilder sb3 = new StringBuilder(50);

        System.out.println("sb1: " + sb1); // Salida: (vacío)
        System.out.println("sb2: " + sb2); // Salida: Hello
        System.out.println("sb3 capacity: " + sb3.capacity()); // Salida: 50 (o mayor si el valor predeterminado es diferente)

        // Ejemplo de setLength
        System.out.println("\nEjemplo de setLength:");
        StringBuilder sb4 = new StringBuilder("Hello, World!");
        sb4.setLength(5);
        System.out.println(sb4); // Salida: Hello

        sb4.setLength(10);
        System.out.println(sb4); // Salida: Hello (con caracteres nulos añadidos al final)

        // Ejemplo de ensureCapacity
        System.out.println("\nEjemplo de ensureCapacity:");
        StringBuilder sb5 = new StringBuilder();
        System.out.println("Capacidad Inicial: " + sb5.capacity()); // Salida: 16 (o el valor predeterminado)

        sb5.ensureCapacity(100);
        System.out.println("Capacidad despues del ensureCapacity: " + sb5.capacity()); // Salida: 100 (o mayor)

        // Ejemplo de append
        System.out.println("\nEjemplo de append:");
        StringBuilder sb6 = new StringBuilder("Hello");
        sb6.append(", World!");
        System.out.println(sb6); // Salida: Hello, World!

        // Ejemplo de insert
        System.out.println("\nEjemplo de insert:");
        StringBuilder sb7 = new StringBuilder("Hello World!");
        sb7.insert(6, "Java ");
        System.out.println(sb7); // Salida: Hello Java World!

        // Ejemplo de delete
        System.out.println("\nEjemplo de delete:");
        StringBuilder sb8 = new StringBuilder("Hello, Java World!");
        sb8.delete(6, 11);
        System.out.println(sb8); // Salida: Hello, World!

        // Ejemplo de deleteCharAt
        System.out.println("\nEjemplo de deleteCharAt:");
        StringBuilder sb9 = new StringBuilder("Hello, Java World!");
        sb9.deleteCharAt(6);
        System.out.println(sb9); // Salida: Hello, ava World!

        // Ejemplo de reverse
        System.out.println("\nEjemplo de reverse:");
        StringBuilder sb10 = new StringBuilder("Hello, World!");
        sb10.reverse();
        System.out.println(sb10); // Salida: !dlroW ,olleH
    }
}
