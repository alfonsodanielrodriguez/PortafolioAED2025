
package Alfo.clasificacion;

public class TClasificador {
	public static final int METODO_CLASIFICACION_QUICKSORT = 0;
	public static final int METODO_CLASIFICACION_INSERCION = 1;
	public static final int METODO_CLASIFICACION_SHELL = 2;
	public static final int METODO_CLASIFICACION_BURBUJA = 3;
	public static final int METODO_CLASIFICACION_HEAPSORT = 4;

	/**
	 * Punto de entrada al clasificador
	 * 
	 * @param metodoClasificacion
	 * @param orden
	 * @param tamanioVector
	 * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
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
		default:
			System.err.println("Este codigo no deberia haberse ejecutado");
			break;
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
            int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };
            
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


	/**
	 * @param datosParaClasificar
	 * @return
	 */
	protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
		if (datosParaClasificar != null) {
			for (int i = 2; i < datosParaClasificar.length; i++) {
				int j = i - 1;
				while ((j >= 0) && (datosParaClasificar[j+1] < datosParaClasificar[j])) {
					intercambiar(datosParaClasificar, j, j + 1);
					j--;
				}
			}
			return datosParaClasificar;
		}
		return null;
	}

	private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
		int n = datosParaClasificar.length -1;
		for (int i = 0; i <= n ; i++) {
			for (int j = n; j >= (i + 1); j--) {
				if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
					intercambiar(datosParaClasificar, j, j - 1);
				}
			}
		}
		return datosParaClasificar;
	}
        
        protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
		quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
		return datosParaClasificar;
	}
        
        private void quicksort(int[] entrada, int i, int j) {
		int izquierda = i;
		int derecha = j;

		int posicionPivote = encuentraPivote(izquierda,derecha,entrada);
		if (posicionPivote >= 0){ 
			int pivote = entrada[posicionPivote]; //BUSCAMOS EL PIVOTE A PARTIR DE SU POSICION  
			while (izquierda <= derecha) {
				while ((entrada[izquierda] < pivote) && (izquierda < j)) {
					izquierda++; //IZQUIERDA VA SUMANDO 
				}

				while ((pivote < entrada[derecha]) && (derecha > i)) {
					derecha--; //DERECHA RESTA
				}

				if (izquierda <= derecha) { 
					intercambiar(entrada, izquierda, derecha); //Estan desordenados
					izquierda++;
					derecha--;
				}
			}

			if (i < derecha)
				quicksort(entrada, i, derecha ); //DERECHA 
			if (izquierda < j)
				quicksort(entrada, izquierda, j); //IZQUIERDA 
		}
	}
        
        private int encuentraPivote(int izquierda, int derecha, int[] entrada){
            int medio = (izquierda + derecha)/2;
            if ((izquierda <derecha && derecha < medio) || (medio < izquierda && izquierda <derecha))
                return derecha;
            else if ((derecha <izquierda && izquierda <medio) || (medio <izquierda && izquierda <derecha))
                return izquierda;
            else
                return medio;
        }
        
        protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
		for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
			armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
		}
		for (int i = datosParaClasificar.length - 1; i  > 0; i--) {
			intercambiar(datosParaClasificar,0,i);
			armaHeap(datosParaClasificar, 0, i-1);
		}
		return datosParaClasificar;
	}

	private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
		if (primero < ultimo){
			int r = primero;
			while(r <= ultimo / 2){
				if (ultimo == 2*r){ //r tiene un hijo solo
						if (datosParaClasificar[r] < datosParaClasificar[r*2]){
							intercambiar(datosParaClasificar, r, 2 * r);
						} else {
							r = ultimo;
						}
				} else { //r tiene 2 hijos
					int posicionIntercambio = 0;
					if (datosParaClasificar[2*r] > datosParaClasificar[2*r + 1]){
						posicionIntercambio = 2 * r;
					} else {
						posicionIntercambio = 2 * r +1;
					}
					if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]){
						intercambiar(datosParaClasificar,r,posicionIntercambio);
						r = posicionIntercambio;
					} else {
						r = ultimo;
					}
				}
			}			
		}
	}

	public static void main(String args[]) {
		TClasificador clasif = new TClasificador();
		GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
		int[] vectorAleatorio = gdg.generarDatosAleatorios();
		int[] vectorAscendente = gdg.generarDatosAscendentes();
		int[] vectorDescendente = gdg.generarDatosDescendentes();

		int[] resAleatorio = clasif.clasificar(vectorAleatorio,
				METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resAleatorio.length; i++) {
			System.out.print(resAleatorio[i] + " ");
		}
		int[] resAscendente = clasif.clasificar(vectorAscendente,
				METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resAscendente.length; i++) {
			System.out.print(resAscendente[i] + " ");
		}
		int[] resDescendente = clasif.clasificar(vectorDescendente,
				METODO_CLASIFICACION_INSERCION);
		for (int i = 0; i < resDescendente.length; i++) {
			System.out.print(resDescendente[i] + " ");
		}
	}
}