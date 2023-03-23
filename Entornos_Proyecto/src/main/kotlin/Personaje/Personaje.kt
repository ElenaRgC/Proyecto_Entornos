package Personaje

class Personaje {
    var nivelP:Int =0
    var nombrePPP:String=""
    var clase:String=""
    var descripcionP:String=""


    constructor(ni: Int, noppp: String, cl:String, desp:String ){
        this.nivelP = ni
        this.nombrePPP = noppp
        this.clase = cl
        this.descripcionP = desp

    }

    override fun toString(): String {
        return "Personaje.Personaje(nivel=$nivelP, nombre='$nombrePPP', elemento='$clase', descripcion='$descripcionP')"
    }
}