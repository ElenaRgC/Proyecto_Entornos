package Pelea


import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

/**
 * Pelea fichero
 * Clase encargada de manejar la lectura y escritura de objetos Pelea a archivos.
 * @constructor Create empty Pelea fichero
 */
class PeleaFichero {
    /**
     * Insertar
     *
     * @param lista La lista de objetos Pelea a insertar en el archivo.
     * @param no El nombre del archivo en el cual se insertan los objetos Pelea.
     * @param ti Indica si se debe anezar la información al final del archivo (true) o si se debe sobrescribir el archivo (false).
     */
    fun insertar(lista:List<Pelea>, no:String, ti:Boolean){
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
     * @param n El nombre del archivo del cual se deben recuperar los objetos Pelea.
     * @return Una lista de objetos Pelea.
     */
    fun recuperar(n:String):ArrayList<Pelea>{
        var solucion = ArrayList<Pelea>()
        var nombrePP:String
        var nombreJJ:String
        var fecha:String


        val file = File(n)

        val lineas = file.readLines()
        for (linea in lineas) {
            nombrePP = linea.substringAfter("nombre personaje=").substringBefore(", n")
            nombreJJ = linea.substringAfter("nombre jefe='").substringBeforeLast("'")


            var pelea = Pelea(nombrePP,nombreJJ)
            solucion.add(pelea)
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