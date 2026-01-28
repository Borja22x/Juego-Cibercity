package cartas;

//creamos las cartas que se van a utilizar en el juego
public class Carta {
	
	private int puntosVictoria;
    private int id;
    private String nombre;
    private String descripcion;
    private int coste; // de 1 a 6 bitcoins
    private TipoCarta tipo;

    public Carta(int id, String nombre, String descripcion, int coste, TipoCarta tipo, int puntosVictoria) {

        //setters 
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coste = coste;
        this.tipo = tipo;
        this.puntosVictoria = puntosVictoria;
    }

    // getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getCoste() { return coste; }
    public TipoCarta getTipo() { return tipo; }
    public int getPuntosVictoria() { return puntosVictoria; }
}



