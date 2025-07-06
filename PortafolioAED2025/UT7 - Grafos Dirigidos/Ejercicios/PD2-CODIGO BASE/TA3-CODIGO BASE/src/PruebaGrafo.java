public class PruebaGrafo {

    public static void main(String[] args) {
       /* TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_1.txt","./src/conexiones_1.txt",
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
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());*/
        
        /*  EJERCICIO PD2  */
        
        TGrafoDirigido grafoUruguay=(TGrafoDirigido) UtilGrafos.cargarGrafo("C:\\Users\\alfon\\Desktop\\portafolio-alfonsodanielrodriguez\\Unidad Tematica 7\\Ejercicios\\PD2-CODIGO BASE\\TA3-CODIGO BASE\\src\\PD2Vertices.txt", "C:\\Users\\alfon\\Desktop\\portafolio-alfonsodanielrodriguez\\Unidad Tematica 7\\Ejercicios\\PD2-CODIGO BASE\\TA3-CODIGO BASE\\src\\PDConexiones.txt", false, TGrafoDirigido.class);
        //Object[] etiquetas =grafoUruguay.getEtiquetasOrdenado(); 
        Double[][] matrizUruguay= UtilGrafos.obtenerMatrizCostos(grafoUruguay.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizUruguay, grafoUruguay.getVertices(), "Matriz Uruguay");
        Double[][] mFloyd= grafoUruguay.floyd(); 
        UtilGrafos.imprimirMatrizMejorado(mFloyd, grafoUruguay.getVertices(), "Matriz despues de Floyd");
        Object[] etiquetasarray = grafoUruguay.getEtiquetasOrdenado();
        
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("Excentricidad de " + etiquetasarray[i] + " : " + grafoUruguay.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println(grafoUruguay.centroDelGrafo());
        
        /*  EJERCICIO PD3  */
        
        
        TGrafoDirigido grafoInternacional = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos.txt", "./src/conexiones.txt", false, TGrafoDirigido.class); 
        Double[][] matrizInternacional= UtilGrafos.obtenerMatrizCostos(grafoInternacional.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matrizInternacional, grafoInternacional.getVertices(), "Matriz Internacional");
        //Para calcular los costos minímos de conexiones entre todo para de ciudades se utiliza el Algoritmo Floyd
        Double[][] internacionalFloyd= grafoInternacional.floyd(); 
        UtilGrafos.imprimirMatrizMejorado(internacionalFloyd, grafoInternacional.getVertices(), "Matriz internasional despues de Floyd");
        System.out.println("El centro del Grafo es:  " + grafoInternacional.centroDelGrafo());
        
        System.out.println("Respuestas: 1. El costo de volar de Montevideo a Rio de Janeiro es: b. 3780\n"
                + "2. El costo de volar de Montevideo a Curitiba es: a) 2580\n"
                + "3. Los servicios de mantenimiento se instalan en: c) Curitiba");
        
        
        System.out.println("Se recorre el grafo de la siguiente manera: "+ grafoInternacional.bpf());
        System.out.println(" Partiendo desde Montevideo se recorren los siguientes vertices: " + grafoInternacional.bpf("Montevideo"
        + "\nPodemos ver que se recorren todos los vertices del grafo."));
        
        System.out.println(grafoInternacional.bpf("Montevideo"));
        
        
        /*EJERCICIO PD 4 */
        TCaminos caminos= new TCaminos(); 
        caminos= grafoInternacional.todosLosCaminos("Montevideo", "Curitiba"); 
        System.out.println(caminos.imprimirCaminos());
        
        
         /*EJERCICIO PD 5 */
        System.out.println("Verificar si el grafo tiene ciclos: "+ grafoInternacional.tieneCiclo());
        
    }
}
