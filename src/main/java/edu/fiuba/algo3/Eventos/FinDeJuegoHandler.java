package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FinDeJuegoHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Kahoot kahoot;

    public FinDeJuegoHandler(Stage stage, Kahoot kahoot) {
        this.stage = stage;
        this.kahoot = kahoot;
    }

    @Override
    public void handle(ActionEvent event) {

        HBox aux2 = new HBox();
        ImageView aux3 = new ImageView("file:src/main/java/edu/fiuba/algo3/imagenes/logo_purple.png");
        aux2.getChildren().add(aux3);
        BorderPane aux = new BorderPane();
        VBox general = new VBox();
        Label finDeJuego = new Label("Fin del juego");
        finDeJuego.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        finDeJuego.setTextFill(Color.web("#FFFFFF"));
        HBox mensajeFin = new HBox(finDeJuego);
        Label ganador = new Label();
        int puntosJugadorUno = kahoot.jugadores().get(0).puntaje().valor();
        int puntosJugadorDos= kahoot.jugadores().get(1).puntaje().valor();
        if(puntosJugadorUno > puntosJugadorDos){
            ganador.setText("El ganador es: " + kahoot.jugadores().get(0).nombre());
        }
        else if(puntosJugadorUno < puntosJugadorDos){
            ganador.setText("El ganador es: " + kahoot.jugadores().get(1).nombre());
        }
        else {
            ganador.setText("Hubo un empate");
        }
        ganador.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        ganador.setTextFill(Color.web("#FFFFFF"));
        HBox mensajeGanador = new HBox(ganador);

        Label puntos = new Label(kahoot.jugadores().get(0).nombre() + ": "+ puntosJugadorUno + "\n" + kahoot.jugadores().get(1).nombre() + ": " + puntosJugadorDos);
        puntos.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        puntos.setTextFill(Color.web("#FFFFFF"));
        HBox mensajePuntos = new HBox(puntos);

        Button fin = new Button("Finalizar");
        OpcionSalirEventHandler salir = new OpcionSalirEventHandler();
        fin.setOnAction(salir);
        Button nuevo = new Button("Juego Nuevo");
        ReiniciarHandler reiniciar = new ReiniciarHandler(stage);
        nuevo.setOnAction(reiniciar);
        HBox botones = new HBox();
        botones.getChildren().addAll(nuevo,fin);

        general.getChildren().addAll(mensajeFin,mensajeGanador,mensajePuntos,botones);

        Image fondo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        aux.setBackground(new Background(imagenDeFondo));
        general.setAlignment(Pos.CENTER);
        aux2.getChildren().add(general);
        aux2.setAlignment(Pos.CENTER);
        aux.setCenter(aux2);
        Scene escenaFin = new Scene(aux, 512, 250);
        stage.setScene(escenaFin);
        stage.setFullScreen(true);
        stage.show();
    }
}
