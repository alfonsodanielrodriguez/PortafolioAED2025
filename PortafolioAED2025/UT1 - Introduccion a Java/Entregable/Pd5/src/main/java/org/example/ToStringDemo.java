package org.example;

public class ToStringDemo {
    public void ToStringDemo(){
        double d = 888.51;
        String s = Double.toString(d);
        int dot = s.indexOf('.');

        System.out.println((dot + " digits before decimal point.\n"));
        System.out.println(((s.length() - dot - 1) + " digits after decimal point."));
    }

}
//La salida de la clase es la cantidad de digitos antes del punto.
//y en la otra linea imprime la cantidad de digitos despues del punto.


//Indicar por qué se imprime cada uno de los datos y la razón de su forma
//Primero lo que pasa es tomar el double y pasarlo a String, luego divide al String por el punto (indexOf())
//se calcula la cantidad de dígitos después del punto decimal,
//y el s.length() es 6, dot es 3, y restando 1 (para excluir el punto decimal) da 6 - 3 - 1 = 2.
