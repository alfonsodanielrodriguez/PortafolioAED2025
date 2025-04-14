package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1 ");
        EnumTest firstDay = new EnumTest(EnumTest.Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(EnumTest.Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(EnumTest.Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(EnumTest.Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(EnumTest.Day.SUNDAY);
        seventhDay.tellItLikeItIs();


        System.out.println("Ejercicio 3 ");
        char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
        String helloString = new String(helloArray);
        System.out.println(helloString);
        StringDemo stringDemo = new StringDemo();
        System.out.println(stringDemo.StringDemo());


        System.out.println("Ejercicio 4 ");

        String argumento1 = "13.4";
        String argumento2 = "66.1";

        if (args.length != 2) {
            // convert strings to numbers
            //float a = (Float.valueOf(args[0])).floatValue();        //Aqui cambiaria el metodo de Float a Interger.parseInt
            //float b = (Float.valueOf(args[1])).floatValue();
            float a = Float.parseFloat(argumento1);
            float b = Float.parseFloat(argumento2);

            // do some arithmetic
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
        } else {
            System.out.println("This program requires two command-line arguments.");
        }

        System.out.println("Ejercicio 5 ");
        ToStringDemo tostringdemo = new ToStringDemo();
        tostringdemo.ToStringDemo();


        System.out.println("Ejercicio 6 ");
        Ejercicio6 ejercicio6 = new Ejercicio6();
        ejercicio6.Ejercicio6();

        System.out.println("Ejercicio 7");
        Ejercicio7 ejercicio7 = new Ejercicio7();
        ejercicio7.Ejercicio7();

        System.out.println("Ejercicio 8");
        StringBuilder sb = new StringBuilder("Able was I ere I saw  Elba.");
        //La capacidad inicial del StringBuilder será al menos igual a la longitud de la cadena

        System.out.println("Ejercicio 9");
        String hannah = "Did Hannah see bees? Hannah did.";
        //Hannah.lenght muestra la cantidad de letras que tiene la String hannah
        System.out.println(hannah.length());
        //hannah.charAt(12) muestra que valor tiene el lugar 12 de la string hannah que seria : "e"
        System.out.println(hannah.charAt(12));
        //
        int primerab = hannah.indexOf("b");
        System.out.println("La letra b de la String Hannah esta en el lugar " + primerab );

        System.out.println("Ejercicio 10 ");
        String ejercicio10 = "Was it a car or a cat I saw?";
        String resultado = ejercicio10.substring(9, 12);
        System.out.println("ejercicio 10, la palabra es : " + resultado);

        System.out.println("Ejercicio 11 ");
        ComputeResult result = new ComputeResult();
        result.ComputeResult();
    }
}