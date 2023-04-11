package Habilidad

import Clases.Fila

/**
 * Habilidad
 *
 * Representa una fila de la tabla "habilidad"
 *
 * @property nivel Nivel de la habilidad.
 * @property nombre Nombre de la habilidad.
 * @property elemento Elemento de la habilidad.
 * @property descripcion Descripción de la habilidad.
 * @property dano Daño de la habilidad.
 * @property nombreP Nombre del personake asociado a la habilidad.
 * @constructor Crea un objeto Habilidad vacío.
 * @constructor Crea un objeto Habilidad con los parámetros especificados.
 */
class Habilidad: Fila {
    var nivel:Int =0
    var nombre:String=""
    var elemento:String=""
    var descripcion:String=""
    var dano:Int=0
    var nombreP:String=""

    constructor()

    constructor(ni:Int, no:String, el:String, des:String, da:Int, np:String ){
        this.nivel = ni
        this.nombre = no
        this.elemento = el
        this.descripcion = des
        this.dano = da
        this.nombreP = np

    }

    override fun toString(): String {
        return "$nombre: Nivel= $nivel, Elemento= $elemento, Descripcion= $descripcion, Daño= $dano, Personaje= $nombreP"
    }

}