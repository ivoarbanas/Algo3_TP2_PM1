package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;

import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application  {

    private Stage stage;
    private Scene menuPrincipal;
    private Kahoot kahoot;
    private Usuario jugadorActivo;

    public static void main(String[] args) {
        launch(); //llama a start
    }

    @Override
    public void start(Stage stage) {
        kahoot = new Kahoot();
        this.stage = stage;
        stage.setTitle("Kahoot 2");
        StackPane layout = new StackPane();
        HBox cajaX = new HBox();
        VBox cajaY = new VBox();
        var label = new Label("Bienvenidos a Kahoot 2");
        Button botonReglas = new Button("Reglas");
        Button botonComenzar = new Button("Comenzar");
        Button botonSalir = new Button("Salir");
        botonReglas.setOnAction(e ->mostrarReglas());
        botonComenzar.setOnAction(e ->ingresarNombres());
        botonSalir.setOnAction(e -> stage.close());
        cajaX.getChildren().addAll(botonComenzar,botonReglas,botonSalir);
        cajaY.getChildren().addAll(label,cajaX);
        layout.getChildren().add(cajaY);
        menuPrincipal = new Scene(layout, 640, 480);
        stage.setScene(menuPrincipal);
        stage.show();
    }

    public void mostrarPregunta() {
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

    }

    public void mostrarReglas(){
        var label = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at nunc eu enim mollis laoreet nec id ipsum. Aenean accumsan odio sed vehicula ullamcorper. Nullam sit amet tellus vel justo ultricies interdum. Curabitur porttitor risus luctus nisi aliquet ultrices. Vestibulum scelerisque finibus nisi sed iaculis. Maecenas at consequat dui, sit amet ultricies nulla. Etiam posuere tempor metus ac hendrerit.\n" +
                "\n" +
                "Maecenas egestas ultrices nunc non pretium. Suspendisse nunc sapien, faucibus ac tortor eget, porta consectetur enim. Integer non tempor mauris, non tincidunt ex. Donec et sem tincidunt, faucibus elit ut, volutpat neque. Nam non fermentum augue, eget egestas nibh. Duis pulvinar lacus eu magna ullamcorper dignissim. Praesent eleifend lectus purus, ut lobortis ipsum commodo id. Integer vehicula augue in dolor mattis rhoncus. Vestibulum tempor maximus mi vitae congue. Duis condimentum ipsum eu urna gravida, ac convallis orci eleifend.\n" +
                "\n" +
                "Aliquam erat volutpat. Nulla facilisi. Aenean a erat sed massa porta posuere sed eu enim. Integer consequat euismod dolor sed rutrum. In a eros a mauris porta rhoncus sit amet eget felis. Nam fringilla tempus dictum. Maecenas non ullamcorper nunc. Proin euismod odio quis rutrum egestas. Vivamus ex ligula, congue dictum velit vitae, congue efficitur leo.\n" +
                "\n" +
                "Cras a mi nunc. Nulla facilisi. Cras pellentesque id augue vel gravida. Cras ultricies gravida purus a semper. Nam eu convallis nibh. Phasellus non est vitae urna iaculis mattis. In eget lobortis ipsum. Nunc maximus non felis et lobortis.\n" +
                "\n" +
                "Quisque tincidunt nibh tellus, quis feugiat magna placerat vel. Donec et felis vel magna aliquam elementum id volutpat justo. Vestibulum ac pretium tortor. Curabitur quis felis lectus. Aenean gravida elit imperdiet, luctus lectus maximus, sodales augue. Duis a risus aliquet leo tempus pellentesque at non lorem. In quis auctor lectus. Curabitur placerat luctus libero eu viverra. Etiam sollicitudin lectus leo, ac lacinia justo ullamcorper sed. Duis tempor blandit turpis et lobortis. Proin feugiat, tellus in ullamcorper accumsan, sapien sapien rhoncus urna, at viverra turpis purus et urna. Aliquam feugiat blandit elit sit amet porta.");
        Button botonVolver = new Button("Volver");
        botonVolver.setOnAction(e -> stage.setScene(menuPrincipal));
        VBox cajaY = new VBox();
        cajaY.getChildren().add(label);
        cajaY.getChildren().add(botonVolver);
        StackPane layout = new StackPane();
        layout.getChildren().add(cajaY);
        var scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public void ingresarNombres(){
        if(kahoot.jugadores().size() < 2){
            HBox cajaX = new HBox();
            VBox cajaY = new VBox();
            var label = new Label("Ingrese su nombre: ");
            TextField cajaNombre = new TextField();
            String nombreBoton;
            if(kahoot.jugadores().size() == 1){
                nombreBoton = "Empezar Juego";
            }
            else{
                nombreBoton = "Cargar Jugador";
            }
            Button cargarNombre = new Button(nombreBoton);
            Button botonVolver = new Button("Volver");
            cajaX.getChildren().addAll(label,cajaNombre,cargarNombre);
            cajaY.getChildren().addAll(cajaX,botonVolver);
            cargarNombre.setOnAction(e -> cargarUsuario(cajaNombre));
            botonVolver.setOnAction(e -> stage.setScene(menuPrincipal));

            StackPane layout = new StackPane();
            layout.getChildren().add(cajaY);
            var scene = new Scene(layout, 640, 480);
            stage.setScene(scene);
            stage.show();
        }
        else {
            mostrarPregunta();
        }
    }

    public void cargarUsuario(TextField cajaNombre){
        String nombre = cajaNombre.getText();
        kahoot.crearJugador(nombre);
        ingresarNombres();
    }



}