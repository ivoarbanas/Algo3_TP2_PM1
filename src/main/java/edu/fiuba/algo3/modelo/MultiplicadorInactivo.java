package edu.fiuba.algo3.modelo;

public class MultiplicadorInactivo extends Multiplicador {
    public MultiplicadorInactivo(){
        super();
    }

    public Puntaje calcularPuntajeConMultiplicador(Puntaje puntajeAMultiplicar){

        return puntajeAMultiplicar;

    }

    public int valorDelMultiplicador(){
        return 1;
    }
}
