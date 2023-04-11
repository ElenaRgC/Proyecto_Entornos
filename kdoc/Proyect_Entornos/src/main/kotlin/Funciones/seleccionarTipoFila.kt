package Funciones

import Clases.Fila
import Habilidad.Habilidad
import Jefe.Jefe
import Pelea.Pelea
import Personaje.Personaje
import java.lang.Exception

/**
 * Seleccionar tipo fila
 *
 * Selecciona el tipo de fila correspondiente a la tabla especificada.
 *
 * @param nombreTabla el nombre de la tabla en la que se desea trabajar.
 * @return una instancia de la clase Fila que corresponde a la tabla especificada.
 * @throws Exception si el nombre de la tabla no corresponde a una tabla válida.
 */
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