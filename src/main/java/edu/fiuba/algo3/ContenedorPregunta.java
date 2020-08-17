package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.EnviarRespuestaGroupChoiceHandler;
import edu.fiuba.algo3.Eventos.EnviarRespuestaMultipleChoiceHandler;
import edu.fiuba.algo3.Eventos.EnviarRespuestaOrderedChoiceHandler;
import edu.fiuba.algo3.Eventos.EnviarRespuestaVerdaderoFalsoHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class ContenedorPregunta extends BorderPane {

    BarraDeMenu menuBar;
    Kahoot kahoot;
    Stage stage;
    Usuario jugadorActivo;
    VBox preguntaYOpciones;
    Label enunciado;
    HBox general;
    Button aceptar;
    VBox puntos;
    VBox multiplicadores;
    ToggleGroup grupoMultiplicadores;
    ArrayList<ToggleButton> botonesMultiplicadores;

    public ContenedorPregunta(Stage stage, Kahoot kahoot){
        this.stage = stage;
        this.kahoot = kahoot;
        this.setMenu(stage);
        general = new HBox();
        aceptar = new Button("Aceptar");
        puntos = new VBox();
        multiplicadores = new VBox();
        grupoMultiplicadores = new ToggleGroup();
        this.mostrarPregunta();
    }

    private void mostrarPregunta() {
        jugadorActivo = kahoot.jugadores().get(0);
        ToggleButton x2 = new ToggleButton("X2");
        x2.setUserData(jugadorActivo.getX2());
        ToggleButton x3 = new ToggleButton("X3");
        x3.setUserData(jugadorActivo.getX3());
        ToggleButton exclusividad = new ToggleButton("Exclusividad");
        botonesMultiplicadores = new ArrayList<>();
        botonesMultiplicadores.add(x2);
        botonesMultiplicadores.add(x3);
        botonesMultiplicadores.add(exclusividad);
        x2.setToggleGroup(grupoMultiplicadores);
        x3.setToggleGroup(grupoMultiplicadores);
        exclusividad.setToggleGroup(grupoMultiplicadores);
        multiplicadores.getChildren().addAll(x2, x3, exclusividad);
        preguntaYOpciones = new VBox();
        Label puntosJugadorUno = new Label(kahoot.jugadores().get(0).nombre() + ": " + kahoot.jugadores().get(0).puntaje().valor());
        Label puntosJugadorDos = new Label(kahoot.jugadores().get(1).nombre() + ": " + kahoot.jugadores().get(1).puntaje().valor());
        enunciado = new Label(kahoot.rondaActiva().pregunta().enunciado());
        puntos.getChildren().addAll(puntosJugadorUno, puntosJugadorDos);
        setContenido(kahoot.rondaActiva().pregunta());

    }

    private void setContenido(Pregunta pregunta){
        VBox opcionesUno = new VBox();
        VBox opcionesDos = new VBox();
        HBox todasLasOpciones = new HBox();
        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        if(pregunta instanceof VerdaderoFalso){

            ToggleGroup grupoOpciones = new ToggleGroup();
            ArrayList<ToggleButton> botonesOpciones = new ArrayList<>();
            for (Opcion opcion : opciones) {
                ToggleButton botonOpcion = new ToggleButton(opcion.valor());
                botonOpcion.setUserData(opcion);
                botonesOpciones.add(botonOpcion);
                botonOpcion.setToggleGroup(grupoOpciones);
            }
            for (int opcion = 0; opcion < botonesOpciones.size(); opcion++) {
                if (opcion % 2 != 1) {
                    opcionesUno.getChildren().add(botonesOpciones.get(opcion));
                } else {
                    opcionesDos.getChildren().add(botonesOpciones.get(opcion));
                }

            }
            EnviarRespuestaVerdaderoFalsoHandler enviarRespuestaHandler = new EnviarRespuestaVerdaderoFalsoHandler(kahoot,stage,grupoOpciones,grupoMultiplicadores,botonesOpciones,botonesMultiplicadores,pregunta,this);
            aceptar.setOnAction(enviarRespuestaHandler);
        }

        if(pregunta instanceof MultipleChoice){

            ArrayList<CheckBox> botonesOpciones = new ArrayList<>();
            for (Opcion opcion : opciones) {
                CheckBox botonOpcion = new CheckBox(opcion.valor());
                botonOpcion.setUserData(opcion);
                botonesOpciones.add(botonOpcion);
            }
            Collections.shuffle(botonesOpciones);

            for (int opcion = 0; opcion < botonesOpciones.size(); opcion++) {
                if (opcion % 2 != 1) {
                    opcionesUno.getChildren().add(botonesOpciones.get(opcion));
                } else {
                    opcionesDos.getChildren().add(botonesOpciones.get(opcion));
                }

            }

            EnviarRespuestaMultipleChoiceHandler enviarRespuestaHandler = new EnviarRespuestaMultipleChoiceHandler(kahoot,stage,grupoMultiplicadores,botonesOpciones,botonesMultiplicadores,pregunta,this);
            aceptar.setOnAction(enviarRespuestaHandler);
        }

        if(pregunta instanceof OrderedChoice){

            ArrayList<Spinner> botonesOpciones = new ArrayList<>();
            ArrayList<String> nombresOpciones = new ArrayList<>();

            for (Opcion opcion : opciones) {
                nombresOpciones.add(opcion.valor());
            }
            Collections.shuffle(nombresOpciones);

            for (Opcion opcion : opciones) {
                ObservableList <String> opcionesOrdenadas = FXCollections.observableList(nombresOpciones);
                Spinner botonOpcion = new Spinner(opcionesOrdenadas);
                botonesOpciones.add(botonOpcion);
                todasLasOpciones.getChildren().add(botonOpcion);
            }

            EnviarRespuestaOrderedChoiceHandler enviarRespuestaHandler = new EnviarRespuestaOrderedChoiceHandler(kahoot,stage,grupoMultiplicadores,botonesOpciones,botonesMultiplicadores,pregunta,this);
            aceptar.setOnAction(enviarRespuestaHandler);
        }

        if(pregunta instanceof GroupChoice){
            ArrayList<String> nombresGrupos = new ArrayList<>();
            nombresGrupos.add(((GroupChoice) pregunta).grupoUno());
            nombresGrupos.add(((GroupChoice) pregunta).grupoDos());
            ObservableList <String> grupos = FXCollections.observableList(nombresGrupos);
            ArrayList<HBox> botonesOpciones = new ArrayList<>();
            for (Opcion opcion : opciones) {
                HBox contenedorOpcion = new HBox();
                Spinner botonOpcion = new Spinner(grupos);
                Label nombreOpcion = new Label(opcion.valor());
                contenedorOpcion.getChildren().addAll(nombreOpcion,botonOpcion);
                botonOpcion.setUserData(opcion);
                botonesOpciones.add(contenedorOpcion);
            }

            Collections.shuffle(botonesOpciones);

            for (int opcion = 0; opcion < botonesOpciones.size(); opcion++) {
                if (opcion % 2 != 1) {
                    opcionesUno.getChildren().add(botonesOpciones.get(opcion));
                } else {
                    opcionesDos.getChildren().add(botonesOpciones.get(opcion));
                }

            }
            EnviarRespuestaGroupChoiceHandler enviarRespuestaHandler = new EnviarRespuestaGroupChoiceHandler(kahoot,stage,grupoMultiplicadores,botonesOpciones,botonesMultiplicadores,pregunta,this);
            aceptar.setOnAction(enviarRespuestaHandler);
        }

        todasLasOpciones.getChildren().addAll(opcionesUno, opcionesDos);
        preguntaYOpciones.getChildren().addAll(enunciado, todasLasOpciones, aceptar);
        general.getChildren().addAll(puntos, preguntaYOpciones, multiplicadores);
        this.setCenter(general);
    }

    private void setMenu(Stage stage) {
        Scene vacia = new Scene(new VBox());
        this.menuBar = new BarraDeMenu(vacia,stage);
        this.setTop(menuBar);

    }

    public void jugadorActivo(Usuario jugador){
        jugadorActivo = jugador;
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

    public Usuario getJugadorActivo() {
        return jugadorActivo;
    }
}
