package ut9_ta4;

import java.util.Arrays;
import java.util.Random;

public class TClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_HEAPSORT = 5;
    public static final int METODO_CLASIFICACION_SELECCION = 6;

    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
                return ordenarPorHeapSort(datosParaClasificar);
            case METODO_CLASIFICACION_SELECCION:
                return ordenarPorSeleccionDirecta(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
        }
        return datosParaClasificar;
    }
    
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION -> {
                if (cascara) {
                    return ordenarPorInsercionCascara(datosParaClasificar);
                } else {
                    return ordenarPorInsercion(datosParaClasificar);
                }
            }
            case METODO_CLASIFICACION_SHELL -> {
                if (cascara) {
                    return ordenarPorShellCascara(datosParaClasificar);
                } else {
                    return ordenarPorShell(datosParaClasificar);
                }
            }
            case METODO_CLASIFICACION_BURBUJA -> {
                if (cascara) {
                    return ordenarPorBurbujaCascara(datosParaClasificar);
                } else {
                    return ordenarPorBurbuja(datosParaClasificar);
                }
            }
            case METODO_CLASIFICACION_QUICKSORT -> {
                if (cascara) {
                    return ordenarPorQuickSortCascara(datosParaClasificar);
                } else {
                    return ordenarPorQuickSort(datosParaClasificar);
                }
            }
            case METODO_CLASIFICACION_HEAPSORT -> {
                if (cascara) {
                    return ordenarPorHeapSortCascara(datosParaClasificar);
                } else {
                    return ordenarPorHeapSort(datosParaClasificar);
                }
            }
            case METODO_CLASIFICACION_SELECCION -> {
                if (cascara) {
                    return ordenarPorSeleccionDirectaCascara(datosParaClasificar);
                } else {
                    return ordenarPorSeleccionDirecta(datosParaClasificar);
                }
            }
            default -> {
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
            }
        }
        return datosParaClasificar;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    while (j >= 0) {
                        if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                        }
                        j = j - inc;
                    }
                }
            }
        }
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorShellCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j + 1, j);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }
    
    protected int[] ordenarPorInsercionCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorBurbujaCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    public boolean estaOrdenado(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            if (vector[i] >= vector[i + 1]) {
                return false;
            }
        }
        return true;
    }

    protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
        quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }
    
    public int ordenarPorQuickSortAltura(int[] datosParaClasificar) {
        int altura = quicksortAltura(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return altura;
    }
    
    protected int[] ordenarPorQuickSortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }
 
    private void quicksort(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        int posicionPivote = encuentraPivote(izquierda, derecha, entrada);
        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    // L se mueve a la derecha
                    izquierda++;
                }

                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    // R se mueve a la izquierda
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, derecha, izquierda);
                    izquierda++;
                    derecha--;
                }
            }

            if (i < derecha) {
                quicksort(entrada, i, derecha);
            }
            if (izquierda < j) {
                quicksort(entrada, izquierda, j);
            }
        }
    }

    
    private int quicksortAltura(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;

        int posicionPivote = encuentraPivote(izquierda, derecha, entrada);
        if (posicionPivote >= 0) {
            // El pivote es el elemento de la entrada cuyo índice es "posicionPivote".
            int pivote = entrada[posicionPivote];
            while (izquierda <= derecha) {
                while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                    // L debe moverse a la derecha.
                    izquierda++;
                }

                while ((pivote < entrada[derecha]) && (derecha > i)) {
                    // R debe moverse a la izquierda.
                    derecha--;
                }

                if (izquierda <= derecha) {
                    intercambiar(entrada, derecha, izquierda);
                    izquierda++;
                    derecha--;
                }
            }

            int maxAltura = 0;

            // Un tercer error relacionado con las llamadas recursivas,
            // respecto a los límites de los subarreglos.
            if (i < derecha) {
                // derecha es el fin del subvector izquierdo.
                int alturaIzquierda = quicksortAltura(entrada, i, derecha);
                if (maxAltura < alturaIzquierda) {
                    maxAltura = alturaIzquierda;
                }
            }
            if (izquierda < j) {
                // izquierda es el fin del subvector derecho.
                int alturaDerecha = quicksortAltura(entrada, izquierda, j);
                if (maxAltura < alturaDerecha) {
                    maxAltura = alturaDerecha;
                }
            }

            return maxAltura + 1;
        }
        return 0;
    }
    
    
    private int encuentraPivote(int izquierda, int derecha, int[] entrada) {
        int medio = (izquierda + derecha) / 2;
        if ((izquierda < derecha && derecha < medio) || (medio < izquierda && izquierda > derecha)) {
            return derecha;
        } else if ((derecha < izquierda && izquierda < medio) || (medio < izquierda && izquierda < derecha)) {
            return izquierda;
        } else {
            return medio;
        }
    }
    
    private int encuentraPivoteRandom(int primero, int ultimo) {
        Random random = new Random();
        return random.nextInt(primero, ultimo);
    }
    
    private int encuentraPivotePromedio(int[] entrada) {
        int sumaTotal = 0;
        for (int numero : entrada) {
            sumaTotal += numero;
        }
        return sumaTotal / entrada.length;
    }

    protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
            armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        for (int i = datosParaClasificar.length - 1; i > 0; i--) {
            intercambiar(datosParaClasificar, 0, i);
            armaHeap(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorHeapSortCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }

    private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) { //r tiene un hijo solo
                    if (datosParaClasificar[r] < datosParaClasificar[r * 2]) {
                        intercambiar(datosParaClasificar, r, 2 * r);
                        // r = 2;
                    } else {
                        r = ultimo;
                    }
                } else { //r tiene 2 hijos
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * r] > datosParaClasificar[2 * r + 1]) {
                        posicionIntercambio = 2 * r;
                    } else {
                        posicionIntercambio = 2 * r + 1;
                    }
                    if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]) {
                        intercambiar(datosParaClasificar, r, posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }
    
    protected int[] ordenarPorSeleccionDirecta(int[] datosParaClasificar) {
        seleccionDirecta(datosParaClasificar);
        return datosParaClasificar;
    }
    
    protected int[] ordenarPorSeleccionDirectaCascara(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
        }
        return null;
    }
    
    private void seleccionDirecta(int[] datosParaClasificar) {
        for (int i = 0; i < datosParaClasificar.length - 1; i++) {
            int indiceDelMenor = i;
            for (int j = i + 1; j < datosParaClasificar.length; j++) {
                if (datosParaClasificar[j] < datosParaClasificar[indiceDelMenor]) {
                    indiceDelMenor = j;
                }
            }
            intercambiar(datosParaClasificar, i, indiceDelMenor);
        }
    }

    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos(50);
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

        /*int[] resAleatorio = clasif.clasificar(vectorAleatorio,
                METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio.length; i++) {
            System.out.print(resAleatorio[i] + " ");
        }
         */
