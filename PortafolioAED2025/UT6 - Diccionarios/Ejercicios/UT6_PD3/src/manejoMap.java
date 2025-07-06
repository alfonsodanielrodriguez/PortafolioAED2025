import java.util.*;

public class manejoMap {

    public manejoMap(){
    }

    public <K, V> void eliminarKeyNull(Map<K, V> map){
        map.remove(null);
    }

    public <K, V> void imprimirMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
        }
    }


    public void eliminarValuesNull(HashMap<String,Integer> map){
        ArrayList<String> array = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == null){
                array.add(entry.getKey());
            }
        }
        for(String nulos : array){
            map.remove(nulos);
        }
    }

    public <K, V> void invertirMap(Map<K, V> map){
        Map<V,K> mapDevolver = new HashMap<>();
        for(Map.Entry<K, V> entry : map.entrySet()){
            K key = entry.getKey();
            V value = entry.getValue();
            mapDevolver.put(value,key);
        }
        imprimirMap(mapDevolver);
    }


    public static void longitudCaracteres(String entrada) {
        String[] palabras = entrada.split(" ");
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        for (String palabra : palabras) {
            int longitud = palabra.length();
            map.putIfAbsent(longitud, new ArrayList<>());
            map.get(longitud).add(palabra);
        }
        for(Map.Entry<Integer , List<String>> entry : map.entrySet()){
            System.out.println("Longitud : " + entry.getKey() + " , " + entry.getValue());
        }
    }

    public static List randomLectura(String argumento, int cantidad){
        String[] temp = ManejadorArchivosGenerico.leerArchivo(argumento);
        List lista = new ArrayList();
        for (String linea : temp){
            lista.add(linea);
        }
        Random rand = new Random();
        for (int i = 0; i < cantidad ; i++){
            int n = rand.nextInt(temp.length-1);
            System.out.println(lista.get(n));
        }
        return lista;
    }





}
