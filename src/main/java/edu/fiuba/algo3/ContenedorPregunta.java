package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.EnviarRespuestaHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Usuario;
import edu.fiuba.algo3.modelo.VerdaderoFalsoPenalidad;
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

    public ContenedorPregunta(Stage stage, Kahoot kahoot){
        this.stage = stage;
        this.kahoot = kahoot;
        this.setMenu(stage);
        this.setContenido();
    }

    private void setContenido() {
        jugadorActivo = kahoot.jugadores().get(0);
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobe el parcial", false);
        kahoot.cargarPregunta(pregunta);
        VBox preguntaYOpciones = new VBox();
        VBox puntos = new VBox();
        VBox multiplicadores = new VBox();
        HBox general = new HBox();
        VBox opcionesUno = new VBox();
        VBox opcionesDos = new VBox();
        HBox todasLasOpciones = new HBox();
        ToggleGroup grupoOpciones = new ToggleGroup();
        ToggleGroup grupoMultiplicadores = new ToggleGroup();
        ToggleButton x2 = new ToggleButton("X2");
        ToggleButton x3 = new ToggleButton("X3");
        ToggleButton exclusividad = new ToggleButton("Exclusividad");
        ArrayList<ToggleButton> botonesMultiplicadores = new ArrayList<>();
        botonesMultiplicadores.add(x2);
        botonesMultiplicadores.add(x3);
        botonesMultiplicadores.add(exclusividad);
        Button aceptar = new Button("Aceptar");
        Label puntosJugadorUno = new Label(kahoot.jugadores().get(0).nombre() + ": " + kahoot.jugadores().get(0).puntaje().valor());
        Label puntosJugadorDos = new Label(kahoot.jugadores().get(1).nombre() + ": " + kahoot.jugadores().get(1).puntaje().valor());
        Label enunciado = new Label(pregunta.enunciado());
        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();
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
        x2.setToggleGroup(grupoMultiplicadores);
        x3.setToggleGroup(grupoMultiplicadores);
        exclusividad.setToggleGroup(grupoMultiplicadores);
        puntos.getChildren().addAll(puntosJugadorUno, puntosJugadorDos);
        todasLasOpciones.getChildren().addAll(opcionesUno, opcionesDos);
        preguntaYOpciones.getChildren().addAll(enunciado, todasLasOpciones, aceptar);
        multiplicadores.getChildren().addAll(x2, x3, exclusividad);
        general.getChildren().addAll(puntos, preguntaYOpciones, multiplicadores);
        EnviarRespuestaHandler enviarRespuestaHandler = new EnviarRespuestaHandler(kahoot,grupoOpciones,grupoMultiplicadores,botonesOpciones,botonesMultiplicadores,jugadorActivo,pregunta,this);
        aceptar.setOnAction(enviarRespuestaHandler);
        this.setCenter(general);
    }

    private void setMenu(Stage stage) {
        Scene vacia = new Scene(new VBox());
        this.menuBar = new BarraDeMenu(vacia,stage);
        this.setTop(menuBar);

    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}
