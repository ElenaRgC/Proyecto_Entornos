package Pelea

class Pelea {
    var nombrePP:String=""
    var nombreJJ:String=""
    var fecha:Int=0


    constructor(fe:Int, np:String, nj:String ){
        this.nombrePP = np
        this.nombreJJ = nj
        this.fecha = fe
    }

    override fun toString(): String {
        return "Habilidad.Habilidad(nombre personaje=$nombrePP, nombre jefe='$nombreJJ', fecha='$fecha')"
    }
}