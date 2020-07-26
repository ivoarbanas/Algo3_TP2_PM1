package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoClasico extends VerdaderoFalso{

    public VerdaderoFalsoClasico(String enunciado, boolean esVerdadera){
        super(enunciado, esVerdadera);
    }
    @Override
    public int respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas){
        return 1;
    }

    @Override
    public int respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas) {
        return 0;
    }
}
