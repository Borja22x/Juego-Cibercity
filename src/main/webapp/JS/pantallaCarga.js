// === Configuración de imágenes ===
        var fondos = [
            "pantallaCarga1.png",
            "pantallaCarga2.png",
            "pantallaCarga3.png",
            "pantallaCarga4.png",
            "pantallaCarga5.png",
            "pantallaCarga6.png",
            "pantallaCarga7.png",
            "pantallaCarga8.png",
            "pantallaCarga9.png"
        ];

        // Selección aleatoria del fondo
        var fondoAleatorio = fondos[Math.floor(Math.random() * fondos.length)];
        var background = document.getElementById("background");
        
        // CAMBIO 3: Construir URL correctamente
        var imagenURL = contextPath + "/img/" + fondoAleatorio;
        console.log("URL imagen:", imagenURL);
        
        background.style.backgroundImage = "url('" + imagenURL + "')";

        // === Barra de progreso ===
        var progreso = 0;
        var progressFill = document.getElementById("progress-fill");
        var progressText = document.getElementById("progress-text");

        var intervalo = setInterval(function() {
            progreso += Math.floor(Math.random() * 5) + 1;
            if (progreso > 100) progreso = 100;

            progressFill.style.width = progreso + "%";
            progressText.textContent = progreso + "%";

            if (progreso === 100) {
                clearInterval(intervalo);

                // Efecto de fade-out antes de cambiar de pantalla
                background.classList.add("fade-out");
                progressFill.classList.add("fade-out");

                setTimeout(function() {
                    // Redirigir al menú principal del juego
                    window.location.href = contextPath + "/pantallaJuego";
                }, 1000);
            }
        }, 100);