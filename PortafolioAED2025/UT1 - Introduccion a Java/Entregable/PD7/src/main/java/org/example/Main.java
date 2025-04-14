package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 del UT1_TA7 ");

        String s = "1";
        while (s != "1000") {
            s += "0";

        /*
        El mismo representa un bucle infinito ya que la comparación con el operador == entre el objeto s y el
        literal “1000” jamás devuelve True.
        ● ¿Por qué esto es así? ¿Qué diferencia representa con otros lenguajes como C#?

        Respuesta = En Java, el operador == compara las referencias de los objetos, no los valores de los objetos.
        En C#, el operador == compara los valores de los objetos, no las referencias de los objetos.
        En este caso del codigo de ejemplo, el bucle es infinito porque la comparación con el operador == entre el
        objeto s y el literal “1000” no devuelve True.
         */


            System.out.println("Ejercicio 2 ");

            String s1 = "Hola";
            String s2 = "Hola";
            if (s1 == s2) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }

            String s3 = new String("Hola");
            String s4 = "Hola";
            if (s3 == s4) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
/*
        ● ¿Qué sentencia se ejecuta como resultado del If en cada caso y por qué? Busca en internet
        referencias que te permitan explicar las respuestas a las preguntas anteriores. Asegúrate que
        las mismas sean autoritativas y cítalas adecuadamente en tu respuesta.

        ● Propone una versión correcta del código del Ejercicio #1.

        Respuesta = En el primer caso, la sentencia que se ejecuta es True, porque las cadenas de texto son iguales y
        se encuentran en la misma ubicación. En el segundo caso, la sentencia que se ejecuta es False, porque
        las cadenas de texto son iguales pero se encuentran en diferentes ubicaciones.
        Para corregir el código del Ejercicio #1, se puede utilizar el método intern() de la clase String, que devuelve
        una referencia a la cadena de texto que se encuentra en la memoria. De esta forma, se puede comparar las cadenas
        de texto de forma correcta.
         */


            System.out.println("Versión corregida.");
            String s8 = "1";
            String target = "1000".intern();

            while (s8 != target) {
                s8 += "0";
                s8 = s8.intern();
            }
            System.out.println(s8);
        }
    }
}