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
        jugadores = new ArrayList<Usuario>();
        preguntas = new ArrayList<Pregunta>();
    }
    public ArrayList<Usuario> jugadores(){
        return jugadores;
    }
    //main
    public void comenzarJuego(){
        //cargarJugadores();
        while(ronda < 10 ){
            presentarPreguntaALosUsuarios();
            verificarRonda();
            ronda++;
        }
        //finalizar juego
    }

    public void verificarRonda(){
        Puntaje puntajeJugador1 = preguntas.get(ronda).calcularPuntajeParaRespuesta(jugadores.get(0).respuestas());
        Puntaje puntajeJugador2 = preguntas.get(ronda).calcularPuntajeParaRespuesta(jugadores.get(1).respuestas());
        sistemaPuntaje.cambiarPuntaje(jugadores.get(0),puntajeJugador1);
        sistemaPuntaje.cambiarPuntaje(jugadores.get(1),puntajeJugador2);
    }

    public void crearJugador(String nombre){
        Usuario jugador = new Usuario(nombre);
        jugadores.add(jugador);
    }
    public void cargarPregunta(Pregunta pregunta){
        preguntas.add(pregunta);
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
            jugador.vaciarRespuestas();
        }
    }

}
