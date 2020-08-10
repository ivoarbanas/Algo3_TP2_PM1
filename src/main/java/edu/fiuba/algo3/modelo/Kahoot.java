package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Kahoot {

    private ArrayList<Usuario> jugadores;
    private ArrayList<Ronda> rondas;
    private Ronda rondaActiva;
    private SistemaPuntaje sistemaPuntaje;

    public Kahoot() {
        rondaActiva = new Ronda();
        sistemaPuntaje = new SistemaPuntaje();
        jugadores = new ArrayList<Usuario>();
        rondas = new ArrayList<Ronda>();
        rondas.add(rondaActiva);


    }
    public ArrayList<Usuario> jugadores(){
        return jugadores;
    }
    //main
    /*public void comenzarJuego(){
        //cargarJugadores();
        while(ronda < 10 ){
            presentarPreguntaALosUsuarios();
            verificarRonda();
            ronda++;
        }
        //finalizar juego
    }*/

    public void verificarRonda() {

        Puntaje puntajeJugadorUno = rondaActiva.obtenerPuntajeJugador(jugadores.get(0));
        Puntaje puntajeJugadorDos = rondaActiva.obtenerPuntajeJugador(jugadores.get(1));

        if( (puntajeJugadorUno.valor() != puntajeJugadorDos.valor() ) ) {
            if ((jugadores.get(0).getExclusividad() == jugadores.get(1).getExclusividad())) {
                this.aplicarExclusividadCuadruplicada(jugadores().get(0), puntajeJugadorUno);
                this.aplicarExclusividadCuadruplicada(jugadores().get(1), puntajeJugadorDos);
            } else {
                this.aplicarExclusividadDuplicada(jugadores().get(0), puntajeJugadorUno);
                this.aplicarExclusividadDuplicada(jugadores().get(1), puntajeJugadorDos);
            }
        }

        puntajeJugadorUno = this.aplicarMultiplicador(jugadores().get(0),puntajeJugadorUno);
        puntajeJugadorDos = this.aplicarMultiplicador(jugadores().get(1),puntajeJugadorDos);

        sistemaPuntaje.cambiarPuntaje(jugadores.get(0), puntajeJugadorUno);
        sistemaPuntaje.cambiarPuntaje(jugadores.get(1), puntajeJugadorDos);
    }

    public void crearJugador(String nombre){
        Usuario jugador = new Usuario(nombre);
        jugadores.add(jugador);
    }

    /*public void cargarPregunta(Pregunta pregunta){
        preguntas.add(pregunta);
    }*/

    public void cargarPregunta(Pregunta pregunta){
        rondaActiva.cargarPregunta(pregunta);
    }

    public void crearPreguntas(){
        //lee el archivo y envia mensaje a las clases dependiendo lo que va leyendo
    }

    //hago el metodo para agregar una pregunta especifica ¿¿¿¿¿¿¿¿PARA QUE SIRVE????????
   /* public void agregarPreguntaParticular(Pregunta pregunta){

        preguntas.add(pregunta);
    }*/

    // NO SE USA TODAVIA
    public void presentarPreguntaALosUsuarios(){
        for (Usuario jugador : jugadores) {
            jugador.elegirRespuesta(rondaActiva.pregunta());
        }
    }

    public void cambiarRonda(){

        for (Usuario jugador : jugadores){
            jugador.vaciarRespuestas();
            jugador.limpiarMultiplicador();
        }
        rondaActiva = new Ronda();
        rondas.add(rondaActiva);

    }

    public Puntaje aplicarMultiplicador(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return rondaActiva.aplicarMultiplicador(jugadorAfectado,puntajeAMultiplicar);
    }

    public Puntaje aplicarExclusividadDuplicada(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return rondaActiva.aplicarExclusividadDuplicada(jugadorAfectado,puntajeAMultiplicar);
    }

    public Puntaje aplicarExclusividadCuadruplicada(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return rondaActiva.aplicarExclusividadCuadruplicado(jugadorAfectado,puntajeAMultiplicar);
    }

    public Ronda rondaActiva(){
        return rondaActiva;
    }
}
