package Alfo;

public class UT5_PD2 {

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\alfon\\Desktop\\UT5\\Ejercicios\\UT5_PD2\\src\\main\\java\\Alfo\\palabras1.txt");
        for (String p : palabrasclave) {
            //System.out.println(p);
                trie.insertarTextoPorLinea(p);
        }
        trie.imprimir();  
        
        System.out.println("");
        System.out.println("Buscar paginas ");
        System.out.println(trie.buscar("ala"));
        
        /*
        TArbolTrie trie1 = new TArbolTrie();
        String[] palabrasclave1 = ManejadorArchivosGenerico.leerArchivo("C:\Users\alfon\Desktop\UT5\Ejercicios\UT5_PD2\src\main\java\Alfo\palabras1.txt");
        for (String p : palabrasclave1) {
            //System.out.println(p);
                trie1.insertarPatricia(p);
        }
        trie1.imprimir();  
        System.out.println(trie.buscar("ala"));
        */
    }
}
