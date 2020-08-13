package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CargarUsuarioHandler implements EventHandler<ActionEvent> {

    TextField nombreJugadorUno, nombreJugadorDos;
    Kahoot kahoot;
    Stage stage;
    Scene proximaEscena;

    public CargarUsuarioHandler(Kahoot kahoot, TextField nombreJugadorUno, TextField nombreJugadorDos, Stage stage, Scene proximaEscena){
        this.kahoot = kahoot;
        this.nombreJugadorUno = nombreJugadorUno;
        this.nombreJugadorDos = nombreJugadorDos;
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(ActionEvent event) {
        String nombreUsuarioUno = nombreJugadorUno.getText();
        kahoot.crearJugador(nombreUsuarioUno);
        String nombreUsuarioDos = nombreJugadorDos.getText();
        kahoot.crearJugador(nombreUsuarioDos);
        stage.setScene(proximaEscena);
    }
}
