package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int valor;

    public Puntaje(){
        valor = 0;
    }
    public void cantidad(int cantidad){
        valor = cantidad;
    }
    public int valor(){
        return valor;
    }

    public Puntaje aplicarMultiplicador(Multiplicador multiplicador) {
        valor = valor * multiplicador.valorDelMultiplicador();
        return this;
    }
}
