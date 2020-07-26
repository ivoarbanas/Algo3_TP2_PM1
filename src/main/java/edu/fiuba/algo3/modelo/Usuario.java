package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private Puntos puntos;
    ArrayList<RespuestaUsuario> respuestasDelUsuario;
    ArrayList<Opcion> opcionesDeLaPregunta;
    private boolean todasCorrectas; //cuando cambia de ronda esto de reinicia

    public Usuario (String nombre){
        this.nombre = nombre;
        puntos = new Puntos();
        respuestasDelUsuario = new ArrayList();
        todasCorrectas = true;
    }

    private boolean respuestaYaCreada(Opcion respuestaNueva){
        for(int i=0; i<cantidadRespuestasDelUsuario() ;i++){
            if(respuestaNueva == respuestasDelUsuario.get(i).valor()){
                return true;
            }
        }
        return false;
    }

    public void nuevaRespuesta(Opcion respuestaNueva) {
        if(!respuestaYaCreada(respuestaNueva)){
            RespuestaUsuario nuevaRespuesta = new RespuestaUsuario(respuestaNueva);
            respuestasDelUsuario.add(nuevaRespuesta);
        }
    }
    private void vaciarRespuestas(){
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

    public void elegirRespuestaParaPrueba(Pregunta pregunta,int eleccion) {
        nuevaRespuesta(pregunta.opciones().get(eleccion));
    }

    public int cantidadRespuestasDelUsuario(){
        return respuestasDelUsuario.size();
    }

    public boolean sonTodasCorrectas(){
        return todasCorrectas;
    }

    public void nuevaRonda() {
        todasCorrectas = true;
        vaciarRespuestas();
    }

    public void respuestaIncorrecta() {
        todasCorrectas = false;
    }
}

