/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoble;

/**
 * jaime Alfredo Perez Rivera
 */
public class Main {
    public static void main(String[] args) {
        ListaDoble lista = new ListaDoble();

        System.out.println("1.INSERTAR EN POSICION");
        lista.insertarEnPosicion(0, 20); 
        lista.insertarEnPosicion(1, 40); 
        lista.insertarEnPosicion(1, 30); 
        lista.insertarEnPosicion(0, 10);
        lista.insertarEnPosicion(lista.getTamanio(), 50); 
        imprimirEstado(lista);

        //1.Prueba de indice fuera del rango
        try {
            lista.insertarEnPosicion(99, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepcion esperada al insertar en pos invalida: " + e.getMessage());
        }

        //2.Pruebas de eliminacion por posicion, por valor y del ultimo nodo.
        System.out.println("\n2.ELIMINACIONES");
        int eliminadoPos = lista.eliminarEnPosicion(2); // Elimina el 30.
        System.out.println("Eliminado en posicion 2: " + eliminadoPos);
        imprimirEstado(lista);

        boolean eliminadoValExiste = lista.eliminarPorValor(40);
        boolean eliminadoValNoExiste = lista.eliminarPorValor(999);
        System.out.println("Eliminar valor 40: " + eliminadoValExiste);
        System.out.println("Eliminar valor 999: " + eliminadoValNoExiste);
        imprimirEstado(lista);

        boolean eliminadoUlt = lista.eliminarUltimo();
        System.out.println("Eliminar ultimo nodo: " + eliminadoUlt);
        imprimirEstado(lista);

        //3.Pruebas de vaciado total y casos borde en lista vacia.
        System.out.println("\n3.CASOS BORDE");
        while (!lista.estaVacia()) {
            lista.eliminarUltimo();
        }
        System.out.println("Eliminar ultimo en lista vacia: " + lista.eliminarUltimo());
        imprimirEstado(lista);

        //4.Pruebas de insertarOrdenado.
        System.out.println("\n4.INSERTAR ORDENADO");
        ListaDoble ordenada = new ListaDoble();
        int[] datosAInsertar = {25, 10, 40, 5, 25, 50, 15};

        for (int dato : datosAInsertar) {
            ordenada.insertarOrdenado(dato);
            System.out.println("Insertado ordenado " + dato + " -> " + ordenada);
        }

        System.out.println("\nResultado final de lista ordenada: ");
        imprimirEstado(ordenada);
    }

    //Imprime el resultado
    private static void imprimirEstado(ListaDoble lista) {
        System.out.println("Adelante: " + lista.toString());
        System.out.println("Inverso: " + lista.mostrarInverso());
        System.out.println("Tamanio: " + lista.getTamanio());
    }
}
