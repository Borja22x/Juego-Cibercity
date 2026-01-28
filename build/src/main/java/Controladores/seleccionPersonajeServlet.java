package Controladores;

import java.io.IOException;
import java.util.ArrayList;
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

        Integer jugadorActual = (Integer) session.getAttribute("jugadorActual");
        Integer index = (Integer) session.getAttribute("index");
        
        //Usamos la lista principal que ahora solo tiene disponibles
        List<Personaje> personajesDisponibles = partida.getPersonajes();
     
        // Validación inicial
        if (jugadorActual == null || index == null || jugadores == null || partida == null) {
            response.sendRedirect(request.getContextPath() + "/JSP/pantallaConfig.jsp");
            return;
        }
        
        if (index >= personajesDisponibles.size()) {
            index = 0; // Si el index apunta a un personaje que fue eliminado, resetearlo.
        }

        String accion = request.getParameter("accion");

        // Procesar acciones
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
            	jugadorActual = 0;
            	session.setAttribute("jugadores", jugadores);
                session.setAttribute("jugadorActual", jugadorActual);
                response.sendRedirect(request.getContextPath() + "/pantallaCarga");
                return;
            }

            index = 0;
            
         // Recargamos la lista de disponibles (aunque ya está actualizada en partida)
            personajesDisponibles = partida.getPersonajes(); 
           
            
        }

        // Actualizar sesión
        session.setAttribute("jugadorActual", jugadorActual);
        session.setAttribute("index", index);

        // CRÍTICO: Pasar el nombre del jugador ACTUAL como atributo
        Jugador jugadorActivo = jugadores.get(jugadorActual);
        
        request.setAttribute("personajeActual", personajesDisponibles.get(index));
        request.setAttribute("jugadorNombre", jugadorActivo.getNombre());

        request.getRequestDispatcher("/JSP/seleccionPersonaje.jsp").forward(request, response);
    }
}