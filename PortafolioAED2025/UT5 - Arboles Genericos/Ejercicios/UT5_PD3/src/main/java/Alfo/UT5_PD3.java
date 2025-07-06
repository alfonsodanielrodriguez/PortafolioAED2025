package Alfo;

public class UT5_PD3 {

    public static void main(String[] args) {
        String[] libro = ManejadorArchivosGenerico.leerArchivo("C:\\Users\\alfon\\Desktop\\UT5\\Ejercicios\\UT5_PD3\\src\\main\\java\\Alfo\\Libro.txt");
        /*TArbolTrie trie = new TArbolTrie();
        for (int i = 0; i < libro.length; i++){
            trie.indizarLibro(libro[i], i);
        }
        trie.imprimir();*/
        
        for (int i = 0; i < libro.length; i++){
            TNodoTrie.printwords(libro[i]);
        }
    }
}
