package Funciones

import Clases.Fila
import Habilidad.Habilidad
import Jefe.Jefe
import Pelea.Pelea
import Personaje.Personaje

/**
 * Introducir campo en fila
 *
 * Introduce un campo en una fila, dependiendo del tipo de fila y la posición del campo en la fila.
 *
 * @param fila la fila en la que se introducirá el campo.
 * @param i la posición del campo dentro de la fila.
 * @param campo el valor del campo que se va a introducir.
 */
fun introducirCampoEnFila(fila: Fila, i: Int, campo: String) {

    when (fila) {
        is Habilidad -> when (i) {
            0 -> fila.nombre = campo
            1 -> fila.nivel = campo.toInt()
            2 -> fila.elemento = campo
            3 -> fila.descripcion = campo
            4 -> fila.dano = campo.toInt()
            5 -> fila.nombreP = campo
        }
        is Jefe -> when (i) {
            0 -> fila.nombreJ = campo
            1 -> fila.nivelJ = campo.toInt()
            2 -> fila.vida = campo.toInt()
            3 -> fila.dificultad = campo
            4 -> fila.descripcionJ = campo
        }
        is Pelea -> when (i) {
            0 -> fila.nombrePP = campo
            1 -> fila.nombreJJ = campo
        }
        is Personaje -> when (i) {
            0 -> fila.nombrePPP = campo
            1 -> fila.nivelP = campo.toInt()
            2 -> fila.clase = campo
            3 -> fila.descripcionP = campo
        }
    }

}