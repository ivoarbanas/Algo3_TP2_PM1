package edu.fiuba.algo3.modelo;

public class OpcionCorrecta extends Opcion {

    public OpcionCorrecta(String valor) {
        super(valor);
    }

    public Puntaje verificar(RespuestaUsuario respuestaDelUsuario, Pregunta pregunta, Usuario jugador, int respuestasVerificadas){
        if(this == respuestaDelUsuario.valor()){
            return pregunta.respuestaEsCorrecta(jugador, respuestasVerificadas);
        }
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(0);
        return puntaje;
    }

    public int esCorrecta(){
        return 1;
    }
}

