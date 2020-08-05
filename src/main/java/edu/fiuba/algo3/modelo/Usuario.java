package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private Puntaje puntaje;
    private Multiplicador multiplicadorActivo;
    private Multiplicador x2;
    private Multiplicador x3;
    private ArrayList<Opcion> respuestasDelUsuario;

    public Usuario (String nombre){
        this.nombre = nombre;
        x2 = new X2();
        x3 = new X3();
        multiplicadorActivo = new MultiplicadorInactivo();
        puntaje = new Puntaje();
        respuestasDelUsuario = new ArrayList();
    }


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

    public void cambiarPuntaje(Puntaje puntaje){
        this.puntaje.cantidad(puntaje.valor() + this.puntaje().valor());
    }

    public Puntaje puntaje(){
        return puntaje;
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


    public void utilizarMultiplicadorX2(){
        multiplicadorActivo = x2;
        x2 = new MultiplicadorInactivo();
    }

    public void utilizarMultiplicadorX3(){
        multiplicadorActivo = x3;
        x3 = new MultiplicadorInactivo();;
    }

    public void limpiarMultiplicador(){
        multiplicadorActivo = null;
    }

    public Multiplicador getMultiplicador(){
        return multiplicadorActivo;
    }

}

