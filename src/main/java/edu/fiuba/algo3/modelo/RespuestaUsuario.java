package edu.fiuba.algo3.modelo;

public class RespuestaUsuario {
    private Opcion respuesta;

    public RespuestaUsuario(Opcion respuesta){
        this.respuesta = respuesta;
    }
    public Opcion valor(){
        return respuesta;
    }
}
