package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MostrarResultadoHandler implements EventHandler<ActionEvent> {

    ArrayList<Opcion> opcionCorrecta;
    ContenedorPregunta contenedor;
    Kahoot kahoot;
    Stage stage;

    public MostrarResultadoHandler(ArrayList<Opcion> opcionCorrecta, ContenedorPregunta contenedor, Kahoot kahoot, Stage stage){
        this.opcionCorrecta = opcionCorrecta;
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


        Label label;
        if(opcionCorrecta.size() == 1){
            label = new Label("La respuesta correcta es: " + opcionCorrecta.get(0).valor());
        }
        else{
            String opciones = opcionCorrecta.get(0).valor();
            for(int opcion = 1; opcion < opcionCorrecta.size(); opcion++){
                opciones += ", " + opcionCorrecta.get(opcion).valor();
            }
            label = new Label("Las respuestas correcta son: " + opciones);
        }
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
