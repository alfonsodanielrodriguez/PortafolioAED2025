package Alfo;


import java.util.Random;

public class GeneradorDatosGenericos {
    private static final int TAMANIO_MAX = 32000;
    
    /*
    private static int TAMANIO_MAX = 32000;
    public void setTamMax(int valor){
        this.TAMANIO_MAX = valor;
    }
    */
    
    public int[] generarDatosAleatorios() {
        Random rnd = new Random();
        int[] datosGenerados = new int[TAMANIO_MAX];
        boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(TAMANIO_MAX);
            while(datosUtilizados[j]){
                j = (j + 1) % TAMANIO_MAX;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    public int[] generarDatosAscendentes() {
        int [] copiaAscendente = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
    }

    public int[] generarDatosDescendentes() {
        int [] copiaDescendente = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaDescendente[i] = TAMANIO_MAX - i;
        }
        return copiaDescendente;
    }

    public int[] generarDatosAleatorios(int t) {
        Random rnd = new Random();
        int[] datosGenerados = new int[t];
        boolean[] datosUtilizados = new boolean[t];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(t);
            while(datosUtilizados[j]){
                j = (j + 1) % t;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    public int[] generarDatosAscendentes(int t) {
        int [] copiaAscendente = new int[t];
        for (int i = 0; i < t; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
    }

    public int[] generarDatosDescendentes(int t) {
        int [] copiaDescendente = new int[t];
        for (int i = 0; i < t; i++) {
            copiaDescendente[i] = t - i;
        }
        return copiaDescendente;
    }

}
