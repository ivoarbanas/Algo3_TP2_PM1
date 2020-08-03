package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class GroupChoice extends Pregunta {

    String grupo1;
    String grupo2;
    ArrayList<Opcion> listaOpcionesGrupo1;
    ArrayList<Opcion> listaOpcionesGrupo2;

    public GroupChoice(String nombreGrupo1, String nombreGrupo2, ArrayList<Opcion> opcionesGrupo1, ArrayList<Opcion> opcionesGrupo2){
        super("Coloque las opciones en el grupo adecuado");
        grupo1 = nombreGrupo1;
        grupo2 = nombreGrupo2;
        listaOpcionesGrupo1 = opcionesGrupo1;
        listaOpcionesGrupo2 = opcionesGrupo2;
    }

    public boolean opcionEstaEnListaGrupo(ArrayList<Opcion> listaGrupo, Opcion opcion){
        for(int i=0;i< listaGrupo.size();i++){
            if(listaGrupo.get(i).valor().equals(opcion.valor())) return true;
        }
        return false;
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestasGrupo1) {

        if(!(listaOpcionesGrupo1.size() == listaDeRespuestasGrupo1.size())){
            Puntaje puntajeNulo = new PuntajeNulo();
            return puntajeNulo;
        }
        for (int i=0; i<listaDeRespuestasGrupo1.size();i++){
            if(!opcionEstaEnListaGrupo(listaOpcionesGrupo1, listaDeRespuestasGrupo1.get(i))){
                Puntaje puntajeNulo = new PuntajeNulo();
                return puntajeNulo;
            }
        }
        Puntaje puntajePositivo = new PuntajePositivo();
        return puntajePositivo;
    }
}
