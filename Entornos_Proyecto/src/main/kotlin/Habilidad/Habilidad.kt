package Habilidad

import Clases.Fila

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