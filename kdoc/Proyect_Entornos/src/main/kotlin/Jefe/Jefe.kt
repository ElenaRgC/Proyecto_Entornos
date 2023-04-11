package Jefe

import Clases.Fila

/**
 * Jefe
 * Clase que representa un jefe en el juego.
 * Hereda de la interfaz Fila.
 * @property nivelJ El nivel del jefe.
 * @property nombreJ El nombre del jefe.
 * @property vida La vida del jefe.
 * @property dificultad La dificultad del jefe.
 * @property descripcion La descripción del jefe.
 * @constructor Crea un objeto Jefe vacío
 * @constructor Crea un objeto Jefe con los parámetros dados.
 * @param ni El nivel del jefe.
 * @param no El nombre del jefe.
 * @param vi La vida del jefe.
 * @param di La dificultad del jefe.
 * @param des La descripción del jefe.
 */
class Jefe: Fila {
    var nivelJ:Int =0
    var nombreJ:String=""
    var vida:Int =0
    var dificultad:String=""
    var descripcionJ:String=""

    constructor()

    constructor(ni:Int, no:String, vi:Int, di:String, des:String ){
        this.nivelJ = ni
        this.nombreJ = no
        this.vida = vi
        this.dificultad = di
        this.descripcionJ = des
    }

    override fun toString(): String {
        return "Jefe: $nombreJ, Nivel= $nivelJ, Vida=$vida, Dificultad= $dificultad, Descripcion= $descripcionJ"
    }
}