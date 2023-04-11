package Personaje

import Clases.Fila

/**
 * Personaje
 * @property nombrePPP El nombre del personaje principal
 * @property nivelP El nivel del personaje
 * @property clase La clase a la que pertenece el personaje.
 * @property descripcionP Una breve descripción del personaje.
 * @constructor Crea un objeto Personaje sin inicializar sus propiedades.
 * @constructor Crea un objeto Personaje con sus propiedades.
 */
class Personaje: Fila {
    var nombrePPP:String=""
    var nivelP:Int =0
    var clase:String=""
    var descripcionP:String=""

    /**
     * constructor sin argumentos. Inicializa todas las propiedades en su valor predeterminado
     */
    constructor()

    /**
     * Constructor que inicializa todas las propiedades del personaje
     * @param noppp El nombre del personaje principal.
     * @param ni El nivel del personaje.
     * @param cl La clase a la que pertenece el personaje.
     * @param desp Una breve descripción del personaje.
     */
    constructor(noppp: String, ni: Int,  cl:String, desp:String ){
        this.nombrePPP = noppp
        this.nivelP = ni
        this.clase = cl
        this.descripcionP = desp

    }

    /**
     * To string
     *
     * @return una cadena de texto que contiene el nombre del personaje, su nivel, clase y descripción.
     */
    override fun toString(): String {
        return "$nombrePPP: Nivel= $nivelP, Elemento= $clase, Descripcion= $descripcionP"
    }
}