//        int[] resQui = clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_QUICKSORT);
//        for (int i = 0; i < resQui.length; i++) {
//            System.out.print(resQui[i] + " ");
//        }
        /*int[] resAscendente = clasif.clasificar(vectorAscendente,
				METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resAscendente.length; i++) {
			System.out.print(resAscendente[i] + " ");
		}
		int[] resDescendente = clasif.clasificar(vectorDescendente,
				METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resDescendente.length; i++) {
			System.out.print(resDescendente[i] + " ");
		}*/
        int[] prueba = {256, 458, 365, 298, 043, 648};

        long inicial = System.nanoTime();
        clasif.clasificar(vectorAleatorio, METODO_CLASIFICACION_HEAPSORT);
        long vFinal = System.nanoTime();

        System.out.println(vFinal - inicial);

        inicial = System.nanoTime();
        clasif.clasificar(vectorAscendente, METODO_CLASIFICACION_HEAPSORT);
        vFinal = System.nanoTime();

        System.out.println(vFinal - inicial);

        inicial = System.nanoTime();
        clasif.clasificar(vectorDescendente, METODO_CLASIFICACION_HEAPSORT);
        vFinal = System.nanoTime();

        System.out.println(vFinal - inicial);

        //System.out.println(Arrays.toString(prueba));
    }
}
