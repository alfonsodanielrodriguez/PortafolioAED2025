package uy.edu.ucu.aed;

public class TTablaHash implements IHash {
    private int[] tabla;
    private int tamano;
    private int cantidadElementos;

    public TTablaHash(int tamano) {
        this.tamano = tamano;
        this.tabla = new int[tamano];
        this.cantidadElementos = 0;
    }

    public int funcionHashing(int unaClave) {
        return unaClave % this.tamano;
    }

    public int insertar(int unaClave) {
        int posicion = this.funcionHashing(unaClave);
        int i = 0;

        while (this.tabla[posicion] != 0 && this.tabla[posicion] != unaClave) {
            posicion = (posicion + i * i) % this.tamano;
            ++i;
        }

        if (this.tabla[posicion] == 0) {
            this.tabla[posicion] = unaClave;
            ++this.cantidadElementos;
        }
        return posicion;
    }

    public int buscar(int unaClave) {
        int posicion = this.funcionHashing(unaClave);
        int i = 0;

        while (this.tabla[posicion] != 0 && this.tabla[posicion] != unaClave) {
            posicion = (posicion + i * i) % this.tamano;
            ++i;
        }

        return this.tabla[posicion] == unaClave ? posicion : -1;
    }
}
