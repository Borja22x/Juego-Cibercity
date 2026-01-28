package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartas.Mazo;


public class Partida {

	//variables inicio juego
    private int ronda;
    private int turnoActual;
    private List<Jugador> jugadores;
    private List<Jugador> jugadoresQueCompletaron;


    //Personajes no elegidos
    private List<Personaje> personajesDisponibles;
    //Personajes por elegir
    private List<Personaje> personajesSeleccionados;

    //lista edificios
    private static final List<String> EDIFICIOS = List.of(
            "edificioAzul",
            "edificioVerde",
            "edificioRojo",
            "edificioRosa",
            "edificioAmarillo"
    );

    // CONSTRUCTOR

    public Partida() {
        this.ronda = 1;
        this.turnoActual = 0;
        this.jugadores = new ArrayList<>();

        this.personajesDisponibles = new ArrayList<>();
        this.personajesSeleccionados = new ArrayList<>();
        
        this.jugadoresQueCompletaron = new ArrayList<>();

        
        cargarPersonajes();
    }

    // INICIALIZACIÓN
    private void cargarPersonajes() {

        personajesDisponibles.add(new Personaje(
                "Sabio",
                "sabio.png",
                "Gana 3 bitcoins por turno y 2 por cada ventana propia."
        ));

        personajesDisponibles.add(new Personaje(
                "Arquitecto de Red",
                "arquitecto_red.png",
                "Gana 3 bitcoins por turno y 2 por cada ventana propia."
        ));

        personajesDisponibles.add(new Personaje(
                "Comerciante",
                "comerciante.png",
                "Gana 3 bitcoins por turno y 2 por cada ventana propia."
        ));

        personajesDisponibles.add(new Personaje(
                "Constructor",
                "constructor.png",
                "Gana 2 bitcoins por ronda y 2 puntos por ventana."
        ));

        personajesDisponibles.add(new Personaje(
                "Destructor",
                "destructor.png",
                "Paga la mitad al construir."
        ));

        personajesDisponibles.add(new Personaje(
                "Hacker",
                "hacker.png",
                "Gana 6 bitcoins por ronda."
        ));

        personajesDisponibles.add(new Personaje(
                "Inteligencia Artificial Avanzada",
                "ia.png",
                "Gana 4 bitcoins por ronda y 3 puntos."
        ));

        personajesDisponibles.add(new Personaje(
                "Saboteador Digital",
                "saboteador.png",
                "Gana 5 bitcoins por ronda y 2 puntos."
        ));
    }

    // JUGADORES
    //asigna edificio a cada jugador
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        asignarEdificios();
    }
    
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    //Devuelve el jugador actual
    public Jugador getJugadorActual() {
        return jugadores.get(turnoActual);
    }

    // EDIFICIOS
    //Asigna eficio al jugador
    private void asignarEdificios() {
        List<String> edificiosDisponibles = new ArrayList<>(EDIFICIOS);
        Collections.shuffle(edificiosDisponibles);

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).setEdificioAsignado(edificiosDisponibles.get(i));
        }
    }

    // TURNOS Y RONDAS

    public int getRonda() {
        return ronda;
    }

    public boolean siguienteTurno() {
        turnoActual++;

        // Si hemos pasado por todos los jugadores
        if (turnoActual >= jugadores.size()) {
            turnoActual = 0;

            // Si alguien activó el final → NO se inicia nueva ronda
            if (finDePartidaActivado) {
                return true; // indica que la partida debe terminar
            }

            avanzarRonda();
        }

        return false; // la partida continúa
    }

    //Cambio a la siguiente ronda
    private void avanzarRonda() {
        ronda++;

        for (Jugador jugador : jugadores) {
            aplicarGananciasRonda(jugador);
        }

        // comprobar fin de partida AL FINAL DE LA RONDA
        if (!jugadoresQueCompletaron.isEmpty()) {
            // aquí luego irás a pantalla de ganador
        }
    }

    //Gestion del pago de bitcoins al inicio de cada ronda según el rol
    private void aplicarGananciasRonda(Jugador jugador) {
        Personaje rol = jugador.getPersonajeSeleccionado();
        if (rol == null) return;

        int ganancia = 0;

        switch (rol.getNombre()) {

        // SICARIO
        case "Hacker":
            ganancia = 6;
            break;

        // BANDIDO
        case "Saboteador Digital":
            ganancia = 5;
            jugador.sumarPuntosExtra(2);
            break;

        // HECHICERO
        case "Inteligencia Artificial Avanzada":
            ganancia = 4;
            jugador.sumarPuntosExtra(3);
            break;

        // CONSTRUCTOR
        case "Constructor":
            ganancia = 2;
            jugador.sumarPuntosExtra(jugador.getVentanasConstruidas() * 2);
            break;

        // GRAN LÍDER
        case "Arquitecto de Red":

        // COMERCIANTE
        case "Comerciante":

        // SABIO
        case "Sabio":
            ganancia = 3 + jugador.getVentanasConstruidas() * 2;
            break;

        // DESTRUCTOR
        case "Destructor":
            ganancia = 2;
            break;
    }



        if (ganancia > 0) {
            jugador.ganarBitcoin(ganancia);
            jugador.setGananciaUltimaRonda(ganancia);
        }
    }


    // PERSONAJES (COMPATIBLE CON SERVLETS)
    //lista de personajes 
    public List<Personaje> getPersonajes() {
        return personajesDisponibles;
    }
    
    //Personaje elegido asignado al jugador
    public void seleccionar(int index) {
        Personaje elegido = personajesDisponibles.remove(index);
        personajesSeleccionados.add(elegido);
    }

    //FIN DE PARTIDA
    //Devuelve al ganador
 public Jugador getGanador() {
     Jugador ganador = null;
     int maxPuntos = -1;

     for (Jugador j : jugadores) {
         int puntos = j.calcularPuntosFinales();

         if (puntos > maxPuntos) {
             maxPuntos = puntos;
             ganador = j;
         }
     }

     return ganador;
 }


    
    public void comprobarEdificioCompletado(Jugador jugador) {
        if (jugador.getVentanasConstruidas() >= 7 &&
            !jugadoresQueCompletaron.contains(jugador)) {

            jugadoresQueCompletaron.add(jugador);

            // Activamos que esta será la ÚLTIMA ronda
            finDePartidaActivado = true;
        }
    }



    public boolean hayGanador() {
        for (Jugador jugador : jugadores) {
            if (jugador.getVentanasConstruidas() >= 7) {
                return true;
            }
        }
        return false;
    }
    
    
    //Reparte las cartas iniciales
 public void repartirCartasIniciales(Mazo mazo) {
     for (Jugador jugador : jugadores) {
         for (int i = 0; i < 2; i++) {
             if (jugador.puedeRobarCarta()) {
                 jugador.robarCarta(mazo.robar());
             }
         }
     }
 }
 
 private boolean finDePartidaActivado = false;
 
}

