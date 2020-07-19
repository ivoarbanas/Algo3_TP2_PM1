package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoClasico extends VerdaderoFalso{
    //lo creamos aca pero va a ir en la clase Kahoot
    private SistemaPuntaje sistemaPuntaje;

    public VerdaderoFalsoClasico(String enunciado, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta){
        super(enunciado,opcionCorrecta,opcionIncorrecta);
        sistemaPuntaje = new SistemaPuntaje();
    }
    @Override
    public void respuestaEsCorrecta(Usuario jugador){
        sistemaPuntaje.cambiarPuntaje(jugador, 1);
    }

    @Override
    public void respuestaEsIncorrecta(Usuario jugador) {
        //no hace nada
    }
}
