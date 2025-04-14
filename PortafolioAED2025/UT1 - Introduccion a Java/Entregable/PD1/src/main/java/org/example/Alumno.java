package org.example;

public class Alumno {
    private String nombre;
    public Alumno(String nombre) {
        this.nombre = nombre;
    }
    public String getNombreAdmiracion() {
        return nombre.concat("!");
    }


    public int recorrer (String cadena){
        int res = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ') {
                res++;
                //System.out.println(res);
            } else {
                //System.out.println(res);
                return res;
            }
        }
        //System.out.println(res);
        return res;

    }
// Cambie el 1 por el 0 en el bucle para que pueda contar todas las letras,
// Le agrege un else, y int i tiene que ser menor a cadena.length() para que pueda ingresar al bucle for y no menor igual.
// Tambien le agregue un print para poder controlar la ejecucion del programa


    public static int getValor() {
        int vector[] = {6, 16, 26, 36, 46, 56, 66, 76};
        int idx = 8;
        return vector[idx - 1];
    }

//Ya que no exite un valor en la posicion 8, resolvi en tomar el ultimo valor como 8-1 para poder retornar el ultimo valor.
//Le elimine la clase y lo deje como un metodo adentro de la clase org.example.Alumno.java.
//Si quisiera obtener de otra forma el ultimo valor podria cambiar el idx = 7 o colocar el int idx = vector.lenght();
//La Array vector tiene 7 valores y no 8, entonces el ultimo valor era 8 - 1 o de la otra forma que explique arriba


    public static char getPrimerCaracter(String palabra) {
        //String string[] = new String[];
        return (palabra.charAt(0));
    }

// Elimine la clase para poder usarla en la clase org.example.Alumno
// Elimine el Array, cambie el charAt(1) por el charAt(0) ya que quiero el primer valor y no el segundo
// Quiero retornar solo la primer letra de la unica String palabra que tengo y no de un array de string
//Detecte el problema porque me pide la primera letra y veo que el CharAt pedia la segunda letra, no podia usarlo en mi clase alumno y de nada me servia la Array que habia


    public static String paraAString(int a) {
        //Object x1 = new Integer(a);
        //return (String) (x1) ;
        return Integer.toString(a);
    }
}

//Use el metodo Integer.toString(int x) para cambiar mi int a String



