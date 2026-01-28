package Controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Clases.Partida;
import Clases.Jugador;
import cartas.Mazo;


//Servlet encargado de crear la partida y los jugadores a partir del formulario de configuración inicial

@WebServlet("/configurar")
public class ConfigurarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        System.out.println(">>> ConfigurarServlet ejecutado");
        
        //número de jugadores seleccionado en el formulario
        String playersStr = request.getParameter("players");

        if (playersStr == null) {
            System.out.println(">>> ERROR: players es null");
            request.setAttribute("error", "Debes seleccionar cuántos jugadores participan.");
            request.getRequestDispatcher("/JSP/pantallaConfig.jsp").forward(request, response);
            return;
        }

        int numJugadores = Integer.parseInt(playersStr);
        System.out.println(">>> Número de jugadores: " + numJugadores);

        List<Jugador> listaJugadores = new ArrayList<>();
        List<String> nombresValidos = new ArrayList<>();

        //creación y validación jugadores
        for (int i = 1; i <= numJugadores; i++) {
            String nombre = request.getParameter("jugador" + i);

            System.out.println(">>> jugador" + i + ": " + nombre);

            //si esta vacío le metmos un nombre 
            if (nombre == null || nombre.trim().isEmpty()) {
                nombre = "Jugador " + i;
            } else {
                nombre = nombre.trim();
            }
            
            //comprobamos que el nombre no esté repetido
            if (nombresValidos.contains(nombre)) {
                System.out.println(">>> ERROR: nombre repetido " + nombre);
                request.setAttribute("error", "El nombre '" + nombre + "' está repetido.");
                request.getRequestDispatcher("/JSP/pantallaConfig.jsp").forward(request, response);
                return;
            }

            nombresValidos.add(nombre);
            listaJugadores.add(new Jugador(nombre));
        }
        
        //guardamos en sesión
        HttpSession session = request.getSession(true);
        
        //creamos partida
        Partida partida = new Partida();
        partida.setJugadores(listaJugadores);
        
        //creamos mazo y lo preparamos
        Mazo mazo = new Mazo();
        mazo.barajar();
        partida.repartirCartasIniciales(mazo);

        session.setAttribute("partida", partida);
        session.setAttribute("mazo", mazo);
        session.setAttribute("jugadores", listaJugadores);
        session.setAttribute("jugadorActual", 0);

        System.out.println(">>> Partida creada correctamente, redirigiendo a /seleccionar");
        
        //redirigimos al servlet de selección de personajes
        response.sendRedirect(request.getContextPath() + "/seleccionar");
    }
}

