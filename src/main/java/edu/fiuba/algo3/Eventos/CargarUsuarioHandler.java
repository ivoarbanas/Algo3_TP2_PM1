package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class CargarUsuarioHandler implements EventHandler<ActionEvent> {

    TextField nombreJugadorUno, nombreJugadorDos;
    Kahoot kahoot;

    public CargarUsuarioHandler(Kahoot kahoot, TextField nombreJugadorUno, TextField nombreJugadorDos){
        this.kahoot = kahoot;
        this.nombreJugadorUno = nombreJugadorUno;
        this.nombreJugadorDos = nombreJugadorDos;
    }

    @Override
    public void handle(ActionEvent event) {
        String nombreUsuarioUno = nombreJugadorUno.getText();
        kahoot.crearJugador(nombreUsuarioUno);
        String nombreUsuarioDos = nombreJugadorDos.getText();
        kahoot.crearJugador(nombreUsuarioDos);
    }
}
