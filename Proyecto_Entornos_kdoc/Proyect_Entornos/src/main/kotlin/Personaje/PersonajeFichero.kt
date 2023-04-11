package Personaje


import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

/**
 * Personaje fichero
 * Permite la manipulación de archivos relacionados con Personaje
 * @constructor Create empty Personaje fichero
 */
class PersonajeFichero {
    /**
     * Insertar
     *
     * @param lista La lista de Personaje a insertar
     * @param no El nombre del archivo
     * @param ti Indica si se va a sobrescribir el archivo o no
     */
    fun insertar(lista:List<Personaje>, no:String, ti:Boolean){
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
     * @param n El nombre del archivo
     * @return Una lista de Personaje
     */
    fun recuperar(n:String):ArrayList<Personaje>{
        var solucion = ArrayList<Personaje>()
        var nombrePPP:String
        var nivelP:Int
        var clase :String
        var descripcionP:String

        val file = File(n)


        val lineas = file.readLines()
        for (linea in lineas) {
            nombrePPP = linea.substringAfter("nombre personaje=").substringBefore(",")
            nivelP = linea.substringAfter("nivel='").substringBeforeLast("', c").toInt()
            clase = linea.substringAfter("clase='").substringBeforeLast("', d")
            descripcionP = linea.substringAfter("descripcion='").substringBeforeLast("'")


            var personaje = Personaje(nombrePPP,nivelP,clase,descripcionP)
            solucion.add(personaje)
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