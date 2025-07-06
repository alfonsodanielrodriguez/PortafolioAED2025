//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package uy.edu.ucu.aed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class  ManejadorArchivos{
    public ManejadorArchivos() {
    }

    public static void escribirArchivo(String nombreCompletoArchivo, String[] listaLineasArchivo) {
        try {
            FileWriter fw = new FileWriter(nombreCompletoArchivo, true);

            try {
                BufferedWriter bw = new BufferedWriter(fw);

                try {
                    String[] var4 = listaLineasArchivo;
                    int var5 = listaLineasArchivo.length;

                    for(int var6 = 0; var6 < var5; ++var6) {
                        String lineaActual = var4[var6];
                        bw.write(lineaActual);
                        bw.newLine();
                    }
                } catch (Throwable var10) {
                    try {
                        bw.close();
                    } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                    }

                    throw var10;
                }

                bw.close();
            } catch (Throwable var11) {
                try {
                    fw.close();
                } catch (Throwable var8) {
                    var11.addSuppressed(var8);
                }

                throw var11;
            }

            fw.close();
        } catch (IOException var12) {
            IOException e = var12;
            System.out.println("Error al escribir el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }

    }

    public static String[] leerArchivo(String nombreCompletoArchivo) {
        ArrayList<String> listaLineasArchivo = new ArrayList();

        try {
            FileReader fr = new FileReader(nombreCompletoArchivo);

            try {
                BufferedReader br = new BufferedReader(fr);

                String lineaActual;
                try {
                    while((lineaActual = br.readLine()) != null) {
                        listaLineasArchivo.add(lineaActual);
                    }
                } catch (Throwable var8) {
                    try {
                        br.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }

                    throw var8;
                }

                br.close();
            } catch (Throwable var9) {
                try {
                    fr.close();
                } catch (Throwable var6) {
                    var9.addSuppressed(var6);
                }

                throw var9;
            }

            fr.close();
        } catch (FileNotFoundException var10) {
            FileNotFoundException e = var10;
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException var11) {
            IOException e = var11;
            System.out.println("Error al leer el archivo " + nombreCompletoArchivo);
            e.printStackTrace();
        }

        System.out.println("Archivo leído satisfactoriamente");
        return (String[])listaLineasArchivo.toArray(new String[0]);
    }
}
