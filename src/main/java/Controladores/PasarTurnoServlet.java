package Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Clases.Partida;

// servle permite al jugador pasar su turno sin realizar ninguna acción y no modifica cartas, dinero ni estado jugador

@WebServlet("/pasarTurno")
public class PasarTurnoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        //Recuperamos la partida desde sesión
        Partida partida = (Partida) session.getAttribute("partida");

        //si hay algún fallo se vuelve para atras
        if (partida == null) {
            response.sendRedirect(request.getContextPath() + "/JSP/pantallaConfig.jsp");
            return;
        }

        //Avanzar turno
        boolean fin = partida.siguienteTurno();

        //Si se acabó la partida vamos ala pantalla final
        if (fin) {
            session.setAttribute("jugadores", partida.getJugadores());
            session.setAttribute("ganador", partida.getGanador());
            response.sendRedirect(request.getContextPath() + "/finPartida");
            return;
        }
        
        //Guarda estado actualizado de la partida
        session.setAttribute("partida", partida);
        //volvemos al juego con el siguiente jugador
        response.sendRedirect(request.getContextPath() + "/pantallaJuego");
    }
}
