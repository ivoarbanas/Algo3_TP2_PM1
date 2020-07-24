package edu.fiuba.algo3.modelo;

public class VerdaderoFalsoPenalidad extends VerdaderoFalso{
    //lo creamos aca pero va a ir en la clase Kahoot
    private SistemaPuntaje sistemaPuntaje;

    public VerdaderoFalsoPenalidad(String enunciado, String opcionCorrectaValor, String opcionIncorrectaValor){
        super(enunciado,opcionCorrectaValor,opcionIncorrectaValor);
        sistemaPuntaje = new SistemaPuntaje();
    }
    @Override
    public void respuestaEsCorrecta(Usuario jugador){
        sistemaPuntaje.cambiarPuntaje(jugador, 1);
    }

    @Override
    public void respuestaEsIncorrecta(Usuario jugador) { sistemaPuntaje.cambiarPuntaje(jugador, -1); }
}

