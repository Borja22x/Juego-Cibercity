package Controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Clases.Partida;
import Clases.Jugador;

@WebServlet("/configurar")
public class ConfigurarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String playersStr = request.getParameter("players");
        
        if (playersStr == null || playersStr.isEmpty()) {
            request.setAttribute("error", "Debes seleccionar cuántos jugadores participan.");
            request.getRequestDispatcher("/JSP/pantallaConfig.jsp").forward(request, response);
            return;
        }
        
        int numJugadores = Integer.parseInt(playersStr);
        
        // Guardamos el número de jugadores para que el JSP pueda reconstruir los inputs
        request.setAttribute("numJugadores", numJugadores); 
        
        List<Jugador> listaJugadores = new ArrayList<>();
        List<String> nombresValidos = new ArrayList<>();
        
        
        for (int i = 1; i <= numJugadores; i++) {
            String nombre = request.getParameter("jugador" + i);
            
            // Lógica para asignar nombre por defecto o limpiar espacios
            if (nombre == null || nombre.trim().isEmpty()) {
                nombre = "Jugador " + i;
            } else {
                nombre = nombre.trim();
            }
            
            // VERIFICACIÓN DE NOMBRE REPETIDO CON ArrayList
            if (nombresValidos.contains(nombre)) { 
                // Si el nombre ya está en la lista, se muestra error
                request.setAttribute("error", "El nombre de jugador '" + nombre + "' ya ha sido utilizado. ¡Los nombres deben ser únicos!");
                
                // Volvemos a la pantalla Conf y mostramos el error (se mantiene numJugadores en el request)
                request.getRequestDispatcher("/JSP/pantallaConfig.jsp").forward(request, response);
                return; 
            }
            
            // Si el nombre es único
            nombresValidos.add(nombre);
            listaJugadores.add(new Jugador(nombre));
        }
        
        // Si no hay errores, inicializamos la partida
        HttpSession session = request.getSession(true);
        session.setAttribute("jugadores", listaJugadores);
        session.setAttribute("jugadorActual", 0);
        session.setAttribute("index", 0);
        session.setAttribute("partida", new Partida());
        
        response.sendRedirect(request.getContextPath() + "/seleccionar");
    }
}