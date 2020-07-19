package edu.fiuba.algo3.modelo;

public class SistemaPuntaje {
    public SistemaPuntaje(){}
    public void cambiarPuntaje(Usuario jugador, int puntaje){
        Puntos puntos = new Puntos();
        puntos.cantidad(jugador.puntos().valor() + puntaje);
        jugador.cambiarPuntos(puntos);
    }
}
