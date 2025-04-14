package org.example;


class Marcapaso {
    // Medidas continuas
    public short presionSanguinea;
    public short frecuenciaCardiaca;
    public int nivelAzucar;

    // Registro de autodiagnóstico
    public long maximaFuerza;          //long porque el valor máximo es mayor que el rango de int
    public float minimoTiempoEntreLatidos;  //float por el tamaño menor en memoria
    public double bateriaRestante;    //double para mayor precisión
    public char[] codigoFabricante;    //String es lo más flexible y no se puede hacer más pequeño en memoria

    public Marcapaso(int presionSanguinea, int frecuenciaCardiaca, int nivelAzucar, int maximaFuerza, float minimoTiempoEntreLatidos, double bateriaRestante, char[] codigoFabricante) {
        this.presionSanguinea = (short) presionSanguinea;
        this.frecuenciaCardiaca = (short) frecuenciaCardiaca;
        this.nivelAzucar = nivelAzucar;
        this.maximaFuerza = maximaFuerza;
        this.minimoTiempoEntreLatidos = minimoTiempoEntreLatidos;
        this.bateriaRestante = bateriaRestante;
        this.codigoFabricante = codigoFabricante;
    }

    public void DetallesMarcapaso(){
        System.out.println("Presion Sanguinea : " + presionSanguinea );
        System.out.println("Frecuencia Cardiaca : " + frecuenciaCardiaca);
        System.out.println("Nivel de Azucar : " + nivelAzucar);
        System.out.println("Maxima Fuerza " + maximaFuerza);
        System.out.println("Tiempo Minimo entre los latidos : " + minimoTiempoEntreLatidos);
        System.out.println("Bateria Restante : " + bateriaRestante);
        System.out.println("Codigo de Fabrica : " + new String(codigoFabricante));
    }
}
