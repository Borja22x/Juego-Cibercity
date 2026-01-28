<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Información</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/gameInfo.css">

    <!-- ICON -->
    <link rel="icon" type="image/x-icon" 
          href="${pageContext.request.contextPath}/img/eva-pestaña-google.png">
</head>

<body>

    <div id="titulo">
        <h1>Info</h1>
    </div>
    
    <section>
        <div id="imagen">
            <img src="${pageContext.request.contextPath}/img/evaGameInfo.png" 
                 alt="Mascota llamada Eva">
        </div>

        <div>
            <p>Versión: 1.0</p>
            <p>
                Correos: <br>
                lucia.soto.sanchez@gmail.com <br>
                borjacanosavarela@gmail.com <br>
                andrearivadulla99@gmail.com <br>
            </p>

            <p>
                Autores:<br>
                Lucia Soto Sánchez<br>
                Borja Canosa Varela<br>
                Andrea Pollán Rivadulla<br>
            </p>
        </div>
    </section>

    <div id="botonAtras">
        <a href="${pageContext.request.contextPath}/JSP/index.jsp" id="icono-volver">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" 
                 viewBox="0 0 24 24" fill="none"
                 stroke="currentColor" stroke-width="2" stroke-linecap="round" 
                 stroke-linejoin="round" class="feather feather-rotate-ccw">
                <polyline points="1 4 1 10 7 10"></polyline>
                <path d="M3.51 15a9 9 0 1 0 2.13-9.36L1 10"></path>
            </svg>
        </a>
    </div>

</body>

</html>