import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String , Integer> map = new HashMap<>();
        args[2] = ".\\src\\libro.txt";
        map.put("Coates", 4);
        map.put("Lopez",70);
        map.put("Gregorio",null);
        map.put(null, 99);

        System.out.println("Ejercicio 1");
        manejoMap manejoMapas = new manejoMap();
        manejoMapas.imprimirMap(map);
        System.out.println("-");

        System.out.println("Ejercicio 2");
        manejoMapas.invertirMap(map);

        System.out.println("Ejercicio 3");
        String texto = "manzana plátano pera mamao Coco";
        manejoMapas.longitudCaracteres(texto);

        System.out.println("Ejercicio 4");
        String argumento = ".\\Users\\alfon\\Desktop\\Practicas\src\\libro.txt";
        manejoMapas.randomLectura(argumento, 2);

    }
}