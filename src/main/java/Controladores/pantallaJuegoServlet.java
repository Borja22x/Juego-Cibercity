package Controladores;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import Clases.Jugador;
import Clases.Partida;

//Servlet que prepara todos los datos necesarios para mostrar la pantalla principal del juego (estado del turno actual).

@WebServlet("/pantallaJuego")
public class pantallaJuegoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        // Recuperamos la partida y los jugadores desde sesión
        Partida partida = (Partida) session.getAttribute("partida");
        List<Jugador> jugadores = (List<Jugador>) session.getAttribute("jugadores");

        //si falla algo volvemos para atras
        if (partida == null || jugadores == null) {
            response.sendRedirect(request.getContextPath() + "/JSP/pantallaConfig.jsp");
            return;
        }

        //JUGADOR ACTUAL REAL
        Jugador jugador = partida.getJugadorActual();
        
        //Datos de la view
        request.setAttribute("jugador", jugador);
        request.setAttribute("ronda", partida.getRonda());
        request.setAttribute("nombreJugador", jugador.getNombre());
        request.setAttribute("bitcoin", jugador.getBitcoin());
        request.setAttribute("rol", jugador.getPersonajeSeleccionado().getNombre());
        request.setAttribute("ganancias", jugador.getGananciaUltimaRonda());

        //Lista jugadores
        request.setAttribute("jugadores", jugadores);
        
        //Enviar a la jsp
        request.getRequestDispatcher("/JSP/pantallaJuego.jsp").forward(request, response);
    }

    @Override
    //Mostrar pantalla
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
