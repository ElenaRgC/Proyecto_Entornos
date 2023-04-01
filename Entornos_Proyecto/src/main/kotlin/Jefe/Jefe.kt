package Jefe

import Clases.Fila

class Jefe: Fila {
    var nivelJ:Int =0
    var nombreJ:String=""
    var vida:Int =0
    var dificultad:String=""
    var descripcionJ:String=""


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