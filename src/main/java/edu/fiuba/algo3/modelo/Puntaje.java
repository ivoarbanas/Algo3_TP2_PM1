package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int valor;

    public Puntaje(){
        valor = 0;
    }
    public Puntaje(int valor){
        this.valor = valor;
    }
    public void cantidad(int cantidad){
        valor = cantidad;
    }
    public int valor(){
        return valor;
    }

}
