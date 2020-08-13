package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.AplicacionOnKeyPressEventHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application  {

    public static void main(String[] args) {
        launch(); //llama a start
    }

    @Override
    public void start(Stage stage) {
        Kahoot kahoot = new Kahoot();
        stage.setTitle("Kahoot 2");

        ContenedorNombres contenedorPrincipal = new ContenedorNombres(stage, kahoot);
        Scene escenaNombres = new Scene(contenedorPrincipal, 512, 250);

        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerNombres = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaNombres.setOnKeyPressed(aplicacionOnKeyPressEventHandlerNombres);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaNombres,kahoot);
        Scene escenaInicial = new Scene(contenedorBienvenidos, 512, 250);

        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerInicial = new AplicacionOnKeyPressEventHandler(stage, contenedorBienvenidos.getBarraDeMenu());
        escenaInicial.setOnKeyPressed(aplicacionOnKeyPressEventHandlerInicial);

        stage.setScene(escenaInicial);
        stage.show();
    }


    /*public void mostrarPregunta() {
        //aca hay que usar un metodo para obtener pregunta
        jugadorActivo = kahoot.jugadores().get(0);
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobe el parcial", false);
        kahoot.cargarPregunta(pregunta);
        StackPane layoutPregunta = new StackPane();
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
        Button aceptar = new Button("Aceptar");
        var puntosJugador1 = new Label(kahoot.jugadores().get(0).nombre() + ": " + kahoot.jugadores().get(0).puntaje().valor());
        var puntosJugadorDos = new Label(kahoot.jugadores().get(1).nombre() + ": " + kahoot.jugadores().get(1).puntaje().valor());
        var enunciado = new Label(pregunta.enunciado());
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
        puntos.getChildren().addAll(puntosJugador1, puntosJugadorDos);
        todasLasOpciones.getChildren().addAll(opcionesUno, opcionesDos);
        preguntaYOpciones.getChildren().addAll(enunciado, todasLasOpciones, aceptar);
        multiplicadores.getChildren().addAll(x2, x3, exclusividad);
        general.getChildren().addAll(puntos, preguntaYOpciones, multiplicadores);
        layoutPregunta.getChildren().add(general);
        aceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Toggle opcionTogger = grupoOpciones.getSelectedToggle();
                ArrayList<Opcion> opcionElegida = new ArrayList<>();
                if (opcionTogger == botonesOpciones.get(0)) {
                    Opcion unaOpcionElegida = (Opcion) botonesOpciones.get(0).getUserData();
                    opcionElegida.add(unaOpcionElegida);
                    jugadorActivo.cargarRespuestas(opcionElegida);
                    botonesOpciones.get(0).setSelected(false);

                } else if (opcionTogger == botonesOpciones.get(1)) {
                    Opcion unaOpcionElegida = (Opcion) botonesOpciones.get(1).getUserData();
                    opcionElegida.add(unaOpcionElegida);
                    jugadorActivo.cargarRespuestas(opcionElegida);
                    botonesOpciones.get(1).setSelected(false);

                } else {
                    //no selecciona nada (ventana emergente)
                }
                Toggle multiplicadoresTogger = grupoMultiplicadores.getSelectedToggle();
                if(multiplicadoresTogger == x2){
                    jugadorActivo.utilizarMultiplicadorX2();
                    x2.setSelected(false);
                }
                else if(multiplicadoresTogger == x3){
                    jugadorActivo.utilizarMultiplicadorX3();
                    x3.setSelected(false);
                }
                else if(multiplicadoresTogger == exclusividad){
                    //jugadorActivo.utilizarExclusividad();
                }
                if(jugadorActivo == kahoot.jugadores().get(1)){
                    jugadorActivo = kahoot.jugadores().get(0);
                    kahoot.verificarRonda();
                    mostrarResultado(pregunta.opcionCorrecta());
                }
                else{
                    jugadorActivo = kahoot.jugadores().get(1);
                }
            }
        });
        var scenePregunta = new Scene(layoutPregunta, 640, 480);
        stage.setScene(scenePregunta);
        stage.show();
    }

    public void mostrarResultado(Opcion opcionCorrecta){
        StackPane layout = new StackPane();
        VBox cajaY = new VBox();
        HBox cajaX = new HBox();
        VBox puntosJugadores = new VBox();
        var label = new Label("La respuesta correcta es: "+opcionCorrecta.valor());
        var puntosJugador1 = new Label(kahoot.jugadores().get(0).nombre() + ": " + kahoot.jugadores().get(0).puntaje().valor());
        var puntosJugadorDos = new Label(kahoot.jugadores().get(1).nombre() + ": " + kahoot.jugadores().get(1).puntaje().valor());
        Button siguiente = new Button("Siguiente Pregunta");
        siguiente.setOnAction(e -> mostrarPregunta());
        puntosJugadores.getChildren().addAll(puntosJugador1,puntosJugadorDos);
        cajaY.getChildren().addAll(label,siguiente);
        cajaX.getChildren().addAll(puntosJugadores,cajaY);
        layout.getChildren().add(cajaX);
        var respuestaCorrecta = new Scene(layout, 640, 480);
        stage.setScene(respuestaCorrecta);
        stage.show();

    }*/

}