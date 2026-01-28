<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Clases.Personaje" %>

<%
    Personaje p = (Personaje) request.getAttribute("personajeActual");
    String jugador = (String) request.getAttribute("jugadorNombre");

    if (p == null || jugador == null) {
%>
        <h1>Error: datos no encontrados.</h1>
        <p>Asegúrate de que el servlet está enviando correctamente los datos.</p>
        </body></html>
<%
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Selección de Personaje</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/seleccionPersonaje.css">
    <link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/eva-pestaña-google.png">
</head>

<body>

<h1>Turno de: <%= jugador %></h1>

<!-- Resto del código igual -->
<div class="container">
    <p id="personaje-nombre"><%= p.getNombre() %></p>

    <div class="selector">
        <a href="<%= request.getContextPath() %>/seleccionar?accion=left" class="arrow">◀</a>

        <div class="personaje-info">
            <img src="<%= request.getContextPath() %>/img/<%= p.getArchivo() %>" alt="<%= p.getNombre() %>">
        </div>

        <div class="descripcion-box">
            <h2>Habilidades</h2>
            <p><%= p.getDescripcion() %></p>
        </div>

        <a href="<%= request.getContextPath() %>/seleccionar?accion=right" class="arrow">▶</a>
    </div>

    <a href="<%= request.getContextPath() %>/seleccionar?accion=select" class="select-btn">
        SELECCIONAR
    </a>
</div>

</body>
</html>