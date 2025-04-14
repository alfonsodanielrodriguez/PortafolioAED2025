package org.example;

class CircularQueue {
    private int[] queue;      
    private int front;        
    private int fin;         
    private int tamanho;         
    private int Capacidad;     

    public CircularQueue(int Capacidad) {
        this.Capacidad = Capacidad;
        queue = new int[Capacidad];
        front = 0;
        fin = -1;
        tamanho = 0;
    }

    public boolean verificarCapacidad() {
        return tamanho == Capacidad;
    }

    public void agregarElemento(int elemento) {
        if (verificarCapacidad() == true) {
            System.out.println("Error: Cola llena");
            return;
        }
        fin = (fin + 1) % Capacidad;
        queue[fin] = elemento;
        tamanho++;
    }

    public int quitarElemento() {
        if (estaVacia()) {
            System.out.println("Error: Cola vacía");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % Capacidad;
        tamanho--;
        return element;
    }

    public boolean estaVacia() {
        return tamanho == 0;
    }
    public boolean estaLleno(){
        return tamanho == Capacidad;
    }

    public void verLista(){
        for (int i = 0; i < tamanho; i++) {
            System.out.print(queue[(front + i) % Capacidad] + " ");
        }
    }
}
/*
    Algoritmo QuitaDeCola()
        Si (la cola está vacía) Entonces
            Mostrar "Error: Cola vacía"
            devolver NULL
        FinSi

        elemento ← cola[front]
        front ← (front + 1) mod capacidad
        tamaño ← tamaño - 1

        devolver elemento
    FinAlgoritmo
 */