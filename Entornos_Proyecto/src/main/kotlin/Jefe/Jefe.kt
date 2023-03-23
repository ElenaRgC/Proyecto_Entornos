package Jefe

class Jefe {
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
        return "Jefe.Jefe(nivel=$nivelJ, nombre='$nombreJ', vida='$vida', dificultad='$dificultad', descripcion='$descripcionJ')"
    }
}