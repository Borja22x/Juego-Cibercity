package Clases;

//Representa un personaje seleccionable por los jugadores
public class Personaje {
	
    private String nombre;
    private String archivo;
    private String descripcion;

    public Personaje(String nombre, String archivo, String descripcion) {
        this.nombre = nombre;
        this.archivo = archivo;
        this.descripcion = descripcion;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}
