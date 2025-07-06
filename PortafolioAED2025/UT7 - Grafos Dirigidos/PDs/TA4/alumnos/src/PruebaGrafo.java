
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_1.txt", "./src/conexiones_1.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
//        Double[][] mfloyd = gd.floyd();
//        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
//        for (int i = 0; i < etiquetasarray.length; i++) {
//            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
//        }
//        System.out.println();
//        System.out.println("Centro del grafo: " + gd.centroDelGrafo());

        Collection<TVertice> recorrido = gd.bpf();
        System.out.println("BPF:");
        StringBuilder camino = new StringBuilder();
        // imprimir etiquetas del bpf de todo el grafo....
        recorrido.forEach((vertice) -> {
            camino.append(vertice.getEtiqueta()).append(", ");
        });
        System.out.println(camino.toString());
        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        // imprimir etiquetas del bpf desde Asunción....
        StringBuilder caminoAsuncion = new StringBuilder();
        recorrido_Asuncion.forEach((vertice) -> {
            caminoAsuncion.append(vertice.getEtiqueta()).append(", ");
        });
        System.out.println("\nRecorrido desde Asuncion:");
        System.out.println("\t" + caminoAsuncion.toString());

    }
}
