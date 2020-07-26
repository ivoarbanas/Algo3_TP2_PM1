package edu.fiuba.algo3.modelo;

public class OpcionIncorrecta extends Opcion{

    public OpcionIncorrecta(String valor) {
        super(valor);
    }

    public int asignacionPuntaje(RespuestaUsuario respuestaDelUsuario, Pregunta pregunta, Usuario jugador, int respuestasVerificadas){
        if(this == respuestaDelUsuario.valor()){
            return pregunta.respuestaEsIncorrecta(jugador,respuestasVerificadas);
        }
        return 0;
    }
}
