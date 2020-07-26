package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoPenalidad extends VerdaderoFalso{

    public VerdaderoFalsoPenalidad(String enunciado, boolean esVerdadera){
        super(enunciado,esVerdadera);
    }
    @Override
    public int respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas){
        return 1;
    }

    @Override
    public int respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas) {
        return -1;
    }
}

