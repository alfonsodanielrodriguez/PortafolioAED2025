
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // cargar grafo con casas y distancias
        TGrafoRedElectrica laRed = (TGrafoRedElectrica) UtilGrafos.cargarGrafo("src/barrio.txt", "src/distancias.txt",
                false, TGrafoRedElectrica.class);

        /*
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
         */
        
        //Solucion utilizando Prim
        
        TAristas mejorRedPrim = laRed.mejorRedElectrica();

        String[] result = new String[mejorRedPrim.size() + 1];
        int i = 0;
        double costoTotal = 0;

        for (TArista tArista : mejorRedPrim) {
            result[i] = tArista.getEtiquetaOrigen() + " --> " + tArista.getEtiquetaDestino() + ". Costo: " + tArista.getCosto();
            i++;
            costoTotal += tArista.getCosto();
        }

        result[i] = "El costo total de la red es: " + costoTotal;

        ManejadorArchivosGenerico.escribirArchivo("src/redElectricaPrim.txt", result);

        //Solucion utilizando Kruskal
        
        TAristas mejorRedKruskal = laRed.mejorRedElectricaKruskal();

        String[] resultKruskal = new String[mejorRedKruskal.size() + 1];
        int k = 0;
        double costoTotalK = 0;

        for (TArista tArista : mejorRedKruskal) {
            resultKruskal[k] = tArista.getEtiquetaOrigen() + " --> " + tArista.getEtiquetaDestino() + ". Costo: " + tArista.getCosto();
            k++;
            costoTotalK += tArista.getCosto();
        }

        resultKruskal[k] = "El costo total de la red es: " + costoTotalK;

        ManejadorArchivosGenerico.escribirArchivo("src/redElectricaKruskal.txt", resultKruskal);

    }
}
