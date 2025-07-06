/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut4.pd0;

public class UT4PD0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArbolBB arbol = new ArbolBB();
        ElementoAB ocho = new ElementoAB(8,8);
        ElementoAB dos = new ElementoAB(2,2);
        ElementoAB tres = new ElementoAB(3,3);
        ElementoAB cuatro = new ElementoAB(4,4);
        ElementoAB suma = new ElementoAB("+","+");
        ElementoAB resta = new ElementoAB("-","-");
        ElementoAB mult = new ElementoAB("*","*");
        ElementoAB div = new ElementoAB("/","/");
        ElementoAB cinco = new ElementoAB(5,5);
        
        
        
        arbol.insertar(mult);
        mult.setHijoDer(div);
        div.setHijoDer(cinco);
        div.setHijoIzq(cuatro);        
        mult.setHijoIzq(resta);
        resta.setHijoDer(tres);
        resta.setHijoIzq(suma);
        suma.setHijoDer(dos);
        suma.setHijoIzq(ocho);
        
        System.out.println("Obtener la arbol InOrder: ((8+2)-3)*4 \n"+ arbol.inOrden());
        System.out.println();
        System.out.println("Obtener valor de la expresion expresión: \n"+ arbol.calcularOperaciones());
        System.out.println();    
        
    }
    
}
