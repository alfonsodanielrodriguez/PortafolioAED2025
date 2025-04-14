package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("UT3 - PD9");

        String corchetes1 = "{}{}{}{}{}";
        String corchetes2 = "{}{}{{{{{";

        Expresion expresion1 = new Expresion();
        Expresion expresion2 = new Expresion();

        System.out.println(expresion1.controlCorchetes(corchetes1));
        System.out.println(expresion2.controlCorchetes(corchetes2));
    }
}