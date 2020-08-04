package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private Puntaje Puntaje;
    private boolean utilizaMultiplicador;
    public Multiplicador multiplicador;
    ArrayList<Opcion> respuestasDelUsuario;

    public Usuario (String nombre){
        this.nombre = nombre;
        utilizaMultiplicador = false;
        Puntaje = new Puntaje();
        respuestasDelUsuario = new ArrayList();
    }

    // NO USO
    /*private boolean respuestaYaCreada(Opcion respuestaNueva){
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
    }*/

    public void vaciarRespuestas(){
        respuestasDelUsuario.clear();
    }

    public void cargarRespuestas(ArrayList<Opcion> listaDeRespuestas){
        vaciarRespuestas();
        respuestasDelUsuario = listaDeRespuestas;
    }

    public ArrayList<Opcion> respuestas(){
        return respuestasDelUsuario;
    }

    public void cambiarPuntaje(Puntaje Puntaje){
        this.Puntaje = Puntaje;
    }

    public Puntaje puntaje(){
        return Puntaje;
    }

    // TODAVIA NO IMPLEMENTAMOS >> REEMPLAZO POR CARGAR_RESPUESTA

    public void elegirRespuesta(Pregunta pregunta) {

        //System.out.println("Elija una opcion, numeros"); aca va javafx

        // EL SCANNER DEBERIA IR AÑADIENDO OPCION A OPCION EN LA LISTADERESPUESTAS Y LUEGO CARGARLA AL USUARIO
        Scanner scanner = new Scanner(System.in);
        int eleccion = scanner.nextInt();

        ArrayList <Opcion> listaDeRespuestas = new ArrayList<Opcion>();
        cargarRespuestas(listaDeRespuestas);
    }

    /*
    public void elegirRespuestaParaPrueba(Pregunta pregunta,int eleccion) {
        nuevaRespuesta(pregunta.opciones().get(eleccion));
    }*/

    public int cantidadRespuestasDelUsuario(){
        return respuestasDelUsuario.size();
    }

    public void utilizarMultiplicador(Multiplicador multiplicadorAsignado){
        utilizaMultiplicador = true;
        multiplicador = multiplicadorAsignado;
    }

    public void limpiarMultiplicador(){
        utilizaMultiplicador = false;
    }

    public Multiplicador getMultiplicador(){
        return multiplicador;
    }

    public boolean utilizaMultiplicador(){
        return utilizaMultiplicador;
    }
}

