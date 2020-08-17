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

public class EnviarRespuestaVerdaderoFalsoHandler extends EnviarRespuestaHandler {

    ToggleGroup grupoOpciones;
    ArrayList<ToggleButton> botonesOpciones;


    public EnviarRespuestaVerdaderoFalsoHandler(Kahoot kahoot, Stage stage,ToggleGroup grupoOpciones, ToggleGroup grupoMultiplicadores, ArrayList<ToggleButton> botonesOpciones, ArrayList<ToggleButton> botonesMultiplicadores, Pregunta pregunta, ContenedorPregunta contenedor){
        super(kahoot, stage,  grupoMultiplicadores,  botonesMultiplicadores,  pregunta,  contenedor);
        this.botonesOpciones = botonesOpciones;
        this.grupoOpciones = grupoOpciones;
    }

    @Override
    public void handle(ActionEvent event) {

        Toggle opcionTogger = grupoOpciones.getSelectedToggle();
        ArrayList<Opcion> opcionElegida = new ArrayList<>();

        if (opcionTogger == botonesOpciones.get(0)) {
            Opcion unaOpcionElegida = (Opcion) botonesOpciones.get(0).getUserData();
            opcionElegida.add(unaOpcionElegida);
            contenedor.getJugadorActivo().cargarRespuestas(opcionElegida);
            botonesOpciones.get(0).setSelected(false);

        } else if (opcionTogger == botonesOpciones.get(1)) {
            Opcion unaOpcionElegida = (Opcion) botonesOpciones.get(1).getUserData();
            opcionElegida.add(unaOpcionElegida);
            contenedor.getJugadorActivo().cargarRespuestas(opcionElegida);
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

            EnviarRespuestaHandler multiplicadorHandler = new EnviarRespuestaHandler(kahoot, stage,  grupoMultiplicadores,  botonesMultiplicadores,  pregunta,  contenedor);
            multiplicadorHandler.handle(event);
        }
    }
}
