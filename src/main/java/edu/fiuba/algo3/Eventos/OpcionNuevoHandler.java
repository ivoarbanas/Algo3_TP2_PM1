package edu.fiuba.algo3.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionNuevoHandler implements EventHandler<ActionEvent> {

    Scene proximaEscena;
    Stage stage;

    public OpcionNuevoHandler(Scene proximaEscena, Stage stage){
        this.proximaEscena = proximaEscena;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);

    }
}
