package Funciones

import Clases.Fila
import Habilidad.Habilidad
import Jefe.Jefe
import Pelea.Pelea
import Personaje.Personaje
import java.lang.Exception

fun seleccionarTipoFila(nombreTabla: String): Fila {
    var fila = Fila()

    when (nombreTabla) {
        "habilidad" -> fila = Habilidad()
        "jefe" -> fila = Jefe()
        "pelea" -> fila = Pelea()
        "personaje" -> fila = Personaje()
        else -> throw Exception()
    }

    return fila
}