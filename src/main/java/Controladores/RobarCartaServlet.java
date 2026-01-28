package Controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Clases.Partida;
import Clases.Jugador;
import cartas.Mazo;

@WebServlet("/robarCarta")
public class RobarCartaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Partida partida = (Partida) session.getAttribute("partida");
        Mazo mazo = (Mazo) session.getAttribute("mazo");

        if (partida == null || mazo == null) {
            response.sendRedirect(request.getContextPath() + "/JSP/pantallaConfig.jsp");
            return;
        }

        Jugador jugador = partida.getJugadorActual();

        // Robar carta SI PUEDE
        if (jugador.puedeRobarCarta()) {
            jugador.robarCarta(mazo.robar());
        }

        // Avanzar turno
        boolean fin = partida.siguienteTurno();

        if (fin) {
            session.setAttribute("jugadores", partida.getJugadores());
            session.setAttribute("ganador", partida.getGanador());

            response.sendRedirect(request.getContextPath() + "/finPartida");
            return;
        }

        // Guardar estado actualizado
        session.setAttribute("partida", partida);
        session.setAttribute("mazo", mazo);

        response.sendRedirect(request.getContextPath() + "/pantallaJuego");
    }
}
