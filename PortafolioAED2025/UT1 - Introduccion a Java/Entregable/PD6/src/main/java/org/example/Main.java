package org.example;
public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 ");
        Tablero tablero = new Tablero();
        tablero.Imprimirtablero(5, 5);

        Calculos calcular = new Calculos();
        String path = "C:\\Users\\alfon\\Desktop\\PortafolioAED2025\\UTA\\PD6\\src\\main\\java\\org\\example\\medidas.txt";
        calcular.leerArchivoMedidas(path);
        calcular.Area();
        calcular.Perimetro();

        LeerArchivo leerarchivos = new LeerArchivo();
        String path1 ="C:\\Users\\alfon\\Desktop\\PortafolioAED2025\\UTA\\PD6\\src\\main\\java\\org\\example\\archivo.txt";
        leerarchivos.leerEntradaArchivo(path1);
        leerarchivos.Ejercicio2();

    }
}