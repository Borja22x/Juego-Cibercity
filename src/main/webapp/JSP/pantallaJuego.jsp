<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pantalla de Juego</title>

    <link rel="stylesheet" 
          href="${pageContext.request.contextPath}/CSS/pantallaJuego.css">
    <link rel="icon" type="image/x-icon" 
          href="${pageContext.request.contextPath}/img/eva-pestaña-google.png">

</head>




<body>

    <h1>Ronda <%= request.getAttribute("ronda") != null ? request.getAttribute("ronda") : "(num)" %></h1>

    <section id="ciudad">
    

<section id="ciudad">

    <!-- ========= EDIFICIO AZUL ========= -->
    <c:set var="ventanasAzul" value="0"/>
    <c:forEach var="j" items="${jugadores}">
        <c:if test="${j.edificioAsignado == 'edificioAzul'}">
            <c:set var="ventanasAzul" value="${j.ventanasConstruidas}"/>
        </c:if>
    </c:forEach>

    <div id="edificioAzul"
         class="azul ${jugador.edificioAsignado == 'edificioAzul' ? 'edificio-activo' : ''}">
        <c:forEach var="i" begin="1" end="7">
            <button class="ventana ${i <= ventanasAzul ? 'encendida' : ''}"></button>
        </c:forEach>
    </div>


    <!-- ========= EDIFICIO VERDE ========= -->
    <c:set var="ventanasVerde" value="0"/>
    <c:forEach var="j" items="${jugadores}">
        <c:if test="${j.edificioAsignado == 'edificioVerde'}">
            <c:set var="ventanasVerde" value="${j.ventanasConstruidas}"/>
        </c:if>
    </c:forEach>

    <div id="edificioVerde"
         class="verde ${jugador.edificioAsignado == 'edificioVerde' ? 'edificio-activo' : ''}">
        <c:forEach var="i" begin="1" end="7">
            <button class="ventana ${i <= ventanasVerde ? 'encendida' : ''}"></button>
        </c:forEach>
    </div>


    <!-- ========= EDIFICIO ROJO ========= -->
    <c:set var="ventanasRojo" value="0"/>
    <c:forEach var="j" items="${jugadores}">
        <c:if test="${j.edificioAsignado == 'edificioRojo'}">
            <c:set var="ventanasRojo" value="${j.ventanasConstruidas}"/>
        </c:if>
    </c:forEach>

    <div id="edificioRojo"
         class="rojo ${jugador.edificioAsignado == 'edificioRojo' ? 'edificio-activo' : ''}">
        <c:forEach var="i" begin="1" end="7">
            <button class="ventana ${i <= ventanasRojo ? 'encendida' : ''}"></button>
        </c:forEach>
    </div>


    <!-- ========= EDIFICIO ROSA ========= -->
    <c:set var="ventanasRosa" value="0"/>
    <c:forEach var="j" items="${jugadores}">
        <c:if test="${j.edificioAsignado == 'edificioRosa'}">
            <c:set var="ventanasRosa" value="${j.ventanasConstruidas}"/>
        </c:if>
    </c:forEach>

    <div id="edificioRosa"
         class="rosa ${jugador.edificioAsignado == 'edificioRosa' ? 'edificio-activo' : ''}">
        <c:forEach var="i" begin="1" end="7">
            <button class="ventana ${i <= ventanasRosa ? 'encendida' : ''}"></button>
        </c:forEach>
    </div>


    <!-- ========= EDIFICIO AMARILLO ========= -->
    <c:set var="ventanasAmarillo" value="0"/>
    <c:forEach var="j" items="${jugadores}">
        <c:if test="${j.edificioAsignado == 'edificioAmarillo'}">
            <c:set var="ventanasAmarillo" value="${j.ventanasConstruidas}"/>
        </c:if>
    </c:forEach>

    <div id="edificioAmarillo"
         class="amarillo ${jugador.edificioAsignado == 'edificioAmarillo' ? 'edificio-activo' : ''}">
        <c:forEach var="i" begin="1" end="7">
            <button class="ventana ${i <= ventanasAmarillo ? 'encendida' : ''}"></button>
        </c:forEach>
    </div>

</section>    

    </section>

    <!-- MENÚ LATERAL -->
    <section id="menu">

        <div id="info-jugador">
            <h2>Turno de: 
                <%= request.getAttribute("nombreJugador") != null 
                        ? request.getAttribute("nombreJugador") 
                        : "(nombre)" %>
            </h2>

            <h3>Dinero: 
                <%= request.getAttribute("bitcoin") != null 
                        ? request.getAttribute("bitcoin") 
                        : "(bitcoin)" %>
            </h3>

            <h3>Rol: 
                <%= request.getAttribute("rol") != null 
                        ? request.getAttribute("rol") 
                        : "(rol)" %>
            </h3>

            <p>
                Has conseguido 
                <%= request.getAttribute("ganancias") != null 
                        ? request.getAttribute("ganancias") 
                        : "X" %>
                bitcoin.
            </p>
        </div>
<h3>Tus cartas:</h3>

<div id="cartas-jugador"> 

    <c:if test="${empty jugador.mano}">
        <p>No tienes cartas.</p>
    </c:if>

    <c:forEach var="carta" items="${jugador.mano}">
        <div class="carta">

            <p><strong>${carta.nombre}</strong></p>
            <p>${carta.descripcion}</p>
            <p>Coste: ${carta.coste} bitcoins</p>

            <!-- BOTÓN CONSTRUIR -->
            <form action="${pageContext.request.contextPath}/construirCarta" method="post">
			    <input type="hidden" name="idCarta" value="${carta.id}">
			
			    <button type="submit" ${jugador.bitcoin < carta.coste ? 'disabled' : ''}>
			        Construir
			    </button>
			</form>


            <!-- MENSAJE SI NO PUEDE PAGAR -->
            <c:if test="${jugador.bitcoin < carta.coste}">
                <p style="color: #888; font-size: 13px;">
                    No tienes bitcoins suficientes
                </p>
            </c:if>

        </div>
    </c:forEach>

</div>


        <article></article>

        <p>¿Qué deseas hacer?</p>

<div id="botones-accion" style="display: flex; justify-content: center; gap: 20px; align-items: center; margin-top: 20px;">

    <c:if test="${jugador.puedeRobarCarta()}">
        <form action="${pageContext.request.contextPath}/robarCarta" method="post" style="margin: 0;">
            <button type="submit">Robar carta</button>
        </form>
    </c:if>
    
    <form action="${pageContext.request.contextPath}/pasarTurno" method="post" style="margin: 0;">
        <button type="submit">Pasar turno</button>
    </form>
    
    <c:if test="${!jugador.puedeRobarCarta()}">
        <p style="color: red; font-weight: bold; margin: 0; position: absolute; transform: translateY(40px);">
            Tienes el máximo de 5 cartas
        </p>
    </c:if>

</div>

    </section>




   

    

</body>
</html>
