package Pelea

import Clases.Fila

/**
 * Pelea
 *
 * Esta clase representa una pelea entre un personaje y un jefe.
 * @constructor Crea una instancia de Pelea vacía.
 */
class Pelea: Fila {
    var nombrePP:String=""
    var nombreJJ:String=""

    constructor()

    /**
     * Crea una instancia de Pelea con el nombre del personaje y del jefe
     * @param np El nombre del personaje que está luchadno en la pelea.
     * @param nj El nombre del jefe que está luchando en la pelea
     */
    constructor(np:String, nj:String ){
        this.nombrePP = np
        this.nombreJJ = nj
    }

    /**
     * To string
     *
     * @return una cadena que representa la Pelea con el nombre del personaje y del jefe.
     */
    override fun toString(): String {
        return "Personaje= $nombrePP, Jefe= $nombreJJ"
    }
}