package edu.fiuba.algo3.modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class Kahoot {

    private ArrayList<Usuario> jugadores;
    private ArrayList<Ronda> rondas;
    private Ronda rondaActiva;
    private SistemaPuntaje sistemaPuntaje;
    private int ronda;

    public Kahoot() {

        sistemaPuntaje = new SistemaPuntaje();
        jugadores = new ArrayList<Usuario>();
        rondas = new ArrayList<Ronda>();
        ronda = 0;
        rondaActiva = new Ronda();


    }
    public ArrayList<Usuario> jugadores(){
        return jugadores;
    }


    public void verificarRonda() {

        Puntaje puntajeJugadorUno = rondaActiva.obtenerPuntajeJugador(jugadores.get(0));
        Puntaje puntajeJugadorDos = rondaActiva.obtenerPuntajeJugador(jugadores.get(1));



        if( (puntajeJugadorUno.valor() != puntajeJugadorDos.valor() ) ) {
            if ((jugadores.get(0).usoExclusividadEnRonda() && jugadores.get(1).usoExclusividadEnRonda())) {
                ExclusividadDePuntajeCuadruple exclusividadDePuntajeCuadruple = new ExclusividadDePuntajeCuadruple();
                puntajeJugadorUno = this.aplicarExclusividad(puntajeJugadorUno, exclusividadDePuntajeCuadruple);
                puntajeJugadorDos = this.aplicarExclusividad(puntajeJugadorDos, exclusividadDePuntajeCuadruple);
            } else {
                puntajeJugadorUno = this.aplicarExclusividad(puntajeJugadorUno, jugadores.get(0).getExclusividad());
                puntajeJugadorDos = this.aplicarExclusividad(puntajeJugadorDos, jugadores.get(1).getExclusividad());
            }
        }
        if(((jugadores.get(0).usoExclusividadEnRonda() || jugadores.get(1).usoExclusividadEnRonda())) && (puntajeJugadorUno.valor() == puntajeJugadorDos.valor() )){
            puntajeJugadorUno = new Puntaje(0);
            puntajeJugadorDos = new Puntaje(0);
        }

        puntajeJugadorUno = this.aplicarMultiplicador(jugadores().get(0),puntajeJugadorUno);
        puntajeJugadorDos = this.aplicarMultiplicador(jugadores().get(1),puntajeJugadorDos);


        sistemaPuntaje.cambiarPuntaje(jugadores.get(0), puntajeJugadorUno);
        sistemaPuntaje.cambiarPuntaje(jugadores.get(1), puntajeJugadorDos);


    }

    public void crearJugador(String nombre){
        Usuario jugador = new Usuario(nombre);
        jugadores.add(jugador);
    }

    public void cargarPreguntas(){
        try {
            JsonReader reader = new JsonReader(new FileReader("preguntas.json"));

            reader.beginArray();
            while (reader.hasNext()) {

                reader.beginObject();
                while (reader.hasNext()) {
                    String name = reader.nextName();
                    if(name.equals("enunciado")){
                        String enunciado = reader.nextString();
                        name = reader.nextName();
                        String tipoDePregunta = reader.nextString();
                        Ronda ronda = new Ronda();
                        if (tipoDePregunta.equals("Verdadero y Falso Clasico")) {
                            name = reader.nextName();
                            VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico(enunciado,reader.nextBoolean());
                            ronda.cargarPregunta(pregunta);
                            rondas.add(ronda);

                        } else if (tipoDePregunta.equals("Verdadero y Falso con Penalidad")) {
                            name = reader.nextName();
                            VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad(enunciado,reader.nextBoolean());
                            ronda.cargarPregunta(pregunta);
                            rondas.add(ronda);

                        } else if (tipoDePregunta.equals("Multiple Choice Clasico")) {

                            MultipleChoiceClasico pregunta = new MultipleChoiceClasico(enunciado);
                            name = reader.nextName();
                            reader.beginObject();
                            while (reader.hasNext()) {
                                String tipoDeOpcion = reader.nextName();
                                Opcion opcionACargar = new Opcion(reader.nextString());
                                if (tipoDeOpcion.equals("opcionVerdadera")) {
                                    pregunta.cargarOpcionCorrecta(opcionACargar);
                                } else {
                                    pregunta.cargarOpcionIncorrecta(opcionACargar);
                                }

                            }
                            reader.endObject();
                            ronda.cargarPregunta(pregunta);
                            rondas.add(ronda);

                        } else if (tipoDePregunta.equals("Multiple Choice Penalidad")) {

                            MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad(enunciado);
                            name = reader.nextName();
                            reader.beginObject();
                            while (reader.hasNext()) {
                                String tipoDeOpcion = reader.nextName();
                                Opcion opcionACargar = new Opcion(reader.nextString());
                                if (tipoDeOpcion.equals("opcionVerdadera")) {
                                    pregunta.cargarOpcionCorrecta(opcionACargar);
                                } else {
                                    pregunta.cargarOpcionIncorrecta(opcionACargar);
                                }

                            }
                            reader.endObject();
                            ronda.cargarPregunta(pregunta);
                            rondas.add(ronda);

                        } else if (tipoDePregunta.equals("Multiple Choice Parcial")) {

                            MultipleChoiceParcial pregunta = new MultipleChoiceParcial(enunciado);
                            name = reader.nextName();
                            reader.beginObject();
                            while (reader.hasNext()) {
                                String tipoDeOpcion = reader.nextName();
                                Opcion opcionACargar = new Opcion(reader.nextString());
                                if (tipoDeOpcion.equals("opcionVerdadera")) {
                                    pregunta.cargarOpcionCorrecta(opcionACargar);
                                } else {
                                    pregunta.cargarOpcionIncorrecta(opcionACargar);
                                }

                            }
                            reader.endObject();
                            ronda.cargarPregunta(pregunta);
                            rondas.add(ronda);

                        }
                        else if (tipoDePregunta.equals("Ordered Choice")) {

                            OrderedChoice pregunta = new OrderedChoice(enunciado);
                            name = reader.nextName();
                            reader.beginObject();
                            while (reader.hasNext()) {
                                String tipoDeOpcion = reader.nextName();
                                Opcion opcionACargar = new Opcion(reader.nextString());
                                pregunta.cargarOpcionOrdenada(opcionACargar);
                            }
                            reader.endObject();
                            ronda.cargarPregunta(pregunta);
                            rondas.add(ronda);

                        }
                        else if (tipoDePregunta.equals("Group Choice")) {
                            name = reader.nextName();
                            String grupo1 = reader.nextString();
                            name = reader.nextName();
                            String grupo2 = reader.nextString();
                            GroupChoice pregunta = new GroupChoice(grupo1,grupo2);
                            name = reader.nextName();
                            reader.beginObject();
                            while (reader.hasNext()) {
                                String tipoDeOpcion = reader.nextName();
                                Opcion opcionACargar = new Opcion(reader.nextString());
                                if (tipoDeOpcion.equals("opcionGrupo1")) {
                                    pregunta.cargarOpcionesGrupoUno(opcionACargar);
                                } else {
                                    pregunta.cargarOpcionesGrupoDos(opcionACargar);
                                }
                            }
                            reader.endObject();
                            ronda.cargarPregunta(pregunta);
                            rondas.add(ronda);

                        }
                    }

                    else {
                        reader.skipValue();

                    }
                }
                reader.endObject();
            }
            rondaActiva = rondas.get(0);

            reader.endArray();

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cargarPregunta(Pregunta pregunta){
        rondaActiva.cargarPregunta(pregunta);
    }

    public void cambiarRonda(){

        for (Usuario jugador : jugadores){
            jugador.vaciarRespuestas();
            jugador.limpiarMultiplicador();
            jugador.limpiarExclusividad();
        }
        if(ronda + 1 < rondas.size()){
            rondaActiva = rondas.get(ronda + 1);
            ronda += 1;
        }
        else{

        }


    }

    public boolean finDeJuego(){
        if(ronda + 1 < rondas.size()){
            return false;
        }
        else{
            return true;
        }
    }

    public Puntaje aplicarMultiplicador(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return rondaActiva.aplicarMultiplicador(jugadorAfectado,puntajeAMultiplicar);
    }

    public Puntaje aplicarExclusividad(Puntaje puntajeAMultiplicar, ExclusividadDePuntaje exclusividadDePuntaje){
        return rondaActiva.aplicarExclusividad(puntajeAMultiplicar, exclusividadDePuntaje);
    }

    public Ronda rondaActiva(){
        return rondaActiva;
    }

}
