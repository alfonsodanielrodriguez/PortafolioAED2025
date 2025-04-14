package org.example;

public class multsuma {
    public double a;
    public double b;
    public double c;
    public double resultado;

    public multsuma(double a , double b , double c ){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void Multsuma(){
        resultado = a*b+c;
        System.out.println("El resultado de la operacion es : " + resultado);
    }
}