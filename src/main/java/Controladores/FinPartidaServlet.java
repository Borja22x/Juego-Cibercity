package Controladores;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/finPartida")
public class FinPartidaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        // Recuperar datos guardados
        request.setAttribute("ganador", session.getAttribute("ganador"));
        request.setAttribute("jugadores", session.getAttribute("jugadores"));

        request.getRequestDispatcher("/JSP/finPartida.jsp")
               .forward(request, response);
    }
}
