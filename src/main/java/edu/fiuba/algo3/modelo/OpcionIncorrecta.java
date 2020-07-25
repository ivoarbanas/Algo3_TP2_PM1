package edu.fiuba.algo3.modelo;

public class OpcionIncorrecta extends Opcion{

    public OpcionIncorrecta(String valor) {
        super(valor);
    }

    public void asignacionPuntaje(RespuestaUsuario respuestaDelUsuario, Pregunta pregunta, Usuario jugador, int respuestasVerificadas){
        if(this == respuestaDelUsuario.valor()){
            pregunta.respuestaEsIncorrecta(jugador);
        }
    }
}
