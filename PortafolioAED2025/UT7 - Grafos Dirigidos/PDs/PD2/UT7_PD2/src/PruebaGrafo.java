
public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_1.txt", "./src/conexiones_1.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println("\nCentro del grafo: " + gd.centroDelGrafo());

        // EJERCICIO 1:
        TGrafoDirigido grafoDirigido = UtilGrafos.cargarGrafo("src/ciudades.txt", "src/conexionesCiudades.txt", true, TGrafoDirigido.class);
        Double[][] matrizGrafoDirigido = UtilGrafos.obtenerMatrizCostos(grafoDirigido.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizGrafoDirigido, grafoDirigido.getVertices(), "Matriz");
        
        // EJERCICIO 2:
        Double[][] floydGrafoDirigido = grafoDirigido.floyd();
        UtilGrafos.imprimirMatrizMejorado(floydGrafoDirigido, grafoDirigido.getVertices(), "Matriz luego de FLOYD");
        
        // EJERCICIO 3:
        Object[] etiquetasGrafoDirigido = grafoDirigido.getEtiquetasOrdenado();
        for (Object object : etiquetasGrafoDirigido) {
            System.out.println("Excentricidad de: " + object + " : " + grafoDirigido.obtenerExcentricidad((Comparable) object));
        }
        System.out.println("\nCentro del grafo: " + grafoDirigido.centroDelGrafo());
    }
}
