package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.EnviarRespuestaGroupChoiceHandler;
import edu.fiuba.algo3.Eventos.EnviarRespuestaMultipleChoiceHandler;
import edu.fiuba.algo3.Eventos.EnviarRespuestaOrderedChoiceHandler;
import edu.fiuba.algo3.Eventos.EnviarRespuestaVerdaderoFalsoHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
//import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class ContenedorPregunta extends BorderPane {

    BarraDeMenu menuBar;
    Kahoot kahoot;
    Stage stage;
    Usuario jugadorActivo;
    VBox preguntaYOpciones;
    MediaPlayer mediaPlayer;
    Label enunciado;
    Button aceptar;
    VBox puntos;
    VBox multiplicadores;
    ToggleGroup grupoMultiplicadores;
    Label tipoDePregunta;
    ArrayList<ToggleButton> botonesMultiplicadores;
    HBox cajaTurno;

    public ContenedorPregunta(Stage stage, Kahoot kahoot, MediaPlayer mediaPlayer){
        this.stage = stage;
        this.kahoot = kahoot;
        this.mediaPlayer = mediaPlayer;
        this.setMenu(stage);
        jugadorActivo = kahoot.jugadores().get(0);
        this.mostrarPregunta();
    }

    public void mostrarPregunta() {
        aceptar = new Button("Aceptar");
        puntos = new VBox();
        multiplicadores = new VBox();
        grupoMultiplicadores = new ToggleGroup();
        preguntaYOpciones = new VBox();

        // Seteamos posiciones de cajas y botones
        preguntaYOpciones.setAlignment(Pos.CENTER);
        preguntaYOpciones.setSpacing(20);
        puntos.setAlignment(Pos.BOTTOM_LEFT);
        multiplicadores.setAlignment(Pos.TOP_RIGHT);
        aceptar.setPrefSize(200,30);



        Label puntosJugadorUno = new Label(kahoot.jugadores().get(0).nombre() + ": " + kahoot.jugadores().get(0).puntaje().valor());
        Label puntosJugadorDos = new Label(kahoot.jugadores().get(1).nombre() + ": " + kahoot.jugadores().get(1).puntaje().valor());
        Label turno = new Label("Turno de: " + jugadorActivo.nombre());
        turno.setTextFill(Color.web("#FFFFFF"));
        turno.setPrefHeight(250);
        cajaTurno = new HBox(turno);
        puntosJugadorDos.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        puntosJugadorUno.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        puntosJugadorUno.setTextFill(Color.web("#FFFFFF"));
        puntosJugadorDos.setTextFill(Color.web("#FFFFFF"));
        turno.setFont(Font.font("Sans Serif", FontWeight.BOLD, 35));
        tipoDePregunta = new Label("Pregunta " + kahoot.rondaActiva().pregunta().getClass().getSimpleName());
        tipoDePregunta.setFont(Font.font("Sans Serif", FontWeight.BOLD, 30));
        tipoDePregunta.setTextFill(Color.web("#FFFFFF"));
        enunciado = new Label(kahoot.rondaActiva().pregunta().enunciado());
        enunciado.setFont(Font.font("Sans Serif", FontWeight.BOLD, 40));
        enunciado.setTextFill(Color.web("#FFFFFF"));
        puntos.getChildren().addAll(puntosJugadorUno, puntosJugadorDos);
        setContenido(kahoot.rondaActiva().pregunta());


    }

    private void setContenido(Pregunta pregunta){

        Image fondo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        botonesMultiplicadores = new ArrayList<>();
        ToggleButton x2 = new ToggleButton("X2");
        ToggleButton x3 = new ToggleButton("X3");
        ToggleButton exclusividad = new ToggleButton("Exclusividad");
        x2.setPrefSize(200,30);
        x3.setPrefSize(200,30);

        exclusividad.setPrefSize(200,30);
        x2.setUserData(jugadorActivo.getX2());
        x2.setToggleGroup(grupoMultiplicadores);
        x3.setUserData(jugadorActivo.getX3());
        x3.setToggleGroup(grupoMultiplicadores);
        exclusividad.setUserData(jugadorActivo.getExclusividad());
        exclusividad.setToggleGroup(grupoMultiplicadores);
        botonesMultiplicadores.add(x2);
        botonesMultiplicadores.add(x3);
        botonesMultiplicadores.add(exclusividad);

        if(pregunta instanceof VerdaderoFalsoPenalidad || pregunta instanceof MultipleChoicePenalidad){
            if(!(jugadorActivo.getX2() instanceof MultiplicadorInactivo)){
                multiplicadores.getChildren().add(x2);
            }
           if(!(jugadorActivo.getX3() instanceof MultiplicadorInactivo)){
               multiplicadores.getChildren().add(x3);
           }
        }
        else if(jugadorActivo.quedaExclusividad() != 0){
            multiplicadores.getChildren().add(exclusividad);
        }

        VBox opcionesUno = new VBox();
        VBox opcionesDos = new VBox();
        HBox todasLasOpciones = new HBox();
        todasLasOpciones.setAlignment(Pos.CENTER);
        opcionesDos.setAlignment(Pos.CENTER);
        opcionesUno.setAlignment(Pos.CENTER);
        todasLasOpciones.setPrefSize(600,200);
        todasLasOpciones.setSpacing(40);
        opcionesDos.setSpacing(30);
        opcionesUno.setSpacing(30);
        ArrayList<Opcion> opciones = pregunta.obtenerOpciones();

        if(pregunta instanceof VerdaderoFalso){

            ToggleGroup grupoOpciones = new ToggleGroup();
            ArrayList<ToggleButton> botonesOpciones = new ArrayList<>();
            for (Opcion opcion : opciones) {
                ToggleButton botonOpcion = new ToggleButton(opcion.valor());

                botonOpcion.setUserData(opcion);
                botonOpcion.setPrefSize(300,50);
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
                botonOpcion.setPrefSize(200,40);
                botonOpcion.setFont(Font.font("Sans Serif", FontWeight.BOLD, 20));
                botonOpcion.setTextFill(Color.web("#FFFFFF"));
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
                botonOpcion.setPrefSize(200,40);
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
                contenedorOpcion.setAlignment(Pos.CENTER);
                Spinner botonOpcion = new Spinner(grupos);
                botonOpcion.setPrefSize(200,40);
                Label nombreOpcion = new Label(opcion.valor() + "  ");
                nombreOpcion.setFont(Font.font("Sans Serif", FontWeight.BOLD, 20));
                nombreOpcion.setTextFill(Color.web("#FFFFFF"));
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
        preguntaYOpciones.getChildren().addAll(tipoDePregunta,enunciado, todasLasOpciones, aceptar);
        cajaTurno.setAlignment(Pos.CENTER);
        VBox aux = new VBox();
        aux.getChildren().addAll(cajaTurno,preguntaYOpciones);
        this.setCenter(aux);
        this.setLeft(puntos);
        this.setRight(multiplicadores);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(kahoot,stage,mediaPlayer);
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
