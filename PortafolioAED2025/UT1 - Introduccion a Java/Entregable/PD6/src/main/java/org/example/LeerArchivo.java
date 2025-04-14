package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LeerArchivo {
    static Map<String, Integer> mapArchivo = new HashMap<>();
    public void leerEntradaArchivo(String path) {
        int contador = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Si la línea ya existe en el mapa, incrementa el contador
                if (mapArchivo.containsKey(line)) {
                    mapArchivo.put(line, mapArchivo.get(line) + 1);
                } else {
                    // Si la línea no existe en el mapa, la agrega con un contador de 1
                    mapArchivo.put(line, contador);
                    contador++;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> entry : mapArchivo.entrySet()) {
            System.out.println("Línea: '" + entry.getValue() + "' - Contenido : " + entry.getKey());
        }
    }

    public static void Ejercicio2() {
        int entero = 0;
        double puntoFlotante = 0.0;
        String cadena = "";

        for (String key : mapArchivo.keySet()) {
            // Aquí podrías querer mapear las claves a sus valores adecuados
            if (key.matches("\\d+")) {  // Comprobación de número entero
                entero = Integer.parseInt(key);
            } else if (key.matches("\\d+\\.\\d+")) { // Comprobación de número de punto flotante
                puntoFlotante = Double.parseDouble(key);
            } else {
                cadena = key;
            }
        }
        double suma = entero + puntoFlotante;
        int divisionEntera = (int) (puntoFlotante / entero);
        double resto = puntoFlotante % entero;

        System.out.println("El entero leído es: " + entero);
        System.out.println("El número de punto flotante es: " + puntoFlotante);
        System.out.println("La cadena leída es \"" + cadena + "\"");
        System.out.println("¡Hola " + cadena + "! La suma de " + entero + " y " + puntoFlotante + " es " + suma + ".");
        System.out.println("La división entera de " + puntoFlotante + " y " + entero + " es " + divisionEntera + " y su resto es " + resto + ".");

    }

}