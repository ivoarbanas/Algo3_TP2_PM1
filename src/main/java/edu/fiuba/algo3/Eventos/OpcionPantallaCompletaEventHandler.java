package edu.fiuba.algo3.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.control.MenuItem;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent> {
    Stage stage;
    MenuItem opcionPantallaCompleta;

    public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta) {
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();
        }
    }
}
