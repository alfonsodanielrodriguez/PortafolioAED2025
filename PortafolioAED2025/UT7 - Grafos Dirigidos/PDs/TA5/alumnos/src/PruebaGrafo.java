
import static java.lang.System.in;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos_1.txt", "./src/conexiones_1.txt",
                false, TGrafoDirigido.class);

        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        // imprimir etiquetas del bpf desde Asunción....
        for (TVertice etVert : recorrido_Asuncion) {
            System.out.print(etVert.getEtiqueta() + " ");
        }

        String ciudadOrigen = "Santos";
        String ciudadDestino = "Curitiba";
        System.out.println("\nTodos los caminos desde " + ciudadOrigen + " a " + ciudadDestino + ":");
        TCaminos caminos = gd.todosLosCaminos(ciudadOrigen, ciudadDestino);
        caminos.imprimirCaminosConsola();

        TGrafoDirigido grafoDirigido = (TGrafoDirigido) UtilGrafos.cargarGrafo("src/aeropuertos_2.txt", "src/conexiones_2.txt",
                false, TGrafoDirigido.class);
        
        ciudadOrigen = "Asuncion";
        ciudadDestino = "Porto_Alegre";
        System.out.println("\nTodos los caminos desde " + ciudadOrigen + " a " + ciudadDestino + ":");
        TCaminos caminos2 = grafoDirigido.todosLosCaminos(ciudadOrigen, ciudadDestino);
        caminos2.imprimirCaminosConsola();

    }
}
