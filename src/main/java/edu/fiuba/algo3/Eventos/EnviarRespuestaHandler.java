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
    ToggleGroup grupoOpciones, grupoMultiplicadores;
    ArrayList<ToggleButton> botonesOpciones, botonesMultiplicadores;
    Usuario jugadorActivo;
    VerdaderoFalsoPenalidad pregunta;
    ContenedorPregunta contenedor;
    Stage stage;

    public EnviarRespuestaHandler(Kahoot kahoot, Stage stage,ToggleGroup grupoOpciones, ToggleGroup grupoMultiplicadores, ArrayList<ToggleButton> botonesOpciones, ArrayList<ToggleButton> botonesMultiplicadores, Usuario jugadorActivo, VerdaderoFalsoPenalidad pregunta, ContenedorPregunta contenedor){
        this.kahoot = kahoot;
        this.grupoOpciones = grupoOpciones;
        this.grupoMultiplicadores = grupoMultiplicadores;
        this.botonesOpciones = botonesOpciones;
        this.botonesMultiplicadores = botonesMultiplicadores;
        this.jugadorActivo = jugadorActivo;
        this.pregunta = pregunta;
        this.contenedor = contenedor;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {

        Toggle opcionTogger = grupoOpciones.getSelectedToggle();
        ArrayList<Opcion> opcionElegida = new ArrayList<>();
        if (opcionTogger == botonesOpciones.get(0)) {
            Opcion unaOpcionElegida = (Opcion) botonesOpciones.get(0).getUserData();
            opcionElegida.add(unaOpcionElegida);
            jugadorActivo.cargarRespuestas(opcionElegida);
            botonesOpciones.get(0).setSelected(false);

        } else if (opcionTogger == botonesOpciones.get(1)) {
            Opcion unaOpcionElegida = (Opcion) botonesOpciones.get(1).getUserData();
            opcionElegida.add(unaOpcionElegida);
            jugadorActivo.cargarRespuestas(opcionElegida);
            botonesOpciones.get(1).setSelected(false);

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Seleccione una opción:");
            String mensaje = "Presione OK para continuar";
            alert.setContentText(mensaje);
            alert.show();
        }

        if(opcionTogger == botonesOpciones.get(0) || opcionTogger == botonesOpciones.get(1)){

            Toggle multiplicadoresTogger = grupoMultiplicadores.getSelectedToggle();
            if(multiplicadoresTogger == botonesMultiplicadores.get(0)){
                jugadorActivo.utilizarMultiplicadorX2();
                botonesMultiplicadores.get(0).setSelected(false);
            }
            else if(multiplicadoresTogger == botonesMultiplicadores.get(1)){
                jugadorActivo.utilizarMultiplicadorX3();
                botonesMultiplicadores.get(1).setSelected(false);
            }
            else if(multiplicadoresTogger == botonesMultiplicadores.get(2)){
                jugadorActivo.utilizarExclusividadPuntaje();
            }
            if(jugadorActivo == kahoot.jugadores().get(1)){
                jugadorActivo = kahoot.jugadores().get(0);
                kahoot.verificarRonda();
                MostrarResultadoHandler mostrarResultadoHandler = new MostrarResultadoHandler(pregunta.opcionCorrecta(),contenedor,kahoot,stage);
                mostrarResultadoHandler.handle(event);
            }
            else{
                jugadorActivo = kahoot.jugadores().get(1);
            }
        }
    }
}
