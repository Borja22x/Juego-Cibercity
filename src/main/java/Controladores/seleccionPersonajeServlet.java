package Controladores;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Clases.Jugador;
import Clases.Partida;
import Clases.Personaje;

@WebServlet("/seleccionar")
public class seleccionPersonajeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Partida partida = (Partida) session.getAttribute("partida");
        List<Jugador> jugadores = (List<Jugador>) session.getAttribute("jugadores");

        // Si no hay partida, volvemos al inicio
        if (partida == null || jugadores == null) {
            response.sendRedirect(request.getContextPath() + "/JSP/pantallaConfig.jsp");
            return;
        }

        // Inicializaciones SEGURAS
        Integer jugadorActual = (Integer) session.getAttribute("jugadorActual");
        if (jugadorActual == null) {
            jugadorActual = 0;
        }

        Integer index = (Integer) session.getAttribute("index");
        if (index == null) {
            index = 0;
        }

        List<Personaje> personajesDisponibles = partida.getPersonajes();

        // Seguridad: no debería pasar, pero evitamos crash
        if (personajesDisponibles == null || personajesDisponibles.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/pantallaCarga");
            return;
        }

        if (index >= personajesDisponibles.size()) {
            index = 0;
        }

        String accion = request.getParameter("accion");

        if ("left".equals(accion)) {
            index = (index - 1 + personajesDisponibles.size()) % personajesDisponibles.size();
        }

        if ("right".equals(accion)) {
            index = (index + 1) % personajesDisponibles.size();
        }

        if ("select".equals(accion)) {
            Personaje elegido = personajesDisponibles.get(index);
            jugadores.get(jugadorActual).setPersonajeSeleccionado(elegido);

            partida.seleccionar(index);

            jugadorActual++;

            if (jugadorActual >= jugadores.size()) {
                Collections.shuffle(jugadores);
                session.setAttribute("jugadores", jugadores);
                session.setAttribute("jugadorActual", 0);
                response.sendRedirect(request.getContextPath() + "/pantallaCarga");
                return;
            }

            index = 0;
            personajesDisponibles = partida.getPersonajes();
        }

        // Guardar estado
        session.setAttribute("jugadorActual", jugadorActual);
        session.setAttribute("index", index);

        Jugador jugadorActivo = jugadores.get(jugadorActual);

        request.setAttribute("personajeActual", personajesDisponibles.get(index));
        request.setAttribute("jugadorNombre", jugadorActivo.getNombre());

        request.getRequestDispatcher("/JSP/seleccionPersonaje.jsp").forward(request, response);
    }
}
