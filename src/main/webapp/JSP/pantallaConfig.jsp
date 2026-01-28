<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Configuración partida</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/pantallaConfig.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/pantallaEscape.css">
<link rel="icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/eva-pestaña-google.png">
</head>
<body>

	<header id="titulo">
		<h1>Configuración partida</h1>
	</header>

	<section class="config">
		<p class="subtitulo">Selección de jugadores</p>

		<form action="${pageContext.request.contextPath}/configurar"
			method="POST" id="form-config">

			<div class="radio-group">
				<%-- Usamos 'checked' para mantener la opción seleccionada si hubo un error --%>
				<label><input type="radio" name="players" value="3"
					<%=(request.getAttribute("numJugadores") != null && request.getAttribute("numJugadores").equals(3)) ? "checked"
		: ""%>>3</label>
				<label><input type="radio" name="players" value="4"
					<%=(request.getAttribute("numJugadores") != null && request.getAttribute("numJugadores").equals(4)) ? "checked"
		: ""%>>4</label>
				<label><input type="radio" name="players" value="5"
					<%=(request.getAttribute("numJugadores") != null && request.getAttribute("numJugadores").equals(5)) ? "checked"
		: ""%>>5</label>
			</div>

			<section id="jugadores-container" class="jugadores"></section>

			<div class="botones">
				<a href="${pageContext.request.contextPath}/JSP/index.jsp"
					class="btn-enlace">Return to menu</a>
				<button type="submit" class="btn-enlace">Initialize game</button>
			</div>

			<%-- Errores --%>
			<%
			String error = (String) request.getAttribute("error");
			if (error != null) {
			%>
			<div
				style="color: white; font-weight: bold; text-align: center; margin-bottom: 15px; padding: 10px;">
				<%=error%>
			</div>
			<%
			}
			%>
			<%-- Fin errores --%>
		</form>
	</section>

	<script src="${pageContext.request.contextPath}/JS/pantallaConfig.js"></script>

</body>
</html>