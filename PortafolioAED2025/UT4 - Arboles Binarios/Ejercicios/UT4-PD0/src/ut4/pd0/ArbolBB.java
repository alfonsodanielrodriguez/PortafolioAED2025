/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut4.pd0;

public class ArbolBB implements IArbolBB<Object>{
    
    private ElementoAB raiz= null;

    @Override
    public boolean insertar(ElementoAB<Object> unElemento) {
        if(this.esVacio()){
            this.raiz=unElemento; 
            return true; 
        }else{
            return this.raiz.insertar(unElemento); 
        }
        
    }

    @Override
    public ElementoAB<Object> buscar(Comparable unaEtiqueta) {
        if(!this.esVacio()){
            return this.raiz.buscar(unaEtiqueta); 
        }
        return null; 
    }
    public String getRaiz(){
        return raiz.getEtiqueta().toString(); 
    }
    
           

    @Override
    public String preOrden() {
        if(!this.esVacio()){
            return this.raiz.preOrden(); 
        }
        return "Árbol vacio"; 
    }

    @Override
    public String inOrden() {
        if(!this.esVacio()){
            return this.raiz.inOrden(); 
        }
        return "Árbol vacio"; 
    }

    @Override
    public String postOrden() {
        if(!this.esVacio()){
            return this.raiz.postOrden(); 
        }
        return "Árbol vacio"; 
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if(raiz!= null){
            this.raiz.eliminar(unaEtiqueta); 
            
        }
    }
    
    public boolean esVacio(){
        return this.raiz==null; 
    }
    
    public int calcularOperaciones(){
        ArbolBB arbol= new ArbolBB(); 
        arbol= this; 
        if(raiz!= null){
            return (int) arbol.raiz.evalExp(); 
        }
        return 0; 
    }
   
}
