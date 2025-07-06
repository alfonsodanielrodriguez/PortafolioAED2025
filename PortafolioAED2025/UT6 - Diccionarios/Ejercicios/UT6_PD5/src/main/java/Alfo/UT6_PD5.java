package Alfo;

public class UT6_PD5 {

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\alfon\\Desktop\\UT 6 - PD\\UT6_PD5\\src\\main\\java\\Alfo\\palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();  
        System.out.println(trie.predecir("bo"));
    }
}
