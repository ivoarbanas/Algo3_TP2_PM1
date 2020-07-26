package edu.fiuba.algo3.modelo;

abstract class Opcion {

    protected String valor;

    public Opcion(String valor) {
        this.valor = valor;
    }

    public String valor() {
        return valor;
    }

    public abstract int verificar(RespuestaUsuario respuestaUsuario, Pregunta pregunta, Usuario jugador, int cantidadVerificadas);

    public abstract int esCorrecta();
}
