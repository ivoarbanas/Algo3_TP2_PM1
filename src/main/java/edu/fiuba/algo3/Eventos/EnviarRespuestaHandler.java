package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EnviarRespuestaHandler implements EventHandler<ActionEvent> {

    Kahoot kahoot;
    ToggleGroup grupoMultiplicadores;
    ArrayList<ToggleButton> botonesMultiplicadores;
    Pregunta pregunta;
    ContenedorPregunta contenedor;
    Stage stage;

    public EnviarRespuestaHandler(Kahoot kahoot, Stage stage, ToggleGroup grupoMultiplicadores, ArrayList<ToggleButton> botonesMultiplicadores, Pregunta pregunta,  ContenedorPregunta contenedor){
        this.kahoot = kahoot;
        this.grupoMultiplicadores = grupoMultiplicadores;
        this.botonesMultiplicadores = botonesMultiplicadores;
        this.pregunta = pregunta;
        this.contenedor = contenedor;
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent event) {

        Toggle multiplicadoresTogger = grupoMultiplicadores.getSelectedToggle();
        if(multiplicadoresTogger == botonesMultiplicadores.get(0)){
            if(contenedor.getJugadorActivo().quedaX2() != 0){
                contenedor.getJugadorActivo().utilizarMultiplicadorX2();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Ya no te quedan multiplicadores X2 para usar");
                String mensaje = "Presione OK para continuar";
                alert.setContentText(mensaje);
                alert.show();
            }
        }

        if(multiplicadoresTogger == botonesMultiplicadores.get(1)){
            if(contenedor.getJugadorActivo().quedaX3() != 0){
                contenedor.getJugadorActivo().utilizarMultiplicadorX3();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Ya no te quedan multiplicadores X3 para usar");
                String mensaje = "Presione OK para continuar";
                alert.setContentText(mensaje);
                alert.show();
            }
        }

        if(multiplicadoresTogger == botonesMultiplicadores.get(2)){
            if(contenedor.getJugadorActivo().quedaExclusividad() != 0){
                contenedor.getJugadorActivo().utilizarExclusividadPuntaje();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Ya no te quedan exclusividades de puntajes para usar");
                String mensaje = "Presione OK para continuar";
                alert.setContentText(mensaje);
                alert.show();
            }
        }
        botonesMultiplicadores.get(0).setSelected(false);
        botonesMultiplicadores.get(1).setSelected(false);
        botonesMultiplicadores.get(2).setSelected(false);
        if(contenedor.getJugadorActivo() == kahoot.jugadores().get(1)){
            contenedor.jugadorActivo(kahoot.jugadores().get(0));
            kahoot.verificarRonda();
            if(pregunta instanceof GroupChoice){
                MostrarResultadoGroupHandler mostrarResultadoGroupHandler = new MostrarResultadoGroupHandler(((GroupChoice)pregunta).listaOpcionesGrupoUno(),((GroupChoice)pregunta).listaOpcionesGrupoDos(),contenedor,kahoot,stage);
                mostrarResultadoGroupHandler.handle(event);
            }
            else{
                MostrarResultadoHandler mostrarResultadoHandler = new MostrarResultadoHandler(pregunta.opcionCorrecta(),contenedor,kahoot,stage);
                mostrarResultadoHandler.handle(event);
            }

        }
        else{
            contenedor.jugadorActivo(kahoot.jugadores().get(1));
        }
    }
}
