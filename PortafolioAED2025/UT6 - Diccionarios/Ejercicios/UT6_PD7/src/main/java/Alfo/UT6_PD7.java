package Alfo;


public class UT6_PD7 {

    public static void main(String[] args) {
        int holaHC = "Hola".hashCode();
        int holaMundoHC = "HolaMundo".hashCode();
        int hashMapHC = "HashMap".hashCode();
        int coleccionesHC = "Colecciones".hashCode();
        
        System.out.println("Hola: " + holaHC );
        System.out.println("HolaMundo: "+ holaMundoHC);
        System.out.println("HashMap: "+ hashMapHC);
        System.out.println("Colecciones: "+ coleccionesHC);
        
        Alumno juan = new Alumno(1234, "Alfonso Rodriguez", "alfo@hotmail.com");
        System.out.println(juan.hashCode());
        System.out.println(juan.equals(new Alumno(123, "Alfonso Rodriguez", "alfo@hotmail.com")));
    }
}
