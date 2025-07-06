/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alfo;

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
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(etiqueta.toString());
        tempStr.append(ArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        if (hijoIzq != null) {
            
            tempStr.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    @Override
    /* Inorden: Izquierdo -> Raiz -> Derecho */
    public String inOrden(){
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(ArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(etiqueta.toString());
        if (hijoDer != null) {
            tempStr.append(ArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }
        return tempStr.toString();
    }

    @Override
    /* Postorden: Izquierdo -> Derecho -> Raiz */
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
        }
        tempStr.append(ArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        tempStr.append(etiqueta.toString());
        return tempStr.toString();
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
