
public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_1.txt", "./src/conexiones_1.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
//        for (int i = 0; i < etiquetasarray.length; i++) {
//            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
//        }
//        System.out.println();
//        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
        
        String ciudadOrigen = "Asuncion";
        String ciudadDestino = "Santos";
        boolean existeConexion = gd.obtenerConectividad(ciudadOrigen, ciudadDestino);
        String respuesta = existeConexion ? "Si" : "No";
        System.out.println("¿Es posible volar desde " + ciudadOrigen + " a " + ciudadDestino + "?: " + respuesta);
        
        ciudadOrigen = "Santos";
        ciudadDestino = "Paraguay";
        existeConexion = gd.obtenerConectividad(ciudadOrigen, ciudadDestino);
        respuesta = existeConexion ? "Si" : "No";
        System.out.println("¿Es posible volar desde " + ciudadOrigen + " a " + ciudadDestino + "?: " + respuesta);
    }
}
