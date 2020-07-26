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
        ronda = 0;
    }

    //main
    public void comenzarJuego(){
        //cargarJugadores();
        while(ronda < 10 ){
            presentarPreguntaALosUsuarios();
            verficarRonda();
            ronda++;
        }
        //finalizar juego
    }

    public void verficarRonda(){
        int puntajeJugador1 = verificador.verificar(preguntas.get(ronda),jugadores.get(0));
        int puntajeJugador2 = verificador.verificar(preguntas.get(ronda),jugadores.get(1));
        sistemaPuntaje.cambiarPuntaje(jugadores.get(0),puntajeJugador1);
        sistemaPuntaje.cambiarPuntaje(jugadores.get(1),puntajeJugador2);
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

    public void cambiarRonda(){
        for (Usuario jugador : jugadores){
            jugador.nuevaRonda();
        }
    }

}