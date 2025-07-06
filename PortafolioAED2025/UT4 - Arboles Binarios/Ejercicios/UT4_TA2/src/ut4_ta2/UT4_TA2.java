/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut4_ta2;

public class UT4_TA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBB arbol = crearArbol();

        ElementoAB elemento = (ElementoAB) arbol.buscar(2);
        System.out.println(elemento.getEtiqueta());
        
        System.out.println(arbol.preOrden());
        System.out.println(arbol.inOrden());
        System.out.println(arbol.postOrden());
        
        arbol.eliminar(9);
        System.out.println(arbol.inOrden());
        
    }
    
    public static ArbolBB crearArbol(){
        ElementoAB uno = new ElementoAB(1,1);
        ElementoAB dos = new ElementoAB(2,2);
        ElementoAB tres = new ElementoAB(3,3);
        ElementoAB cuatro = new ElementoAB(4,4);
        ElementoAB cinco = new ElementoAB(5,5);
        ElementoAB seis = new ElementoAB(6,6);
        ElementoAB siete = new ElementoAB(7,7);
        ElementoAB ocho = new ElementoAB(8,8);
        ElementoAB nueve = new ElementoAB(9,9);
        ElementoAB diez = new ElementoAB(10,10);
        
        ArbolBB arbol = new ArbolBB();
        arbol.insertar(nueve);
        arbol.insertar(ocho);
        arbol.insertar(seis);
        arbol.insertar(cuatro);
        arbol.insertar(dos);
        arbol.insertar(tres);
        arbol.insertar(uno);
        arbol.insertar(cinco);
        arbol.insertar(siete);
        arbol.insertar(diez);
        return arbol;
    }
    
}
