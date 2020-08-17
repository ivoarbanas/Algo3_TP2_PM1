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
    private ArrayList<ExclusividadDePuntaje> exclusividadDePuntajes;
    private ExclusividadDePuntaje exclusividadPuntajeActivo;
    private boolean usoExclusividadEnRonda;

    public Usuario (String nombre){
        this.nombre = nombre;
        x2 = new X2();
        x3 = new X3();
        multiplicadorActivo = new MultiplicadorInactivo();
        puntaje = new Puntaje();
        respuestasDelUsuario = new ArrayList();
        exclusividadDePuntajes = new ArrayList<ExclusividadDePuntaje>();
        exclusividadDePuntajes.add(new ExclusividadDePuntajeDoble());
        exclusividadDePuntajes.add(new ExclusividadDePuntajeDoble());
        exclusividadPuntajeActivo = new ExclusividadDePuntajeNulo();
        usoExclusividadEnRonda = false;
    }

    public Multiplicador getX2(){
        return x2;
    }

    public Multiplicador getX3(){
        return x3;
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

    public void utilizarMultiplicadorX2(){
        multiplicadorActivo = x2;
        x2 = new MultiplicadorInactivo();
    }

    public void utilizarMultiplicadorX3(){
        multiplicadorActivo = x3;
        x3 = new MultiplicadorInactivo();
    }

    public void limpiarMultiplicador(){
        multiplicadorActivo = new MultiplicadorInactivo();
    }

    public Multiplicador getMultiplicador(){
        return multiplicadorActivo;
    }

    public void utilizarExclusividadPuntaje(){
        ExclusividadDePuntaje auxiliar = this.exclusividadDePuntajes.get(0);
        this.exclusividadDePuntajes.remove(0);
        exclusividadPuntajeActivo = auxiliar;
        usoExclusividadEnRonda = true;
    }

    public void limpiarExclusividad(){
        exclusividadPuntajeActivo = new ExclusividadDePuntajeNulo();
        usoExclusividadEnRonda = false;
    }

    public ExclusividadDePuntaje getExclusividad(){
        return exclusividadPuntajeActivo;
    }

    public boolean usoExclusividadEnRonda(){
        return usoExclusividadEnRonda;
    }

    public String nombre(){
        return nombre;
    }

    public int quedaExclusividad(){
        return exclusividadDePuntajes.size();
    }
}

