package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Marcapaso UCU");
        Marcapaso marcapasos = new Marcapaso( 14,  120, 800,
                2000000000, 0.8f, 0.500, "12A5w6W6".toCharArray());
        marcapasos.DetallesMarcapaso();
        /*
            short presionSanguinea: 2 bytes
            short frecuenciaCardiaca: 2 bytes
            int nivelAzucar: 4 bytes
            long maximaFuerza: 8 bytes
            float minimoTiempoEntreLatidos: 4 bytes
            double bateriaRestante: 8 bytes
            char[] codigoFabricante: 8 * 2 bytes = 16 bytes (cada char ocupa 2 bytes)
            TOTAL DE MEMORIA: 44 bytes
         */
    }
}
