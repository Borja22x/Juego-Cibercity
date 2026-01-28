<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    <!-- Título principal -->
    <h1>Ronda <%= request.getAttribute("ronda") != null ? request.getAttribute("ronda") : "(num)" %></h1>

    <!-- CIUDAD / EDIFICIOS -->
    <section id="ciudad">

        <div id="edificioAzul" class="azul">
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
        </div>

        <div id="edificioVerde" class="verde">
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
        </div>

        <div id="edificioRojo" class="rojo">
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
        </div>

        <div id="edificioRosa" class="rosa">
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
        </div>

        <div id="edificioAmarillo" class="amarillo">
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
            <button class="ventana"></button>
        </div>

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
		    <img id="img1" src="/Cibercity/img/Cartas/Analista%20de%20Sistemas/carta_AnalistaDeSistemas_1-removebg-preview.png" alt="Analista">
		    
		    <img id="img2" src="/Cibercity/img/Cartas/Arquitecto%20de%20Red/carta_arquitecto_red_1-removebg-preview.png" alt="Arquitecto">
		    
		    <img id="img3" src="/Cibercity/img/Cartas/Cartas%20Genericas/carta_1-removebg-preview.png" alt="general">
		    
		    <img id="img4" src="/Cibercity/img/Cartas/Comerciante%20de%20Datos/carta_comerciante_1-removebg-preview.png" alt="Comerciante">
		    
		    <img id="img5" src="/Cibercity/img/Cartas/Constructor%20de%20nodos/carta_Constructor_4-removebg-preview.png" alt="Constructor">
		</div>

        <article></article>

        <p>¿Qué deseas hacer?</p>
        <div id="botones-accion">
            <button id="construir">Construir</button>
            <button id="robar">Robar carta</button>
        </div>

    </section>

    <!-- ========================== -->
    <!--   SCRIPTS FINALES          -->
    <!-- ========================== -->

   <!--  <script src="${pageContext.request.contextPath}/JS/cartas.js"></script>
   

    <script>
        document.addEventListener("DOMContentLoaded", () => {
            const contenedor = document.getElementById("cartas-jugador");

            cartas.forEach(carta => {
                const img = document.createElement("img");
                img.src = `${pageContext.request.contextPath}/${carta.rutaImagen}`;
                img.classList.add("carta");
                img.alt = carta.nombre;

                contenedor.appendChild(img);
            });
        });
    </script> -->

</body>
</html>
