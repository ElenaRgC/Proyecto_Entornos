package Jefe

import Clases.Implementacion
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.sql.SQLException

class TestImplementacion {
    private lateinit var implementacion: Implementacion

    @BeforeEach
    fun setUp() {
        implementacion = Implementacion()
    }

    @Test
    @DisplayName("Modificación de campo exitosa")
    fun testModificarCampoExitoso() {
        val nombre = "Luke"
        val nombreCampo = "nivel"
        val nuevoValorCampo = "10"
        val resultadoEsperado = true
        val resultado = implementacion.modificarCampo(nombre, nombreCampo, nuevoValorCampo)
        assertEquals(resultadoEsperado, resultado)
    }

    @Test
    @DisplayName("Modificación de campo fallida")
    fun testModificarCampoFallido() {
        val nombre = "NoExiste"
        val nombreCampo = "nivel"
        val nuevoValorCampo = "10"
        val resultadoEsperado = false
        val resultado = implementacion.modificarCampo(nombre, nombreCampo, nuevoValorCampo)
        assertEquals(resultadoEsperado, resultado)
    }

    @Test
    @DisplayName("Modificación de campo con valor inválido")
    fun testModificarCampoValorInvalido() {
        val nombre = "Luke"
        val nombreCampo = "nombre"
        val nuevoValorCampo = "     "
        assertThrows(SQLException::class.java) {
            implementacion.modificarCampo(nombre, nombreCampo, nuevoValorCampo)
        }
    }
}
