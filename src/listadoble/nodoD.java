/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listadoble;

/**
 * Jaime Alfredo Perez Rivera
 */
public class nodoD {
    
    private int dato;
    //Nodo anterior
    private nodoD ant;
    //Siguiente nodo
    private nodoD sig;
    
    //Inicializacion
    public nodoD(int x) {
        this.dato = x;
        ant = null;
        sig = null;
    }
    
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodoD getAnt() {
        return ant;
    }

    public void setAnt(nodoD ant) {
        this.ant = ant;
    }

    public nodoD getSig() {
        return sig;
    }

    public void setSig(nodoD sig) {
        this.sig = sig;
    }
    
}
