package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        VBox cajaY = new VBox();
        HBox cajaX = new HBox();
        VBox puntosJugadores = new VBox();
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

        Label puntosJugador1 = new Label(kahoot.jugadores().get(0).nombre() + ": " + kahoot.jugadores().get(0).puntaje().valor());
        Label puntosJugadorDos = new Label(kahoot.jugadores().get(1).nombre() + ": " + kahoot.jugadores().get(1).puntaje().valor());
        Button siguiente = new Button("Siguiente Pregunta");
        SiguientePreguntaHandler siguientePreguntaHandler = new SiguientePreguntaHandler(kahoot,stage);
        siguiente.setOnAction(siguientePreguntaHandler);
        puntosJugadores.getChildren().addAll(puntosJugador1,puntosJugadorDos);
        cajaY.getChildren().addAll(label,siguiente);
        cajaX.getChildren().addAll(puntosJugadores,cajaY);
        contenedor.setCenter(cajaX);
    }
}
