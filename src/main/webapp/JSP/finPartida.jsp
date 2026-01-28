<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>¡Victoria!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/finPartida.css">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/eva-pestaña-google.png">
</head>
<body>
    <div id="principal">
        <div id="ganador">
            <h1>GANADOR</h1>
            <img id="fotoGanador" src="${pageContext.request.contextPath}/img/${ganador.personajeSeleccionado.archivo}" alt="Ganador">
            
            <div id="datosGanador">
                <h2>${ganador.nombre}</h2>
                <h3>${ganador.calcularPuntosFinales()} ptos</h3>
                <h4>${ganador.personajeSeleccionado.nombre}</h4>
            </div>
        </div>

        <div id="menu">
            <h5>· Ranking ·</h5>
            <table>
                <c:forEach var="j" items="${jugadores}">
                    <%-- Marcamos con clase 'lider' si es el mismo nombre que el ganador --%>
                    <tr class="${j.nombre == ganador.nombre ? 'lider' : ''}">
                        <th>${j.nombre}</th>
                        <th>${j.calcularPuntosFinales()} ptos.</th>
                        <th>${j.personajeSeleccionado.nombre}</th>
                    </tr>
                </c:forEach>
            </table>

            <div id="botones-accion">
                <a href="${pageContext.request.contextPath}/JSP/index.jsp" id="volverMenu">Ir a la pantalla de inicio</a>
            </div>
        </div>
        
        <div >
	        <img id="imagen-eva-fija" src="${pageContext.request.contextPath}/img/evaGameRules.png" alt="eva">
	    </div>

        <div class="confetti-container">
            <c:forEach begin="1" end="30">
                <div class="confetti"></div>
            </c:forEach>
        </div>
    </div>

    

</body>
</html>