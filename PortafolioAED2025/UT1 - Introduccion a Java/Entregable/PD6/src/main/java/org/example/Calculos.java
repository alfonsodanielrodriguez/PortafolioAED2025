package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculos {
    List<Double> medidas = new ArrayList<>();
    public void leerArchivoMedidas (String path){
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // eliminar espacios en blanco al principio y final
                if (!line.isEmpty()) {
                    try {
                        medidas.add(Double.parseDouble(line));
                    } catch (NumberFormatException e) {
                        System.out.println("Línea inválida: '" + line + "'");
                        // Puedes ignorar, registrar o detener el programa según lo que necesites
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void Area(){
        for(double RADIO : medidas){
            System.out.println("El area de la circunferencia es: " + Math.PI * Math.pow(RADIO, 2));
        }
    }

    public void Perimetro(){
        for(double RADIO : medidas){
            System.out.println("El perimetro de la circunferencia es: " + 2 * Math.PI * RADIO);
        }
    }
}