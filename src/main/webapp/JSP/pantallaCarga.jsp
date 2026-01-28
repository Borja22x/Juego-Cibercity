<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pantalla de Carga - Cibercity</title>

    <!-- CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/CSS/pantallaCarga.css">

    <!-- Icono pestaña -->
    <link rel="icon" type="image/x-icon"
          href="${pageContext.request.contextPath}/img/eva-pestaña-google.png">
</head>

<body>

    <div id="loading-container">
        <div id="background"></div>

        <div id="progress-bar">
            <div id="progress-fill">
                <span id="progress-text">0%</span>
            </div>
        </div>
    </div>

    <script>
        // Definir la variable global 'contextPath' para que el JS externo la use.
        var contextPath = '<%= request.getContextPath() %>';
        console.log("Context Path:", contextPath);
    </script>

    <script src="${pageContext.request.contextPath}/JS/pantallaCarga.js"></script>
    
</body>
</html>