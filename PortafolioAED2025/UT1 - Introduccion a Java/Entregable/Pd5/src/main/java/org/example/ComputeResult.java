package org.example;

public class ComputeResult {
    public void ComputeResult(){
        String original = "este es el curso de Programación 2";
        StringBuilder result = new StringBuilder("hola");
        int index = original.indexOf('a');
        result.setCharAt(0, original.charAt(0));                        //eola
        result.setCharAt(1, original.charAt(original.length()-1));      //e2la
        result.insert(1, original.charAt(4));                           //e 2la
        result.append(original.substring(1,4));                                 //e 2laste
        result.insert(3, (original.substring(index, index+2) + " "));     //e 2am laste
        System.out.println(result);
    }
}

