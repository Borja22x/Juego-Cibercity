class Carta {
    constructor(id, nombre, descripcion, tipo, coste, rutaImagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo; 
        this.coste = coste; 
        this.rutaImagen = rutaImagen;
    }
}

const cartas = [
    new Carta(
        1,
        "Constructor de Nodos",
        "Expande la red construyendo estructuras eficientes.",
        "Constructor",
        3,
        "/CiberCity/img/cartas/carta_1.png"
    ),

    new Carta(
        2,
        "Analista de Sistemas",
        "Evalúa la red y optimiza su rendimiento.",
        "Analista",
        2,
        "/CiberCity/img/cartas/carta_2.png"
    )
];
