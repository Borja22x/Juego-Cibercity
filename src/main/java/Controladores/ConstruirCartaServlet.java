package Controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Clases.Jugador;
import Clases.Partida;
import cartas.Carta;


//Servlet que gestiona la acción de construir una carta y se ejecuta cuando el jugador pulsa botón de construir.
@WebServlet("/construirCarta")
public class ConstruirCartaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        //Recuperar la partida desde sesión
        Partida partida = (Partida) session.getAttribute("partida");

        if (partida == null) {
            //Si no hay partida volvemos a configuración
        	response.sendRedirect(request.getContextPath() + "/JSP/pantallaConfig.jsp");
            return;
        }

        //Obtener jugador del turno
        Jugador jugador = partida.getJugadorActual();

        //Obtener id de la carta
        String idCartaStr = request.getParameter("idCarta");
        if (idCartaStr == null) {
            response.sendRedirect(request.getContextPath() + "/pantallaJuego");
            return;
        }

        int idCarta = Integer.parseInt(idCartaStr);

        //Buscar carta en la mano
        Carta carta = jugador.getCartaPorId(idCarta);

        if (carta == null) {
            response.sendRedirect(request.getContextPath() + "/pantallaJuego");
            return;
        }

        //Intento de construcción
        boolean construida = jugador.usarCarta(carta);

        if (construida) {

            // marcar si alguien llegó a 7 ventanas
            partida.comprobarEdificioCompletado(jugador);

            // Avanzar turno
            boolean fin = partida.siguienteTurno();

            if (fin) {
                session.setAttribute("jugadores", partida.getJugadores());
                session.setAttribute("ganador", partida.getGanador());
                response.sendRedirect(request.getContextPath() + "/finPartida");
                return;
            }
        }

        // Volver al juego (si no pudo construir o si continua)
        response.sendRedirect(request.getContextPath() + "/pantallaJuego");

    }
}
