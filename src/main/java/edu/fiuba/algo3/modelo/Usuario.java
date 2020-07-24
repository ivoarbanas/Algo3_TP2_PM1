package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private Puntos puntos;
    ArrayList<RespuestaUsuario> respuestasDelUsuario;

    public Usuario (String nombre){
        this.nombre = nombre;
        puntos = new Puntos();
        respuestasDelUsuario = new ArrayList();
    }

    public void nuevaRespuesta(String respuesta) {
        RespuestaUsuario nuevaRespuesta = new RespuestaUsuario(respuesta);
        respuestasDelUsuario.add(nuevaRespuesta);
    }
    public void vaciarRespuestas(){
        respuestasDelUsuario.clear();
    }
    public ArrayList<RespuestaUsuario> respuestas(){
        return respuestasDelUsuario;
    }

    public void cambiarPuntos(Puntos puntos){
        this.puntos = puntos;
    }
    public Puntos puntos(){
        return puntos;
    }

    public int cantidadRespuestasDelUsuario(){ return respuestasDelUsuario.size(); }

}
