package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.EnviarRespuestaMultipleChoiceHandler;
import edu.fiuba.algo3.Eventos.EnviarRespuestaVerdaderoFalsoHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

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
        ToggleButton x2 = new ToggleButton("X2");
        ToggleButton x3 = new ToggleButton("X3");
        ToggleButton exclusividad = new ToggleButton("Exclusividad");
        botonesMultiplicadores = new ArrayList<>();
        botonesMultiplicadores.add(x2);
        botonesMultiplicadores.add(x3);
        botonesMultiplicadores.add(exclusividad);
        x2.setToggleGroup(grupoMultiplicadores);
        x3.setToggleGroup(grupoMultiplicadores);
        exclusividad.setToggleGroup(grupoMultiplicadores);
        multiplicadores.getChildren().addAll(x2, x3, exclusividad);
        this.mostrarPregunta();
    }

    private void mostrarPregunta() {
        jugadorActivo = kahoot.jugadores().get(0);
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
