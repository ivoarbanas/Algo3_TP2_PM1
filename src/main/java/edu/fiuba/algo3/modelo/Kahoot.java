package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Kahoot {

    private ArrayList<Usuario> jugadores;
    private ArrayList<Ronda> rondas;
    private Ronda rondaActiva;
    private SistemaPuntaje sistemaPuntaje;
    private int ronda;

    public Kahoot() {

        sistemaPuntaje = new SistemaPuntaje();
        jugadores = new ArrayList<Usuario>();
        rondas = new ArrayList<Ronda>();
        ronda = 0;
        rondaActiva = new Ronda();


    }
    public ArrayList<Usuario> jugadores(){
        return jugadores;
    }
    //main
    /*public void comenzarJuego(){
        //cargarJugadores();
        while(ronda < 10 ){
            presentarPreguntaALosUsuarios();
            verificarRonda();
            ronda++;
        }
        //finalizar juego
    }*/

    public void verificarRonda() {

        Puntaje puntajeJugadorUno = rondaActiva.obtenerPuntajeJugador(jugadores.get(0));
        Puntaje puntajeJugadorDos = rondaActiva.obtenerPuntajeJugador(jugadores.get(1));



        if( (puntajeJugadorUno.valor() != puntajeJugadorDos.valor() ) ) {
            if ((jugadores.get(0).usoExclusividadEnRonda() && jugadores.get(1).usoExclusividadEnRonda())) {
                ExclusividadDePuntajeCuadruple exclusividadDePuntajeCuadruple = new ExclusividadDePuntajeCuadruple();
                puntajeJugadorUno = this.aplicarExclusividad(puntajeJugadorUno, exclusividadDePuntajeCuadruple);
                puntajeJugadorDos = this.aplicarExclusividad(puntajeJugadorDos, exclusividadDePuntajeCuadruple);
            } else {
                puntajeJugadorUno = this.aplicarExclusividad(puntajeJugadorUno, jugadores.get(0).getExclusividad());
                puntajeJugadorDos = this.aplicarExclusividad(puntajeJugadorDos, jugadores.get(1).getExclusividad());
            }
        }
        if(((jugadores.get(0).usoExclusividadEnRonda() || jugadores.get(1).usoExclusividadEnRonda())) && (puntajeJugadorUno.valor() == puntajeJugadorDos.valor() )){
            puntajeJugadorUno = new Puntaje(0);
            puntajeJugadorDos = new Puntaje(0);
        }

        puntajeJugadorUno = this.aplicarMultiplicador(jugadores().get(0),puntajeJugadorUno);
        puntajeJugadorDos = this.aplicarMultiplicador(jugadores().get(1),puntajeJugadorDos);


        sistemaPuntaje.cambiarPuntaje(jugadores.get(0), puntajeJugadorUno);
        sistemaPuntaje.cambiarPuntaje(jugadores.get(1), puntajeJugadorDos);


    }

    public void crearJugador(String nombre){
        Usuario jugador = new Usuario(nombre);
        jugadores.add(jugador);
    }

    public void cargarPreguntas(){
        ArrayList<Pregunta>preguntas = new ArrayList<>();
        VerdaderoFalsoPenalidad pregunta1 = new VerdaderoFalsoPenalidad("Aprobe el parcial", false);
        VerdaderoFalsoPenalidad pregunta4 = new VerdaderoFalsoPenalidad("Aprobe el parcial", false);
        VerdaderoFalsoClasico pregunta2 = new VerdaderoFalsoClasico("Aprobe el recu", true);
        MultipleChoiceParcial pregunta3 = new MultipleChoiceParcial("Profesores turno tarde");
        pregunta3.cargarOpcionCorrecta(new Opcion("+U"));
        pregunta3.cargarOpcionCorrecta(new Opcion("EDSON"));
        pregunta3.cargarOpcionCorrecta(new Opcion("JPB"));
        pregunta3.cargarOpcionIncorrecta(new Opcion("Cba"));
        pregunta3.cargarOpcionCorrecta(new Opcion("Eugenio"));
        Ronda ronda3 = new Ronda();
        ronda3.cargarPregunta(pregunta3);
        Ronda ronda4 = new Ronda();
        ronda4.cargarPregunta(pregunta4);
        Ronda ronda1 = new Ronda();
        ronda1.cargarPregunta(pregunta1);
        Ronda ronda2 = new Ronda();
        ronda2.cargarPregunta(pregunta2);
        rondas.add(ronda1);
        rondas.add(ronda2);
        rondas.add(ronda3);
        rondas.add(ronda4);
        rondaActiva = rondas.get(ronda);
        /*ArrayList<Opcion>
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                while (myReader.hasNext(",")){

                }
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/
    }

    public void cargarPregunta(Pregunta pregunta){
        rondaActiva.cargarPregunta(pregunta);
    }

    public void crearPreguntas(){
        //lee el archivo y envia mensaje a las clases dependiendo lo que va leyendo
    }

    //hago el metodo para agregar una pregunta especifica ¿¿¿¿¿¿¿¿PARA QUE SIRVE????????
   /* public void agregarPreguntaParticular(Pregunta pregunta){

        preguntas.add(pregunta);
    }*/

    // NO SE USA TODAVIA
    public void presentarPreguntaALosUsuarios(){
        for (Usuario jugador : jugadores) {
            jugador.elegirRespuesta(rondas.get(ronda).pregunta());
        }
    }

    public void cambiarRonda(){

        for (Usuario jugador : jugadores){
            jugador.vaciarRespuestas();
            jugador.limpiarMultiplicador();
            jugador.limpiarExclusividad();
        }
        rondaActiva = rondas.get(ronda + 1);
        ronda += 1;

    }

    public Puntaje aplicarMultiplicador(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return rondaActiva.aplicarMultiplicador(jugadorAfectado,puntajeAMultiplicar);
    }

    public Puntaje aplicarExclusividad(Puntaje puntajeAMultiplicar, ExclusividadDePuntaje exclusividadDePuntaje){
        return rondaActiva.aplicarExclusividad(puntajeAMultiplicar, exclusividadDePuntaje);
    }

    public Ronda rondaActiva(){
        return rondaActiva;
    }

    public Ronda obtenerRondaActiva() {
        return rondaActiva;
    }
}
