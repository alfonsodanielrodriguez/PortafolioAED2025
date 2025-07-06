/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4_ta2;

/**
 *
 * @author jpere
 * @param <T>
 */
public class ElementoAB<T> implements IElementoAB {
    
    private ElementoAB<T> hijoIzq;
    private ElementoAB<T> hijoDer;
    private Comparable etiqueta;
    private final T dato;

    public ElementoAB (Comparable etiqueta, T dato){
        this.etiqueta = etiqueta;
        this.dato = dato;
    }
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }
    
    /**
     *
     * @param unaEtiqueta
     * @return
     */
    @Override
    public ElementoAB buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) == 0){
            return this;
        } else {
            if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
                if (this.hijoIzq != null) {
                    return this.hijoIzq.buscar(unaEtiqueta);  
                }
                return null;
            } else {
                if (this.hijoDer != null) {
                    return this.hijoDer.buscar(unaEtiqueta);
                }
                return null;
            }
        }
    }

    @Override
    public boolean insertar(ElementoAB elemento) {
        if (elemento.getEtiqueta().compareTo(this.etiqueta) == 0){
            return false;
        }
        if (elemento.getEtiqueta().compareTo(this.etiqueta) < 0){
            if (this.hijoIzq == null){
                this.hijoIzq = elemento;
                return true;
            } else {
                this.hijoIzq.insertar(elemento);
            }
            return false;
        } else {
            if (this.hijoDer == null){
                this.hijoDer = elemento;
                return true;
            } else {
                this.hijoDer.insertar(elemento);
            }
            return false;
        }
    }

    @Override
    /* Preorden: Raiz -> Izquierdo -> Derecho */
    public String preOrden() {
        String tempStr = "";
        
        /* Checkeo raiz primero */
        tempStr += this.etiqueta;
        
        /* Despues checkeo hijo izquierdo */
        if (this.hijoIzq != null) {
            tempStr += this.hijoIzq.preOrden();
        }
        
        /* Despues checkeo hijo derecho */
        if (this.hijoDer != null) {
            tempStr += this.hijoDer.preOrden();
        }
        return tempStr;
    }

    @Override
    /* Inorden: Izquierdo -> Raiz -> Derecho */
    public String inOrden() {
        String tempStr = "";
        
        /* Checkeo hijo izquierdo primero */
        if (this.hijoIzq != null) {
            tempStr += this.hijoIzq.inOrden();
        }
        
        /* Despues checkeo raiz */
        tempStr += this.etiqueta;
        
        /* Despues checkeo hijo derecho */
        if (this.hijoDer != null) {
            tempStr += this.hijoDer.inOrden();
        }
        return tempStr;
    }

    @Override
    /* Postorden: Izquierdo -> Derecho -> Raiz */
    public String postOrden() {
        String tempStr = "";
        
        /* Checkeo hijo izquierdo primero */
        if (this.hijoIzq != null) {
            tempStr += this.hijoIzq.postOrden();
        }
        
        /* Despues checkeo hijo derecho */
        if (this.hijoDer != null) {
            tempStr += this.hijoDer.postOrden();
        }
        
        /* Despues checkeo raiz */
        tempStr += this.etiqueta;
        return tempStr;
    }

    @Override
    public Object getDatos() {
        return this.dato;
    }
    
    public boolean esVacio(){
        if (hijoDer != null || hijoIzq != null){
            return false;
        }
        return true;
    }
    private ElementoAB quitaElemento(){
        if (hijoIzq == null){
            return hijoDer;
        }
        if (hijoDer == null){
            return hijoIzq;
        }
        ElementoAB elHijo = hijoIzq;
        ElementoAB elPadre = this;
        while (elHijo.hijoDer != null){
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this){
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;
        return elHijo;
    }
    
    @Override
    public ElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) < 0){
            if (hijoIzq != null){
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(etiqueta) > 0){
            if (hijoDer != null){
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        System.out.println("Se eliminó el " + this.etiqueta + ".");
        return quitaElemento();
    }

    @Override
    public void setHijoIzq(ElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(ElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public ElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public ElementoAB getHijoDer() {
        return this.hijoDer;
    }
    
}
