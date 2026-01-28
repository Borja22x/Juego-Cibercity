package Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Clases.Partida;

@WebServlet("/pasarTurno")
public class PasarTurnoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Partida partida = (Partida) session.getAttribute("partida");

        if (partida == null) {
            response.sendRedirect(request.getContextPath() + "/JSP/pantallaConfig.jsp");
            return;
        }

        // 👉 Solo avanzar turno
        boolean fin = partida.siguienteTurno();

        if (fin) {
            session.setAttribute("jugadores", partida.getJugadores());
            session.setAttribute("ganador", partida.getGanador());
            response.sendRedirect(request.getContextPath() + "/finPartida");
            return;
        }

        session.setAttribute("partida", partida);
        response.sendRedirect(request.getContextPath() + "/pantallaJuego");
    }
}
