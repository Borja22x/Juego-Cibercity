<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Game Rules</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/gameRules.css">

    <!-- Icono -->
    <link rel="icon" type="image/x-icon" 
          href="${pageContext.request.contextPath}/img/eva-pestaña-google.png">
</head>

<body>

    <div id="tituloH1">
        <h1>Game Rules</h1>
    </div>

    <div id="imagen-eva">
        <img src="${pageContext.request.contextPath}/img/evaGameRules.png" alt="Mascota Eva">
    </div>

    <p id="r1">Cada jugador empezará con 2 cartas y 10 monedas</p>
    <p id="r2">Para ganar debes construir 7 edificios antes que los demás equipos y obtener la mayor cantidad de puntos finales.</p>
    <p id="r3">Deben participar como mínimo 3 jugadores y 5 como máximo</p>
    <p id="r4">No se podrán repetir personajes y su elección será de forma aleatoria</p>

    <div id="boton-volver">
        <a href="${pageContext.request.contextPath}/JSP/index.jsp" id="icono-volver">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" 
                 viewBox="0 0 24 24" fill="none" stroke="currentColor" 
                 stroke-width="2" stroke-linecap="round" stroke-linejoin="round" 
                 class="feather feather-rotate-ccw">
                    <polyline points="1 4 1 10 7 10"></polyline>
                    <path d="M3.51 15a9 9 0 1 0 2.13-9.36L1 10"></path>
            </svg>
        </a>
    </div>

</body>
</html>