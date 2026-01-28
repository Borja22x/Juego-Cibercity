package Clases;

import java.util.ArrayList;
import java.util.List;


public class Partida {

    private List<Personaje> personajes = new ArrayList<>();
    private List<Personaje> seleccionados = new ArrayList<>();
	private int ronda;

    public Partida() {
    	
    	this.ronda = 1;
    	
        personajes.add(new Personaje("Sabio",
                "holograma analista de sistemas (sabio).png",
                "Gana 3 bitcoins por turno y 2 bitcoins por cada ventana iluminada por una carta suya."
        ));

        personajes.add(new Personaje("Arquitecto de Red",
                "holograma arquitecto de red(gran líder).png",
                "Gana 3 bitcoins por turno y 2 bitcoins por cada ventana iluminada por una carta suya."
        ));

        personajes.add(new Personaje("Comerciante",
                "holograma comerciante(comerciante) .png",
                "Gana 3 bitcoins por turno y 2 bitcoins cada ventana iluminada por una carta suya."
        ));

        personajes.add(new Personaje("Constructor",
                "holograma contructor de nodos(constructor).png",
                "Gana 2 bitcoins por ronda y suma 2 puntos al final de la partida por cada ventana iluminada."
        ));

        personajes.add(new Personaje("Destructor",
                "holograma destructor de sistemas (destructor).png",
                "Gana 2 bitcoins por turno y ilumina ventanas pagando la mitad de su valor."
        ));

        personajes.add(new Personaje("Hacker",
                "holograma hacker(sicario).png",
                "Gana 6 bitcoins por ronda."
        ));

        personajes.add(new Personaje("Ia Avanzada",
                "holograma ia avanzada (hechicero).png",
                "Gana 4 bitcoins por ronda y suma 3 puntos al final de la partida."
        ));

        personajes.add(new Personaje("Saboteador Digital",
                "holograma saboteador digital (bandido).png",
                "Gana 5 bitcoins por ronda y suma 2 puntos al final de la partida"
        ));
    }
    
    
    public Personaje getPersonaje(int index) {
        return personajes.get(index);
    }

    public void seleccionar(int index) { 
        // Obtenemos el personaje
        Personaje personajeElegido = personajes.get(index);
        // Lo agregamos a la lista de elegidos
        seleccionados.add(personajeElegido);
        // Lo borramos para que no aprezca mas y asi otro jugador no lo seleccione
        personajes.remove(index);
    }

    public List<Personaje> getPersonajes() {
        return personajes; // Esto ahora es la lista de los disponibles.
    }
    public int getTotalSeleccionados() {
        return seleccionados.size();
    }

    public List<Personaje> getSeleccionados() {
        return seleccionados;
    }

    public int getRonda() {
        return ronda;
    }
    
    public void avanzarRondaYGanancias (List<Jugador> jugadores) {
        this.ronda++;
        
        for (Jugador jugador : jugadores) {
            Personaje rol = jugador.getPersonajeSeleccionado();
            
            if (rol == null) continue; // Si no tiene rol, saltar

            int ganancia = 0;
            String nombreRol = rol.getNombre();

            switch (nombreRol) {
                // Ganancias por RONDA
                case "Sabio":
                    ganancia = 3;
                    break;
                case "Arquitecto de Red": 
                    ganancia = 3;
                    break;
                case "Comerciante": 
                    ganancia = 3;
                    break;
                case "Constructor":
                    ganancia = 2;
                    break;
                case "Destructor":
                	ganancia = 2;
                	break;
                case "Hacker":
                	ganancia = 6;
                	break;
                case "IA avanzada":
                	ganancia = 4;
                	break;
                case "Saboteador Digital":
                	ganancia = 5;
                	break;
                	
            }
            
            if (ganancia > 0) {
                jugador.ganarBitcoin(ganancia);
                jugador.setGananciaUltimaRonda(ganancia);
            }

        }
    }
}