package edu.fiuba.algo3.modelo;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String valor) {
        super(valor);
    }

    public void asignacionPuntaje(RespuestaUsuario respuestaDelUsuario, Pregunta pregunta, Usuario jugador){
        if(this == respuestaDelUsuario.valor()){
            pregunta.respuestaEsCorrecta(jugador);
        }
    }
}
