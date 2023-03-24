package Pelea

class Pelea {
    var nombrePP:String=""
    var nombreJJ:String=""


    constructor(np:String, nj:String ){
        this.nombrePP = np
        this.nombreJJ = nj
    }

    override fun toString(): String {
        return "Habilidad.Habilidad(nombre personaje=$nombrePP, nombre jefe='$nombreJJ')"
    }
}