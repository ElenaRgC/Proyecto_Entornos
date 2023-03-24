package Personaje

class Personaje {
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
        return "Personaje.Personaje(nombre='$nombrePPP',nivel=$nivelP, elemento='$clase', descripcion='$descripcionP')"
    }
}