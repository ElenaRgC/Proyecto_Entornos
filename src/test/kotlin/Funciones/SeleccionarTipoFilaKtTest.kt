import Funciones.seleccionarTipoFila
import Habilidad.Habilidad
import Jefe.Jefe
import Pelea.Pelea
import Personaje.Personaje
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SeleccionarTipoFilaTest {

    @Test
    fun testSeleccionarTipoFila() {
        // Prueba para la tabla "habilidad"
        var fila = seleccionarTipoFila("habilidad")
        assertTrue(fila is Habilidad)

        // Prueba para la tabla "jefe"
        fila = seleccionarTipoFila("jefe")
        assertTrue(fila is Jefe)

        // Prueba para la tabla "pelea"
        fila = seleccionarTipoFila("pelea")
        assertTrue(fila is Pelea)

        // Prueba para la tabla "personaje"
        fila = seleccionarTipoFila("personaje")
        assertTrue(fila is Personaje)

        // Prueba para una tabla desconocida
        assertThrows(Exception::class.java) { seleccionarTipoFila("tablaDesconocida") }
    }
}
