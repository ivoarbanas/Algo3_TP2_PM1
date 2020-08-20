package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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



        VBox general = new VBox();
        HBox mensajeFin = new HBox(new Label("Fin del juego"));
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
        HBox mensajeGanador = new HBox(ganador);

        Label puntos = new Label(kahoot.jugadores().get(0).nombre() + ": "+ puntosJugadorUno + "\n" + kahoot.jugadores().get(1).nombre() + ": " + puntosJugadorDos);

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

        Scene escenaFin = new Scene(general, 512, 250);
        stage.setScene(escenaFin);
        stage.setFullScreen(true);
    }
}
