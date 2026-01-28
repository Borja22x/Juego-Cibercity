const radios = document.querySelectorAll('input[name="players"]');
const container = document.getElementById('jugadores-container');
    
// Identificamos si un radio button está marcado para saber cuántos inputs dibujar
const radioChecked = document.querySelector('input[name="players"]:checked');
const numJugadoresError = radioChecked ? parseInt(radioChecked.value) : 0;
    
// Función para crear los inputs de nombre
// Función para crear los inputs de nombre
function crearInputs(numJugadores) {
    container.innerHTML = ''; // Limpiamos el contenedor
    
    for (let i = 1; i <= numJugadores; i++) {
        const div = document.createElement('div');
        div.classList.add('jugador-box');

        const p = document.createElement('p');
        p.textContent = 'Player ' + i;
        
        // --- INICIO DE MODIFICACIÓN ---
        
        // 1. Creamos un contenedor específico para el rótulo y el input
        const inputGroup = document.createElement('div');
        inputGroup.classList.add('input-group');
        
        const labelText = document.createElement('span'); // Usamos span para el texto "ID_TAG:"
        labelText.textContent = 'ID_TAG: ';
        
        const input = document.createElement('input');
        input.type = 'text';
        input.name = 'jugador' + i;
        input.maxLength = 20;
        input.required = true;
        input.placeholder = 'Introduce tu nombre';
        
        // 2. Montamos la estructura:
        // El inputGroup contendrá el texto y el campo de texto.
        inputGroup.appendChild(labelText);
        inputGroup.appendChild(input); 
        
        // 3. Montamos la tarjeta del jugador:
        div.appendChild(p);
        div.appendChild(inputGroup); // Añadimos el nuevo grupo
        
        // --- FIN DE MODIFICACIÓN ---
        
        container.appendChild(div);
    }
}
    
    // 1. Lógica de error: Si hubo un error (numJugadoresError > 0), creamos los inputs al cargar
    if (numJugadoresError > 0) {
        crearInputs(numJugadoresError);
    }
    
    // 2. Listener para los radio buttons (comportamiento normal al hacer click)
    radios.forEach(radio => {
        radio.addEventListener('change', () => {
            const numJugadores = parseInt(radio.value);
            crearInputs(numJugadores);
        });
    });
