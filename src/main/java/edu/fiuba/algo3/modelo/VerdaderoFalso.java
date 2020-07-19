package edu.fiuba.algo3.modelo;

abstract class VerdaderoFalso extends Pregunta {

    protected String enunciado;
    protected OpcionCorrecta opcionCorrecta;
    protected OpcionIncorrecta opcionIncorrecta;

    public VerdaderoFalso(String enunciado, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta){
        this.enunciado = enunciado;
        this.opcionCorrecta = opcionCorrecta;
        this.opcionIncorrecta = opcionIncorrecta;
    }

    public OpcionCorrecta obtenerOpcionCorrecta() {
        return opcionCorrecta;
    }

}
