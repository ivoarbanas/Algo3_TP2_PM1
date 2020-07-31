package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoPenalidad extends VerdaderoFalso{

    public VerdaderoFalsoPenalidad(String enunciado, boolean esVerdadera){
        super(enunciado,esVerdadera);
    }
    @Override
    public Puntaje respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas){
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(1);
        return puntaje;
    }

    @Override
    public Puntaje respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas) {
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(-1);
        return puntaje;
    }
}

