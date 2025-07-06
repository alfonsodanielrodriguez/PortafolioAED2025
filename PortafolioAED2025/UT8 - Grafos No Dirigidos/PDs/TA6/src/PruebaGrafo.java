
import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoNoDirigido gnd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("src/vert2.txt", "src/ari2.txt",
                false, TGrafoNoDirigido.class);

        TGrafoNoDirigido grafoPrim = gnd.Prim();
        System.out.println("cantidad de vertices del grafo por prim:" + grafoPrim.getVertices().size());

        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoPrim.getVertices()), grafoPrim.getVertices(), "Matriz de costos Prim");

        LinkedList<TArista> aristasPrim = gnd.PrimAristas();
        double costoTotal = 0;
        for (TArista arista : aristasPrim) {
            System.out.println(arista.getEtiquetaOrigen() + " --> " + arista.getEtiquetaDestino() + ". Costo: " + arista.getCosto());
            costoTotal += arista.getCosto();
        }
        System.out.println("El costo total del árbol de Prim es: " + costoTotal);
        /*
        mostrar las aristas del AAM por Prim y el costo total
         */

        TGrafoNoDirigido grafoKruskal = gnd.Kruskal();
        System.out.println("cantidad de vertices del grafo por kruskal:" + grafoKruskal.getVertices().size());

        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoKruskal.getVertices()), grafoKruskal.getVertices(), "Matriz de costos Kruskal");
        LinkedList<TArista> aristasKruskal = gnd.PrimAristas();
        costoTotal = 0;
        for (TArista arista : aristasKruskal) {
            System.out.println(arista.getEtiquetaOrigen() + " --> " + arista.getEtiquetaDestino() + ". Costo: " + arista.getCosto());
            costoTotal += arista.getCosto();
        }
        System.out.println("El costo total del árbol de Prim es: " + costoTotal);

        /*
        mostrar las aristas del AAM por Kruskal y el costo total
         */
    }
}
