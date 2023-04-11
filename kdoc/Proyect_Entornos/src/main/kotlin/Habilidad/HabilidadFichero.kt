package Habilidad

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

/**
 * Habilidad fichero
 *
 * Clase que maneja la escritura y lectura de habilidades a un archivo de texto
 * @constructor Create empty Habilidad fichero
 */
class HabilidadFichero {
    /**
     * Insertar
     *
     * Inserta una lista de habilidades en un archivo de texto.
     *
     * @param lista La lista de habilidades a insertar.
     * @param no El nombre del archivo a crear o actualizar.
     * @param ti Indica si se debe sobrescribir el archivo (true) o añadir al final (false).
     */
    fun insertar(lista:List<Habilidad>, no:String, ti:Boolean){
        var pw = FileWriter(no, ti)
        var copiar = PrintWriter(pw)
        for (i in lista!!) {
            copiar?.println(i)
        }
        copiar?.flush()
        copiar?.close()
    }

    /**
     * Recuperar
     *
     * Recupera una lista de habilidades desde un archivo de texto
     *
     * @param n El nombre del archivo a leer
     * @return La lista de habilidades recuperada desde el archivo
     */
    fun recuperar(n:String):ArrayList<Habilidad>{
        var solucion = ArrayList<Habilidad>()
        var nombre:String
        var nivel:Int
        var elemento :String
        var descripcion:String
        var dano:Int
        var nombreP:String
        val file = File(n)

        val lineas = file.readLines()
        for (linea in lineas) {
            nivel = linea.substringAfter("nivel=").substringBefore(",").toInt()
            nombre = linea.substringAfter("nombre='").substringBeforeLast("', e")
            elemento = linea.substringAfter("elemento='").substringBeforeLast("', d")
            descripcion = linea.substringAfter("descripcion='").substringBeforeLast("', d")
            dano = linea.substringAfter("daño='").substringBeforeLast("', n").toInt()
            nombreP = linea.substringAfter("nombre personaje='").substringBeforeLast("'")

            var habilidad = Habilidad(nivel,nombre,elemento,descripcion,dano,nombreP)
            solucion.add(habilidad)
        }
        return solucion
    }
}

/** recuperar el texto se podria realizar con expresiones regulares que aun no se han dado y no creo que se den
val entrada = "Autores.Autores(id=3, nombre='Ejemplo 1', nacionalidad='Mejico')"
val pattern = """id=(\d+),\s+nombre='([^']*)',\s+nacionalidad='([^']*)'""".toRegex()

val matchResult = pattern.find(input)
if (matchResult != null) {
val id = matchResult.groupValues[1].toInt()
val nombre = matchResult.groupValues[2]
val nacionalidad = matchResult.groupValues[3]
println("id = $id, nombre = $nombre, nacionalidad = $nacionalidad")
} else {
println("No se encontraron coincidencias")
}
 */