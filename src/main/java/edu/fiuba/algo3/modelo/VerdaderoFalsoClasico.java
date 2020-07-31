package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoClasico extends VerdaderoFalso{

    public VerdaderoFalsoClasico(String enunciado, boolean esVerdadera){
        super(enunciado, esVerdadera);
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
        puntaje.cantidad(0);
        return puntaje;
    }
}
