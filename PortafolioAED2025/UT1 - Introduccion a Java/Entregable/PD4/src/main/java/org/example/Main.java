package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("Unidad de Trabajo 1 - PD4 !");
        System.out.println("Ejercicio 1 ");
        IdentifyMyParts a = new IdentifyMyParts();
        IdentifyMyParts b = new IdentifyMyParts();
        a.y = 5;
        b.y = 6;
        a.x = 1;
        b.x = 2;
        System.out.println("a.y = " + a.y);
        System.out.println("b.y = " + b.y);
        System.out.println("a.x = " + a.x);
        System.out.println("b.x = " + b.x);
        System.out.println("IdentifyMyParts.x = " + IdentifyMyParts.x);

        System.out.println("Ejercicio 2 ");
        Rectangle myRect = new Rectangle();
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.area());


        System.out.println("Ejercicio 3 ");
        String[] students = new String[10];
        String studentName = "Peter Parker";
        students[0] = studentName;

        System.out.println("Cómo hace un programa para destruir un objeto que ha creado? ");
        System.out.println("Tiene el objeto que quiere destruirlo y lo iguala a null, de esa forma se asegura el destruir un objeto creado ");

        NumberHolter holter = new NumberHolter();
        holter.anInt = 42;
        holter.aFloat = 3.14f;

        System.out.println("los valores del NumberHolter son: \nanInt : "+ holter.anInt + "\naFloat : " + holter.aFloat );
    }
}