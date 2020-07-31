package edu.fiuba.algo3.modelo;

public class SistemaPuntaje {
    public SistemaPuntaje(){}
    public void cambiarPuntaje(Usuario jugador, Puntaje puntaje){
        puntaje.cantidad(puntaje.valor()+jugador.puntaje().valor());
        jugador.cambiarPuntaje(puntaje);
    }
}
