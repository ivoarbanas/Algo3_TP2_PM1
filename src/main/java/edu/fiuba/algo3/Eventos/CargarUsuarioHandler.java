package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class CargarUsuarioHandler implements EventHandler<ActionEvent> {

    TextField nombreJugadorUno, nombreJugadorDos;
    Kahoot kahoot;
    Stage stage;
    MediaPlayer mediaPlayer;

    public CargarUsuarioHandler(Kahoot kahoot, TextField nombreJugadorUno, TextField nombreJugadorDos, Stage stage, MediaPlayer mediaPlayer){
        this.kahoot = kahoot;
        this.nombreJugadorUno = nombreJugadorUno;
        this.nombreJugadorDos = nombreJugadorDos;
        this.stage = stage;
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void handle(ActionEvent event) {
        if(nombreJugadorUno.getText().isEmpty() && !(nombreJugadorDos.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Ingrese un nombre válido para el jugador uno");
            String mensaje = "Presione OK para continuar";
            alert.setContentText(mensaje);
            alert.show();
        }
        else if(nombreJugadorDos.getText().isEmpty() && !(nombreJugadorUno.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Ingrese un nombre válido para el jugador dos");
            String mensaje = "Presione OK para continuar";
            alert.setContentText(mensaje);
            alert.show();
        }
        else if(nombreJugadorUno.getText().isEmpty() && nombreJugadorDos.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Ingrese un nombre válido para ambos jugadores");
            String mensaje = "Presione OK para continuar";
            alert.setContentText(mensaje);
            alert.show();
        }
        else{
            String nombreUsuarioUno = nombreJugadorUno.getText();
            kahoot.crearJugador(nombreUsuarioUno);
            String nombreUsuarioDos = nombreJugadorDos.getText();
            kahoot.crearJugador(nombreUsuarioDos);

            ContenedorPregunta contenedorPregunta = new ContenedorPregunta(stage, kahoot,mediaPlayer);
            Scene escenaPregunta = new Scene(contenedorPregunta, 1024, 500);

            AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerPreguntas = new AplicacionOnKeyPressEventHandler(stage, contenedorPregunta.getBarraDeMenu());
            escenaPregunta.setOnKeyPressed(aplicacionOnKeyPressEventHandlerPreguntas);

            stage.setScene(escenaPregunta);
            stage.setFullScreen(true);
        }
    }
}
