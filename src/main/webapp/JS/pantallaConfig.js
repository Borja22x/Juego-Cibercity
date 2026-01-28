document.addEventListener("DOMContentLoaded", () => {

    const radios = document.querySelectorAll('input[name="players"]');
    const container = document.getElementById('jugadores-container');

    // Comprobamos si hubo error y un radio estaba marcado
 //   const radioChecked = document.querySelector('input[name="players"]:checked');
  //  const numJugadoresError = radioChecked ? parseInt(radioChecked.value) : 0;

    function crearInputs(numJugadores) {
        container.innerHTML = '';

        for (let i = 1; i <= numJugadores; i++) {
            const div = document.createElement('div');
            div.classList.add('jugador-box');

            const p = document.createElement('p');
            p.textContent = 'Player ' + i;

            const inputGroup = document.createElement('div');
            inputGroup.classList.add('input-group');

            const labelText = document.createElement('span');
            labelText.textContent = 'ID_TAG: ';

            const input = document.createElement('input');
            input.type = 'text';
            input.name = 'jugador' + i;   // 🔑 CLAVE
            input.maxLength = 20;
            input.required = true;
            input.placeholder = 'Introduce tu nombre';

            inputGroup.appendChild(labelText);
            inputGroup.appendChild(input);

            div.appendChild(p);
            div.appendChild(inputGroup);

            container.appendChild(div);
        }
    }

    // Si venimos de error, reconstruimos los inputs
   // if (numJugadoresError > 0) {
    //    crearInputs(numJugadoresError);
    //}

    // Listener de radios
    radios.forEach(radio => {
        radio.addEventListener('change', () => {
            crearInputs(parseInt(radio.value));
        });
    });

});
