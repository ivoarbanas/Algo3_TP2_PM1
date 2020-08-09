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

        Puntaje puntajeJugador1 = rondaActiva.obtenerPuntajeJugador(jugadores.get(0));
        Puntaje puntajeJugador2 = rondaActiva.obtenerPuntajeJugador(jugadores.get(1));

        if( (puntajeJugador1.valor() != puntajeJugador2.valor() ) ) {
            if ((jugadores.get(0).getExclusividad() == jugadores.get(1).getExclusividad())) {
                this.aplicarExclusividadCuadruplicada(jugadores().get(0), puntajeJugador1);
                this.aplicarExclusividadCuadruplicada(jugadores().get(1), puntajeJugador2);
            } else {
                this.aplicarExclusividadDuplicada(jugadores().get(0), puntajeJugador1);
                this.aplicarExclusividadDuplicada(jugadores().get(1), puntajeJugador2);
            }
        }

        puntajeJugador1 = this.aplicarMultiplicador(jugadores().get(0),puntajeJugador1);
        puntajeJugador2 = this.aplicarMultiplicador(jugadores().get(1),puntajeJugador2);

        sistemaPuntaje.cambiarPuntaje(jugadores.get(0), puntajeJugador1);
        sistemaPuntaje.cambiarPuntaje(jugadores.get(1), puntajeJugador2);
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
