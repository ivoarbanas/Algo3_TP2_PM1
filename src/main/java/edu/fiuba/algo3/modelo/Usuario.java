package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private Puntos puntos;
    ArrayList<RespuestaUsuario> respuestasDelUsuario;
    ArrayList<Opcion> opcionesDeLaPregunta;

    public Usuario (String nombre){
        this.nombre = nombre;
        puntos = new Puntos();
        respuestasDelUsuario = new ArrayList();
    }

    public void nuevaRespuesta(Opcion respuesta) {
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

    public void elegirRespuesta(Pregunta pregunta) {
        System.out.println("Elija una opcion, numeros");
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();
        nuevaRespuesta(pregunta.opciones().get(eleccion));
    }
}
