package Jefe

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter

class JefeFichero {
    fun insertar(lista:List<Jefe>, no:String, ti:Boolean){
        var pw = FileWriter(no, ti)
        var copiar = PrintWriter(pw)
        for (i in lista!!) {
            copiar?.println(i)
        }
        copiar?.flush()
        copiar?.close()
    }
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