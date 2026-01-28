<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CiberCity</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/index.css">

    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/eva-pestaña-google.png">
</head>

<body>
    <h1>CiberCity</h1>

    <div id="botones-portada">
        <a class="btn" href="${pageContext.request.contextPath}/JSP/pantallaConfig.jsp">Play</a>
        <a class="btn" href="${pageContext.request.contextPath}/JSP/gameRules.jsp">Game Rules</a>
        <a class="btn" href="${pageContext.request.contextPath}/JSP/gameInfo.jsp">Info</a>
        <a class="btn" href="https://github.com/Borja22x/Juego-Cibercity.git">Source</a>
    </div>

</body>
</html>