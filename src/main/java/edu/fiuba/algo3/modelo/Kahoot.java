package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Kahoot {

    ArrayList<Usuario> jugadores;
    ArrayList<Pregunta> preguntas;
    Verificador verificador;
    SistemaPuntaje sistemaPuntaje;
    int ronda;

    public Kahoot(){
        verificador = new Verificador();
        sistemaPuntaje = new SistemaPuntaje();
    }

    public void crearJugador(String nombre){
        Usuario jugador = new Usuario(nombre);
        jugadores.add(jugador);
    }

    public void crearPreguntas(){
    //lee el archivo y envia mensaje a las clases dependiendo lo que va leyendo
    }

    //hago el metodo para agregar una pregunta especifica.
    public void agregarPreguntaParticular(Pregunta pregunta){
        preguntas.add(pregunta);
    }

    public void presentarPreguntaALosUsuarios(){
        for (Usuario jugador : jugadores) {
            jugador.elegirRespuesta(preguntas.get(ronda));
        }
    }

}
