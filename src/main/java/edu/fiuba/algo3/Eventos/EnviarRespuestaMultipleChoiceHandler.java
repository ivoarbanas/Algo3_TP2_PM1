package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EnviarRespuestaMultipleChoiceHandler extends EnviarRespuestaHandler{

    ArrayList<CheckBox> botonesOpciones;

    public EnviarRespuestaMultipleChoiceHandler(Kahoot kahoot, Stage stage, ToggleGroup grupoMultiplicadores, ArrayList<CheckBox> botonesOpciones, ArrayList<ToggleButton> botonesMultiplicadores, Pregunta pregunta, ContenedorPregunta contenedor){
        super(kahoot, stage,  grupoMultiplicadores,  botonesMultiplicadores,  pregunta,  contenedor);
        this.botonesOpciones = botonesOpciones;


    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<Opcion> opcionElegida= new ArrayList<>();
        for(CheckBox opcion : botonesOpciones){
            if(opcion.isSelected()){
                Opcion unaOpcionElegida = (Opcion) opcion.getUserData();
                opcionElegida.add(unaOpcionElegida);
                opcion.setSelected(false);
            }
        }
        contenedor.getJugadorActivo().cargarRespuestas(opcionElegida);
        if(opcionElegida.size() == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Seleccione una opción:");
            String mensaje = "Presione OK para continuar";
            alert.setContentText(mensaje);
            alert.show();
        }
        else{
            EnviarRespuestaHandler multiplicadorHandler = new EnviarRespuestaHandler(kahoot, stage,  grupoMultiplicadores,  botonesMultiplicadores,  pregunta,  contenedor);
            multiplicadorHandler.handle(event);
        }
    }
}

