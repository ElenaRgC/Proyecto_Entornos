package Personaje

import Clases.Fila

class Personaje: Fila {
    var nombrePPP:String=""
    var nivelP:Int =0
    var clase:String=""
    var descripcionP:String=""


    constructor(noppp: String, ni: Int,  cl:String, desp:String ){
        this.nombrePPP = noppp
        this.nivelP = ni
        this.clase = cl
        this.descripcionP = desp

    }

    override fun toString(): String {
        return "$nombrePPP: Nivel= $nivelP, Elemento= $clase, Descripcion= $descripcionP"
    }
}