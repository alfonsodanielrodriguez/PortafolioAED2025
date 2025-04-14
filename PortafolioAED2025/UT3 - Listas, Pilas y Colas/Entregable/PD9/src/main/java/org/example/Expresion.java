package org.example;

import java.util.Stack;

public class Expresion {
    Stack pila = new Stack();

    public Expresion() {
    }

    public Boolean controlCorchetes(String oracion){
        for (int i = 0 ; i <= oracion.length() - 1 ; i++){

            if (pila.isEmpty() == true){
                pila.push(oracion.charAt(i));
                char posible = oracion.charAt(i);
            } else {
                if (i != oracion.charAt(i)){
                    pila.pop();
                } else {
                    pila.push(oracion.charAt(i));
                }
            }
        }
        if (pila.isEmpty() != false){
            return  true;
        } else {
            return false;
        }
    }
    public void verPila(){
        while (!pila.empty()) {
            System.out.print(pila.pop());
        }
    }
}
