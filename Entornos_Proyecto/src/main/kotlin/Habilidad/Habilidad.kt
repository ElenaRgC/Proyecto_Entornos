package Habilidad

class Habilidad {
    var nivel:Int =0
    var nombre:String=""
    var elemento:String=""
    var descripcion:String=""
    var dano:Int=0
    var nombreP:String=""

    constructor(ni:Int, no:String, el:String, des:String, da:Int, np:String ){
        this.nivel = ni
        this.nombre = no
        this.elemento = el
        this.descripcion = des
        this.dano = da
        this.nombreP = np

    }

    override fun toString(): String {
        return "Habilidad.Habilidad(nivel=$nivel, nombre='$nombre', elemento='$elemento', descripcion='$descripcion', daño='$dano', nombreP='$nombreP')"
    }
}