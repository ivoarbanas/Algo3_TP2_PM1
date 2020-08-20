package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.GroupChoice;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MostrarResultadoGroupHandler implements EventHandler<ActionEvent> {

    ArrayList<Opcion> opcionGrupo1,opcionGrupo2;
    ContenedorPregunta contenedor;
    Kahoot kahoot;
    Stage stage;

    public MostrarResultadoGroupHandler(ArrayList<Opcion> opcionGrupo1,ArrayList<Opcion> opcionGrupo2, ContenedorPregunta contenedor, Kahoot kahoot, Stage stage){
        this.opcionGrupo1 = opcionGrupo1;
        this.opcionGrupo2 = opcionGrupo2;
        this.contenedor = contenedor;
        this.kahoot = kahoot;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        Image fondo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        contenedor.setBackground(new Background(imagenDeFondo));

        VBox cajaY = new VBox();
        VBox puntosJugadores = new VBox();

        cajaY.setAlignment(Pos.CENTER);
        cajaY.setSpacing(20);
        puntosJugadores.setAlignment(Pos.CENTER);

        String opcionesGrupo1 = opcionGrupo1.get(0).valor();
        for(int opcion = 1; opcion < opcionGrupo1.size(); opcion++){
            opcionesGrupo1 += ", " + opcionGrupo1.get(opcion).valor();
        }
        String opcionesGrupo2 = opcionGrupo2.get(0).valor();
        for(int opcion = 1; opcion < opcionGrupo2.size(); opcion++){
            opcionesGrupo2 += ", " + opcionGrupo2.get(opcion).valor();
        }
        Label label = new Label("Las respuestas correcta son:\n" + ((GroupChoice)(kahoot.rondaActiva().pregunta())).grupoUno() + ": " + opcionesGrupo1 + "\n" + ((GroupChoice)(kahoot.rondaActiva().pregunta())).grupoDos() + ": " + opcionesGrupo2);
        label.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        label.setTextFill(Color.web("#FFFFFF"));
        Label puntosJugador1 = new Label(kahoot.jugadores().get(0).nombre() + ": " + kahoot.jugadores().get(0).puntaje().valor());
        Label puntosJugadorDos = new Label(kahoot.jugadores().get(1).nombre() + ": " + kahoot.jugadores().get(1).puntaje().valor());
        puntosJugadorDos.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        puntosJugador1.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        puntosJugador1.setTextFill(Color.web("#FFFFFF"));
        puntosJugadorDos.setTextFill(Color.web("#FFFFFF"));
        Button siguiente = new Button("Siguiente Pregunta");
        SiguientePreguntaHandler siguientePreguntaHandler = new SiguientePreguntaHandler(kahoot,stage,contenedor);
        siguiente.setOnAction(siguientePreguntaHandler);
        siguiente.setPrefSize(200,30);
        puntosJugadores.getChildren().addAll(puntosJugador1,puntosJugadorDos);
        cajaY.getChildren().addAll(label,puntosJugadores,siguiente);
        contenedor.setRight(null);
        contenedor.setLeft(null);
        contenedor.setCenter(cajaY);
        stage.setFullScreen(true);
    }
}