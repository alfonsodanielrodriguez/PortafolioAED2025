/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.pd0;

public class ElementoAB<T> implements IElementoAB{

    private ElementoAB<T> hijoIzq; 
    private ElementoAB<T> hijoDer;
    private Comparable etiqueta;
    private T dato;
    
    public ElementoAB (Comparable etiqueta, T dato){
        this.etiqueta = etiqueta;
        this.dato = dato;
    }
   

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public ElementoAB getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public ElementoAB getHijoDer() {
        return hijoDer; 
    }

    @Override
    public void setHijoIzq(ElementoAB elemento) {
        this.hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(ElementoAB elemento) {
        this.hijoDer= elemento;
    }

    @Override
    public ElementoAB buscar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(this.etiqueta)==0){
            return this; 
        }else{
            if(unaEtiqueta.compareTo(this.etiqueta)<0){
                if(this.hijoIzq!=null){
                    return this.hijoIzq.buscar(unaEtiqueta);
                }
                return null;
            }else{
                if(this.hijoDer!= null){
                    return this.hijoDer.buscar(unaEtiqueta);
                }
                return null;
            }
        }
    
    }

    @Override
    public boolean insertar(ElementoAB elemento) {
        if(elemento.getEtiqueta().compareTo(this.etiqueta)==0){
            return false;
        }
        if(elemento.getEtiqueta().compareTo(this.etiqueta)<0){
            if(this.hijoIzq==null){
                this.hijoIzq= elemento;
                return true;
            }else{
                this.hijoIzq.insertar(elemento);
            }
            return false;
        }else{
            if(this.hijoDer==null){
               this.hijoDer=elemento;
               return true;
            }else{
                this.hijoDer.insertar(elemento);
            }
            return false;
        }
    }
    //Raiz- izquierdo - derecho
    @Override
    public String preOrden() {
        String tempStr= ""; 
        tempStr+= this.etiqueta; 
        if(this.hijoIzq!= null){
            tempStr+= this.hijoIzq.preOrden(); 
        }
        if(this.hijoDer!= null){
            tempStr+= this.hijoDer.preOrden(); 
        }
        return tempStr; 
    }
    
    //Izquierdo-raiz-derecho
    @Override
    public String inOrden() {
        String tempStr = ""; 
        if(this.hijoIzq!= null){
            tempStr+= this.hijoIzq.inOrden(); 
        }
        tempStr+=this.etiqueta; 
        
        if(this.hijoDer!= null){
            tempStr+= this.hijoDer.inOrden(); 
        }
        
        return tempStr; 
                
    }
    //Inzquierdo- derecho-raiz
    @Override
    public String postOrden() {
        String tempStr= ""; 
        if(this.hijoIzq!= null){
            tempStr+= this.hijoIzq.postOrden(); 
        }
        if(this.hijoDer!=null){
            tempStr+= this.hijoDer.postOrden(); 
                    
        }
        tempStr+=this.etiqueta; 
        return tempStr; 
    }

    @Override
    public Object getDatos() {
        return this.dato;
    }
    
    
    public boolean esVacio(){
        return!(hijoDer !=null || hijoIzq != null); 
    }

    
    private ElementoAB quitaElemento(){
        if(hijoIzq==null){
            return hijoDer; 
        }
        if(hijoDer== null){
            return hijoIzq; 
                    
        }
        ElementoAB elHijo= hijoIzq; 
        ElementoAB elPadre= this; 
        while (elHijo.hijoDer!= null){
            elPadre= elHijo; 
            elHijo= elHijo.hijoDer; 
        }
        if(elPadre!=this){
            elPadre.hijoDer= elHijo.hijoIzq; 
            elHijo.hijoIzq= hijoIzq;
        }
        elHijo.hijoDer= hijoDer; 
        return elHijo; 
    }
     
    @Override
    public ElementoAB eliminar(Comparable unaEtiqueta) {
        if(unaEtiqueta.compareTo(etiqueta)<0){
            if(hijoIzq!= null){
                hijoIzq= hijoIzq.eliminar(unaEtiqueta); 
                
            }
            return this; 
        }
        if(unaEtiqueta.compareTo(etiqueta)>0){
            if(hijoDer!=null){
                hijoDer= hijoDer.eliminar(unaEtiqueta); 
            }
            return this; 
        }
        System.out.println("Se eleminió el "+ this.etiqueta);
        return quitaElemento(); 
    }
    
    
    
    
    public int evalExp(){
        if(this.hijoIzq==null && this.hijoDer== null){
            return (Integer) this.dato; 
        }
        else{
            int x= hijoIzq.evalExp(); 
            int y= hijoDer.evalExp(); 
            switch (dato.toString()){
                case "+":
                    return x+ y; 
                case "-": 
                    return x-y; 
                    
                case "*": 
                    return x*y; 
                case "/": 
                    return x/y; 
                default: 
                    throw new IllegalArgumentException("Operador invalido"); 
            }
        }
    }
   
    
}
