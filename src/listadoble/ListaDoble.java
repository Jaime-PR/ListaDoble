/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listadoble;

/**
 * Jaime Alfredo Perez Rivera
 */
public class ListaDoble {
    
    private int tamanio;
    //Apunta al inicio
    private nodoD cabeza;
    //Apunta al final
    private nodoD cola;
    
    //Crear la lista doble
    public ListaDoble() {
        tamanio = 0;
        cabeza = null;
        cola = null;
    }
    
    //Lista sin cabexa ni cola
    public boolean estaVacia() {
        if(cabeza == null && cola == null){
            return true;
        }else{
            return false;
        }
    }
    
    //Tamano de la lista (nodos)
    public int getTamanio() {
        return tamanio;
    }
    
    public boolean Buscar(int x) {
        nodoD aux = cabeza;

        //Recorre la lista 
        while (aux != null) {
            if (aux.getDato() == x) {
                return true;
            }
            aux = aux.getSig();
        }

        return false;
    }
     
    public nodoD obtenerNodo(int pos) {
        if (pos < 0 || pos >= tamanio) {
            throw new IllegalArgumentException("Posicion invalida: " + pos);
        }

        nodoD aux = cabeza;

        for (int i = 0; i < pos; i++) {
            aux = aux.getSig();
        }

        return aux;
    }
    
    public void actualizar(int dato, int pos){
        nodoD aux = obtenerNodo(pos);
        aux.setDato(dato);
    }
    
    //Apunta al inicio y la cabeza apunta al nuevo nodo
    public void insertarAlInicio(int dato) {
        nodoD nuevo = new nodoD(dato);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.setSig(cabeza);
            cabeza.setAnt(nuevo);
            cabeza = nuevo;
        }

        tamanio++;
    }
    
    //Se pone al final y la cola apunta a este
    public void insertarFinal(int dato) {
        nodoD nuevo = new nodoD(dato);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSig(nuevo);
            nuevo.setAnt(cola);
            cola = nuevo;
        }

        tamanio++;
    }
    
    //Elimina el primer nodo
    public int eliminarAlInicio() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista esta vacia");
        }

        int dato = cabeza.getDato();

        if (tamanio == 1) {
            cabeza = null;
            cola = null;
        } else {
            nodoD eliminado = cabeza;
            cabeza = cabeza.getSig();
            cabeza.setAnt(null);
            eliminado.setSig(null);
        }

        tamanio--;
        return dato;
    }
    
    public int obtener(int pos) {
        return obtenerNodo(pos).getDato();
    }
    
    //Inserta en cualquier posicion 
    public void insertarEnPosicion(int pos, int dato) {
        if (pos < 0 || pos > tamanio) {
            throw new IllegalArgumentException("Posicion invalida: " + pos);
        }

        if (pos == 0) {
            insertarAlInicio(dato);
        } else if (pos == tamanio) {
            insertarFinal(dato);
        } else {
            nodoD actual = obtenerNodo(pos);
            nodoD anterior = actual.getAnt();
            nodoD nuevo = new nodoD(dato);

            nuevo.setAnt(anterior);
            nuevo.setSig(actual);
            anterior.setSig(nuevo);
            actual.setAnt(nuevo);

            tamanio++;
        }
    }
    
    //Elimina el ultima valor y hace que el anterior apunte a null
    public boolean eliminarUltimo() {
        if (estaVacia()) {
            return false;
        }

        if (tamanio == 1) {
            cabeza = null;
            cola = null;
        } else {
            nodoD eliminado = cola;
            cola = cola.getAnt();
            cola.setSig(null);
            eliminado.setAnt(null);
        }

        tamanio--;
        return true;
    }
    
    //Elimina un valor en cualquier posicion
    public int eliminarEnPosicion(int pos) {
        if (pos < 0 || pos >= tamanio) {
            throw new IllegalArgumentException("Posicion invalida: " + pos);
        }

        if (pos == 0) {
            return eliminarAlInicio();
        }

        nodoD eliminado = obtenerNodo(pos);
        int dato = eliminado.getDato();

        if (pos == tamanio - 1) {
            eliminarUltimo();
        } else {
            nodoD anterior = eliminado.getAnt();
            nodoD siguiente = eliminado.getSig();

            anterior.setSig(siguiente);
            siguiente.setAnt(anterior);

            eliminado.setAnt(null);
            eliminado.setSig(null);

            tamanio--;
        }

        return dato;
    }
    
    
    public boolean eliminarPorValor(int x) {
        nodoD aux = cabeza;
        int pos = 0;

        while (aux != null) {
            if (aux.getDato() == x) {
                eliminarEnPosicion(pos);
                return true;
            }

            aux = aux.getSig();
            pos++;
        }

        return false;
    }
    
    //Inserta elementos manteniendo el orden de menor a mayor
    public void insertarOrdenado(int dato) {
        if (estaVacia() || dato <= cabeza.getDato()) {
            insertarAlInicio(dato);
            return;
        }

        if (dato >= cola.getDato()) {
            insertarFinal(dato);
            return;
        }

        nodoD actual = cabeza.getSig();
        while (actual != null && actual.getDato() < dato) {
            actual = actual.getSig();
        }

        nodoD anterior = actual.getAnt();
        nodoD nuevo = new nodoD(dato);

        nuevo.setAnt(anterior);
        nuevo.setSig(actual);
        anterior.setSig(nuevo);
        actual.setAnt(nuevo);

        tamanio++;
    }
    
    @Override
    public String toString() {
        String res = "null";
        nodoD aux = cabeza;

        while (aux != null) {
            res = res + " <-> [" + aux.getDato() + "]";
            aux = aux.getSig();
        }

        return res + " <-> null";
    }
    
    public String mostrarInverso() {
        String res = "null";
        nodoD aux = cola;

        while (aux != null) {
            res = res + " <-> [" + aux.getDato() + "]";
            aux = aux.getAnt();
        }

        return res + " <-> null";
    }
}
