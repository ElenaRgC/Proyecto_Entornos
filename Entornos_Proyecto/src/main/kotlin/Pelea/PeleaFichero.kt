package Pelea


import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

class PeleaFichero {
    fun insertar(lista:List<Pelea>, no:String, ti:Boolean){
        var pw = FileWriter(no, ti)
        var copiar = PrintWriter(pw)
        for (i in lista!!) {
            copiar?.println(i)
        }
        copiar?.flush()
        copiar?.close()
    }
    fun recuperar(n:String):ArrayList<Pelea>{
        var solucion = ArrayList<Pelea>()
        var nombrePP:Int
        var nombreJJ:String
        var fecha:String


        val file = File(n)

        val lineas = file.readLines()
        for (linea in lineas) {
            nombrePP = linea.substringAfter("nombre personaje=").substringBefore(",").toInt()
            nombreJJ = linea.substringAfter("nombre jefe='").substringBeforeLast("', f")
            fecha = linea.substringAfter("fecha='").substringBeforeLast("'")


            var pelea = Pelea(nombrePP,nombreJJ,fecha)
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