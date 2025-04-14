package org.example;

public class Ejercicio6 {
    public void Ejercicio6(){
        
        System.out.println("Ejemplo de substring:");
        String s1 = "Hello, World!";
        System.out.println(s1.substring(7));           // Salida: World!
        System.out.println(s1.substring(0, 5));                 // Salida: Hello

        System.out.println("\nEjemplo de split:");
        String s2 = "banana,uva,pera";
        String[] fruits = s2.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // Limite
        String s3 = "one|dos|three|cuatro";
        String[] limited = s3.split("\\|", 3);
        for (String item : limited) {
            System.out.println(item);
        }

        System.out.println("\nEjemplo de subSequence:");
        CharSequence cs = s1.subSequence(7, 12);
        System.out.println(cs);  // Salida: World

        System.out.println("\nEjemplo de trim:");
        String s4 = "   Hello, World!   ";
        System.out.println("[" + s4.trim() + "]");                      // Salida: [Hello, World!]

        System.out.println("\nEjemplo de toLowerCase:");
        System.out.println(s1.toLowerCase());                           // Salida: hello, world!

        System.out.println("\nEjemplo de toUpperCase:");
        System.out.println(s1.toUpperCase());                           // Salida: HELLO, WORLD!

        System.out.println("\nEjemplo de indexOf:");
        System.out.println(s1.indexOf('W'));                            // Salida: 7
        System.out.println(s1.indexOf("World"));                        // Salida: 7
        System.out.println(s1.indexOf('o', 5));           // Salida: 8
        System.out.println(s1.indexOf("World", 8));      // Salida: -1

        System.out.println("\nEjemplo de lastIndexOf:");
        String s5 = "Hello, World! World!";
        System.out.println(s5.lastIndexOf('W'));                    // Salida: 14
        System.out.println(s5.lastIndexOf("World"));                // Salida: 14
        System.out.println(s5.lastIndexOf('o', 10));         // Salida: 8
        System.out.println(s5.lastIndexOf("World", 10));     // Salida: 7

        System.out.println("\nEjemplo de contains:");
        System.out.println(s1.contains("World"));                           // Salida: true
        System.out.println(s1.contains("world"));                           // Salida: false

        System.out.println("\nEjemplo de replace:");
        System.out.println(s1.replace('o', 'a'));               // Salida: Hella, Warld!
        System.out.println(s1.replace("World", "Java"));       // Salida: Hello, Java!

        System.out.println("\nEjemplo de replaceAll:");
        String s6 = "abc123abc";
        System.out.println(s6.replaceAll("\\d", "#"));       // Salida: abc###abc
        System.out.println(s6.replaceAll("abc", "xyz"));     // Salida: xyz123xyz

        System.out.println("\nEjemplo de replaceFirst:");
        System.out.println(s6.replaceFirst("\\d", "#"));    // Salida: abc#23abc
        System.out.println(s6.replaceFirst("abc", "xyz"));  // Salida: xyz123abc
    }
}


