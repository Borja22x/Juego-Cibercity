package Clases;

import java.util.ArrayList;
import java.util.List;

import cartas.Carta;

//Representa al jugador dentro de la partida, guarda su dinero, ventanas, cartas y puntucación
public class Jugador {

	//variables
    private String nombre;
    private Personaje personajeSeleccionado;

    private int bitcoin;
    private int gananciaUltimaRonda;

    //Lista de cartas del jugador
    private List<Carta> mano; // máx 5 cartas
    public static final int MAX_CARTAS = 5;

    //Cartas contruidas
    private List<Carta> cartasConstruidas;

    //Edificio
    private String edificioAsignado; // edificioAzul, edificioVerde y el resto
    private int ventanasConstruidas;  // ventanas propias iluminadas

    //Puntos
    private int puntosExtra; // por habilidades (hechicero, bandido, etc)

    //Crea el jugador con valores por defecto
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.personajeSeleccionado = null;
        this.bitcoin = 10;

        this.mano = new ArrayList<>();
        this.ventanasConstruidas = 0;
        this.puntosExtra = 0;
        
        this.cartasConstruidas = new ArrayList<>();

    }

    // GETTERS / SETTERS
    public String getNombre() {
        return nombre;
    }

    public Personaje getPersonajeSeleccionado() {
        return personajeSeleccionado;
    }

    public void setPersonajeSeleccionado(Personaje personajeSeleccionado) {
        this.personajeSeleccionado = personajeSeleccionado;
    }

    public int getBitcoin() {
        return bitcoin;
    }

    public int getGananciaUltimaRonda() {
        return gananciaUltimaRonda;
    }

    public void setGananciaUltimaRonda(int gananciaUltimaRonda) {
        this.gananciaUltimaRonda = gananciaUltimaRonda;
    }

    public String getEdificioAsignado() {
        return edificioAsignado;
    }

    public void setEdificioAsignado(String edificioAsignado) {
        this.edificioAsignado = edificioAsignado;
    }

    public int getVentanasConstruidas() {
        return ventanasConstruidas;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public int getPuntosExtra() {
        return puntosExtra;
    }
    
    public List<Carta> getCartasConstruidas() {
        return cartasConstruidas;
    }


    // BITCOINS
    //Añade bitcoins al jugador
    public void ganarBitcoin(int cantidad) {
        this.bitcoin += cantidad;
    }
    
    //Resta bitcoins al jugador
    public boolean gastarBitcoin(int cantidad) {
        if (bitcoin >= cantidad) {
            bitcoin -= cantidad;
            return true;
        }
        return false;
    }

    // CARTAS
    //Comprueba si el jugador puede robar cartas
    public boolean puedeRobarCarta() {
        return mano.size() < MAX_CARTAS;
    }
    
    //Roba 1 carta y la añade al mazo
    public boolean robarCarta(Carta carta) {
        if (puedeRobarCarta()) {
            mano.add(carta);
            return true;
        }
        return false;
    }

    //Usa una de ls cartas del mazo y enciende una ventana ademas de comprobar si el edificio ya está completo, aplica descuentos de personaje, resta bitcoins, mueve la carta de la mano a construidas
    public boolean usarCarta(Carta carta) {

        if (edificioCompletado()) {
            return false;
        }

        int coste = carta.getCoste();

        // Destructor paga la mitad
        if (personajeSeleccionado != null &&
            personajeSeleccionado.getNombre().equals("Destructor de Sistemas")) {
            coste = coste / 2;
        }

        if (!mano.contains(carta)) return false;
        if (!gastarBitcoin(coste)) return false;

        mano.remove(carta);

        //guardar carta usado
        cartasConstruidas.add(carta);

        ventanasConstruidas++;

        return true;
    }


    //PUNTOS
    //calcula los puntos finales de las cartas edificios y por personaje
    public int calcularPuntosFinales() {
        int puntos = 0;

        //PUNTOS POR CARTAS CONSTRUIDAS
        for (Carta c : cartasConstruidas) {
            puntos += c.getPuntosVictoria();
        }

        //Bonus por completar edificio
        if (ventanasConstruidas >= 7) {
            puntos += 10;
        }

        //Bonus extra por habilidades
        puntos += puntosExtra;

        return puntos;
    }

    
    public void sumarPuntosExtra(int puntos) {
        this.puntosExtra += puntos;
    }
    
    
    public Carta getCartaPorId(int id) {
        for (Carta c : mano) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    //avisa cuando el edificio tiene las 7 ventanas pintadas
    public boolean edificioCompletado() {
        return ventanasConstruidas >= 7;
    }
    
    
}
