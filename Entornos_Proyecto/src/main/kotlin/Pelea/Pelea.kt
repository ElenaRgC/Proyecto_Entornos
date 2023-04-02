package Pelea

import Clases.Fila

class Pelea: Fila {
    var nombrePP:String=""
    var nombreJJ:String=""

    constructor()

    constructor(np:String, nj:String ){
        this.nombrePP = np
        this.nombreJJ = nj
    }

    override fun toString(): String {
        return "Personaje= $nombrePP, Jefe= $nombreJJ"
    }
}