/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4_ta2;

/**
 *
 * @author jpere
 */
public class ArbolBB implements IArbolBB<Object>{

    private ElementoAB raiz = null;
    
    
    @Override
    public boolean insertar(ElementoAB<Object> unElemento) {
        if (this.esVacio()){
            this.raiz = unElemento;
            return true;
        } else {
            return this.raiz.insertar(unElemento);
        }
    }

    @Override
    public ElementoAB<Object> buscar(Comparable unaEtiqueta) {
        if (!this.esVacio()) {
            return this.raiz.buscar(unaEtiqueta);        
        }           
        return null;
    }

    @Override
    public String preOrden() {
        if (!this.esVacio()) {
            return this.raiz.preOrden();
        }
        return "Arbol Vacio";
    }

    @Override
    public String inOrden() {
        if (!this.esVacio()) {
            return this.raiz.inOrden();          
        }
        return "Arbol Vacio";
    }

    @Override
    public String postOrden() {
        if (!this.esVacio()) {
            return this.raiz.postOrden();    
        }
        return "Arbol Vacio";
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null){
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }
    
    public boolean esVacio() {
        return this.raiz == null ? true : false;
    }
    
    
}
