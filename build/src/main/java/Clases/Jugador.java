package Clases;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private Personaje personajeSeleccionado;
    private int bitcoin;
	private int gananciaUltimaRonda;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.personajeSeleccionado = null;
        this.bitcoin = 10;

    }

    public String getNombre() { 
    	return nombre; 
    }
    
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }

    public Personaje getPersonajeSeleccionado() { 
    	return personajeSeleccionado; 
    }
    
    public void setPersonajeSeleccionado(Personaje personajeSeleccionado) {
        this.personajeSeleccionado = personajeSeleccionado;
    }

	public Object getBitcoin() {	
		return this.bitcoin;
	}
	
	public void ganarBitcoin(int cantidad) {
        this.bitcoin += cantidad;
    }
	
	public int getGananciaUltimaRonda() {
        return gananciaUltimaRonda;
    }

    public void setGananciaUltimaRonda(int gananciaUltimaRonda) {
        this.gananciaUltimaRonda = gananciaUltimaRonda;
    }
    
}