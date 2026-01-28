package cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Representa todo el mazo de cartas del juego donde están todas las cartas y algunas acciones como barajar y robar


public class Mazo {

	//Lista con todas las cartas del juego
    private List<Carta> cartas;

    //Constructor que crea e inicializa todas las cartas las cartas del jeugo
    public Mazo() {
        cartas = new ArrayList<>();
        inicializarMazo();
    }

    //creamos todas las cartas y le ponemos un id automatico
    private void inicializarMazo() {
        int id = 1;

        // 32 CARTAS GENÉRICAS
 

        // --- Coste 1 (8 Cartas) ---
        cartas.add(new Carta(id++, "Cable de Cobre", "Conexión barata y poco fiable.", 1, TipoCarta.GENERICA, 1));
        cartas.add(new Carta(id++, "Jumper", "Pequeño puente de conexión.", 1, TipoCarta.GENERICA, 1));
        cartas.add(new Carta(id++, "Ping", "Comprobación de latencia básica.", 1, TipoCarta.GENERICA, 1));
        cartas.add(new Carta(id++, "Reset Manual", "A veces lo más simple funciona.", 1, TipoCarta.GENERICA, 1));
        cartas.add(new Carta(id++, "Puerto USB", "Interfaz de entrada estándar.", 1, TipoCarta.GENERICA, 1));
        cartas.add(new Carta(id++, "Antena Básica", "Recepción de señal local.", 1, TipoCarta.GENERICA, 1));
        cartas.add(new Carta(id++, "Parche de Software", "Arreglo rápido de código.", 1, TipoCarta.GENERICA, 1));
        cartas.add(new Carta(id++, "Login Invitado", "Acceso temporal limitado.", 1, TipoCarta.GENERICA, 1));

        // --- Coste 2 (7 Cartas) ---
        cartas.add(new Carta(id++, "Switch 8-Puertos", "Distribución local de paquetes.", 2, TipoCarta.GENERICA, 2));
        cartas.add(new Carta(id++, "Ventilador CPU", "Evita el sobrecalentamiento.", 2, TipoCarta.GENERICA, 2));
        cartas.add(new Carta(id++, "Antivirus Gratuito", "Protección mínima esencial.", 2, TipoCarta.GENERICA, 2));
        cartas.add(new Carta(id++, "Tarjeta de Red", "Interfaz dedicada para conexión.", 2, TipoCarta.GENERICA, 2));
        cartas.add(new Carta(id++, "RAM Extra", "Mejora temporal de velocidad.", 2, TipoCarta.GENERICA, 2));
        cartas.add(new Carta(id++, "Proxy Anónimo", "Oculta tu IP origen.", 2, TipoCarta.GENERICA, 2));
        cartas.add(new Carta(id++, "Backdoor Simple", "Acceso trasero no seguro.", 2, TipoCarta.GENERICA, 2));

        // --- Coste 3 (6 Cartas) ---
        cartas.add(new Carta(id++, "Router Wi-Fi 6", "Conexión inalámbrica rápida.", 3, TipoCarta.GENERICA, 3));
        cartas.add(new Carta(id++, "Firewall Hardware", "Barrera física contra ataques.", 3, TipoCarta.GENERICA, 3));
        cartas.add(new Carta(id++, "VPN Privada", "Túnel encriptado de datos.", 3, TipoCarta.GENERICA, 3));
        cartas.add(new Carta(id++, "Disco SSD", "Acceso a datos ultra rápido.", 3, TipoCarta.GENERICA, 3));
        cartas.add(new Carta(id++, "Repetidor de Señal", "Extiende el alcance de red.", 3, TipoCarta.GENERICA, 3));
        cartas.add(new Carta(id++, "Sniffer de Paquetes", "Intercepta datos del rival.", 3, TipoCarta.GENERICA, 3));

        // --- Coste 4 (5 Cartas) ---
        cartas.add(new Carta(id++, "Servidor Rack", "Potencia de cálculo central.", 4, TipoCarta.GENERICA, 4));
        cartas.add(new Carta(id++, "Base de Datos SQL", "Organización masiva de info.", 4, TipoCarta.GENERICA, 4));
        cartas.add(new Carta(id++, "Balanceador de Carga", "Optimiza el tráfico entrante.", 4, TipoCarta.GENERICA, 4));
        cartas.add(new Carta(id++, "Encriptación AES", "Seguridad de grado militar.", 4, TipoCarta.GENERICA, 4));
        cartas.add(new Carta(id++, "Cluster de Nodos", "Procesamiento paralelo.", 4, TipoCarta.GENERICA, 4));

        // --- Coste 5 (4 Cartas) ---
        cartas.add(new Carta(id++, "Fibra Oscura", "Infraestructura privada masiva.", 5, TipoCarta.GENERICA, 5));
        cartas.add(new Carta(id++, "Mainframe", "El corazón de la corporación.", 5, TipoCarta.GENERICA, 5));
        cartas.add(new Carta(id++, "Algoritmo Cuántico", "Rompe claves tradicionales.", 5, TipoCarta.GENERICA, 5));
        cartas.add(new Carta(id++, "Centro de Datos", "Almacenamiento global.", 5, TipoCarta.GENERICA, 5));

        // --- Coste 6 (2 Cartas) ---
        cartas.add(new Carta(id++, "I.A. General", "Toma el control de la red.", 6, TipoCarta.GENERICA, 6));
        cartas.add(new Carta(id++, "Enlace Satelital", "Conexión orbital global.", 6, TipoCarta.GENERICA, 6));


        // --- CONSTRUCTOR (7 Cartas) ---
        cartas.add(new Carta(id++, "Casco de Ingeniero", "Seguridad en la obra.", 3, TipoCarta.CONSTRUCTOR, 3));
        cartas.add(new Carta(id++, "Planos Maestros", "Construcción eficiente.", 3, TipoCarta.CONSTRUCTOR, 3));
        cartas.add(new Carta(id++, "Grúa de Datos", "Mueve grandes archivos.", 3, TipoCarta.CONSTRUCTOR, 3));
        cartas.add(new Carta(id++, "Andamiaje Digital", "Soporte temporal.", 3, TipoCarta.CONSTRUCTOR, 3));
        cartas.add(new Carta(id++, "Soldador de Código", "Une módulos rotos.", 4, TipoCarta.CONSTRUCTOR, 4));
        cartas.add(new Carta(id++, "Fundación Sólida", "Base indestructible.", 4, TipoCarta.CONSTRUCTOR, 4));
        cartas.add(new Carta(id++, "Constructor Jefe", "Lidera la expansión.", 5, TipoCarta.CONSTRUCTOR, 5));

        // --- COMERCIANTE (7 Cartas) ---
        cartas.add(new Carta(id++, "Monedero Crypto", "Almacena tus ganancias.", 2, TipoCarta.COMERCIANTE, 2));
        cartas.add(new Carta(id++, "Subasta Online", "Vende al mejor postor.", 2, TipoCarta.COMERCIANTE, 2));
        cartas.add(new Carta(id++, "Contrato Inteligente", "Acuerdo automático.", 3, TipoCarta.COMERCIANTE, 3));
        cartas.add(new Carta(id++, "Mercado Negro", "Compras ilegales.", 3, TipoCarta.COMERCIANTE, 3));
        cartas.add(new Carta(id++, "Inversionista Ángel", "Financiación externa.", 4, TipoCarta.COMERCIANTE, 4));
        cartas.add(new Carta(id++, "Evasión Fiscal", "Ahorra costes (arriesgado).", 4, TipoCarta.COMERCIANTE, 4));
        cartas.add(new Carta(id++, "Monopolio", "Control total del mercado.", 5, TipoCarta.COMERCIANTE, 5));

        // --- ARQUITECTO (7 Cartas) ---
        cartas.add(new Carta(id++, "Boceto Inicial", "Primera idea del sistema.", 3, TipoCarta.ARQUITECTO, 3));
        cartas.add(new Carta(id++, "Diagrama UML", "Estructura lógica.", 3, TipoCarta.ARQUITECTO, 3));
        cartas.add(new Carta(id++, "Diseño Modular", "Piezas intercambiables.", 4, TipoCarta.ARQUITECTO, 4));
        cartas.add(new Carta(id++, "Escalabilidad", "Crece sin límites.", 4, TipoCarta.ARQUITECTO, 4));
        cartas.add(new Carta(id++, "Redundancia", "Sistemas de respaldo.", 4, TipoCarta.ARQUITECTO, 4));
        cartas.add(new Carta(id++, "Optimización Topológica", "Rutas perfectas.", 5, TipoCarta.ARQUITECTO, 5));
        cartas.add(new Carta(id++, "Visión de Conjunto", "Estrategia a largo plazo.", 5, TipoCarta.ARQUITECTO, 5));

        // --- ANALISTA (7 Cartas) ---
        cartas.add(new Carta(id++, "Log del Sistema", "Revisa el historial.", 3, TipoCarta.ANALISTA, 3));
        cartas.add(new Carta(id++, "Depurador (Debugger)", "Encuentra fallos.", 3, TipoCarta.ANALISTA, 3));
        cartas.add(new Carta(id++, "Test Unitario", "Verifica componentes.", 4, TipoCarta.ANALISTA, 4));
        cartas.add(new Carta(id++, "Big Data", "Análisis masivo.", 4, TipoCarta.ANALISTA, 4));
        cartas.add(new Carta(id++, "Predicción de Tráfico", "Anticípate al flujo.", 4, TipoCarta.ANALISTA, 4));
        cartas.add(new Carta(id++, "Auditoría Forense", "Investiga ataques.", 5, TipoCarta.ANALISTA, 5));
        cartas.add(new Carta(id++, "Hacker de Sombrero Blanco", "Defensa proactiva.", 5, TipoCarta.ANALISTA, 5));
    }

    
    //Mezcla aleatoriamente las cartas del mazo
    public void barajar() {
        Collections.shuffle(cartas);
    }

    //Roba la carta superior del mazo.
    public Carta robar() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        }
        return null;
    }
    
    //Indica si el mazo ya no tiene cartas
    public boolean estaVacio() {
        return cartas.isEmpty();
    }

    //Devuelve cuántas cartas quedan en el mazo
    public int size() {
        return cartas.size();
    }
 
}