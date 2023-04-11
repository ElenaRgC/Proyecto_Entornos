package Jefe

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

/**
 * Jefe fichero
 * Esta clase contiene dos métodos, uno para insertar una lista de objetos Jefe en un archivo de texto y otro para recuperar los objetos Jefe almacenados en un archivo de texto y devolverlos en una lista.
 * @constructor Crea una instancia de la clase JefeFichero.
 */
class JefeFichero {
    /**
     * Insertar
     *
     * Método para insertar una lista de objetos Jefe en un archivo de texto.
     *
     * @param lista Lista de objetos Jefe a insertar en el archivo.
     * @param no Nombre del archivo.
     * @param ti Booleano que indica si se deben sobreescribir los datos existentes o no.
     */
    fun insertar(lista:List<Jefe>, no:String, ti:Boolean){
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
     * Método para recuperar los objetos Jefe almacenados en un archivo de texto y devolverlos en una lista.
     * @param n Nombre del archivo.
     * @return Lista de objetos Jefe recuperados del archivo.
     */
    fun recuperar(n:String):ArrayList<Jefe>{
        var solucion = ArrayList<Jefe>()
        var nombreJ:String
        var nivelJ:Int
        var vida :Int
        var dificultad:String
        var descripcionJ:String

        val file = File(n)

        val lineas = file.readLines()
        for (linea in lineas) {
            nivelJ = linea.substringAfter("nivel=").substringBefore(",").toInt()
            nombreJ = linea.substringAfter("nombre='").substringBeforeLast("', v")
            vida = linea.substringAfter("vido='").substringBeforeLast("', d").toInt()
            dificultad = linea.substringAfter("dificultad='").substringBeforeLast("', d")
            descripcionJ = linea.substringAfter("descripcion='").substringBeforeLast("'")


            var jefe = Jefe(nivelJ,nombreJ,vida,dificultad,descripcionJ)
            solucion.add(jefe)
        }
        return solucion
    }
}