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

@WebServlet("/pantallaJuego")
public class pantallaJuegoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // Obtener datos de la sesión
        Partida partida = (Partida) session.getAttribute("partida");
        List<Jugador> jugadores = (List<Jugador>) session.getAttribute("jugadores");
        Integer jugadorActual = (Integer) session.getAttribute("jugadorActual");
        
        // Validación: si no hay datos, redirigir a configuración
        if (partida == null || jugadores == null || jugadorActual == null) {
            response.sendRedirect(request.getContextPath() + "/JSP/pantallaConfig.jsp");
            return;
        }
        
        // Obtener el jugador actual (ajustar índice si es necesario)
        int indiceJugador = (jugadorActual >= jugadores.size()) ? 0 : jugadorActual;
        Jugador jugador = jugadores.get(indiceJugador);
        
        // Pasar atributos al JSP
        request.setAttribute("ronda", partida.getRonda()); 
        request.setAttribute("nombreJugador", jugador.getNombre());
        request.setAttribute("bitcoin", jugador.getBitcoin()); 
        request.setAttribute("rol", jugador.getPersonajeSeleccionado().getNombre()); 
        request.setAttribute("ganancias", jugador.getGananciaUltimaRonda()); 
        
        // Redirigir al JSP
        request.getRequestDispatcher("/JSP/pantallaJuego.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}