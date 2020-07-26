package edu.fiuba.algo3.modelo;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String valor) {
        super(valor);
    }

    public int verificar(RespuestaUsuario respuestaDelUsuario, Pregunta pregunta, Usuario jugador, int respuestasVerificadas){
        if(this == respuestaDelUsuario.valor()){
            return pregunta.respuestaEsCorrecta(jugador, respuestasVerificadas);
        }
        return 0;
    }

    public int esCorrecta(){
        return 1;
    }
}

